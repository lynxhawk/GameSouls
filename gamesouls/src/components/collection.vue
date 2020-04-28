<template>
	<v-img width="1920px" :aspect-ratio="16/9" src="../../public/static/images/dk3.jpg">
		<v-tabs color="blue accent-4" style="margin-left:auto;margin-right:auto;width: 1000px;opacity: 0.8;" background-color="white" centered fixed-tabs>
			<v-tabs-slider color="blue accent-4"></v-tabs-slider>
			<v-tab><strong>资讯</strong></v-tab>
			<v-tab><strong>文章</strong></v-tab>
			<v-tab><strong>评测</strong></v-tab>
			<v-tab><strong>攻略</strong></v-tab>
			<v-tab><strong>论坛</strong></v-tab>
			<v-tab-item>
			    <v-card height="730px">
					<v-row class="px-12">
					    <v-col v-for="n in 12" :key="n" md="3">
							<template>
						        <v-card color='white' height="200" width="200" raised @click="opennews">
								<v-img height="100px" src="../../public/static/images/life2.jpg"></v-img>
								<v-card-title class="subtitle-1">《奇异人生2》解锁新章节</v-card-title>
								<v-card-subtitle class="pb-0">5小时前</v-card-subtitle>
								</v-card>
							</template>
						</v-col>
					</v-row>
					<v-pagination :length="20" v-model="page1" total-visible="8"></v-pagination>
			    </v-card>
			</v-tab-item>
			<v-tab-item>
				<v-card height="730px">
				   	<v-row class="px-5">
				   	    <v-col v-for="n in 8" :key="n" md="3">
							<v-card color='white' height="320" width="300" raised @click="">
								<v-list-item>
								    <v-list-item-avatar color="green"></v-list-item-avatar>
										<v-list-item-content>
											<v-list-item-title class="subtitle">魂学研究</v-list-item-title>
											<v-list-item-subtitle>by LynxHawk</v-list-item-subtitle>
								        </v-list-item-content>
								</v-list-item>
								<v-img height="150px" src="../../public/static/images/dk3.jpg"></v-img>
								<v-card-title class="subtitle-1">来讲讲魂的世界观</v-card-title>
								<v-card-subtitle> 
								<v-row justify="start" class="subtitle-2 pl-3 pt-2">2019/09/19
								<v-icon small class="pl-8 pr-2">mdi-heart</v-icon>25
								<v-icon small class="pl-2 pr-2">mdi-comment-multiple</v-icon>33
								</v-row>
								</v-card-subtitle>
							</v-card>
				   	    </v-col>
				   	</v-row>
				   	<v-pagination :length="20" v-model="page1" total-visible="8"></v-pagination>
				</v-card>
			</v-tab-item>
			<v-tab-item>
			    <v-card height="730px">
			    	<v-row class="px-5">
			    	    <v-col v-for="n in 9" :key="n" md="4">
							<v-card @click="" height="200px" width="300px" raised>
							    <v-img max-height="130px" :aspect-ratio="16/9" src="../../public/static/images/ori.jpg">
							    </v-img>
								<v-row>
									<v-col style="width: 80px;margin-left: 8px;">
										<strong>ori and blind forest</strong>
									</v-col>
									<v-col>
									<v-row justify="center"><strong>{{name1}}</strong></v-row>
									<v-rating readonly v-model="rating" background-color="orange lighten-3"
								    color="yellow accent-4" dense half-increments hover size="22"></v-rating>
									</v-col>
								</v-row>
							</v-card>
				    	</v-col>
				    </v-row>
				    <v-pagination :length="20" v-model="page1" total-visible="8"></v-pagination>
				</v-card>
			</v-tab-item>
			<v-tab-item>
				<v-card height="730px" style="margin-left: auto;margin-right: auto;">
				   	<v-row class="px-5">
				   	    <v-col v-for="n in 12" :key="n" md="3">
				   	        <v-card color='white' height="200" width="280" raised @click="">
				   	        	<v-img height="110px" src="../../public/static/images/acs.jpg"></v-img>
									<v-list-item>
				   	        			<v-list-item-content>
											<v-sheet height="35px" style="overflow: hidden;">刺客信条枭雄</v-sheet>
				   	        				<v-list-item-subtitle>
				   	        				<v-row justify="start" class="pt-3 pl-3"><strong>球球</strong>
											<v-spacer></v-spacer>
											<v-icon small class="pr-3">mdi-heart</v-icon>
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
			<v-card height="730px">
			<v-row class="px-5">
			<template v-for="(item, index) in items">
			<v-col md="4">
			<v-card class="mx-auto" color="white" max-width="400" shaped raised height="200px">
			    <v-card-title style="overflow: hidden;">
					<v-sheet height="45px" class="subtitle-1 font-weight-bold">{{item.title}}</v-sheet>
			    </v-card-title>
				<v-divider></v-divider>
			    <v-card-text style="overflow: hidden;" class="subtitle-2 font-weight">
				<v-sheet height="45px">{{item.subtitle}}</v-sheet></v-card-text>
			
			    <v-card-actions>
					<v-list-item class="grow">
			        <v-list-item-content><v-list-item-title>{{item.name}}</v-list-item-title></v-list-item-content>
			        <v-row align="center" justify="end">
						<span class="subtitle-2 mr-4">{{item.time}}</span>
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
	</v-img>
