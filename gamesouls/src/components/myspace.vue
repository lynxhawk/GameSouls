<template>
	<v-img width="1920px" :aspect-ratio="16/9" src="../../public/static/images/dk3.jpg">
		<v-row align="start" class="black--text pt-12 fill-height">
		    <v-col style="padding-left: 60px;" class="pr-10">
				<v-card shaped height="390px" style="opacity: 0.8;" width="350px">
					<v-list>
						<v-list-item>
							<v-avatar size="60px" ><v-img src="../../public/static/images/lynx.jpg"></v-img></v-avatar>
							<v-list-item-content>
							<v-list-item-title class="title pl-2">{{nickname}}</v-list-item-title>
							<v-list-item-subtitle class="pl-2">RPG</v-list-item-subtitle>
							</v-list-item-content>
							<v-btn color="cyan" text><v-icon>mdi-account-multiple-plus</v-icon><strong>关注</strong></v-btn>
						</v-list-item>
						<v-row class="ml-1">
							<v-col>
								<v-sheet style="width:150px;font-size: 15px;height: 90px;overflow: hidden;">{{text}}</v-sheet>
							</v-col>
							<v-col>
								<v-row>正在关注</v-row>
								<v-row class="blue--text"><strong>{{follow}}</strong></v-row>
								<v-row>关注者</v-row>
								<v-row class="blue--text"><strong>{{follower}}</strong></v-row>
							</v-col>
						</v-row>
						<v-row>
							<v-col class="ml-8">
								<v-row justify="start" class="subtitle-2 pb-2">经验值：{{value}}/100</v-row>
								<v-row><v-progress-circular :rotate="-90" :size="80" :width="15" :value="value"
								color="primary">{{ value }}</v-progress-circular></v-row>
							</v-col>
							<v-col class="mr-4">
								<v-row justify="start" class="subtitle-2 ml-1">点赞数：</v-row>
								<v-progress-linear color="light-blue" height="15" :value="value" striped></v-progress-linear>
								<v-row justify="end" class="px-4 subtitle-2">{{value}}/100</v-row>
								<v-row justify="start" class="subtitle-2 ml-1">发表数：</v-row>
								<v-progress-linear color="green" height="15" :value="value" striped></v-progress-linear>
								<v-row justify="end" class="px-4 subtitle-2">{{value}}/100</v-row>
							</v-col>							
						</v-row>
					</v-list>
				</v-card>
				<v-card max-width="350px" max-height="200px" style="opacity: 0.8;" class="mt-4" shaped>
					<v-toolbar color="blue-grey lighten-5" dense>
					<v-toolbar-title>留言板</v-toolbar-title><v-spacer></v-spacer>
					<v-btn @click="dialog1=true" text tile><v-icon>mdi-pencil</v-icon></v-btn></v-toolbar>
					<v-list three-line max-height="150px" class="overflow-y-auto">
					<template v-for="(item, index) in items">
						<v-list-item @click="getIndex(index)">
				        <v-list-item-avatar><v-img :src="item.avatar"></v-img></v-list-item-avatar>
						<v-list-item-content>
							<v-list-item-title>{{item.title}}</v-list-item-title>
				            <v-list-item-subtitle>{{item.subtitle}}</v-list-item-subtitle>
				        </v-list-item-content>
				        </v-list-item>
				      </template>
				    </v-list>
				</v-card>
		    </v-col>
			<v-col class="hidden-sm-and-down" style="padding-right: 80px;">
				<v-tabs style="width: 720px;opacity: 0.8;" background-color="white" centered fixed-tabs>
				    <v-tabs-slider color="blue accent-4"></v-tabs-slider>
				    <v-tab><strong>资讯</strong></v-tab>
					<v-tab><strong>文章</strong></v-tab>
					<v-tab><strong>评测</strong></v-tab>
					<v-tab><strong>攻略</strong></v-tab>
					<v-tab><strong>论坛</strong></v-tab>
					<v-tab-item>
				        <v-card height="555px" >
							<v-row class="px-5">
							    <v-col v-for="n in 6" :key="n" md="4">
									<template>
							        <v-card color='white' class="ma-3" height="200" width="200" raised @click="opennews">
									<v-img height="100px" src="../../public/static/images/life2.jpg"></v-img>
									<v-card-title class="subtitle-1">《奇异人生2》解锁新章节</v-card-title>
									<v-card-subtitle class="pb-0">5小时前</v-card-subtitle>
									</v-card></template>
							    </v-col>
							</v-row>
							<v-pagination :length="20" v-model="page1" total-visible="8"></v-pagination>
				        </v-card>
				    </v-tab-item>
					<v-tab-item>
						<v-card height="555px">
					   	<v-row class="px-5">
					   	    <v-col v-for="n in 6" :key="n" md="4">
								<v-card color='white' class="ma-3" height="200" width="300" raised @click="">
					   	       	<v-list-item>					   	       
					   	       		<v-list-item-content>
					   	       			<v-list-item-title class="title">魂学研究</v-list-item-title>
					   	       	    </v-list-item-content>
					   	       	</v-list-item>
					   	       	<v-img height="100px" src="../../public/static/images/dk3.jpg"></v-img>
					   	       	<v-row justify="start" class="subtitle-2 pl-6 pt-2">2019/09/19
					   	       	<v-icon small class="pl-4 pr-2">mdi-heart</v-icon>25
					   	       	<v-icon small class="pl-2 pr-2">mdi-comment-multiple</v-icon>33
					   	       	</v-row>
								</v-card>
					   	    </v-col>
					   	</v-row>
					   	<v-pagination :length="20" v-model="page1" total-visible="8"></v-pagination>
						</v-card>
					</v-tab-item>
					<v-tab-item>
					    <v-card height="555px">
					    	<v-row class="px-5">
					    	    <v-col v-for="n in 4" :key="n" md="6">
									<v-card @click="" height="230px" width="330px" raised>
									    <v-img max-height="160px" :aspect-ratio="16/9" src="../../public/static/images/ori.jpg">
									    </v-img>
										<v-row>
											<v-col class="ml-2" md="6">
												<strong>ori and blind forest</strong>
											</v-col>
											<v-col>
											<v-row justify="center">{{rating}}</v-row>
											<v-rating readonly v-model="rating" background-color="orange lighten-3"
										    color="yellow accent-4" dense half-increments hover size="25"></v-rating>
											</v-col>
										</v-row>
									</v-card>
					    	    </v-col>
					    	</v-row>
					    	<v-pagination :length="20" v-model="page1" total-visible="8"></v-pagination>
					    </v-card>
					</v-tab-item>
					<v-tab-item>
						<v-card height="555px">
					   	<v-row class="px-5">
					   	    <v-col v-for="n in 6" :key="n" md="4">
					   	        <v-card color='white' class="mt-3 mx-3" height="210" width="300" raised @click="">
					   	        	<v-img height="120px" src="../../public/static/images/acs.jpg"></v-img>
										<v-list-item>
					   	        			<v-list-item-content>
												<v-row style="overflow: hidden;" class="px-3">刺客信条枭雄</v-row>
					   	        				<v-list-item-subtitle>
					   	        				<v-row justify="end" class="pt-3"><v-icon small class="pr-3">mdi-heart</v-icon>
					   	        				<v-sheet class="pr-3">25</v-sheet>
					   	        				<v-icon small class="pr-3">mdi-comment-multiple</v-icon>
					   	        				<v-sheet class="pr-3">33</v-sheet></v-row>
					   	        				</v-list-item-subtitle>
					   	        			</v-list-item-content>						
										</v-list-item>
					   	        </v-card>
					   	    </v-col>
					   	</v-row>
					   	<v-pagination :length="20" v-model="page1" total-visible="8"></v-pagination>
					   </v-card>
					</v-tab-item>
					<v-tab-item>
						<v-card height="555px">
					   	<v-row class="px-5">
							<template v-for="(item1, index) in item1s">
							<v-col md="4">
								<v-card class="mx-auto" color="white" max-width="400" shaped raised>
								    <v-card-title style="overflow: hidden;">
										<v-sheet height="45px" class="subtitle-1 font-weight-bold">{{item1.title}}</v-sheet>
								    </v-card-title>
									<v-divider></v-divider>
								    <v-card-text style="overflow: hidden;" class="subtitle-2 font-weight">
									<v-sheet height="50px">{{item1.subtitle}}</v-sheet></v-card-text>
								
								    <v-card-actions>
										<v-list-item class="grow">
								        <v-row align="center" justify="end">
											<span class="subtitle-2 mr-4">{{item1.time}}</span>
											<v-icon class="mr-2">mdi-comment-text-multiple</v-icon>
											<span class="subtitle-2 mr-2">256</span>
								        </v-row>
										</v-list-item>
								    </v-card-actions>
								</v-card>
							</v-col>
							</template>
						</v-row>
						<v-pagination :length="20" v-model="page5" total-visible="8"></v-pagination>
						</v-card>
					</v-tab-item>
			</v-tabs>
			</v-col>
		</v-row>
	
	<v-dialog v-model="dialog" max-width="350px">
		<v-card height="200px">
			<v-card-title>
				<v-btn icon @click="deletes"><v-icon>mdi-delete</v-icon></v-btn>
				<v-spacer></v-spacer>
				<v-icon @click="dialog = false">mdi-close</v-icon>
			</v-card-title>
			<v-card-text class="pt-4">{{click}}</v-card-text>
		</v-card>
	</v-dialog>
	
	<v-dialog v-model="dialog1" max-width="400px">
		<v-card>
			<v-card-title>
			<span class="headline">留言</span>
			<v-spacer></v-spacer>
			<v-icon @click="dialog1 = false">mdi-close</v-icon>
			</v-card-title>
			<v-card-text>
				<v-textarea clearable counter="500" height="200px" solo required></v-textarea>
			</v-card-text>
		<v-divider></v-divider>
	    <v-card-actions>
			<v-spacer></v-spacer>
			<v-btn color="blue darken-1" text @click=""><strong class="body-1">提交</strong></v-btn>
	    </v-card-actions>
		</v-card>
	</v-dialog>
	
	</v-img>
	
