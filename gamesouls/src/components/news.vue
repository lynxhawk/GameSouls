<template>
	<v-container>
		<v-card height="200px" dark tile>
			<v-img src="../../public/static/images/bg_cyan.jpg" class="fill-height">
				<v-row style="padding-top: 70px;" justify="center" class="display-2">资讯</v-row>
			</v-img>
		</v-card>
		<v-card tile style="display: flex;flex-wrap: wrap;" class="px-12">
			<template v-for="(item, index) in items">
			<v-col md="3">
			<v-card color='white' class="ma-3" height="200" width="200" raised 
			:to="{ path: '/readnews/'+item.id }">
				<v-img height="100px" :src="item.cover"></v-img>
				<v-card-title class="subtitle-1">{{item.title}}</v-card-title>
				<v-card-subtitle class="pb-0">{{item.date}}</v-card-subtitle>
			</v-card>
			</v-col>
			</template>
		</v-card>
		<v-btn color="cyan" dark fab fixed bottom right style="margin-bottom: 70px;"
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
				items:[],snackbar:false,
			}
		},
		created() {
			this.$axios.get('api/getnewslist').then((response)=>{
				this.items=response.data;
			})
		},
		methods:{
			openwrite(){
				if(localStorage.getItem("power")==4||localStorage.getItem("power")==null){
					this.snackbar=true;
				}else{
					this.$router.push({path: '/writenews'});
				}
			},
		}
	}
</script>

<style>
</style>
