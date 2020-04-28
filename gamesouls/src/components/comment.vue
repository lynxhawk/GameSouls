<template>
	<v-img width="1920px" :aspect-ratio="16/9" src="../../public/static/images/dk3.jpg">
	<v-row justify="center">
	<v-card tile width="800px" height="600px"style="opacity: 0.9;margin-top: 60px;">
		<v-tabs vertical>
	      <v-tab>
	        <v-icon left>mdi-comment-text-multiple</v-icon>
			我的评论
	      </v-tab>
	      <v-tab>
	        <v-icon left>mdi-message-reply-text</v-icon>
	        我的回复
	      </v-tab>
	
	    <v-tab-item>
	        <v-card flat height="610px">
	        <v-list three-line>
				<template v-for="(item, index) in items">
	                <v-list-item>
					<v-row>
						<v-sheet class="mr-2 light-blue--text">你在</v-sheet>
						<strong>{{item.title}}</strong>
						<v-sheet class="mx-2 light-blue--text">中评论了</v-sheet>
						<strong>{{item.subtitle}}</strong>
					</v-row>
					</v-list-item>
					<v-divider></v-divider>
	                </template>
	            </v-list>
				<v-pagination class="my-2" :length="20" v-model="page1" total-visible="8"></v-pagination>
	        </v-card>
		</v-tab-item>
	    <v-tab-item>
			<v-card flat height="610px">
			<v-list three-line>
				<template v-for="(item, index) in items">
			        <v-list-item>
						<v-row>
							<v-sheet class="mr-2 light-blue--text">你在</v-sheet>
							<strong>{{item.title}}</strong>
							<v-sheet class="mx-2 light-blue--text">中回复了</v-sheet>
							<strong>{{item.subtitle}}</strong>
						</v-row>
					</v-list-item>
					<v-divider></v-divider>
			        </template>
			    </v-list>
				<v-pagination class="my-2" :length="20" v-model="page1" total-visible="8"></v-pagination>
			</v-card>
	    </v-tab-item>
	    </v-tabs>
	</v-card>
	</v-row>
	
	<v-snackbar bottom color="success" v-model="snackbar">举报成功
	<v-btn dark text @click="snackbar = false">关闭</v-btn></v-snackbar>
	
	<v-snackbar bottom color="success" v-model="snackbar1">关注成功
	<v-btn dark text @click="snackbar1 = false">关闭</v-btn></v-snackbar>
	
	</v-img>
</template>

<script>
	export default {
		name: 'App',
		data() {
			return {
				snackbar:false,snackbar1:false,
				page1:1,page2:1,
				items: [
				        {
						  title: 'mike',
				          subtitle: "I'll be in your neighborhood doing errands this weekend. Do you want to hang out?",
				        },
				        {
						  title: 'elf',
				          subtitle: "Wish I could come, but I'm out of town this weekend.",
				        },				   
						{
						  title: 'jack',
				          subtitle: "Do you have Paris recommendations? Have you ever been?",
				        },				        
				        {
						  title: 'alice',
				          subtitle: "Have any ideas about what we should get Heidi for her birthday?",
				        },				       
				        {
						  title:'candy',
				          subtitle: "We should eat this: Grate, Squash, Corn, and tomatillo Tacos.",
				        },
						{
						  title: 'jack',
						  subtitle: "Do you have Paris recommendations? Have you ever been?",
						}
						]
			}
		},
		methods:{
			deteles(index){
				this.items.splice(index,1);
			},
			jubao(index){
				this.snackbar=true;
			},
			follow(index){
				this.snackbar1=true;
			}
		}
	}
</script>

<style>
</style>