</template>

<script>
	export default {
		name: 'App',
		data() {
			return {
				page1:1,page2:1,page3:1,page4:1,page5:1,
				dialog: false,dialog1:false,click:'',clickindex:'',
				value:20,rating:4.5,
				follow:100,follower:50,
				nickname:'LynxHawk',
				text:'You are not alone You are not alone You are not alone You are not alone',
				items: [
				        {
				          avatar: 'https://cdn.vuetifyjs.com/images/lists/4.jpg',
						  title: 'sp',
				          subtitle: "快更新文章！",
				        },
				        {
				          avatar: 'https://cdn.vuetifyjs.com/images/lists/2.jpg',
						  title: '石头',
				          subtitle: "最近玩了什么新游戏么",
				        },				   
				        {
				          avatar: 'https://cdn.vuetifyjs.com/images/lists/3.jpg',
						  title: '蓝羽龙',
				          subtitle: "MTG的线下活动参加么",
				        },				        
				        {
				          avatar: 'https://cdn.vuetifyjs.com/images/lists/1.jpg',				          
						  title: 'alice',
				          subtitle: "Have any ideas about what we should get Heidi for her birthday?",
				        },				       
				        {
				          avatar: 'https://cdn.vuetifyjs.com/images/lists/5.jpg',				          
						  title:'candy',
				          subtitle: "We should eat this: Grate, Squash, Corn, and tomatillo Tacos.",
				        },
						],
				item1s:	[
						{
							title:'"Turns out semicolon-less style is easier and safer in TS because most gotcha edge cases are type invalid as well."',
							subtitle: "I'll be in your neighborhood doing errands this weekend. Do you want to hang out?I'll be in your neighborhood doing errands this weekend. Do you want to hang out?I'll be in your neighborhood doing errands this weekend. Do you want to hang out?I'll be in your neighborhood doing errands this weekend. Do you want to hang out?",
							time:'2020-01-22',
						},
						{
						  title:'"Turns out semicolon-less style is easier and safer in TS because most gotcha edge cases are type invalid as well."',
						  subtitle: "Wish I could come, but I'm out of town this weekend.",
						  time:'2020-01-22'
						},				   
						{
						  title:'"Turns out semicolon-less style is easier and safer in TS because most gotcha edge cases are type invalid as well."',
						  subtitle: "Do you have Paris recommendations? Have you ever been?",
						  time:'2020-01-22'
						},				        
						{
						  title:'"Turns out semicolon-less style is easier and safer in TS because most gotcha edge cases are type invalid as well."',
						  subtitle: "Have any ideas about what we should get Heidi for her birthday?",
						  time:'2020-01-22'
						},				       
						{
						  title:'"Turns out semicolon-less style is easier and safer in TS because most gotcha edge cases are type invalid as well."',
						  subtitle: "We should eat this: Grate, Squash, Corn, and tomatillo Tacos.",
						  time:'2020-01-22'
						},
						{
						  title:'"Turns out semicolon-less style is easier and safer in TS because most gotcha edge cases are type invalid as well."',
						  subtitle: "Do you have Paris recommendations? Have you ever been?",
						  time:'2020-01-22'
						}
				        ]
				}
			},
			methods:{
			    getIndex:function(index){
					this.clickindex=index;
			        this.click=this.items[index].subtitle;
					this.dialog=true;
			    },
				deletes:function(){
					this.dialog=false;
					this.items.splice(this.clickindex, 1);
				},
				opennews:function(){
					alert("!!!!");
				}
			}
	}
</script>

<style>

	
</style>
