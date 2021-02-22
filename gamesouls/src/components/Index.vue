<template>
	<v-container grid-list-md text-xs-center>

    <v-carousel height="500" hide-delimiter-background show-arrows-on-hover cycle>
	
	<v-carousel-item v-for="item in items" :key="item.id" :src="item.image">
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
						<p class="font-weight-black subtitle-1">{{item.text}}</p> 
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
				<p class="font-weight-black subtitle-1">{{item.text}}</p> 
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
		<v-slide-group v-model="model1" class="pb-5" :show-arrows="showArrows">
	        <v-slide-item v-for="(item1,index) in item1s" :key="item1.id">
			
				<v-card color='white' class="ma-3" height="200" width="200" raised @click="opennews(index)">
					<v-img height="100px" :src="item1.cover"></v-img>
					<v-card-title class="subtitle-1">{{item1.title}}</v-card-title>
					<v-card-subtitle class="pb-0">{{item1.date}}</v-card-subtitle>
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
		<v-slide-group v-model="model2" class="pb-5" :show-arrows="showArrows">
	        <v-slide-item v-for="(item2,index) in item2s" :key="item2.id">
			
	        <v-card color='white' class="ma-3" height="350" width="300" raised @click="openarticle(index)">
				<v-list-item>
				    <v-list-item-avatar><v-img :src="item2.avatar"></v-img></v-list-item-avatar>
						<v-list-item-content>
							<v-list-item-title class="headline">{{item2.title}}</v-list-item-title>
							<v-list-item-subtitle>{{item2.username}}</v-list-item-subtitle>
				        </v-list-item-content>
				</v-list-item>
				<v-img height="200px" :src="item2.cover"></v-img>
				<v-list-item>
					<v-list-item-content>
						<v-list-item-title class="subtitle-1">{{item2.subtitle}}</v-list-item-title>
						<v-list-item-subtitle>
							<v-row justify="end">{{item2.date}}<v-sheet width="40"></v-sheet>
							<v-icon small class="pl-12 pr-2">mdi-heart</v-icon>{{item2.heart}}
							<v-icon small class="pl-4 pr-2">mdi-comment-multiple</v-icon>
							<v-sheet class="pr-4">{{item2.comment}}</v-sheet></v-row>
						</v-list-item-subtitle>
					</v-list-item-content>
				</v-list-item>
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
		<v-slide-group v-model="model3" class="pb-5" :show-arrows="showArrows">
	        <v-slide-item v-for="(item3,index) in item3s" :key="item3.id">
			
	        <v-card  color='white' class="ma-3" height="205" width="350" raised @click="openreview(index)">
				<v-row justify="space-between">
				    <v-col cols="7">
				        <v-card-title>
							<v-avatar size="30"><v-img :src="item3.avatar"></v-img></v-avatar>
								<div class="pl-3">{{item3.username}}</div>
						</v-card-title>
						<v-sheet class="pl-3" id="v-card--c" height="75">{{item3.text}}</v-sheet>
				    </v-col>
				    <v-img class="shrink mt-2" contain height="100px" style="flex-basis: 150px"
				        :src="item3.cover"></v-img>
				</v-row>
				    <v-divider></v-divider>
				    <v-card-actions class="pl-2">
				    <strong>{{item3.game}}</strong>
				      <v-spacer></v-spacer> 
				      <span class="grey--text text--lighten-2 caption mr-2">
				        ({{item3.rate}})
				      </span>
				      <v-rating readonly v-model="item3.rate" background-color="orange lighten-3"
				        color="yellow accent-4" dense half-increments hover size="22"></v-rating>
				    </v-card-actions>
	        </v-card>
			
	        </v-slide-item>
	    </v-slide-group>
	</v-card>
	
	<v-card class="mt-3" tile>
		<v-toolbar dense flat class="yellow--text">
		<v-toolbar-title>攻略</v-toolbar-title>
		<v-spacer></v-spacer>
		<v-btn text x-large color="yellow" :to="{ path: '/walkthrough' }">更多</v-btn>
		</v-toolbar>
		<v-divider></v-divider>
		<v-slide-group v-model="model4" class="pb-5" :show-arrows="showArrows">
	        <v-slide-item v-for="(item4,index) in item4s" :key="item4.id">
			
	        <v-card color='white' class="ma-3" height="290" width="300" raised @click="openwalk(index)">
				
				<v-img height="200px" :src="item4.cover"></v-img>
				<v-list-item>
				    <v-list-item-avatar><v-img :src="item4.avatar"></v-img></v-list-item-avatar>
						<v-list-item-content>
							<v-list-item-title class="headline">{{item4.title}}</v-list-item-title>
							<v-list-item-subtitle>
							<v-row justify="space-between">
							<v-sheet class="pl-4">{{item4.username}}</v-sheet></v-row>
							<v-row justify="end"><v-icon small class="pr-3">mdi-heart</v-icon>
							<v-sheet class="pr-3">{{item4.heart}}</v-sheet>
							<v-icon small class="pr-3">mdi-comment-multiple</v-icon>
							<v-sheet class="pr-3">{{item4.comment}}</v-sheet></v-row>
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
		model1:null,model2:null,model3:null,model4:null,
		showArrows: true,
		items:[],
        item1s:[],item2s:[],item3s:[],item4s:[],
    }),
	created() {
		this.$axios.get('api/getindexlist').then((res)=>{
			  this.items=res.data;
		});
		this.$axios.get('api/getnewsindex').then((res)=>{
			  this.item1s=res.data;
		});
		this.$axios.get('api/getarticleindex').then((res)=>{
			  this.item2s=res.data;
		});
		this.$axios.get('api/getreviewindex').then((res)=>{
			  this.item3s=res.data;
		});
		this.$axios.get('api/getwalkthroughindex').then((res)=>{
			  this.item4s=res.data;
		});
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
		}
	}
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
