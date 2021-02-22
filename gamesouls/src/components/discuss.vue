<template>
	<v-container>
		<v-card height="200px" dark tile>
			<v-img src="../../public/static/images/bg_orange.jpg" class="fill-height">
				<v-row style="padding-top: 75px;" justify="center" class="display-2">论坛</v-row>
				</v-img>
		</v-card>
		<v-card tile style="display: flex;flex-wrap: wrap;">
			<template v-for="(item, index) in items">
			<v-col md="4">
			<v-card class="mx-auto" color="white" width="400" shaped raised :to="{ path: '/readdiscuss/'+item.id }">
			    <v-card-title style="overflow: hidden;">
					<v-sheet height="50px" class="title font-weight-bold">{{item.title}}</v-sheet>
			    </v-card-title>
				<v-divider></v-divider>
			    <v-card-text style="overflow: hidden;" class="subtitle-2 font-weight">
				<v-sheet height="95px">{{item.text}}</v-sheet></v-card-text>
				<v-divider></v-divider>
			    <v-card-actions>
					<v-list-item class="grow">
			        <v-list-item-avatar>
						<v-img class="elevation-6" :src="item.avatar"></v-img>
			        </v-list-item-avatar>
			        <v-list-item-content><v-list-item-title>{{item.username}}</v-list-item-title></v-list-item-content>
			        <v-row align="center" justify="end">
						<span class="subheading mr-4">{{item.date}}</span>
						<v-icon class="mr-2">mdi-comment-text-multiple</v-icon>
						<span class="subheading mr-2">{{item.comment}}</span>
			        </v-row>
					</v-list-item>
			    </v-card-actions>
			</v-card>
			</v-col>
			</template>
		</v-card>
		<v-btn color="orange" fab fixed bottom right dark style="margin-bottom: 70px;"
			@click="openwrite">
			<v-icon>mdi-fountain-pen</v-icon>
		</v-btn>
		<v-snackbar top class="mt-12" color="error" v-model="snackbar">已被禁止提交
		<v-btn dark text @click="snackbar = false">关闭</v-btn></v-snackbar>
	</v-container>
</template>

<script>
	export default{
		data(){
			return{
				items: [],snackbar:false
			}
		},
		created() {
			this.$axios.get('api/getdiscusslist').then((response)=>{
				this.items=response.data;
			})
		},
		methods:{
			openwrite(){
				if(localStorage.getItem("power")==4||localStorage.getItem("power")==null){
					this.snackbar=true;
				}else{
					this.$router.push({path: '/writediscuss'});
				}
			},
		},
		
		
	}
</script>

<style>
</style>
