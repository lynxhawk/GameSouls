<template>
	<v-container>
	<v-card tile class="mx-auto" max-width="800px" style="margin-top: 30px;" height="730px">
	    <v-toolbar color="purple" dark dense><v-toolbar-title>设置</v-toolbar-title>
		</v-toolbar>
	    <v-list subheader>
			<v-subheader>用户基本信息设置</v-subheader>
			<v-list-item>
				<v-list-item-content>
					<v-list-item-title>更改头像</v-list-item-title>
				</v-list-item-content>
				<v-avatar size="60"><v-img :src="avatar"></v-img></v-avatar>
				<!--<v-file-input style="margin-left:40px;width: 150px;" v-model="avatar" placeholder="上传头像" prepend-icon="mdi-account-box" :rules="[rules.size]"
				accept="image/png, image/jpeg, image/bmp" show-size ref="avatar"></v-file-input>-->
				<v-text-field label="上传头像" v-model="avatar" clearable></v-text-field>
				<v-btn @click="updateavatar" text tile>提交</v-btn>
			</v-list-item>
			<v-divider></v-divider>
			<v-list-item>
				<v-list-item-content>
					<v-list-item-title>更改用户名</v-list-item-title>
					<v-list-item-subtitle>如有重复则更改失败</v-list-item-subtitle>
				</v-list-item-content>
				<v-spacer></v-spacer>
				<v-text-field clearable label="新用户名" v-model="username"></v-text-field>
				<v-btn text tile @click="updatename">提交</v-btn>
			</v-list-item>
			<v-divider></v-divider>
			<v-list-item>
				<v-list-item-content>
					<v-list-item-title>更改邮箱</v-list-item-title>
					<v-list-item-subtitle>如有重复则更改失败</v-list-item-subtitle>
				</v-list-item-content>
				<v-spacer></v-spacer>
				<v-text-field clearable label="新邮箱" v-model="email"></v-text-field>
				<v-btn text tile @click="updateemail">提交</v-btn>
			</v-list-item>
			<v-divider></v-divider>
			<v-list-item>
				<v-list-item-content>
					<v-list-item-title>更改感兴趣的游戏类型</v-list-item-title>
				</v-list-item-content>
				<v-combobox v-model="chips" :items="items" chips clearable label="游戏类型"
				    multiple prepend-inner-icon="mdi-heart-multiple-outline">
				    <template v-slot:selection="{ attrs, item, select, selected }">
						<v-chip v-bind="attrs" :input-value="selected" close label ripple
						@click="select" @click:close="remove(item)">
				        <strong>{{ item }}</strong>
						</v-chip>
				    </template>
				</v-combobox>
				<v-btn text tile @click="updatetype">提交</v-btn>
			</v-list-item>
			<v-divider></v-divider>
			<v-list-item>
				<v-list-item-content>
					<v-list-item-title>更改密码</v-list-item-title>
					<v-list-item-subtitle>需验证旧密码</v-list-item-subtitle>
				</v-list-item-content>
				<v-col>
					<v-text-field label="旧密码" clearable
					:append-icon="show1 ? 'mdi-eye' : 'mdi-eye-off'"
					:type="show1 ? 'text' : 'password'" @click:append="show1 = !show1" v-model="pwd1"></v-text-field>
					<v-text-field label="新密码" clearable
					:append-icon="show2 ? 'mdi-eye' : 'mdi-eye-off'"
					:type="show2 ? 'text' : 'password'" @click:append="show2 = !show2" v-model="pwd2"></v-text-field>
					<v-row justify="end"><v-btn text tile @click="updatepassword">提交</v-btn></v-row>
				</v-col>
			</v-list-item>
			<v-divider></v-divider>
			<v-list-item>
				<v-list-item-content>
					<v-list-item-title>更改个人主页背景图片</v-list-item-title>
				</v-list-item-content>
				<!--<v-file-input style="width: 100px;" v-model="background" placeholder="上传图片" prepend-icon="mdi-image"
				accept="image/png, image/jpeg, image/bmp" show-size></v-file-input>-->
				<v-text-field label="更新背景图" v-model="background" clearable></v-text-field>
				<v-btn @click="updatebackground" text tile>提交</v-btn>
			</v-list-item>
			<v-divider></v-divider>
			<v-list-item>
				<v-list-item-content>
					<v-list-item-title>更改个人主页介绍</v-list-item-title>
				</v-list-item-content>
				<v-text-field label="更新介绍" v-model="introduce" clearable></v-text-field>
				<v-btn @click="updateintroduce" text tile>提交</v-btn>
			</v-list-item>
		</v-list>
	</v-card>

	<v-card v-if="power==1||power==2" tile class="mx-auto" max-width="800px" style="margin-top:30px;" height="420px">
		<v-toolbar color="blue" dark dense><v-toolbar-title>设置首页轮播内容</v-toolbar-title></v-toolbar>
		<v-row class="mx-4 mt-2">
			<v-select :items="ids" v-model="id" label="需要更改的轮播图的id"></v-select>
			<v-text-field clearable class="ml-4" label="轮播图标题" v-model="title"></v-text-field>
		</v-row>
		<v-row class="mx-4"><v-text-field clearable label="轮播图URL" v-model="image"></v-text-field></v-row>
		<v-row class="mx-4"><v-textarea label="轮播图内容" v-model="text" clearable></v-textarea></v-row>
		<v-row class="mx-4 mb-2"><v-spacer></v-spacer><v-btn text @click="setup">提交</v-btn></v-row>
	</v-card>	
	<v-snackbar top class="mt-12" color="success" v-model="snackbar">提交成功
		<v-btn dark text @click="snackbar = false">关闭</v-btn></v-snackbar>
	<v-snackbar top class="mt-12" color="error" v-model="snackbar1">提交失败
		<v-btn dark text @click="snackbar1 = false">关闭</v-btn></v-snackbar>
	</v-container>
