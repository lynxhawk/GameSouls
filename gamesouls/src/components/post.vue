<template>
	<v-container>
		<v-card height="200px" dark tile>
			<v-img src="../../public/static/images/bg_blue.jpg" class="fill-height">
				<v-row style="padding-top: 70px;" justify="center" class="display-2">动态</v-row>
			</v-img>
		</v-card>
		<v-card>
			<v-tabs vertical>
				<v-tab>资讯</v-tab>
				<v-tab>文章</v-tab>
				<v-tab>评测</v-tab>
				<v-tab>攻略</v-tab>
			
			    <v-tab-item>
			       <v-card tile style="display: flex;flex-wrap: wrap;" class="px-12">
			       	<!--<template v-for="(item, index) in items">-->
			       	<v-col md="3" v-for="n in 20" :key="n">
			       	<v-card color='white' class="ma-3" height="200" width="200" raised @click="toggle">
			       		<v-img height="100px" src="../../public/static/images/life2.jpg"></v-img>
			       		<v-card-title class="subtitle-1">《奇异人生2》解锁新章节</v-card-title>
			       		<v-card-subtitle class="pb-0">5小时前</v-card-subtitle>
			       	</v-card>
			       	</v-col>
					</v-card>
			    </v-tab-item>
			    <v-tab-item>
					<v-card tile style="display: flex;flex-wrap: wrap;" class="pr-5">
						<!--<template v-for="(item, index) in items">-->
						<v-col md="3" v-for="n in 20" :key="n">
						<v-card color='white' class="ma-3" height="350" width="300" raised @click="toggle">
							<v-list-item>
							    <v-list-item-avatar color="green"></v-list-item-avatar>
									<v-list-item-content>
										<v-list-item-title class="headline">魂学研究</v-list-item-title>
										<v-list-item-subtitle>by LynxHawk</v-list-item-subtitle>
							        </v-list-item-content>
							</v-list-item>
							<v-img height="180px" src="../../public/static/images/dk3.jpg"></v-img>
							<v-card-title class="subtitle-1">来讲讲魂的世界观</v-card-title>
							<v-card-subtitle> 
							<v-row justify="end">
							<v-sheet>2019/09/19</v-sheet>
							<v-icon small class="pl-12 pr-2">mdi-heart</v-icon>25
							<v-icon small class="pl-4 pr-2">mdi-comment-multiple</v-icon>
							<v-sheet class="pr-2">33</v-sheet></v-row>
							</v-card-subtitle>
						</v-card>
						</v-col>
					</v-card>
			    </v-tab-item>
				<v-tab-item>
					<v-card tile style="display: flex;flex-wrap: wrap;">
						<!--<template v-for="(item, index) in items">-->
						<v-col md="4" v-for="n in 20" :key="n">
							<v-card color='white' height="205" width="350" raised @click="toggle">
								<v-row justify="space-between">
									<v-col cols="7">
										<v-card-title>
										<v-avatar size="30" color="red"></v-avatar>
										<div class="pl-3">Spixii</div>
										</v-card-title>
									<v-sheet class="pl-3" id="v-card--c" height="75">{{text}}</v-sheet>
									</v-col>
									<v-img class="mt-2" contain height="100px" style="flex-basis: 100px"
									src="../../public/static/images/ori.jpg"></v-img>
								</v-row>
						    <v-divider></v-divider>
						    <v-card-actions class="pl-2">
								<strong>ori and blind forest</strong>
								<v-spacer></v-spacer> 
								<span class="black--text text--lighten-2 caption mr-2">({{ rating }})</span>
								<v-rating readonly v-model="rating" background-color="orange lighten-3"
						        color="yellow accent-4" dense half-increments hover size="22"></v-rating>
						    </v-card-actions>
							</v-card>
						</v-col>
					</v-card>
				</v-tab-item>
			    <v-tab-item>
			        <v-card tile style="display: flex;flex-wrap: wrap;" class="px-12">
			        	<!--<template v-for="(item, index) in items">-->
			        	<v-col md="4" v-for="n in 20" :key="n">
			        		<v-card color='white' class="ma-3" height="290" width="300" raised @click="toggle">
			        			
			        			<v-img height="200px" src="../../public/static/images/acs.jpg"></v-img>
			        			<v-list-item>
			        			    <v-list-item-avatar color="yellow"></v-list-item-avatar>
			        					<v-list-item-content>
			        						<v-list-item-title class="headline">刺客信条枭雄</v-list-item-title>
			        						<v-list-item-subtitle>
			        						<v-row justify="space-between">
			        						<v-sheet class="pl-4">by 球球</v-sheet></v-row>
			        						<v-row justify="end"><v-icon small class="pr-3">mdi-heart</v-icon>
			        						<v-sheet class="pr-3">25</v-sheet>
			        						<v-icon small class="pr-3">mdi-comment-multiple</v-icon>
			        						<v-sheet class="pr-3">33</v-sheet></v-row>
			        						</v-list-item-subtitle>
			        					</v-list-item-content>						
			        			</v-list-item>
			        		
			        		</v-card>
			        	</v-col>
			        </v-card>
				</v-tab-item>
			</v-tabs>
		</v-card>
	</v-container>
</template>

<script>
export default {
		name: 'App',
		data() {
			return {
				page1:1,page2:1,page3:1,page4:1,
				rating:5,
				text:'非常精彩的横版式通关动作游戏，画面精美动作流畅关卡设计有挑战性，剧情与世界观的结合非常的好，抱走ori!'
			}
		}
}
</script>

<style>
</style>
