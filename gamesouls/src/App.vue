<template>
	<v-app>		
	<v-navigation-drawer v-model="drawer" fixed temporary>
		<v-list class="pa-1" >
			<v-list-item @click="opendialog">
			<v-list-item-avatar>
				<v-icon v-if="avatar==null" x-large>mdi-account-circle</v-icon>
				<v-avatar v-else><v-img width="30" :src="avatar"></v-img></v-avatar>
			</v-list-item-avatar>
			<v-list-item-content>
				<v-list-item-title>
				<div v-if="nickname==null">未登录</div>
				<div v-else>{{nickname}}</div>
				</v-list-item-title>
			</v-list-item-content>
			</v-list-item>
		</v-list>

		<v-list dense light>
			<v-divider></v-divider>
			<v-list-item v-if="power!=null">
				<router-link :to="{ path: '/myspace/'+this.id }">
				<v-btn text tile color="grey darken-2" height="45" width="230">
					<v-row class="pl-4">
						<v-icon class="pr-8">dashboard</v-icon>
					<v-sheet class="pt-1">个人中心</v-sheet></v-row>
				</v-btn></router-link>
			</v-list-item>
			<v-list-item v-for="item in items" :key="item.title" v-if="power!=null">
				<router-link :to="{ path: '/'+item.path }">
				<v-btn text tile color="grey darken-2" height="45" width="230">
					<v-row class="pl-4">
						<v-icon class="pr-8">{{ item.icon }}</v-icon>
					<v-sheet class="pt-1">{{ item.title }}</v-sheet></v-row>
				</v-btn></router-link>
			</v-list-item>
			<v-list-item v-if="power==1||power==2">
				<router-link :to="{ path: '/managereport' }">
				<v-btn text tile color="grey darken-2" height="45" width="230">
					<v-row class="pl-4">
						<v-icon class="pr-8">mdi-alert</v-icon>
					<v-sheet class="pt-1">举报管理</v-sheet></v-row>
				</v-btn>
				</router-link>
			</v-list-item>
			<v-list-item v-if="power==1||power==2">
				<router-link :to="{ path: '/managefeedback' }">
				<v-btn text tile color="grey darken-2" height="45" width="230">
					<v-row class="pl-4">
						<v-icon class="pr-8">mdi-message-alert</v-icon>
					<v-sheet class="pt-1">反馈管理</v-sheet></v-row>
				</v-btn>
				</router-link>
			</v-list-item>
			<v-list-item v-if="power==1||power==2">
				<router-link :to="{ path: '/managecheck' }">
				<v-btn text tile color="grey darken-2" height="45" width="230">
					<v-row class="pl-4">
						<v-icon class="pr-8">mdi-magnify-scan</v-icon>
					<v-sheet class="pt-1">审核管理</v-sheet></v-row>
				</v-btn>
				</router-link>
			</v-list-item>
			<v-list-item v-if="power==1||power==2">
				<router-link :to="{ path: '/managepower' }">
				<v-btn text tile color="grey darken-2" height="45" width="230">
					<v-row class="pl-4">
						<v-icon class="pr-8">mdi-shield-edit</v-icon>
					<v-sheet class="pt-1">权限管理</v-sheet></v-row>
				</v-btn>
				</router-link>
			</v-list-item>
		</v-list>
		
		<template v-slot:append>
			<div class="pa-2" v-if="nickname!=null">
				<v-btn block tile text @click="logout">退出登录</v-btn>
			</div>
	    </template>
    </v-navigation-drawer>
		
    <v-app-bar color="white" elevation-4 app dense>
		
		<v-toolbar-title class="headline">
        GameSouls
		</v-toolbar-title>
        <v-spacer></v-spacer>
			<v-toolbar-items class="hidden-sm-and-down">
				<router-link :to="{ path: '/' }"><v-btn height="48" text color="blue" tile><strong>主页</strong></v-btn></router-link>
				<router-link :to="{ path: '/post' }"><v-btn height="48" text color="light-blue" tile><strong>动态</strong></v-btn></router-link>
				<router-link :to="{ path: '/news' }"><v-btn height="48" text color="cyan" tile><strong>资讯</strong></v-btn></router-link>
				<router-link :to="{ path: '/article' }"><v-btn height="48" text color="green" tile><strong>文章</strong></v-btn></router-link>
				<router-link :to="{ path: '/review' }"><v-btn height="48" text color="red" tile><strong>评测</strong></v-btn></router-link>
				<router-link :to="{ path: '/walkthrough' }"><v-btn height="48" text color="yellow" tile><strong>攻略</strong></v-btn></router-link>
				<router-link :to="{ path: '/discuss' }"><v-btn height="48" text color="orange" tile><strong>论坛</strong></v-btn></router-link>
				<router-link :to="{ path: '/search' }"><v-btn height="48" text color="purple" tile><strong>搜索</strong></v-btn></router-link>
			</v-toolbar-items>
			<v-badge :content="messages" :value="messages" color="blue accent-2" overlap bottom offset-y="20" offset-x="50" left>
				<v-btn icon large @click.stop="drawer = !drawer">
				    <v-icon v-if="avatar==null" large>mdi-account-circle</v-icon>
					<v-avatar v-else size="36"><v-img :src="avatar"></v-img></v-avatar>
				</v-btn>
			</v-badge>
			<v-menu class="hidden-md-and-up">
				<template v-slot:activator="{ on }">
				    <v-btn icon v-on="on" class="hidden-md-and-up">
				        <v-icon>mdi-dots-vertical</v-icon>
				    </v-btn>
				</template>
				<v-list>
					<v-list-item><router-link :to="{ path: '/' }"><v-btn height="48" text color="blue" tile><strong>主页</strong></v-btn></router-link></v-list-item>
					<v-divider></v-divider>
					<v-list-item><router-link :to="{ path: '/post' }"><v-btn height="48" text color="light-blue" tile><strong>动态</strong></v-btn></router-link></v-list-item>
					<v-divider></v-divider>
					<v-list-item><router-link :to="{ path: '/news' }"><v-btn height="48" text color="cyan" tile><strong>资讯</strong></v-btn></router-link></v-list-item>
					<v-divider></v-divider>
					<v-list-item><router-link :to="{ path: '/article' }"><v-btn height="48" text color="green" tile><strong>文章</strong></v-btn></router-link></v-list-item>
					<v-divider></v-divider>
					<v-list-item><router-link :to="{ path: '/review' }"><v-btn height="48" text color="red" tile><strong>评测</strong></v-btn></router-link></v-list-item>
					<v-divider></v-divider>
					<v-list-item><router-link :to="{ path: '/walkthrough' }"><v-btn height="48" text color="yellow" tile><strong>攻略</strong></v-btn></router-link></v-list-item>
					<v-divider></v-divider>
					<v-list-item><router-link :to="{ path: '/discuss' }"><v-btn height="48" text color="orange" tile><strong>论坛</strong></v-btn></router-link></v-list-item>
					<v-divider></v-divider>
					<v-list-item><router-link :to="{ path: '/search' }"><v-btn height="48" text color="purple" tile><strong>搜索</strong></v-btn></router-link></v-list-item>
				</v-list>
			</v-menu>
	</v-app-bar>
	
    <v-btn blue fab fixed bottom right @click="backTop" v-show="btnFlag">
        <v-icon>keyboard_arrow_up</v-icon>
    </v-btn>
	
	<v-row justify="center">
	    <v-dialog v-model="dialog1" max-width="400px">
			<v-card>
				<v-card-title>
				<span class="headline">用户登录</span>
				<v-spacer></v-spacer>
				<v-icon @click="dialog1 = false">mdi-close</v-icon>
				</v-card-title>
				<v-divider></v-divider>
				<v-card-text>
					<v-row class="px-5"><v-text-field v-model="username" label="用户名" hint="昵称" clearable :rules="[rules.required]"></v-text-field></v-row>
					<v-row class="px-5"><v-text-field v-model="password" label="密码" clearable
					:append-icon="show3 ? 'mdi-eye' : 'mdi-eye-off'" :rules="[rules.required]"
					:type="show3 ? 'text' : 'password'" @click:append="show3 = !show3"></v-text-field>
					<!--<v-checkbox v-model="checkbox" label="记住密码"></v-checkbox>-->
					</v-row>
					<v-row justify="end"><v-btn text @click="dialog3 = true">
					<small>忘记密码?</small></v-btn></v-row>
				</v-card-text>
			<v-divider></v-divider>
	        <v-card-actions>
				<v-btn color="blue darken-1" text @click="dialog2 = true">注册</v-btn>
				<v-spacer></v-spacer>
				<v-btn color="blue darken-1" text @click="login">登录</v-btn>
	        </v-card-actions>
			</v-card>
	    </v-dialog>
	</v-row>
	
	<v-row justify="center">
	    <v-dialog v-model="dialog2" max-width="400px">
			<v-card>
				<v-card-title>
				<span class="headline">用户注册</span>
				<v-spacer></v-spacer>
				<v-icon @click="dialog2 = false">mdi-close</v-icon>
				</v-card-title>
				<v-divider></v-divider>
				<v-card-text>
					<v-row class="px-5"><v-text-field label="昵称" hint="长度在1~20之间" :rules="[rules.required]"
					clearable counter="20" v-model="username1"></v-text-field></v-row>
					<v-row class="px-5"><v-text-field v-model="email1" label="邮箱" clearable :rules="[rules.required]"></v-text-field></v-row>
					<v-row class="px-5"><v-text-field  v-model="password1" label="密码" hint="长度在6~20之间" counter="20" 
					:append-icon="show1 ? 'mdi-eye' : 'mdi-eye-off'" :rules="[rules.required]"
					:type="show1 ? 'text' : 'password'" @click:append="show1 = !show1"></v-text-field></v-row>
					<v-row class="px-5"><v-text-field v-model="password2" label="重复输入密码" hint="长度在6~20之间" 
					counter="20" :append-icon="show2 ? 'mdi-eye' : 'mdi-eye-off'" :rules="[rules.required]"
					:type="show2 ? 'text' : 'password'" @click:append="show2 = !show2"></v-text-field>
					</v-row>
				</v-card-text>
			<v-divider></v-divider>
	        <v-card-actions>
				<v-spacer></v-spacer>
				<v-btn color="blue darken-1" text @click="signin">注册</v-btn>
	        </v-card-actions>
			</v-card>
	    </v-dialog>
	</v-row>
	
	<v-row justify="center">
	    <v-dialog v-model="dialog3" max-width="400px">
			<v-card>
				<v-card-title>
				<span class="headline">修改密码</span>
				<v-spacer></v-spacer>
				<v-icon @click="dialog3 = false">mdi-close</v-icon>
				</v-card-title>
				<v-divider></v-divider>
				<v-card-text>
					<v-row class="px-5"><v-text-field label="邮箱" clearable :rules="[rules.required]"></v-text-field>
					<v-btn text class="primary mt-2 ml-2" @click="send">发送验证码</v-btn></v-row>
					<v-row class="px-5"><v-text-field label="验证码" clearable :rules="[rules.required]"></v-text-field></v-row>
					<v-row class="px-5"><v-text-field label="新密码" clearable
					:append-icon="show4 ? 'mdi-eye' : 'mdi-eye-off'" :rules="[rules.required]"
					:type="show4 ? 'text' : 'password'" @click:append="show4 = !show4"></v-text-field>
					</v-row>
				</v-card-text>
			<v-divider></v-divider>
	        <v-card-actions>
				<v-spacer></v-spacer>
				<v-btn color="blue darken-1" text @click="change">确定</v-btn>
	        </v-card-actions>
			</v-card>
	    </v-dialog>
	</v-row>
			
    <v-content>
		<router-view></router-view>
    </v-content>
		
	<v-footer padless tile light height="auto">
		<v-card class="flex" tile>
		<v-card-title class="blue-grey darken-1 teal">
        <v-spacer></v-spacer>
        <v-btn v-for="icon in icons" :key="icon" class="mx-3" dark icon>
          <v-icon size="24px">{{ icon }}</v-icon>
        </v-btn>
		</v-card-title>
		<v-card-actions class="blue-grey darken-2 justify-center">
        &copy;2020 — <strong>LynxHawk</strong>
		</v-card-actions>
		</v-card>
	</v-footer>
	
	<v-snackbar top color="success" v-model="snackbar1">注册成功
		<v-btn dark text @click="snackbar1 = false">关闭</v-btn></v-snackbar>
		<v-snackbar top color="success" v-model="snackbar2">登录成功
		<v-btn dark text @click="snackbar2 = false">关闭</v-btn></v-snackbar>
		<v-snackbar top color="error" v-model="snackbar3">注册失败
		<v-btn dark text @click="snackbar3 = false">关闭</v-btn></v-snackbar>
		<v-snackbar top color="error" v-model="snackbar4">登录失败
		<v-btn dark text @click="snackbar4 = false">关闭</v-btn></v-snackbar>
		<v-snackbar top color="success" v-model="snackbar5">发送验证码成功
		<v-btn dark text @click="snackbar5 = false">关闭</v-btn></v-snackbar>
		<v-snackbar top color="success" v-model="snackbar6">修改成功
	<v-btn dark text @click="snackbar6 = false">关闭</v-btn></v-snackbar>
	
	</v-app>
