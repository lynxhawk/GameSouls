<template>
	<v-img width="1920px" :aspect-ratio="16/9" :src="background">
		<v-tabs class="hidden-sm-and-down" color="blue accent-4" style="margin-left:auto;margin-right:auto;width: 1000px;opacity: 0.8;" background-color="white" centered fixed-tabs>
			<v-tabs-slider color="blue accent-4"></v-tabs-slider>
			<v-tab><strong>资讯</strong></v-tab>
			<v-tab><strong>文章</strong></v-tab>
			<v-tab><strong>评测</strong></v-tab>
			<v-tab><strong>攻略</strong></v-tab>
			<v-tab><strong>论坛</strong></v-tab>
			<v-tab-item>
			    <v-card height="730px">
					<v-row class="px-12">
						<template v-for="(item, index) in item1s">
					    <v-col md="3">
						    <v-card color='white' height="200" width="200" raised @click="opennews(index)">
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
				<v-card height="730px">
				   	<v-row class="px-5">
						<template v-for="(item, index) in item2s">
				   	    <v-col md="3">
							<v-card color='white' height="320" width="300" raised @click="openarticle(index)">
								<v-list-item>
								    <v-list-item-avatar><v-img :src="item.avatar"></v-img></v-list-item-avatar>
										<v-list-item-content>
											<v-list-item-title class="subtitle">{{item.title}}</v-list-item-title>
											<v-list-item-subtitle>{{item.username}}</v-list-item-subtitle>
								        </v-list-item-content>
								</v-list-item>
								<v-img height="150px" :src="item.cover"></v-img>
								<v-card-title class="subtitle-1">{{item.subtitle}}</v-card-title>
								<v-card-subtitle> 
								<v-row justify="start" class="subtitle-2 pl-3 pt-2">{{item.date}}
								<v-icon small class="pl-8 pr-2">mdi-heart</v-icon>{{item.heart}}
								<v-icon small class="pl-2 pr-2">mdi-comment-multiple</v-icon>{{item.comment}}
								</v-row>
								</v-card-subtitle>
							</v-card>
				   	    </v-col>
						</template>
				   	</v-row>
				   	<v-pagination :length="length2" v-model="page2" total-visible="8"></v-pagination>
				</v-card>
			</v-tab-item>
			<v-tab-item>
			    <v-card height="730px">
			    	<v-row class="px-5">
						<template v-for="(item, index) in item3s">
			    	    <v-col md="4">
							<v-card @click="" height="200px" width="300px" raised @click="openreview(index)">
							    <v-img max-height="130px" :aspect-ratio="16/9" :src="item.cover">
							    </v-img>
								<v-row>
									<v-col style="width: 80px;margin-left: 8px;">
										<strong>{{item.game}}</strong>
									</v-col>
									<v-col>
									<v-row justify="center"><strong>{{item.username}}</strong></v-row>
									<v-rating readonly v-model="item.rate" background-color="orange lighten-3"
								    color="yellow accent-4" dense half-increments hover size="22"></v-rating>
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
				<v-card height="730px" style="margin-left: auto;margin-right: auto;">
				   	<v-row class="px-5">
						<template v-for="(item, index) in item4s">
				   	    <v-col md="3">
				   	        <v-card color='white' height="200" width="280" raised @click="openwalk(index)">
				   	        	<v-img height="110px" :src="item.cover"></v-img>
									<v-list-item>
				   	        			<v-list-item-content>
											<v-sheet height="35px" style="overflow: hidden;">{{item.title}}</v-sheet>
				   	        				<v-list-item-subtitle>
				   	        				<v-row justify="start" class="pt-3 pl-3"><strong>{{item.username}}</strong>
											<v-spacer></v-spacer>
											<v-icon small class="pr-3">mdi-heart</v-icon>
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
			<v-card height="730px">
			<v-row class="px-5">
			<template v-for="(item, index) in item5s">
				<v-col md="4">
				<v-card class="mx-auto" color="white" max-width="400" shaped raised height="200px" @click="opendiscuss(index)">
			    <v-card-title style="overflow: hidden;">
					<v-sheet height="45px" class="subtitle-1 font-weight-bold">{{item.title}}</v-sheet>
			    </v-card-title>
				<v-divider></v-divider>
			    <v-card-text style="overflow: hidden;" class="subtitle-2 font-weight">
				<v-sheet height="45px">{{item.text}}</v-sheet></v-card-text>
			
			    <v-card-actions>
					<v-list-item class="grow">
			        <v-list-item-content><v-list-item-title>{{item.username}}</v-list-item-title></v-list-item-content>
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
	
	<v-tabs class="hidden-md-and-up" style="margin-left:auto;margin-right:auto;width: auto;opacity: 0.8;" background-color="white" centered show-arrows>
		<v-tabs-slider color="blue accent-4"></v-tabs-slider>
		<v-tab><strong>资讯</strong></v-tab>
		<v-tab><strong>文章</strong></v-tab>
		<v-tab><strong>评测</strong></v-tab>
		<v-tab><strong>攻略</strong></v-tab>
		<v-tab><strong>论坛</strong></v-tab>
		<v-tab-item>
		    <v-card height="1350px">
				<v-row class="px-3">
					<template v-for="(item, index) in item1s">
						<v-col md="4">
					        <v-card color='white' height="190" width="180" raised @click="opennews(index)">
							<v-img height="90px" :src="item.cover"></v-img>
							<v-sheet class="subtitle-1 px-3 pt-2" height="60" style="overflow:auto;">
								{{item.title}}
							</v-sheet>
							<v-card-subtitle>{{item.date}}</v-card-subtitle>
							</v-card>
						</v-col>
					</template>
				</v-row>
				<v-pagination :length="length1" v-model="page1" total-visible="8"></v-pagination>
		    </v-card>
		</v-tab-item>
		<v-tab-item>
			<v-card height="1350px">
			   	<v-row class="px-3">
					<template v-for="(item, index) in item2s">
			   	    <v-col md="3">
						<v-card color='white' height="190" width="180" raised @click="openarticle(index)">
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
		    <v-card height="1350px">
		    	<v-row class="px-3">
					<template v-for="(item, index) in item3s">
		    	    <v-col md="3">
						<v-card @click="openreview(index)" height="190px" width="180px" raised>
							<v-img max-height="110px" :aspect-ratio="16/9" :src="item.cover"></v-img>
								<v-row class="ml-2 mr-2 mt-2" style="overflow: hidden;">
									<v-sheet height="50px">
										<strong>{{item.game}}</strong>
									</v-sheet>
								</v-row>
								<v-row justify="center">
									<v-rating readonly v-model="item.rate" background-color="orange lighten-3"
								    color="yellow accent-4" dense half-increments hover size="25"></v-rating>
								</v-row>
						</v-card>
			    	</v-col>
					</template>
			    </v-row>
			    <v-pagination :length="length3" v-model="page3" total-visible="8"></v-pagination>
			</v-card>
		</v-tab-item>
		<v-tab-item>
			<v-card height="1350px" style="margin-left: auto;margin-right: auto;">
			   	<v-row class="px-2">
					<template v-for="(item, index) in item4s">
			   	    <v-col md="3">
			   	        <v-card color='white' height="180" width="185" raised @click="openwalk(index)">
			   	        	<v-img height="100px" :src="item.cover"></v-img>
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
			<v-card height="1350px">
		   	<v-row class="px-3">
				<template v-for="(item, index) in item5s">
				<v-col md="4">
					<v-card height="200px" class="mx-auto" color="white" width="180" shaped raised @click="opendiscuss(index)">
					    <v-card-title style="overflow: hidden;">
							<v-sheet height="45px" class="subtitle-1 font-weight-bold">{{item.title}}</v-sheet>
					    </v-card-title>
						<v-divider></v-divider>
					    <v-card-text style="overflow: hidden;" class="subtitle-2 font-weight">
						<v-sheet height="45px">{{item.text}}</v-sheet></v-card-text>
	
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
	
	</v-img>