</template>

<script>
export default{
	data(){
		return{
			snackbar:false,snackbar1:false,chips:[],attrs:[],selected:[],
			ids:[1,2,3,4],image:null,text:null,title:null,id:null,introduce:null,
			show1:false,show2:false,
			pwd1:null,pwd2:null,
			email:null,username:null,power:null,avatar:'',background:null,
			items: ['RPG', 'FPS','MMORPG','ARPG','MOBA','策略','解谜','单机','手游','音游']
		}
	},
	created() {
		if(localStorage.getItem("id")!=null){
			this.power=localStorage.getItem("power");
		}
	},
	methods:{
		updateavatar(){
			this.$axios.get('api/updateavatar/'+localStorage.getItem("id"),{
			    params:{
					avatar:this.avatar
			    }
			}).then((response)=>{
				this.snackbar=true;
				localStorage.setItem("avatar",this.avatar);
			});
		},
		updatename(){
			this.$axios.get('api/updateusername/'+localStorage.getItem("id"),{
			    params:{
					username:this.username
			    }
			}).then((response)=>{
				if(response.data==true){
					this.snackbar=true;
					localStorage.setItem("username",this.username);
				}else{
					this.snackbar1=true;
				}
			});
		},
		updateemail(){
			this.$axios.get('api/updateemail/'+localStorage.getItem("id"),{
			    params:{
					email:this.email
			    }
			}).then((response)=>{
				if(response.data==true){
					//localStorage.setItem("email",this.email);
					this.snackbar=true;
				}else{
					this.snackbar1=true;
				}
			});
		},
		updatetype(){
			this.$axios.get('api/updategametype/'+localStorage.getItem("id"),{
			    params:{
					gametype:this.chips.toString()
			    }
			}).then((response)=>{
				this.snackbar=true;
				//localStorage.setItem("gametype",this.chips.toString());
			});
		},
		updatepassword(){
			this.$axios.get('api/updatepassword/'+localStorage.getItem("id"),{
			    params:{
					password1:this.pwd1,
					password2:this.pwd2
			    }
			}).then((response)=>{
				if(response.data==true){
					this.snackbar=true;
				}else{
					this.snackbar1=true;
				}
			});
		},
		updatebackground(){
			this.$axios.get('api/updatebackground/'+localStorage.getItem("id"),{
			    params:{
					background:this.background
			    }
			}).then((response)=>{
				this.snackbar=true;
				localStorage.setItem("background",this.background);
			});
		},
		updateintroduce(){
			this.$axios.get('api/updateintroduce/'+localStorage.getItem("id"),{
			    params:{
					introduce:this.introduce
			    }
			}).then((response)=>{
				this.snackbar=true;
			});
		},
		setup(){
			this.$axios.get('api/updateindex/'+this.id,{
			    params:{
					text:this.text,
					title:this.title,
					image:this.image
			    }
			}).then((response)=>{
				if(response.data==true)
				this.snackbar=true;
			});
		},
		remove (item) {
			this.chips.splice(this.chips.indexOf(item), 1)
			this.chips = [...this.chips]
		},
		showavatar(){
			// let formData = new FormData();
			// formData.append('avatar', this.avatar);
			//     axios({
			//         method: 'post',
			//         url: '/api/updateavatar/'+localStorage.getItem("id"),
			//               data:formData,
			//               headers: {
			//                 'Content-Type': 'multipart/form-data'
			//               }
			//             })
			//             .then(function (res) {
			//               console.log(res)
			//             })
			//var reader = new FileReader();
			//reader.readAsDataURL(this.avatar); // 读出 base64
			//reader.onloadend = function () {
			// // 图片的 base64 格式, 可以直接当成 img 的 src 属性值
			//var dataURL = reader.result;
			//console.log(dataURL);
			//     this.url = dataURL;
			// 	//console.log(this.url);
			//}
			this.url = URL.createObjectURL(this.avatar);
		},
		
	}
}
</script>

<style>
</style>
