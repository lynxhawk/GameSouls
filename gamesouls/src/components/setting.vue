<template>
	<v-img width="1920px" :aspect-ratio="16/9" src="../../public/static/images/dk3.jpg">
	<v-card tile class="mx-auto" max-width="800px" style="margin-top: 60px;overflow-y: auto;" height="600px">
	    <v-toolbar color="white" dense><v-toolbar-title>设置</v-toolbar-title>
		</v-toolbar>
	    <v-list subheader>
			<v-subheader>用户基本信息设置</v-subheader>
			<v-list-item>
				<v-list-item-content>
					<v-list-item-title>更改头像</v-list-item-title>
				</v-list-item-content><!--G://picture/lynx.jpg-->
				<v-avatar size="60"><v-img :src="url"></v-img></v-avatar>
				<v-file-input style="margin-left:40px;width: 150px;" v-model="avatar" placeholder="上传头像" prepend-icon="mdi-account-box" :rules="[rules.size]"
				accept="image/png, image/jpeg, image/bmp" show-size ref="avatar"></v-file-input>
				<v-btn @click="showavatar" text tile>提交</v-btn>
			</v-list-item>
			<v-divider></v-divider>
			<v-list-item>
				<v-list-item-content>
					<v-list-item-title>更改用户名</v-list-item-title>
					<v-list-item-subtitle>如有重复则更改失败</v-list-item-subtitle>
				</v-list-item-content>
				<v-spacer></v-spacer>
				<v-text-field clearable label="新用户名" :value="username"></v-text-field>
				<v-btn text tile @click="snackbar">提交</v-btn>
			</v-list-item>
			<v-divider></v-divider>
			<v-list-item>
				<v-list-item-content>
					<v-list-item-title>更改邮箱</v-list-item-title>
					<v-list-item-subtitle>如有重复则更改失败</v-list-item-subtitle>
				</v-list-item-content>
				<v-spacer></v-spacer>
				<v-text-field clearable label="新邮箱" :value="email"></v-text-field>
				<v-btn text tile @click="snackbar">提交</v-btn>
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
				<v-btn text tile @click="snackbar">提交</v-btn>
			</v-list-item>
			<v-divider></v-divider>
			<v-list-item>
				<v-list-item-content>
					<v-list-item-title>更改密码</v-list-item-title>
					<v-list-item-subtitle>需验证旧密码</v-list-item-subtitle>
				</v-list-item-content>
				<v-col>
					<v-text-field label="旧密码" clearable
					:append-icon="show1 ? 'mdi-eye' : 'mdi-eye-off'" :rules="[rules.required, rules.min,rules.max]"
					:type="show1 ? 'text' : 'password'" @click:append="show1 = !show1" :value="pwd1"></v-text-field>
					<v-text-field label="新密码" clearable
					:append-icon="show2 ? 'mdi-eye' : 'mdi-eye-off'" :rules="[rules.required, rules.min,rules.max]"
					:type="show2 ? 'text' : 'password'" @click:append="show2 = !show2" :value="pwd2"></v-text-field>
					<v-row justify="end"><v-btn text tile @click="snackbar">提交</v-btn></v-row>
				</v-col>
			</v-list-item>
			<v-divider></v-divider>
			<v-list-item>
				<v-list-item-content>
					<v-list-item-title>更改个人主页背景图片</v-list-item-title>
				</v-list-item-content>
				<v-file-input style="width: 100px;" v-model="background" placeholder="上传图片" prepend-icon="mdi-image"
				accept="image/png, image/jpeg, image/bmp" show-size></v-file-input>
				<v-btn @click="" text tile>提交</v-btn>
			</v-list-item>
		</v-list>
	</v-card>
	<v-snackbar bottom color="success" v-model="snackbar">提交成功
		<v-btn dark text @click="snackbar = false">关闭</v-btn></v-snackbar>
	</v-img>
</template>

<script>
export default{
	data(){
		return{
			snackbar:false,chips:[],attrs:[],
			show1:false,show2:false,
			background:'',
			avatar:'',url:'',
			pwd1:'',pwd2:'',
			email:'',username:'',
			items: ['RPG', 'FPS','MMORPG','ARPG','MOBA','策略','解谜','单机','手游','音游'],
			rules: {
			required: value => !value || '不能为空',
			min: value => value.length >= 6 || '长度不能小于1' ,
			max: value => value.length <=20 || '长度不能大于20',
			emailMatch: () => ('电子邮件格式不匹配'),
			size:value => !value || value.size < 2000000 || '头像大小需小于 2 MB!',
			},
		}
	},
	methods:{
		submit(){
			snackbar:true
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