</template>

<script>
export default {
		name: 'App',
		data() {
			return {
				background:null,
				length1:null,length2:null,length3:null,length4:null,length5:null,
				item1s:[],item2s:[],item3s:[],item4s:[],item5s:[],
				page1:1,page2:1,page3:1,page4:1,page5:1,
				totalitem1s:[],totalitem2s:[],totalitem3s:[],totalitem4s:[],totalitem5s:[]
			}
		},
		methods:{
			opennews(index){
				this.$router.push({path: '/readnews/' + this.item1s[index].id});
			},
			openarticle(index){
				this.$router.push({path: '/readarticle/' + this.item2s[index].id});
			},
			openreview(index){
				this.$router.push({path: '/readreview/' + this.item3s[index].id});
			},
			openwalk(index){
				this.$router.push({path: '/readwalk/' + this.item4s[index].id});
			},
			opendiscuss(index){
				this.$router.push({path: '/readdiscuss/' + this.item5s[index].id});
			}
		},
		created() {
			if(localStorage.getItem("background")!=null){
				this.background=localStorage.getItem("background");
			}
			this.$axios.get('api/newscollectlist/'+localStorage.getItem("id")).then((response)=>{
			    var a = response.data;
				this.length1=Math.ceil(a.length/12);
					for (let i = 0; i < this.length1; i++) {
						this.totalitem1s[i] = a.slice(12 * i, 12 * (i + 1));
					}
				this.item1s = this.totalitem1s[this.page1-1];
			});
			this.$axios.get('api/articlecollectlist/'+localStorage.getItem("id")).then((response)=>{
			    var a = response.data;
				this.length2=Math.ceil(a.length/12);
					for (let i = 0; i < this.length2; i++) {
						this.totalitem2s[i] = a.slice(12 * i, 12 * (i + 1));
					}
				this.item2s = this.totalitem2s[this.page2-1];
			});
			this.$axios.get('api/reviewcollectlist/'+localStorage.getItem("id")).then((response)=>{
			    var a = response.data;
				this.length3=Math.ceil(a.length/12);
					for (let i = 0; i < this.length3; i++) {
						this.totalitem3s[i] = a.slice(12 * i, 12 * (i + 1));
					}
				this.item3s = this.totalitem3s[this.page3-1];
			});
			this.$axios.get('api/walkcollectlist/'+localStorage.getItem("id")).then((response)=>{
			    var a = response.data;
				this.length4=Math.ceil(a.length/9);
					for (let i = 0; i < this.length4; i++) {
						this.totalitem4s[i] = a.slice(9 * i, 9 * (i + 1));
					}
				this.item4s = this.totalitem4s[this.page4-1];
			});
			this.$axios.get('api/discusscollectlist/'+localStorage.getItem("id")).then((response)=>{
			    var a = response.data;
				this.length5=Math.ceil(a.length/9);
					for (let i = 0; i < this.length5; i++) {
						this.totalitem5s[i] = a.slice(9 * i, 9 * (i + 1));
					}
				this.item5s = this.totalitem5s[this.page5-1];
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
			}
		},
}
</script>

<style>
</style>
