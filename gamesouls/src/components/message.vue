<template>
	<v-img width="1920px" :aspect-ratio="16/9" :src="background">
		<v-row justify="center">
			<v-card tile width="800px" height="600px" style="opacity: 0.9;margin-top: 60px;overflow-y: auto;">
				<v-list two-line>
					<template v-for="(item, index) in items" >
						<v-list-item @click="read(index)">
						
				        <v-list-item-content>
							<v-list-item-title v-if="item.unread==0">
								<v-sheet class="black--text">{{item.type}}{{item.title}}收到了{{item.username}}的{{item.type1}}</v-sheet>
							</v-list-item-title>
							<v-list-item-title v-if="item.unread==1">
								<v-sheet class="grey--text">{{item.type}}{{item.title}}收到了{{item.username}}的{{item.type1}}</v-sheet>
							</v-list-item-title>
							<v-list-item-subtitle v-text="item.date"></v-list-item-subtitle>
				        </v-list-item-content>
				
				        <v-list-item-action>
							<v-btn icon :key="index" :content="item" :index="index" @click="deletes(index)"><v-icon color="grey">mdi-close</v-icon></v-btn>
				        </v-list-item-action>
						
						</v-list-item>
						<v-divider></v-divider>
					</template>
				</v-list>
			</v-card>
		</v-row>
		<v-snackbar top color="success" v-model="snackbar1" class="mt-12">删除成功
			<v-btn dark text @click="snackbar1 = false">关闭</v-btn></v-snackbar>
	</v-img>
</template>

<script>
	export default{
		name: 'App',
		data(){
			return{
				background:null,snackbar1:false,
				items:[]
			}
		},
		created() {
			if(localStorage.getItem("id")!=null){
				this.background=localStorage.getItem("background");
			}
			this.$axios.get('api/getmessagelist/'+localStorage.getItem("id")).then((res)=>{
				  this.items=res.data;
			});
		},
		methods:{
			read:function(index){
				this.$axios.get('api/readmessage/'+this.items[index].id).then((res)=>{
					this.items[index].unread=1;
				});
			},
			deletes:function(index) {
				this.$axios.get('api/deletemessage/'+this.items[index].id).then((res)=>{
					if(res.data==true){
						this.items.splice(index, 1);
						this.snackbar1=true;
					}
				});
			}
		}
	}
</script>

<style>
</style>
