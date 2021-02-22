<template>
	<v-img width="1920px" :aspect-ratio="16/9" :src="background">
		<v-row align="start" class="black--text pt-12 fill-height">
		    <v-col style="padding-left: 60px;" class="pr-10">
				<v-card shaped height="390px" style="opacity: 0.8;" width="350px">
					<v-list>
						<v-list-item>
							<v-avatar size="60px"><v-img :src="avatar"></v-img></v-avatar>
							<v-list-item-content>
							<v-list-item-title class="title pl-2">{{username}}</v-list-item-title>
							<v-list-item-subtitle class="pl-2">{{gametype}}</v-list-item-subtitle>
							</v-list-item-content>
							<v-btn color="cyan" text @click="addfollow" v-show="showfollow">
								<v-icon>mdi-account-multiple-plus</v-icon><strong>关注</strong></v-btn>
							<v-btn color="cyan" text @click="deletefollow" v-show="showcancelfollow">
								<v-icon>mdi-account-multiple-minus</v-icon><strong>取消关注</strong></v-btn>
						</v-list-item>
						<v-row class="ml-1">
							<v-col>
								<v-sheet style="width:150px;font-size: 15px;height: 90px;overflow: hidden;">{{introduce}}</v-sheet>
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
								<v-row justify="start" class="subtitle-2 pb-2">经验值：{{exp}}/100</v-row>
								<v-row><v-progress-circular :rotate="-90" :size="80" :width="15" v-model="exp"
								color="primary">{{ exp }}</v-progress-circular></v-row>
							</v-col>
							<v-col class="mr-4">
								<v-row justify="start" class="subtitle-2 ml-1">点赞数：</v-row>
								<v-progress-linear color="light-blue" height="15" v-model="heart" striped></v-progress-linear>
								<v-row justify="end" class="px-4 subtitle-2">{{heart}}/100</v-row>
								<v-row justify="start" class="subtitle-2 ml-1">发表数：</v-row>
								<v-progress-linear color="green" height="15" v-model="publish" striped></v-progress-linear>
								<v-row justify="end" class="px-4 subtitle-2">{{publish}}/100</v-row>
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
							<v-list-item-title>{{item.username}}</v-list-item-title>
				            <v-list-item-subtitle>{{item.text}}</v-list-item-subtitle>
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
								<template v-for="(item, index) in item1s">
							    <v-col md="4">
							        <v-card color='white' class="ma-3" height="200" width="200" raised :to="{ path: '/readnews/'+item.id }">
									<v-img height="100px" :src="item.cover"></v-img>
									<v-card-title class="subtitle-1">{{item.title}}</v-card-title>
									<v-card-subtitle class="pb-0">{{item.date}}</v-card-subtitle>
									</v-card>
							    </v-col>
								</template>
							</v-row>
							<v-pagination :length="length1" v-model="page1" total-visible="8"></v-pagination>
				        </v-card>
				    </v-tab-item>
					<v-tab-item>
						<v-card height="555px">
					   	<v-row class="px-5">
							<template v-for="(item, index) in item2s">
					   	    <v-col md="4">
								<v-card color='white' class="ma-3" height="200" width="300" raised :to="{ path: '/readarticle/'+item.id }">
					   	       	<v-list-item>					   	       
					   	       		<v-list-item-content>
					   	       			<v-list-item-title class="title">{{item.title}}</v-list-item-title>
					   	       	    </v-list-item-content>
					   	       	</v-list-item>
					   	       	<v-img height="100px" :src="item.cover"></v-img>
					   	       	<v-row justify="start" class="subtitle-2 pl-6 pt-2">{{item.date}}
					   	       	<v-icon small class="pl-4 pr-2">mdi-heart</v-icon>{{item.heart}}
					   	       	<v-icon small class="pl-2 pr-2">mdi-comment-multiple</v-icon>{{item.comment}}
					   	       	</v-row>
								</v-card>
					   	    </v-col>
							</template>
					   	</v-row>
					   	<v-pagination :length="length2" v-model="page2" total-visible="8"></v-pagination>
						</v-card>
					</v-tab-item>
					<v-tab-item>
					    <v-card height="555px">
					    	<v-row class="px-5">
								<template v-for="(item, index) in item3s">
					    	    <v-col md="6">
									<v-card height="230px" width="330px" raised :to="{ path: '/readreview/'+item.id }">
									    <v-img max-height="160px" :aspect-ratio="16/9" :src="item.cover">
									    </v-img>
										<v-row>
											<v-col class="ml-2" md="6">
												<strong>{{item.game}}</strong>
											</v-col>
											<v-col>
											<v-row justify="center">{{item.rate}}</v-row>
											<v-rating readonly v-model="item.rate" background-color="orange lighten-3"
										    color="yellow accent-4" dense half-increments hover size="25"></v-rating>
											</v-col>
										</v-row>
									</v-card>
					    	    </v-col>
								</template>
					    	</v-row>
					    	<v-pagination :length="length3" v-model="page3" total-visible="8"></v-pagination>
					    </v-card>
					</v-tab-item>
					<v-tab-item>
						<v-card height="555px">
					   	<v-row class="px-5">
							<template v-for="(item, index) in item4s">
					   	    <v-col md="4">
					   	        <v-card color='white' class="mt-3 mx-3" height="210" width="300" raised :to="{ path: '/readwalk/'+item.id }">
					   	        	<v-img height="120px" :src="item.cover"></v-img>
										<v-list-item>
					   	        			<v-list-item-content>
												<v-row style="overflow: hidden;" class="px-3">{{item.title}}</v-row>
					   	        				<v-list-item-subtitle>
					   	        				<v-row justify="end" class="pt-3"><v-icon small class="pr-3">mdi-heart</v-icon>
					   	        				<v-sheet class="pr-3">{{item.heart}}</v-sheet>
					   	        				<v-icon small class="pr-3">mdi-comment-multiple</v-icon>
					   	        				<v-sheet class="pr-3">{{item.comment}}</v-sheet></v-row>
					   	        				</v-list-item-subtitle>
					   	        			</v-list-item-content>						
										</v-list-item>
					   	        </v-card>
					   	    </v-col>
							</template>
					   	</v-row>
					   	<v-pagination :length="length4" v-model="page4" total-visible="8"></v-pagination>
					   </v-card>
					</v-tab-item>
					<v-tab-item>
						<v-card height="555px">
					   	<v-row class="px-5">
							<template v-for="(item, index) in item5s">
							<v-col md="4">
								<v-card class="mx-auto" color="white" max-width="400" shaped raised :to="{ path: '/readdiscuss/'+item.id }">
								    <v-card-title style="overflow: hidden;">
										<v-sheet height="45px" class="subtitle-1 font-weight-bold">{{item.title}}</v-sheet>
								    </v-card-title>
									<v-divider></v-divider>
								    <v-card-text style="overflow: hidden;" class="subtitle-2 font-weight">
									<v-sheet height="50px">{{item.text}}</v-sheet></v-card-text>
								    <v-card-actions>
										<v-list-item class="grow">
								        <v-row align="center" justify="end">
											<span class="subtitle-2 mr-4">{{item.date}}</span>
											<v-icon class="mr-2">mdi-comment-text-multiple</v-icon>
											<span class="subtitle-2 mr-2">{{item.comment}}</span>
								        </v-row>
										</v-list-item>
								    </v-card-actions>
								</v-card>
							</v-col>
							</template>
						</v-row>
						<v-pagination :length="length5" v-model="page5" total-visible="8"></v-pagination>
						</v-card>
					</v-tab-item>
			</v-tabs>
			</v-col>
			<v-col class="hidden-md-and-up mx-12">
				<v-tabs style="width: 330px;opacity: 0.8;" background-color="white" centered show-arrows>
				    <v-tabs-slider color="blue accent-4"></v-tabs-slider>
				    <v-tab><strong>资讯</strong></v-tab>
					<v-tab><strong>文章</strong></v-tab>
					<v-tab><strong>评测</strong></v-tab>
					<v-tab><strong>攻略</strong></v-tab>
					<v-tab><strong>论坛</strong></v-tab>
					<v-tab-item>
				        <v-card height="760px" >
							<v-row class="px-12">
								<template v-for="(item, index) in mitem1s">
							    <v-col md="4">
							        <v-card color='white' class="ma-1" height="200" width="200" raised :to="{ path: '/readnews/'+item.id }">
									<v-img height="100px" :src="item.cover"></v-img>
									<v-card-title class="subtitle-1">{{item.title}}</v-card-title>
									<v-card-subtitle>{{item.date}}</v-card-subtitle>
									</v-card>
							    </v-col>
								</template>
							</v-row>
							<v-pagination :length="mlength1" v-model="mpage1" total-visible="5"></v-pagination>
				        </v-card>
				    </v-tab-item>
					<v-tab-item>
						<v-card height="760px">
					   	<v-row class="px-12">
							<template v-for="(item, index) in mitem2s">
					   	    <v-col md="4">
								<v-card color='white' class="ma-1" height="200" width="280" raised :to="{ path: '/readarticle/'+item.id }">
					   	       	<v-list-item>					   	       
					   	       		<v-list-item-content>
					   	       			<v-list-item-title class="title">{{item.title}}</v-list-item-title>
					   	       	    </v-list-item-content>
					   	       	</v-list-item>
					   	       	<v-img height="100px" :src="item.cover"></v-img>
					   	       	<v-row justify="start" class="subtitle-2 ml-6 mt-2">{{item.date}}
								<v-icon small class="ml-12 mr-2">mdi-heart</v-icon>{{item.heart}}
					   	       	<v-icon small class="ml-2 mr-2">mdi-comment-multiple</v-icon>{{item.comment}}
					   	       	</v-row>
								</v-card>
					   	    </v-col>
							</template>
					   	</v-row>
					   	<v-pagination :length="mlength2" v-model="mpage2" total-visible="5"></v-pagination>
						</v-card>
					</v-tab-item>
					<v-tab-item>
					    <v-card height="760px">
					    	<v-row class="px-12">
								<template v-for="(item, index) in mitem3s">
					    	    <v-col md="6">
									<v-card height="210px" width="260px" raised :to="{ path: '/readreview/'+item.id }">
									    <v-img max-height="160px" :aspect-ratio="16/9" :src="item.cover">
									    </v-img>
										<v-row>
											<v-col class="ml-2" md="6">
												<strong>{{item.game}}</strong>
											</v-col>
											<v-col>
											<v-row justify="center">{{item.rate}}</v-row>
											<v-rating readonly v-model="item.rate" background-color="orange lighten-3"
										    color="yellow accent-4" dense half-increments hover size="25"></v-rating>
											</v-col>
										</v-row>
									</v-card>
					    	    </v-col>
								</template>
					    	</v-row>
					    	<v-pagination :length="mlength3" v-model="mpage3" total-visible="5"></v-pagination>
					    </v-card>
					</v-tab-item>
					<v-tab-item>
						<v-card height="760px">
					   	<v-row class="px-5">
							<template v-for="(item, index) in mitem4s">
					   	    <v-col md="4">
					   	        <v-card color='white' class="mt-1 mx-3" height="200" width="260" raised :to="{ path: '/readwalk/'+item.id }">
					   	        	<v-img height="120px" :src="item.cover"></v-img>
										<v-list-item>
					   	        			<v-list-item-content>
												<v-row style="overflow: hidden;" class="px-3">{{item.title}}</v-row>
					   	        				<v-list-item-subtitle>
					   	        				<v-row justify="end" class="pt-3"><v-icon small class="pr-3">mdi-heart</v-icon>
					   	        				<v-sheet class="pr-3">{{item.heart}}</v-sheet>
					   	        				<v-icon small class="pr-3">mdi-comment-multiple</v-icon>
					   	        				<v-sheet class="pr-3">{{item.comment}}</v-sheet></v-row>
					   	        				</v-list-item-subtitle>
					   	        			</v-list-item-content>						
										</v-list-item>
					   	        </v-card>
					   	    </v-col>
							</template>
					   	</v-row>
					   	<v-pagination class="mt-2" :length="mlength4" v-model="mpage4" total-visible="5"></v-pagination>
					   </v-card>
					</v-tab-item>
					<v-tab-item>
						<v-card height="760px">
					   	<v-row class="px-5">
							<template v-for="(item, index) in mitem5s">
							<v-col md="4">
								<v-card class="mx-auto" color="white" height="210" width="400" shaped raised :to="{ path: '/readdiscuss/'+item.id }">
								    <v-card-title style="overflow: hidden;">
										<v-sheet height="45px" class="subtitle-1 font-weight-bold">{{item.title}}</v-sheet>
								    </v-card-title>
									<v-divider></v-divider>
								    <v-card-text style="overflow: hidden;" class="subtitle-2 font-weight">
									<v-sheet height="50px">{{item.text}}</v-sheet></v-card-text>
								    <v-card-actions>
										<v-list-item class="grow">
								        <v-row align="center" justify="end">
											<span class="subtitle-2 mr-4">{{item.date}}</span>
											<v-icon class="mr-2">mdi-comment-text-multiple</v-icon>
											<span class="subtitle-2 mr-2">{{item.comment}}</span>
								        </v-row>
										</v-list-item>
								    </v-card-actions>
								</v-card>
							</v-col>
							</template>
						</v-row>
						<v-pagination :length="mlength5" v-model="mpage5" total-visible="5"></v-pagination>
						</v-card>
					</v-tab-item>
			</v-tabs>
			</v-col>
		</v-row>
	
	<v-dialog v-model="dialog" max-width="350px">
		<v-card height="200px">
			<v-card-title>
				<v-btn icon @click="deletes" v-show="showdelete"><v-icon>mdi-delete</v-icon></v-btn>
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
				<v-textarea clearable v-model="board" counter="500" height="200px" solo required></v-textarea>
			</v-card-text>
		<v-divider></v-divider>
	    <v-card-actions>
			<v-spacer></v-spacer>
			<v-btn color="blue darken-1" text @click="addboard"><strong class="body-1">提交</strong></v-btn>
	    </v-card-actions>
		</v-card>
	</v-dialog>
	<v-snackbar top color="success" class="mt-12" v-model="snackbar1">删除成功
	<v-btn dark text @click="snackbar1 = false">关闭</v-btn></v-snackbar>
	<v-snackbar top color="success" class="mt-12" v-model="snackbar2">添加留言成功
	<v-btn dark text @click="snackbar2 = false">关闭</v-btn></v-snackbar>
	<v-snackbar top color="success" class="mt-12" v-model="snackbar3">关注成功
	<v-btn dark text @click="snackbar3 = false">关闭</v-btn></v-snackbar>
	<v-snackbar top class="mt-12" color="error" v-model="snackbar4">未登录
	<v-btn dark text @click="snackbar4 = false">关闭</v-btn></v-snackbar>
	<v-snackbar top color="success" class="mt-12" v-model="snackbar5">取消关注成功
	<v-btn dark text @click="snackbar5 = false">关闭</v-btn></v-snackbar>
	</v-img>
	
