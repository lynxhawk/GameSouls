<template>
	<v-container>
		<v-row justify="center">
		<v-card width="800px" tile>
			<v-row justify="center" class="display-1 pt-12 pb-12">{{title}}</v-row>
			<v-row align="center" class="pl-12 pb-6">
				<v-avatar size="40"><v-img @click="openperson" :src="avatar"></v-img></v-avatar>
				<v-sheet class="subtitle-1 ml-3">{{username}}</v-sheet>
				<v-sheet class="subtitle-1 ml-3">{{date}}</v-sheet>
				<v-spacer></v-spacer>
				<v-btn small fab dark color="yellow" class="mx-1" @click="addheart"><v-icon>mdi-heart-outline</v-icon></v-btn>
				<v-btn small fab dark color="yellow" class="mx-1" @click="addcollect"><v-icon>mdi-bookmark-outline</v-icon></v-btn>
				<v-btn small fab dark color="yellow" class="mx-1" @click="send"><v-icon>mdi-share-outline</v-icon></v-btn>
				<v-tooltip top>
					<template v-slot:activator="{ on }">
					<v-btn small fab dark color="yellow" v-on="on" @click="editwalk" class="ml-1 mr-6">
						<v-icon>mdi-file-document-edit-outline</v-icon></v-btn>
					</template>编辑申请
				</v-tooltip>
			</v-row>
			<v-row class="px-12">
				<v-sheet v-html="text"></v-sheet>
			</v-row>
			<v-row class="px-12 py-6">
				<v-btn rounded dark color="yellow" @click="addheart"><v-icon>mdi-heart-outline</v-icon>{{heart}}</v-btn>
				<v-btn rounded dark color="yellow" class="ml-1 mr-4" @click="addcollect"><v-icon>mdi-bookmark-outline</v-icon>{{collect}}</v-btn>
				<v-spacer></v-spacer>
				<v-btn small fab dark color="yellow" class="mx-1" @click="addreport"><v-icon>mdi-comment-alert-outline</v-icon></v-btn>
				<v-btn small fab dark color="yellow" class="mx-1" @click="send"><v-icon>mdi-share-outline</v-icon></v-btn>
				<v-btn small fab dark color="yellow" class="ml-1" @click="deletewalk" v-show="showdelete">
					<v-icon>mdi-delete</v-icon></v-btn>
			</v-row>
			<v-divider></v-divider>
			<v-row class="px-12 py-3">
				攻略修改参与者：{{editperson}}
			</v-row>
		</v-card>
		<v-card width="800px" tile>
			<v-row class="px-12 py-6 title">评论·{{comment}}</v-row>
			<v-divider></v-divider>
			<v-row>
			<v-textarea color="yellow" class="pl-6 pt-6" label="评论" v-model="commenttext" outlined clearable></v-textarea>
			<v-btn text color="yellow" class="mt-6 mr-6 ml-2" tile @click="addcomment">提交</v-btn></v-row>
			<v-divider></v-divider>
			<v-list>
				<template v-for="(item, index) in item1s">
				<v-list-item>
					<v-list-item-avatar>
					    <v-img @click="openpeople(index)" :src="item.avatar"></v-img>
					</v-list-item-avatar>
					<v-list-item-content>
					    <v-list-item-title v-html="item.username"></v-list-item-title>
						<v-list-item-subtitle v-html="item.text"></v-list-item-subtitle>
					</v-list-item-content>
				</v-list-item>
				</template>
			</v-list>
		</v-card>
		</v-row>
		<v-snackbar top color="success" class="mt-12" v-model="snackbar">点赞成功
		<v-btn dark text @click="snackbar = false">关闭</v-btn></v-snackbar>
		<v-snackbar top color="success" class="mt-12" v-model="snackbar1">收藏成功
		<v-btn dark text @click="snackbar1 = false">关闭</v-btn></v-snackbar>
		<v-snackbar top color="success" class="mt-12" v-model="snackbar2">评论成功
		<v-btn dark text @click="snackbar2 = false">关闭</v-btn></v-snackbar>
		<v-snackbar top color="success" class="mt-12" v-model="snackbar3">取消收藏成功
		<v-btn dark text @click="snackbar3 = false">关闭</v-btn></v-snackbar>
		<v-snackbar top color="success" class="mt-12" v-model="snackbar4">举报成功
		<v-btn dark text @click="snackbar4 = false">关闭</v-btn></v-snackbar>
		<v-snackbar top color="success" class="mt-12" v-model="snackbar5">链接已复制到剪贴板
		<v-btn dark text @click="snackbar5 = false">关闭</v-btn></v-snackbar>
		<v-snackbar top color="success" class="mt-12" v-model="snackbar6">删除成功
		<v-btn dark text @click="snackbar6 = false">关闭</v-btn></v-snackbar>
		<v-snackbar top class="mt-12" color="error" v-model="snackbar7">已被禁止提交
		<v-btn dark text @click="snackbar7 = false">关闭</v-btn></v-snackbar>
		<v-snackbar top class="mt-12" color="error" v-model="snackbar8">未登录
		<v-btn dark text @click="snackbar8 = false">关闭</v-btn></v-snackbar>
	</v-container>
