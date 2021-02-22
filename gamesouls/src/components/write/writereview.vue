<template>
	<v-row justify="center" width="800px" class="mt-6">
		<v-card style="width: 800px;" class="px-6" tile>
			<v-row class="pt-4">
			<v-text-field v-model="game" prepend-icon="mdi-microsoft-xbox-controller" color="red" clearable label="游戏名"></v-text-field>
			<v-btn color="red" text tile height="50" width="70" class="ml-2" @click="upload">
				<strong>提交</strong></v-btn>
			</v-row>
			<v-row align="center">
				<v-sheet>评分</v-sheet>
				<v-rating v-model="rate" background-color="orange lighten-3"
				color="yellow accent-4" half-increments hover size="30"></v-rating>
			</v-row>
			<v-row>
				<v-textarea color="red" class="pt-2" label="评论" v-model="text" clearable></v-textarea>
			</v-row>
			<v-row>
				<!--<v-file-input color="red" v-model="background" placeholder="评测封面" prepend-icon="mdi-image"
				accept="image/png, image/jpeg, image/bmp" show-size></v-file-input>-->
				<v-text-field v-model="cover" color="red" prepend-icon="mdi-image" clearable label="评测封面"></v-text-field>
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
				rate:0,text:'',game:'',cover:'',snackbar:false
			}
		},
		methods:{
			upload(){
				let data={
					userid:localStorage.getItem("id"),
					username:localStorage.getItem("username"),
					avatar:localStorage.getItem("avatar"),
					game:this.game,
					rate:this.rate,
					text:this.text,
					cover:this.cover
				};
				this.$axios.post('http://localhost:8888/addreview/',data).then((response)=>{
					this.snackbar=true;
					this.$router.go(-1);
				})
			}
		}
		
	}			
</script>

<style>
</style>
