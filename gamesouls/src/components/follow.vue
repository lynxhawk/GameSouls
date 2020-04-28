<template>
	<v-img width="1920px" :aspect-ratio="16/9" src="../../public/static/images/dk3.jpg">
	<v-row justify="center">
	<v-card tile width="800px" height="600px"style="opacity: 0.9;margin-top: 60px;">
		<v-tabs vertical>
	      <v-tab>
	        <v-icon left>mdi-account-heart</v-icon>
	        正在关注
	      </v-tab>
	      <v-tab>
	        <v-icon left>mdi-account-heart-outline</v-icon>
	        关注者
	      </v-tab>
	
	    <v-tab-item>
	        <v-card flat height="600px" style="overflow-y: auto;">
	        <v-list three-line>
				<template v-for="(item, index) in items">
	                <v-list-item>
						<v-list-item-avatar><v-img :src="item.avatar"></v-img></v-list-item-avatar>
						<v-list-item-content>
							<v-list-item-title v-html="item.title"></v-list-item-title>
							<v-list-item-subtitle v-html="item.subtitle"></v-list-item-subtitle>
						</v-list-item-content>
						<v-list-item-action>
						<v-row>
					    <v-btn text>
					        <v-icon color="primary">mdi-account-multiple-check</v-icon>
					        正在关注</v-btn>
						<v-menu>
							<template v-slot:activator="{ on }">
					        <v-btn icon v-on="on"><v-icon>mdi-dots-vertical</v-icon></v-btn>
							</template>
								<v-list>
									<v-list-item>
										<v-btn text @click="deteles(index)">取消关注</v-btn>
							        </v-list-item>
									<v-divider></v-divider>
									<v-list-item><v-btn text @click="jubao(index)">举报</v-btn></v-list-item>
							    </v-list>
						</v-menu>
						</v-row>
					    </v-list-item-action>
					</v-list-item>
					<v-divider></v-divider>
	                </template>
	            </v-list>
	        </v-card>
		</v-tab-item>
	    <v-tab-item>
			<v-card flat height="600px" style="overflow-y: auto;">
			<v-list three-line>
				<template v-for="(item, index) in items">
			        <v-list-item>
						<v-list-item-avatar><v-img :src="item.avatar"></v-img></v-list-item-avatar>
						<v-list-item-content>
							<v-list-item-title v-html="item.title"></v-list-item-title>
							<v-list-item-subtitle v-html="item.subtitle"></v-list-item-subtitle>
						</v-list-item-content>
						<v-list-item-action>
						<v-row>
					    <v-btn text @click="follow(index)">
					        <v-icon color="primary">mdi-account-multiple-plus</v-icon>
					        关注</v-btn>
						<v-menu>
							<template v-slot:activator="{ on }">
					        <v-btn icon v-on="on"><v-icon>mdi-dots-vertical</v-icon></v-btn>
							</template>
								<v-list>
									<v-list-item><v-btn text @click="snackbar1 = true">举报</v-btn></v-list-item>
							    </v-list>
						</v-menu>
						</v-row>
					    </v-list-item-action>
					</v-list-item>
					<v-divider></v-divider>
			        </template>
			    </v-list>
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
				items: [
				        {
				          avatar: 'https://cdn.vuetifyjs.com/images/lists/1.jpg',
						  title: 'mike',
				          subtitle: "快十家地方卡打开九分裤多级反馈设计开发的接口了撒娇的叫法雷克萨考虑到I'll be in your neighborhood doing errands this weekend. Do you want to hang out?",
				        },
				        {
				          avatar: 'https://cdn.vuetifyjs.com/images/lists/2.jpg',
						  title: 'elf',
				          subtitle: "Wish I could come, but I'm out of town this weekend.",
				        },				   
				        {
				          avatar: 'https://cdn.vuetifyjs.com/images/lists/3.jpg',
						  title: 'jack',
				          subtitle: "Do you have Paris recommendations? Have you ever been?",
				        },				        
				        {
				          avatar: 'https://cdn.vuetifyjs.com/images/lists/4.jpg',				          
						  title: 'alice',
				          subtitle: "Have any ideas about what we should get Heidi for her birthday?",
				        },				       
				        {
				          avatar: 'https://cdn.vuetifyjs.com/images/lists/5.jpg',				          
						  title:'candy',
				          subtitle: "We should eat this: Grate, Squash, Corn, and tomatillo Tacos.",
				        },
						{
						  avatar: 'https://cdn.vuetifyjs.com/images/lists/1.jpg',
						  title: 'mike',
						  subtitle: "快十家地方卡打开九分裤多级反馈设计开发的接口了撒娇的叫法雷克萨考虑到I'll be in your neighborhood doing errands this weekend. Do you want to hang out?",
						},
						{
						  avatar: 'https://cdn.vuetifyjs.com/images/lists/2.jpg',
						  title: 'elf',
						  subtitle: "Wish I could come, but I'm out of town this weekend.",
						},				   
						{
						  avatar: 'https://cdn.vuetifyjs.com/images/lists/3.jpg',
						  title: 'jack',
						  subtitle: "Do you have Paris recommendations? Have you ever been?",
						},				        
						{
						  avatar: 'https://cdn.vuetifyjs.com/images/lists/4.jpg',				          
						  title: 'alice',
						  subtitle: "Have any ideas about what we should get Heidi for her birthday?",
						},				       
						{
						  avatar: 'https://cdn.vuetifyjs.com/images/lists/5.jpg',				          
						  title:'candy',
						  subtitle: "We should eat this: Grate, Squash, Corn, and tomatillo Tacos.",
						},
						{
						  avatar: 'https://cdn.vuetifyjs.com/images/lists/1.jpg',
						  title: 'mike',
						  subtitle: "快十家地方卡打开九分裤多级反馈设计开发的接口了撒娇的叫法雷克萨考虑到I'll be in your neighborhood doing errands this weekend. Do you want to hang out?",
						},
						{
						  avatar: 'https://cdn.vuetifyjs.com/images/lists/2.jpg',
						  title: 'elf',
						  subtitle: "Wish I could come, but I'm out of town this weekend.",
						},				   
						{
						  avatar: 'https://cdn.vuetifyjs.com/images/lists/3.jpg',
						  title: 'jack',
						  subtitle: "Do you have Paris recommendations? Have you ever been?",
						},				        
						{
						  avatar: 'https://cdn.vuetifyjs.com/images/lists/4.jpg',				          
						  title: 'alice',
						  subtitle: "Have any ideas about what we should get Heidi for her birthday?",
						},				       
						{
						  avatar: 'https://cdn.vuetifyjs.com/images/lists/5.jpg',				          
						  title:'candy',
						  subtitle: "We should eat this: Grate, Squash, Corn, and tomatillo Tacos.",
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
