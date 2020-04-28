<template>
	<v-container grid-list-md text-xs-center>

    <v-carousel height="500" hide-delimiter-background show-arrows-on-hover cycle>
	
	<v-carousel-item v-for="item in items" :key="item.id" :src="item.src">
		<v-card height="300" id="v-card--b"></v-card>	
			<v-hover v-slot:default="{ hover }">
				<v-card class="v-card--a hidden-sm-and-down" height="150" width="500" :elevation="hover ? 20 : 0" shaped>
					<v-card id="v-card--a" shaped height="150" width="500" color="white" :class="{ 'on-hover': hover }" >
						<v-card-title class="title black--text">
							<v-row class=" flex-column" justify="end">
							<p class="mr-12 text-right">{{ item.title }}</p>
							</v-row>
						</v-card-title>
						<v-card-subtitle class="black--text">
						<p class="font-weight-black subtitle-1">{{text}}</p> 
						</v-card-subtitle>
					</v-card>
				</v-card>
			</v-hover>
			<v-card class="hidden-md-and-up mx-4" color="white" height="150" style="overflow: hidden;opacity: 0.6;" shaped>
				<v-card-title class="title black--text">
					<v-row class=" flex-column" justify="end">
					<p class="mr-12 text-right">{{ item.title }}</p>
					</v-row>
				</v-card-title>
				<v-card-subtitle class="black--text">
				<p class="font-weight-black subtitle-1">{{text}}</p> 
				</v-card-subtitle>
			</v-card>
	</v-carousel-item>
    </v-carousel>
	
	<v-card class="mt-3" tile>
		<v-toolbar dense class="cyan--text" flat>
		<v-toolbar-title>资讯</v-toolbar-title>
		<v-spacer></v-spacer>
		<v-btn text x-large color="cyan" :to="{ path: '/news' }">更多</v-btn>
		</v-toolbar>
		<v-divider></v-divider>
		<v-slide-group v-model="model" class="pb-5" :show-arrows="showArrows">
	        <v-slide-item v-for="n in 15" :key="n"  v-slot:default="{ toggle }">
			
				<v-card color='white' class="ma-3" height="200" width="200" raised @click="toggle">
					<v-img height="100px" src="../../public/static/images/life2.jpg"></v-img>
					<v-card-title class="subtitle-1">《奇异人生2》解锁新章节</v-card-title>
					<v-card-subtitle class="pb-0">5小时前</v-card-subtitle>
				</v-card>
			  
	        </v-slide-item>
	    </v-slide-group>
	</v-card>
	
	<v-card class="mt-3" tile>
		<v-toolbar dense flat class="green--text">
		<v-toolbar-title >文章</v-toolbar-title>
		<v-spacer></v-spacer>
		<v-btn text x-large color="green" :to="{ path: '/article' }">更多</v-btn>
		</v-toolbar>
		<v-divider></v-divider>
		<v-slide-group v-model="model" class="pb-5" :show-arrows="showArrows">
	        <v-slide-item v-for="n in 15" :key="n"  v-slot:default="{ toggle }">
			
	        <v-card color='white' class="ma-3" height="350" width="300" raised @click="toggle">
				<v-list-item>
				    <v-list-item-avatar color="green"></v-list-item-avatar>
						<v-list-item-content>
							<v-list-item-title class="headline">魂学研究</v-list-item-title>
							<v-list-item-subtitle>by LynxHawk</v-list-item-subtitle>
				        </v-list-item-content>
				</v-list-item>
				<v-img height="200px" src="../../public/static/images/dk3.jpg"></v-img>
				<v-card-title class="subtitle-1">来讲讲魂的世界观</v-card-title>
				<v-card-subtitle> 
				<v-row justify="end">
				2019/09/19<v-sheet width="50"></v-sheet>
				<v-icon small class="pl-12 pr-2">mdi-heart</v-icon>25
				<v-icon small class="pl-4 pr-2">mdi-comment-multiple</v-icon>
				<v-sheet class="pr-2">33</v-sheet></v-row>
				</v-card-subtitle>
	        </v-card>
			
	        </v-slide-item>
	    </v-slide-group>
	</v-card>
	
	<v-card class="mt-3" tile>
		<v-toolbar dense flat class="red--text">
		<v-toolbar-title>评测</v-toolbar-title>
		<v-spacer></v-spacer>
		<v-btn text x-large color="red" :to="{ path: '/review' }">更多</v-btn>
		</v-toolbar>
		<v-divider></v-divider>
		<v-slide-group v-model="model" class="pb-5" :show-arrows="showArrows">
	        <v-slide-item v-for="n in 15" :key="n"  v-slot:default="{ toggle }">
			
	        <v-card  color='white' class="ma-3" height="205" width="350" raised @click="toggle">
				<v-row justify="space-between">
				    <v-col cols="7">
				        <v-card-title>
							<v-avatar size="30" color="red"></v-avatar>
								<div class="pl-3">Spixii</div>
						</v-card-title>
						<v-sheet class="pl-3" id="v-card--c" height="75">{{text}}</v-sheet>
				    </v-col>
				    <v-img class="shrink mt-2" contain height="100px" style="flex-basis: 150px"
				        src="../../public/static/images/ori.jpg"></v-img>
				</v-row>
				    <v-divider></v-divider>
				    <v-card-actions class="pl-2">
				    <strong>ori and blind forest</strong>
				      <v-spacer></v-spacer> 
				      <span class="grey--text text--lighten-2 caption mr-2">
				        ({{ rating }})
				      </span>
				      <v-rating readonly v-model="rating" background-color="orange lighten-3"
				        color="yellow accent-4" dense half-increments hover size="22"></v-rating>
				    </v-card-actions>
	        </v-card>
			
	        </v-slide-item>
	    </v-slide-group>
	</v-card>
	
	<v-card class="mt-3" tile>
		<v-toolbar dense flat class="yellow--text">
		<v-toolbar-title >攻略</v-toolbar-title>
		<v-spacer></v-spacer>
		<v-btn text x-large color="yellow" :to="{ path: '/walkthrough' }">更多</v-btn>
		</v-toolbar>
		<v-divider></v-divider>
		<v-slide-group v-model="model" class="pb-5" :show-arrows="showArrows">
	        <v-slide-item v-for="n in 15" :key="n"  v-slot:default="{ toggle }">
			
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
			
	        </v-slide-item>
	    </v-slide-group>
	</v-card>
	
	<v-divider></v-divider>

	
  </v-container>
  
