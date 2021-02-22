<template>
	<v-img width="1920px" :aspect-ratio="16/9" :src="background">
	<v-container class="py-4">
		<v-toolbar color="white" width="800px" class="mx-auto my-2">
		    <v-toolbar-title>举报管理</v-toolbar-title>
		    <v-spacer></v-spacer>
		</v-toolbar>
		<template v-for="(item, index) in items">
		<v-card width="800px" class="mx-auto my-2" tile>
			<v-card-title>{{item.username}}<v-spacer></v-spacer>
			<v-icon @click="deletereport(index)">mdi-delete</v-icon></v-card-title>
			<v-card-text>举报了{{item.type}}{{item.title}}</v-card-text>
		</v-card>
		</template>
		<v-pagination :length="length" v-model="page1" total-visible="12"></v-pagination>
		<v-snackbar top color="success" v-model="snackbar1" class="mt-12">删除成功
			<v-btn dark text @click="snackbar1 = false">关闭</v-btn></v-snackbar>
		<v-snackbar top color="error" v-model="snackbar2" class="mt-12">删除失败
			<v-btn dark text @click="snackbar2 = false">关闭</v-btn></v-snackbar>
	</v-container>
	</v-img>
</template>

<script>
	export default {
		name: 'App',
		data() {
			return {
				snackbar1:false,snackbar2:false,page1:1,length:null,
				items:[],totalitems:[],
			}
		},
		methods:{
			deletereport(index){
				this.$axios.get('api/deletereport/'+this.items[index].id).then((response)=>{
					this.snackbar1=true;
					this.items.splice(index, 1);
				})
			}
		},
		created() {
			if(localStorage.getItem("background")!=null){
				this.background=localStorage.getItem("background");
			}
			this.$axios.get('api/getreportlist').then((response)=>{
			    var a = response.data;
				this.length=Math.ceil(a.length/5);
					for (let i = 0; i < this.length; i++) {
						this.totalitems[i] = a.slice(5 * i, 5 * (i + 1));
					}
				this.items = this.totalitems[this.page1-1];
			});
		},
		watch:{
			page1(val, oldVal){
				this.items = this.totalitems[val-1];
			}
		}
	}	
</script>

<style>
</style>