</template>

<script>
export default {
	name: 'App',
	data() {
		return {
			btnFlag:false,power:null,id:null,length:0,
			dialog1:false,dialog2:false,dialog3:false,
			show1:false,show2:false,show3:false,show4:false,
			nickname:null,avatar:null,
			username:null,password:null,
			drawer:null,checkbox:false,
			username1:null,email1:null,
			password1:null,password2:null,
			snackbar1:false,snackbar2:false,snackbar3:false,snackbar4:false,snackbar5:false,snackbar6:false,
			messages:null,
			items: [
				//{ icon: 'dashboard', title: '个人中心', path:'myspace'+'/'+this.id},
				{ icon: 'mdi-bell', title: '消息提醒' , path:'message'},
				{ icon: 'mdi-package',title: '我的发表', path:'publish'},
				{ icon: 'mdi-heart', title: '我的关注', path:'follow' },
				{ icon: 'mdi-bookmark-multiple', title: '我的收藏', path:'collection' },
				{ icon: 'mdi-forum', title: '我的评论', path:'comment' },
				{ icon: 'chat_bubble', title: '反馈', path:'feedback' },
				{ icon: 'settings', title: '设置', path:'setting' }
				],
			icons: ['mdi-qqchat','mdi-twitter','mdi-github-circle','mdi-steam','mdi-email'],
			rules: {
			required: value => !!value || '不能为空'
			}
		}
    },
	created() {
		if(localStorage.getItem("username")!=null){
			this.nickname=localStorage.getItem("username");
			this.power=localStorage.getItem("power");
			this.avatar=localStorage.getItem("avatar");
			this.id=localStorage.getItem("id");
			this.$axios.get('http://localhost:8888/getunread/'+localStorage.getItem("id")).then((response)=>{
				this.messages=response.data;
			});
		}
	},
	mounted () {
		window.addEventListener('scroll', this.scrollToTop);
		// window.addEventListener('storage', function (e) {
		//     localStorage.setItem(e.key, e.oldValue);
		// });
		// var x = document.createElement('div');
		//   Object.defineProperty(x, 'id', {
		//       get:function(){
		//           // 在这里放入你的代码
		//           alert('禁止打开控制台');
		// 		 window.location.href="https://www.baidu.com";
		//       }
		//   });
		// console.log(x);
	},
	destroyed () {
		window.removeEventListener('scroll', this.scrollToTop)
	},
	methods: {
		opendialog(){
			if(localStorage.getItem("id")==null){
				this.dialog1=true;
			}
		},
		login(){
			this.$axios.get('http://localhost:8888/login',{
			        params:{
			            username:this.username,
						password:this.password
			        }
			    }).then((response)=>{
			        var a = response.data;
					if(a==true){
						console.log("success");
						this.snackbar2=true;
						this.dialog1=false;
						this.$axios.get('http://localhost:8888/getuserinfo/'+this.username).then((res)=>{
							localStorage.setItem("id",res.data[0].id);
							localStorage.setItem("username",res.data[0].username);
							localStorage.setItem("avatar",res.data[0].avatar);
							localStorage.setItem("background",res.data[0].background);
							localStorage.setItem("power",res.data[0].power);
							this.power=localStorage.getItem("power");
							this.nickname=localStorage.getItem("username");
							this.avatar=localStorage.getItem("avatar");
							this.id=localStorage.getItem("id");
							this.$axios.get('http://localhost:8888/getunread/'+localStorage.getItem("id")).then((response)=>{
								this.messages=response.data;
							});
						})
					}
			    }).catch((error)=>{
			        console.log(error);
					this.snackbar4=true;
			    });
		},
		signin(){
			if(this.password1==this.password2){
				this.$axios.get('http://localhost:8888/signin',{
				        params:{
				            username:this.username1,
							email:this.email1,
							password:this.password1
				        }
				    }).then((response)=>{
						var a = response.data;
						if(a==true){
							this.dialog2=false;
							this.snackbar1=true;
						}else{
							this.snackbar3=false;
						}
					})
			}
			else{
				this.snackbar3=true;
			}
		},
		logout(){
			localStorage.clear();
			this.username=null;
			this.nickname=null;
			this.power=null;
			this.avatar=null;
			this.messages=null;
			this.$router.push({ path: '/'});
		},
		send(){
			this.snackbar5=true;
		},
		change(){
			this.snackbar6=true;
			this.dialog3=false;
		},
        // 点击图片回到顶部方法，加计时器是为了过渡顺滑
		backTop () {
			let that = this
			let timer = setInterval(() => {
			let ispeed = Math.floor(-that.scrollTop / 5)
			document.documentElement.scrollTop = document.body.scrollTop = that.scrollTop + ispeed
				if (that.scrollTop === 0) {
					clearInterval(timer)
				}
			}, 16)
		},
        // 为了计算距离顶部的高度，当高度大于60显示回顶部图标，小于60则隐藏
		scrollToTop () {
			let that = this
			let scrollTop = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop
			that.scrollTop = scrollTop
			if (that.scrollTop > 60) {
				that.btnFlag = true
			} else {
				that.btnFlag = false
			}
		}
	}
	
}
</script>

<style>
.v-card{
	opacity: .0s;
}
a{
  text-decoration: none;
}
 
.router-link-active {
  text-decoration: none;
	color: #000000;
}
</style>
