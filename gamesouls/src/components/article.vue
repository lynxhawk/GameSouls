<template>
	<v-container>
		<v-card height="200px" dark tile>
			<v-img src="../../public/static/images/bg_green.jpg" class="fill-height">
				<v-row style="padding-top: 70px;" justify="center" class="display-2">文章</v-row>
			</v-img>
		</v-card>
		<v-card tile style="display: flex;flex-wrap: wrap;" class="pr-5">
			<template v-for="(item, index) in items">
			<v-col md="3">
			<v-card color='white' class="ma-3" height="350" width="300" raised :to="{ path: '/readarticle/'+item.id }">
				<v-list-item>
				    <v-list-item-avatar><v-img :src="item.avatar"></v-img></v-list-item-avatar>
						<v-list-item-content>
							<v-list-item-title class="headline">{{item.title}}</v-list-item-title>
							<v-list-item-subtitle>{{item.username}}</v-list-item-subtitle>
				        </v-list-item-content>
				</v-list-item>
				<v-img height="180px" :src="item.cover"></v-img>
				<v-card-title class="subtitle-1">{{item.subtitle}}</v-card-title>
				<v-card-subtitle> 
				<v-row justify="end">
				<v-sheet class="pr-1">{{item.date}}</v-sheet>
				<v-icon small class="pl-12 pr-2">mdi-heart</v-icon>{{item.heart}}
				<v-icon small class="pl-4 pr-2">mdi-comment-multiple</v-icon>
				<v-sheet class="pr-2">{{item.comment}}</v-sheet></v-row>
				</v-card-subtitle>
			</v-card>
			</v-col>
			</template>
		</v-card>
		<v-btn color="green" fab fixed bottom right dark style="margin-bottom: 70px;"
		@click="openwrite">
			<v-icon>mdi-fountain-pen</v-icon>
		</v-btn>
		<v-snackbar top class="mt-12" color="error" v-model="snackbar">已被禁止提交
		<v-btn dark text @click="snackbar = false">关闭</v-btn></v-snackbar>
	</v-container>
</template>

<script>
	export default {
		name: 'App',
		data() {
			return {
				items:[],snackbar:false
			}
		},
		created() {
			this.$axios.get('api/getarticlelist').then((response)=>{
				this.items=response.data;
			})
		},
		methods:{
			openwrite(){
				if(localStorage.getItem("power")==4||localStorage.getItem("power")==null){
					this.snackbar=true;
				}else{
					this.$router.push({path: '/writearticle'});
				}
			},
		},
	}
</script>

<style>
</style>