</template>

<script>
	export default {
		name: 'App',
		data() {
			return {
				page1:1,page2:1,page3:1,page4:1,page5:1,showdelete:false,showfollow:true,showcancelfollow:false,
				mpage1:1,mpage2:1,mpage3:1,mpage4:1,mpage5:1,
				background:'',avatar:'',id:null,username:null,gametype:null,
				follow:null,follower:null,exp:null,heart:null,publish:null,introduce:null,
				snackbar1:false,snackbar2:false,snackbar3:false,snackbar4:false,snackbar5:false,
				length1:null,length2:null,length3:null,length4:null,length5:null,
				mlength1:null,mlength2:null,mlength3:null,mlength4:null,mlength5:null,
				totalitem1s:[],totalitem2s:[],totalitem3s:[],totalitem4s:[],totalitem5s:[],
				mtotalitem1s:[],mtotalitem2s:[],mtotalitem3s:[],mtotalitem4s:[],mtotalitem5s:[],
				dialog: false,dialog1:false,click:'',clickindex:'',board:'',
				items:[], //留言板
				item1s:[],item2s:[],item3s:[],item4s:[],item5s:[], //发表作品
				mitem1s:[],mitem2s:[],mitem3s:[],mitem4s:[],mitem5s:[], //发表作品移动端显示
				item6s:[] //个人信息
				}
			},
			created() {
				this.id=localStorage.getItem("id");
				this.$axios.get('http://localhost:8888/getuserinfobyid/'+this.$route.params.id).then((res)=>{
					this.item6s=res.data;
					this.background=this.item6s[0].background;
					this.avatar=this.item6s[0].avatar;
					this.username=this.item6s[0].username;
					this.gametype=this.item6s[0].gametype;
					this.follow=this.item6s[0].follow;
					this.follower=this.item6s[0].follower;
					this.exp=this.item6s[0].exp;
					this.heart=this.item6s[0].heart;
					this.publish=this.item6s[0].publish;
					this.introduce=this.item6s[0].introduce;
					if(localStorage.getItem("id")==this.$route.params.id){
					this.showdelete=true;
					}
					this.$axios.get('http://localhost:8888/isfollow',{
					        params:{
					            userid:localStorage.getItem("id"),
								followid:this.$route.params.id
					        }
					    }).then((response)=>{
							if(response.data==true){
								this.showcancelfollow=true;
								this.showfollow=false;
							}else{
								this.showcancelfollow=false;
								if(this.$route.params.id==this.id){
									this.showfollow=false;
								}else{
									this.showfollow=true;
								}
							}
					})
				});
				this.$axios.get('http://localhost:8888/getboardlist/'+this.$route.params.id).then((res)=>{
					this.items=res.data;
				});
				this.$axios.get('http://localhost:8888/getusernewslist/'+this.$route.params.id).then((res)=>{
					var a = res.data;
					this.length1=Math.ceil(a.length/6);
						for (let i = 0; i < this.length1; i++) {
							this.totalitem1s[i] = a.slice(6 * i, 6 * (i + 1));
						}
					this.item1s = this.totalitem1s[this.page1-1];
					
					this.mlength1=Math.ceil(a.length/3);
						for (let i = 0; i < this.mlength1; i++) {
							this.mtotalitem1s[i] = a.slice(3 * i, 3 * (i + 1));
						}
					this.mitem1s = this.mtotalitem1s[this.mpage1-1];
				});
				this.$axios.get('http://localhost:8888/getuserarticlelist/'+this.$route.params.id).then((res)=>{
					var a = res.data;
					this.length2=Math.ceil(a.length/6);
						for (let i = 0; i < this.length2; i++) {
							this.totalitem2s[i] = a.slice(6 * i, 6 * (i + 1));
						}
					this.item2s = this.totalitem2s[this.page2-1];
					
					this.mlength2=Math.ceil(a.length/3);
						for (let i = 0; i < this.mlength2; i++) {
							this.mtotalitem2s[i] = a.slice(3 * i, 3 * (i + 1));
						}
					this.mitem2s = this.mtotalitem2s[this.mpage2-1];
				});
				this.$axios.get('http://localhost:8888/getuserreviewlist/'+this.$route.params.id).then((res)=>{
					var a = res.data;
					this.length3=Math.ceil(a.length/4);
						for (let i = 0; i < this.length3; i++) {
							this.totalitem3s[i] = a.slice(4 * i, 4 * (i + 1));
						}
					this.item3s = this.totalitem3s[this.page3-1];
					
					this.mlength3=Math.ceil(a.length/3);
						for (let i = 0; i < this.mlength3; i++) {
							this.mtotalitem3s[i] = a.slice(3 * i, 3 * (i + 1));
						}
					this.mitem3s = this.mtotalitem3s[this.mpage3-1];
				});
				this.$axios.get('http://localhost:8888/getuserwalklist/'+this.$route.params.id).then((res)=>{
					var a = res.data;
					this.length4=Math.ceil(a.length/6);
						for (let i = 0; i < this.length4; i++) {
							this.totalitem4s[i] = a.slice(6 * i, 6 * (i + 1));
						}
					this.item4s = this.totalitem4s[this.page4-1];
					
					this.mlength4=Math.ceil(a.length/3);
						for (let i = 0; i < this.mlength4; i++) {
							this.mtotalitem4s[i] = a.slice(3 * i, 3 * (i + 1));
						}
					this.mitem4s = this.mtotalitem4s[this.mpage4-1];  
				});
				this.$axios.get('http://localhost:8888/getuserdiscusslist/'+this.$route.params.id).then((res)=>{
					var a = res.data;
					this.length5=Math.ceil(a.length/6);
						for (let i = 0; i < this.length5; i++) {
							this.totalitem5s[i] = a.slice(6 * i, 6 * (i + 1));
						}
					this.item5s = this.totalitem5s[this.page5-1];
					
					this.mlength5=Math.ceil(a.length/3);
						for (let i = 0; i < this.mlength5; i++) {
							this.mtotalitem5s[i] = a.slice(3 * i, 3 * (i + 1));
						}
					this.mitem5s = this.mtotalitem5s[this.mpage5-1];  
				});
			},
			watch:{
				page1(val, oldVal){
					this.item1s = this.totalitem1s[val-1];
				},
				page2(val, oldVal){
					this.item2s = this.totalitem2s[val-1];
				},
				page3(val, oldVal){
					this.item3s = this.totalitem3s[val-1];
				},
				page4(val, oldVal){
					this.item4s = this.totalitem4s[val-1];
				},
				page5(val, oldVal){
					this.item5s = this.totalitem5s[val-1];
				},
				mpage1(val, oldVal){
					this.mitem1s = this.mtotalitem1s[val-1];
				},
				mpage2(val, oldVal){
					this.mitem2s = this.mtotalitem2s[val-1];
				},
				mpage3(val, oldVal){
					this.mitem3s = this.mtotalitem3s[val-1];
				},
				mpage4(val, oldVal){
					this.mitem4s = this.mtotalitem4s[val-1];
				},
				mpage5(val, oldVal){
					this.mitem5s = this.mtotalitem5s[val-1];
				}
			},
			methods:{
			    getIndex:function(index){
					this.clickindex=this.items[index].id;
			        this.click=this.items[index].text;
					this.dialog=true;
			    },
				deletes:function(index){
					this.$axios.get('http://localhost:8888/deleteboard/'+this.clickindex).then((res)=>{
						if(res.data=true){
							this.dialog=false;
							this.items.splice(index, 1);
							this.snackbar1=true;
						}
					});
				},
				addboard(){
					if(localStorage.getItem("id")==null){
						this.snackbar4=true;
					}else{
					this.$axios.get('http://localhost:8888/addboard/'+this.$route.params.id,{
					        params:{
					            userid2:localStorage.getItem("id"),
								username:localStorage.getItem("username"),
								avatar:localStorage.getItem("avatar"),
								text:this.board,
					        }
					    }).then((response)=>{
							if(response.data=true){
								this.snackbar2=true;
								this.dialog1=false;
								this.$router.go(0);
							}
					})
					}
				},
				addfollow(){
					if(localStorage.getItem("id")==null){
						this.snackbar4=true;
					}else{
						this.$axios.get('http://localhost:8888/addfollow',{
					        params:{
					            userid:localStorage.getItem("id"),
								followid:this.$route.params.id
					        }
					    }).then((response)=>{
							if(response.data=true){
								this.snackbar3=true;
								this.$router.go(0);
							}
					})
					}
				},
				deletefollow(){
					this.$axios.get('http://localhost:8888/deletefollow',{
					        params:{
					            userid:localStorage.getItem("id"),
								followid:this.$route.params.id
					        }
					    }).then((response)=>{
							if(response.data=true){
								this.snackbar5=true;
								this.$router.go(0);
							}
					})
				
				}
			}
	}
</script>

<style>

	
</style>
