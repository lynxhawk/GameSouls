<template>
	<v-row justify="center" width="800px" align="center">
		<v-card style="width: 800px;" class="px-6" tile>
			<v-row class="pt-4">
			<v-text-field prepend-icon="mdi-format-title" color="orange" clearable v-model="title" label="帖子标题"></v-text-field>
			<v-btn color="orange" text tile height="50" width="70" class="ml-2" @click="upload">
				<strong>提交</strong></v-btn>
			</v-row>
			<v-row>
				<v-textarea color="orange" class="pt-2" label="帖子内容" v-model="text" clearable></v-textarea>
			</v-row>
			<v-row>
				<!--<v-file-input color="orange" v-model="files" placeholder="上传图片" prepend-icon="mdi-image"
				accept="image/png, image/jpeg, image/bmp" show-size multiple></v-file-input>-->
				<v-text-field v-model="cover" color="orange" prepend-icon="mdi-image" clearable label="论坛封面"></v-text-field>
			</v-row>
		</v-card>
		<v-snackbar top color="success" class="mt-12" v-model="snackbar">发布成功
		<v-btn dark text @click="snackbar = false">关闭</v-btn></v-snackbar>
	</v-row>
</template>

<script>
	export default{
		data(){
			return{
				snackbar:false,text:'',title:'',cover:'',
			}
		},
		methods:{
			upload(){
				let data={
					userid:localStorage.getItem("id"),
					username:localStorage.getItem("username"),
					avatar:localStorage.getItem("avatar"),
					title:this.title,
					text:this.text,
					image:this.cover
				};
				this.$axios.post('http://localhost:8888/adddiscuss/',data).then((response)=>{
					this.snackbar=true;
					this.$router.go(-1);
				})
				//console.log(this.content);
			}
		}
	}			
</script>

<style>
</style>
