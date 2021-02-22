<template>
	<v-container>
		<v-card height="200px" dark tile>
			<v-img src="../../public/static/images/bg_yellow.jpg" class="fill-height">
				<v-row style="padding-top: 70px;" justify="center" class="display-2">攻略</v-row>
			</v-img>
		</v-card>
		<v-card tile style="display: flex;flex-wrap: wrap;" class="px-12">
			<template v-for="(item, index) in items">
			<v-col md="4">
				<v-card color='white' class="ma-3" height="290" width="300" raised :to="{ path: '/readwalk/'+item.id }">
					<v-img height="200px" :src="item.cover"></v-img>
					<v-list-item>
					    <v-list-item-avatar><v-img :src="item.avatar"></v-img></v-list-item-avatar>
							<v-list-item-content>
								<v-list-item-title class="headline">{{item.title}}</v-list-item-title>
								<v-list-item-subtitle>
								<v-row justify="space-between">
								<v-sheet class="pl-4">{{item.username}}</v-sheet></v-row>
								<v-row justify="end"><v-icon small class="pr-3">mdi-heart</v-icon>
								<v-sheet class="pr-3">{{item.heart}}</v-sheet>
								<v-icon small class="pr-3">mdi-comment-multiple</v-icon>
								<v-sheet class="pr-3">{{item.comment}}</v-sheet></v-row>
								</v-list-item-subtitle>
							</v-list-item-content>						
					</v-list-item>
				</v-card>
			</v-col>
			</template>
		</v-card>
		<v-btn color="yellow" dark fab fixed bottom right dark style="margin-bottom: 70px;"
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
			this.$axios.get('api/getwalkthroughlist').then((response)=>{
				this.items=response.data;
			})
		},
		methods:{
			openwrite(){
				if(localStorage.getItem("power")==4||localStorage.getItem("power")==null){
					this.snackbar=true;
				}else{
					this.$router.push({path: '/writewalk'});
				}
			}
		}
	}
</script>

<style>
</style>