</template>

<script>
	export default{
		data(){
			return{
				heart:'',collect:'',comment:'',showdelete:false,
				username:'',userid:'',commenttext:'',
				title:'',cover:'',avatar:'',
				date:'',
				snackbar:false,snackbar1:false,snackbar2:false,snackbar3:false,
				snackbar4:false,snackbar5:false,snackbar6:false,snackbar7:false,snackbar8:false,
				text:'',editperson:'',
				item1s: []
			}
		},
		created(){
			this.$axios.get('http://localhost:8888/getwalk/'+this.$route.params.id).then((res)=>{
				  this.title=res.data[0].title;
				  this.heart=res.data[0].heart;
				  this.collect=res.data[0].collect;
				  this.comment=res.data[0].comment;
				  this.id=res.data[0].id;
				  this.userid=res.data[0].userid;
				  this.username=res.data[0].username;
				  this.date=res.data[0].date;
				  this.avatar=res.data[0].avatar;
				  this.cover=res.data[0].cover;
				  this.text=res.data[0].text;
				  if(this.userid==localStorage.getItem("id")){
				  	this.showdelete=true;
				  }
			});
			this.$axios.get('http://localhost:8888/getwalkcommentlist/'+this.$route.params.id).then((res)=>{
				  this.item1s=res.data;
			});
			if(localStorage.getItem("power")<3&&localStorage.getItem("id")!=null){
				this.showdelete=true;
			}
			this.$axios.get('http://localhost:8888/getuserchecklist/'+this.$route.params.id).then((res)=>{
				  var b=res.data;
				  for(var i=0;i<b.length;i++){
					  this.editperson=this.editperson+b[i].username+' ';
				  }
			});
		},
		methods:{
			editwalk(){
				this.$router.push({path: '/editwalk/' + this.id});
			},
			deletewalk(){
				this.$axios.get('http://localhost:8888/deletewalk/'+this.id).then((response)=>{
					if(response.data=true){
						this.snackbar6=true;
						this.$router.go(-1);
					}
				})
			},
			send(){
				this.$copyText(window.location.href).then(res => {
				  this.snackbar5=true;
				}).catch(err => {
				})
			},
			openperson(){
				this.$router.push({ path: '/myspace/'+this.userid});
			},
			openpeople(index){
				this.$router.push({ path: '/myspace/'+this.item1s[index].userid});
			},
			addheart(){
				if(localStorage.getItem("power")==null){
					this.snackbar8=true;
				}else{
					this.$axios.get('http://localhost:8888/heartwalkthrough/',{
				        params:{
				           id:this.id,
						   userid:this.userid,
						   userid1:localStorage.getItem("id"),
						   username:localStorage.getItem("username"),
						   title:this.title
				        }
				    }).then((response)=>{
						if(response.data=true){
							this.snackbar=true;
							this.heart=this.heart+1;
						}
				})
				}
				
			},
			addcollect(){
				if(localStorage.getItem("power")==null){
					this.snackbar8=true;
				}else{
				this.$axios.get('http://localhost:8888/addwalkcollect/',{
				        params:{
				           id:this.id,
						   userid:localStorage.getItem("id")
				        }
				    }).then((response)=>{
						if(response.data==true){
							this.snackbar1=true;
							this.collect=this.collect+1;
						}else{
							this.snackbar3=true;
							this.collect=this.collect-1;
						}
				})
				}
			},
			addreport(){
				if(localStorage.getItem("power")==null){
					this.snackbar8=true;
				}else{
				this.$axios.get('http://localhost:8888/reportwalk/',{
				        params:{
						   userid:localStorage.getItem("id"),
						   username:localStorage.getItem("username"),
						   reportid:this.id,
						   title:this.title
				        }
				    }).then((response)=>{
						if(response.data=true){
							this.snackbar4=true;
						}
				})
				}
			},
			addcomment(){
				if(localStorage.getItem("power")==4||localStorage.getItem("power")==null){
					this.snackbar7=true;
				}else{
				this.$axios.get('http://localhost:8888/addwalkcomment/',{
				        params:{
						   userid:localStorage.getItem("id"),
						   username:localStorage.getItem("username"),
						   avatar:localStorage.getItem("avatar"),
						   text:this.commenttext,
						   workid:this.$route.params.id,
						   type:"攻略",
						   title:this.title
				        }
				    }).then((response)=>{
						if(response.data=true){
							this.snackbar2=true;
							this.comment=this.comment+1;
							this.$router.go(0);
						}
				})
				}
			}
		}
		
	}
</script>

<style>
</style>
