<template>
	<v-img width="1920px" :aspect-ratio="16/9" :src="background">
	<v-row justify="center">
	
	<v-card class="mt-12" style="width: 800px" height="370px" tile>
		<v-toolbar color="white" dense><v-toolbar-title>用户反馈</v-toolbar-title></v-toolbar>
		<v-row class="ml-4 mr-4">
		<v-textarea v-model="feedback" clearable counter="500" height="200px" required>
		</v-textarea>
		</v-row>
		
		<!--<v-file-input multiple label="上传图片" accept=".png, .jpg, .jpeg" 
		 show-size clearable counter v-model="files">
			<template v-slot:selection="{ text }">
				<v-chip small label color="primary">
		         {{ text }}
		       </v-chip>
		    </template>
		</v-file-input>-->
		<v-sheet height="20px"></v-sheet>

		<v-row justify="end">
		<v-btn class="mr-4 title" height="50px" width="100px" @click="submit" text tile>提交</v-btn>
		</v-row>	
	</v-card>
	</v-row>
		<v-snackbar top class="mt-12" color="success" v-model="snackbar">提交成功 
		<v-btn dark text @click="snackbar = false">关闭</v-btn></v-snackbar>
		<v-snackbar top class="mt-12" color="error" v-model="snackbar1">提交失败
		<v-btn dark text @click="snackbar1 = false">关闭</v-btn></v-snackbar>
	</v-img>
	
</template>

<script>
	export default {
	    data: () => ({
			snackbar:false,snackbar1:false,
			feedback:'',
			background:null,
	    }),
		created() {
			if(localStorage.getItem("background")!=null){
				this.background=localStorage.getItem("background");
			}
		},
		methods: {
		    submit () {
				if(this.feedback!='')
				{
					this.$axios.get('api/addfeedback',{
						params:{
						    userid:localStorage.getItem("id"),
							username:localStorage.getItem("username"),
							text:this.feedback
						    }
						}).then((response)=>{
							this.snackbar=true;
						})
				}else{
					this.snackbar1=true;
				}
			}
		}
	}
</script>

<style>
</style>
