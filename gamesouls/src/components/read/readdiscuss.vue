<template>
	<v-container>
		<v-row justify="center">
		<v-card width="800px" tile>
			<v-row>
			<v-col>
				<v-avatar class="ml-10 mt-6" size="40"><v-img @click="openperson" :src="avatar"></v-img></v-avatar>
				<v-sheet class="subtitle-1 ml-10">{{username}}</v-sheet>
				<v-sheet class="subtitle-1 ml-10">{{date}}</v-sheet>
				<v-row class="ml-10 mt-4">
					<v-btn rounded dark color="orange" @click="addcollect"><v-icon>mdi-bookmark-outline</v-icon>{{collect}}</v-btn>
				</v-row>
				<v-row class="ml-10 mt-4">
					<v-btn small fab dark color="orange" class="mr-1" @click="addreport"><v-icon>mdi-comment-alert-outline</v-icon></v-btn>
					<v-btn small fab dark color="orange" class="mr-1" @click="send"><v-icon>mdi-share-outline</v-icon></v-btn>
					<v-btn small fab dark color="orange" @click="deletediscuss" v-show="showdelete">
						<v-icon>mdi-delete</v-icon></v-btn>
				</v-row>
			</v-col>
			<v-divider vertical></v-divider>
			<v-col md="9">
				<v-row justify="start" class="title px-12">{{title}}</v-row>
				<v-row justify="start" class="px-12">
					{{text}}
				</v-row>
				<v-row class="px-12">
					<v-img width="400px" :src="cover"></v-img>
				</v-row>
			</v-col>
			</v-row>
			<v-divider></v-divider>
			<v-row class="px-12 py-3 title">回复·{{comment}}</v-row>
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
				<v-divider></v-divider>
				</template>
			</v-list>
			<v-pagination color="orange" class="my-6" :length="length1" v-model="page1" total-visible="8"></v-pagination>
		</v-card>
		<v-card width="800px" tile>
			<v-row class="px-8 py-1 title">回复</v-row>
			<v-row>
			<v-textarea color="orange" class="pl-6 pt-1" label="评论" v-model="commenttext" outlined clearable></v-textarea>
			<v-btn text color="orange" class="mt-6 mr-6 ml-2" tile @click="addcomment">提交</v-btn></v-row>
			<v-divider></v-divider>
		</v-card>
		</v-row>
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
				collect:'',comment:'',commenttext:'',length1:null,page1:1,showdelete:false,
				username:'',userid:'',id:'',avatar:'',cover:'',
				snackbar1:false,snackbar2:false,snackbar3:false,snackbar8:false,
				snackbar4:false,snackbar5:false,snackbar6:false,snackbar7:false,
				title:'',
				date:'',
				text:'',
				item1s: [],totalitem1s:[]
			}
		},
		created(){
			this.$axios.get('http://localhost:8888/getdiscuss/'+this.$route.params.id).then((res)=>{
				  this.title=res.data[0].title;
				  this.collect=res.data[0].collect;
				  this.comment=res.data[0].comment;
				  this.id=res.data[0].id;
				  this.userid=res.data[0].userid;
				  this.username=res.data[0].username;
				  this.text=res.data[0].text;
				  this.date=res.data[0].date;
				  this.avatar=res.data[0].avatar;
				  this.cover=res.data[0].image;
				  if(this.userid==localStorage.getItem("id")){
				  	this.showdelete=true;
				  }
			});
			this.$axios.get('http://localhost:8888/getdiscusreplylist/'+this.$route.params.id).then((res)=>{
				  var a = res.data;
				  this.length1=Math.ceil(a.length/5);
				  	for (let i = 0; i < this.length1; i++) {
				  		this.totalitem1s[i] = a.slice(5 * i, 5 * (i + 1));
				  	}
				  this.item1s = this.totalitem1s[this.page1-1];
			});
			if(localStorage.getItem("power")<3&&localStorage.getItem("id")!=null){
				this.showdelete=true;
			}
		},
		watch:{
			page1(val, oldVal){
				this.item1s = this.totalitem1s[val-1];
			},
		},
		methods:{
			deletediscuss(){
				this.$axios.get('http://localhost:8888/deletediscuss/'+this.id).then((response)=>{
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
			addcollect(){
				if(localStorage.getItem("power")==null){
					this.snackbar8=true;
				}else{
				this.$axios.get('http://localhost:8888/adddiscusscollect/',{
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
				this.$axios.get('http://localhost:8888/reportdiscuss/',{
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
				this.$axios.get('http://localhost:8888/addreply/',{
				        params:{
						   userid:localStorage.getItem("id"),
						   username:localStorage.getItem("username"),
						   avatar:localStorage.getItem("avatar"),
						   text:this.commenttext,
						   workid:this.$route.params.id,
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
