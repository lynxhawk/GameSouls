<template>
	<v-container>
		<v-row justify="center">
		<v-card width="800px" tile>
			<v-row justify="center" class="display-1 pt-12 pb-12">{{title}}</v-row>
			<v-row align="center" class="px-12 pb-6">
				<v-sheet class="subtitle-1 ml-3">{{username}}</v-sheet>
				<v-spacer></v-spacer>
				<v-btn tile color="amber" dark @click="updatewalk">确认修改</v-btn>
			</v-row>
			<v-row class="px-12">
				<v-sheet v-html="text"></v-sheet>
			</v-row>
		</v-card>
		</v-row>
		<v-snackbar top color="success" class="mt-12" v-model="snackbar">确认成功
		<v-btn dark text @click="snackbar = false">关闭</v-btn></v-snackbar>
	</v-container>
</template>

<script>
	export default{
		data(){
			return{
				text:'',title:'',username:'',userid:'',id:'',workid:'',
				snackbar:false
			}
		},
		created() {
			this.$axios.get('http://localhost:8888/getcheckinfo/'+this.$route.params.id).then((response)=>{
			    var a = response.data[0];
				this.text=a.text;
				this.title=a.title;
				this.username=a.username;
				this.userid=a.userid;
				this.id=a.id;
				this.workid=a.workid;
			});
		},
		methods:{
			updatewalk(){
				let data={
					id:this.id,
					userid:this.userid,
					workid:this.workid,
					title:this.title,
					text:this.text
				};
				this.$axios.post('http://localhost:8888/updatewalk/',data).then((response)=>{
					this.snackbar=true;
					this.$router.go(-1);
				})
			}
		}
	}
</script>

<style>
img{
	width: 100%;
}
</style>