</template>

<script>
  export default {
    data: () => ({
		model:null,
		showArrows: true,
		page:1,
		dialog: false,
		rating: 5,
        items: [
          {
			id:1,
			title:'Dark Souls',
            //src: 'https://cdn.vuetifyjs.com/images/carousel/squirrel.jpg'
			src:'../../../static/images/600918.jpg'
          },
          {
			id:2,
			title:'ac',
            //src: 'https://cdn.vuetifyjs.com/images/carousel/sky.jpg'
			src:'../../../static/images/acs.jpg'
          },
          {
			id:3,
			title:'life is strange',
            //src: 'https://cdn.vuetifyjs.com/images/carousel/bird.jpg'
			src:'../../../static/images/life2.jpg'
          },
          {
			id:4,
			title:'ori and blind forest',
            //src: 'https://cdn.vuetifyjs.com/images/carousel/planet.jpg'
			src:'../../../static/images/ori.jpg'
          }
        ],
		gameinfos:[
			'Developer:FromSoftware',
			'Publisher:fromsoftware,BANDAI NAMCO Entertainment',
			'发行日期:2016年4月12日',
			'分类：ARPG',
			'语言：英语 简体中文 繁体中文 等',
			'分级 ：PEGI 16 	Violence, Online Gameplay',
			'Platform:PC & XBOX & PS4'	
		],
		text:'Dark Souls III is an action role-playing game played in a third-person perspective, similar to previous games in the series.'
		+'According to lead director and series creator Hidetaka Miyazaki,' 
		+'the game\'s gameplay design followed "closely from Dark Souls II".'
		+'Players are equipped with a variety of weapons to fight against enemies,such as bows, throwable projectiles, and swords.'
		+'Shields can act as secondary weapons but they are mainly used to deflect enemies\' attacks and protect the player from suffering damage.[2] Each weapon has two basic types of attack, one being a standard attack, and the other being slightly more powerful that can be charged up, similar to FromSoftware\'s previous game, Bloodborne. In addition, attacks can be evaded through dodge-rolling.Bonfires, which serve as checkpoints, return from previous installments.'
		+'Ashes, according to Miyazaki, play an important role in the game.',
      importantLinks: 
	  [
        {
          text: 'Documentation',
          href: 'https://vuetifyjs.com'
        },
        {
          text: 'Chat',
          href: 'https://community.vuetifyjs.com'
        },
        {
          text: 'Made with Vuetify',
          href: 'https://madewithvuetifyjs.com'
        },
        {
          text: 'Twitter',
          href: 'https://twitter.com/vuetifyjs'
        },
        {
          text: 'Articles',
          href: 'https://medium.com/vuetify'
        }
      ]
    })
  }
</script>

<style>
<style>
.v-card--reveal {
  align-items: center;
  bottom: 0;
  justify-content: center;
  opacity: .5;
  position: absolute;
  width: 100%;
}
.v-card--a{
	position: relative;
	left: 630px;
	overflow: hidden;
	opacity: 0.7;
	transition: opacity .4s ease-in-out;
}
#v-card--a:not(.on-hover) {
  opacity: 0.6;
 }
#v-card--b{
	opacity: .0;
}
#v-card--c{
	overflow: hidden;
}
</style>
