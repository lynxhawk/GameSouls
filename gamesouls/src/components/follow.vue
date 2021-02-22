<template>
	<v-img width="1920px" :aspect-ratio="16/9" :src="background">
	<v-row justify="center">
	<v-card tile width="800px" height="600px"style="opacity: 0.9;margin-top: 60px;">
		<v-tabs vertical>
	      <v-tab>
	        <v-icon left>mdi-account-heart</v-icon>
	        正在关注
	      </v-tab>
	      <v-tab>
	        <v-icon left>mdi-account-heart-outline</v-icon>
	        关注者
	      </v-tab>
	
	    <v-tab-item>
	        <v-card flat height="600px" style="overflow-y: auto;">
	        <v-list three-line>
				<template v-for="(item, index) in items">
	                <v-list-item>
						<v-list-item-avatar><v-img @click="openpeople(index)" :src="item.avatar"></v-img></v-list-item-avatar>
						<v-list-item-content>
							<v-list-item-title v-html="item.username"></v-list-item-title>
							<v-list-item-subtitle v-html="item.introduce"></v-list-item-subtitle>
						</v-list-item-content>
						<v-list-item-action>
						<v-row>
					    <v-btn text>
					        <v-icon color="primary">mdi-account-multiple-check</v-icon>
					        正在关注</v-btn>
						<v-menu>
							<template v-slot:activator="{ on }">
					        <v-btn icon v-on="on"><v-icon>mdi-dots-vertical</v-icon></v-btn>
							</template>
								<v-list>
									<v-list-item>
										<v-btn text @click="deteles(index)">取消关注</v-btn>
							        </v-list-item>
									<v-divider></v-divider>
									<v-list-item><v-btn text @click="jubao(index)">举报</v-btn></v-list-item>
							    </v-list>
						</v-menu>
						</v-row>
					    </v-list-item-action>
					</v-list-item>
					<v-divider></v-divider>
	                </template>
	            </v-list>
	        </v-card>
		</v-tab-item>
	    <v-tab-item>
			<v-card flat height="600px" style="overflow-y: auto;">
			<v-list three-line>
				<template v-for="(item, index) in item1s">
			        <v-list-item>
						<v-list-item-avatar><v-img @click="openpeople1(index)" :src="item.avatar"></v-img></v-list-item-avatar>
						<v-list-item-content>
							<v-list-item-title v-html="item.username"></v-list-item-title>
							<v-list-item-subtitle v-html="item.introduce"></v-list-item-subtitle>
						</v-list-item-content>
						<v-list-item-action>
						<v-row>
					    <v-btn text @click="follow(index)">
					        <v-icon color="primary">mdi-account-multiple-plus</v-icon>
					        关注</v-btn>
						<v-menu>
							<template v-slot:activator="{ on }">
					        <v-btn icon v-on="on"><v-icon>mdi-dots-vertical</v-icon></v-btn>
							</template>
								<v-list>
									<v-list-item><v-btn text @click="jubao1(index)">举报</v-btn></v-list-item>
							    </v-list>
						</v-menu>
						</v-row>
					    </v-list-item-action>
					</v-list-item>
					<v-divider></v-divider>
			        </template>
			    </v-list>
			</v-card>
	    </v-tab-item>
	    </v-tabs>
	</v-card>
	</v-row>
	
	<v-snackbar top color="success" class="mt-12" v-model="snackbar">举报成功
	<v-btn dark text @click="snackbar = false">关闭</v-btn></v-snackbar>
	<v-snackbar top color="success" class="mt-12" v-model="snackbar1">关注成功
	<v-btn dark text @click="snackbar1 = false">关闭</v-btn></v-snackbar>
	<v-snackbar top color="success" class="mt-12" v-model="snackbar2">取消关注成功
	<v-btn dark text @click="snackbar2 = false">关闭</v-btn></v-snackbar>
	<v-snackbar top color="info" class="mt-12" v-model="snackbar3">已关注
	<v-btn dark text @click="snackbar3 = false">关闭</v-btn></v-snackbar>
	
	</v-img>
</template>

<script>
	export default {
		name: 'App',
		data() {
			return {
				snackbar:false,snackbar1:false,snackbar2:false,snackbar3:false,
				background:null,
				items:[],item1s:[]
			}
		},
		created() {
			if(localStorage.getItem("id")!=null){
				this.background=localStorage.getItem("background");
			}
			this.$axios.get('api/getuserfollow/'+localStorage.getItem("id")).then((res)=>{
				  this.items=res.data;
			});
			this.$axios.get('api/getuserfollower/'+localStorage.getItem("id")).then((res)=>{
				  this.item1s=res.data;
			});
		},
		methods:{
			openpeople(index){
				this.$router.push({ path: '/myspace/'+this.items[index].id});
			},
			openpeople1(index){
				this.$router.push({ path: '/myspace/'+this.item1s[index].id});
			},
			deteles(index){
				this.$axios.get('api/deletefollow/',{
					params:{
					    userid:localStorage.getItem("id"),
						followid:this.items[index].id
					}
				}).then((res)=>{
					if(res.data==true){
						this.items.splice(index, 1);
						this.snackbar2=true;
					}
				});
			},
			jubao(index){
				this.$axios.get('api/addfollowreport',{
				        params:{
				            userid:localStorage.getItem("id"),
							username:localStorage.getItem("username"),
							reportid:this.items[index].id,
							title:this.items[index].username
				        }
				    }).then((response)=>{
						this.snackbar=true;
				})
			},
			jubao1(index){
				this.$axios.get('api/addfollowreport',{
				        params:{
				            userid:localStorage.getItem("id"),
							username:localStorage.getItem("username"),
							reportid:this.item1s[index].id,
							title:this.item1s[index].username
				        }
				    }).then((response)=>{
						this.snackbar=true;
				})
			},
			follow(index){
				this.$axios.get('api/isfollow',{
				        params:{
				            userid:localStorage.getItem("id"),
							followid:this.item1s[index].id
				        }
				    }).then((response)=>{
					if(response.data==true){
						this.snackbar3=true;
					}else{
						this.$axios.get('api/addfollow',{
				        params:{
				            userid:localStorage.getItem("id"),
							followid:this.item1s[index].id
				        }
						}).then((response)=>{
							this.snackbar1=true;
						})
					}
					})
			}
		}
	}
</script>

<style>
</style>