</template>

<script>
export default {
		name: 'App',
		data() {
			return {
				rating:5,
				page1:1,page2:1,page3:1,page4:1,page5:1,
				name1:'spixii',
				items: [
				        {
						  name: 'mike',
						  title:'"Turns out semicolon-less style is easier and safer in TS because most gotcha edge cases are type invalid as well."',
				          subtitle: "I'll be in your neighborhood doing errands this weekend. Do you want to hang out?I'll be in your neighborhood doing errands this weekend. Do you want to hang out?I'll be in your neighborhood doing errands this weekend. Do you want to hang out?I'll be in your neighborhood doing errands this weekend. Do you want to hang out?",
						  time:'2020-01-22'
				        },
				        {
						  name: 'elf',
						  title:'"Turns out semicolon-less style is easier and safer in TS because most gotcha edge cases are type invalid as well."',
				          subtitle: "Wish I could come, but I'm out of town this weekend.",
						  time:'2020-01-22'
				        },				   
						{
						  name: 'jack',
						  title:'"Turns out semicolon-less style is easier and safer in TS because most gotcha edge cases are type invalid as well."',
				          subtitle: "Do you have Paris recommendations? Have you ever been?",
						  time:'2020-01-22'
				        },				        
				        {
						  name: 'alice',
						  title:'"Turns out semicolon-less style is easier and safer in TS because most gotcha edge cases are type invalid as well."',
				          subtitle: "Have any ideas about what we should get Heidi for her birthday?",
						  time:'2020-01-22'
				        },				       
				        {
						  name:'candy',
						  title:'"Turns out semicolon-less style is easier and safer in TS because most gotcha edge cases are type invalid as well."',
				          subtitle: "We should eat this: Grate, Squash, Corn, and tomatillo Tacos.",
						  time:'2020-01-22'
				        },
						{
						  name: 'jack',
						  title:'"Turns out semicolon-less style is easier and safer in TS because most gotcha edge cases are type invalid as well."',
						  subtitle: "Do you have Paris recommendations? Have you ever been?",
						  time:'2020-01-22'
						},
						{
						  name: 'alice',
						  title:'"Turns out semicolon-less style is easier and safer in TS because most gotcha edge cases are type invalid as well."',
						  subtitle: "Have any ideas about what we should get Heidi for her birthday?",
						  time:'2020-01-22'
						},				       
						{
						  name:'candy',
						  title:'"Turns out semicolon-less style is easier and safer in TS because most gotcha edge cases are type invalid as well."',
						  subtitle: "We should eat this: Grate, Squash, Corn, and tomatillo Tacos.",
						  time:'2020-01-22'
						},
						{
						  name: 'jack',
						  title:'"Turns out semicolon-less style is easier and safer in TS because most gotcha edge cases are type invalid as well."',
						  subtitle: "Do you have Paris recommendations? Have you ever been?",
						  time:'2020-01-22'
						}
						]
			}
		},
		methods:{
			opennews:function(){
				alert("!!!!");
			}
		}
}
</script>

<style>
</style>
