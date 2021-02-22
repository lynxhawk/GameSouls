<template>
	<v-container>
		<v-card height="200px" dark tile>
			<v-img src="../../public/static/images/bg_red.jpg" class="fill-height">
				<v-row style="padding-top: 70px;" justify="center" class="display-2">评测</v-row>
			</v-img>
		</v-card>
		<v-card tile style="display: flex;flex-wrap: wrap;">
			<template v-for="(item, index) in items">
			<v-col md="4">
				<v-card color='white' class="ma-3" height="205" width="350" raised :to="{ path: '/readreview/'+item.id }">
					<v-row justify="space-between">
						<v-col cols="7">
							<v-card-title>
							<v-avatar size="30"><v-img :src="item.avatar"></v-img></v-avatar>
							<div class="pl-3">{{item.username}}</div>
							</v-card-title>
						<v-sheet class="pl-3" id="v-card--c" height="75">{{item.text}}</v-sheet>
						</v-col>
						<v-img class="mt-8" height="100px" style="flex-basis: 30px"
						:src="item.cover"></v-img>
					</v-row>
			    <v-divider></v-divider>
			    <v-card-actions class="pl-2">
					<strong>{{item.game}}</strong>
					<v-spacer></v-spacer> 
					<span class="black--text text--lighten-2 caption mr-2">({{item.rate}})</span>
					<v-rating readonly v-model="item.rate" background-color="orange lighten-3"
			        color="yellow accent-4" dense half-increments hover size="22"></v-rating>
			    </v-card-actions>
				</v-card>
			</v-col>
			</template>
		</v-card>
		<v-btn color="red" fab fixed bottom right dark style="margin-bottom: 70px;"
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
				items:[],snackbar:false
			}
		},
		created() {
			this.$axios.get('api/getreviewlist').then((response)=>{
				this.items=response.data;
			})
		},
		methods:{
			openwrite(){
				if(localStorage.getItem("power")==4||localStorage.getItem("power")==null){
					this.snackbar=true;
				}else{
					this.$router.push({path: '/writereview'});
				}
			}
		}
	}
</script>

<style>
</style>
