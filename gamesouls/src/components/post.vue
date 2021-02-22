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
			       	<template v-for="(item, index) in item1s">
			       	<v-col md="3">
			       	<v-card color='white' class="ma-3" height="200" width="200" raised :to="{ path: '/readnews/'+item.id }">
			       		<v-img height="100px" :src="item.cover"></v-img>
			       		<v-card-title class="subtitle-1">{{item.title}}</v-card-title>
			       		<v-card-subtitle class="pb-0">{{item.date}}</v-card-subtitle>
			       	</v-card>
			       	</v-col>
					</template>
					</v-card>
			    </v-tab-item>
			    <v-tab-item>
					<v-card tile style="display: flex;flex-wrap: wrap;" class="pr-5">
						<template v-for="(item, index) in item2s">
						<v-col md="3">
						<v-card color='white' class="ma-3" height="350" width="300" raised :to="{ path: '/readarticle/'+item.id }">
							<v-list-item>
							    <v-list-item-avatar><v-img :src="item.avatar"></v-img></v-list-item-avatar>
									<v-list-item-content>
										<v-list-item-title class="headline">{{item.title}}</v-list-item-title>
										<v-list-item-subtitle>{{item.username}}</v-list-item-subtitle>
							        </v-list-item-content>
							</v-list-item>
							<v-img height="180px" :src="item.cover"></v-img>
							<v-card-title class="subtitle-1">{{item.subtitle}}</v-card-title>
							<v-card-subtitle> 
							<v-row justify="end">
							<v-sheet>{{item.date}}</v-sheet>
							<v-icon small class="pl-12 pr-2">mdi-heart</v-icon>{{item.heart}}
							<v-icon small class="pl-4 pr-2">mdi-comment-multiple</v-icon>
							<v-sheet class="pr-2">{{item.comment}}</v-sheet></v-row>
							</v-card-subtitle>
						</v-card>
						</v-col>
						</template>
					</v-card>
			    </v-tab-item>
				<v-tab-item>
					<v-card tile style="display: flex;flex-wrap: wrap;">
						<template v-for="(item, index) in item3s">
						<v-col md="4">
							<v-card color='white' height="205" width="350" raised :to="{ path: '/readreview/'+item.id }">
								<v-row justify="space-between">
									<v-col cols="7">
										<v-card-title>
										<v-avatar size="30"><v-img :src="item.avatar"></v-img></v-avatar>
										<div class="pl-3">{{item.username}}</div>
										</v-card-title>
									<v-sheet class="pl-3" id="v-card--c" height="75">{{item.text}}</v-sheet>
									</v-col>
									<v-img class="mt-2" contain height="100px" style="flex-basis: 100px"
									:src="item.cover"></v-img>
								</v-row>
						    <v-divider></v-divider>
						    <v-card-actions class="pl-2">
								<strong>{{item.game}}</strong>
								<v-spacer></v-spacer> 
								<span class="black--text text--lighten-2 caption mr-2">({{item.rate}})</span>
								<v-rating readonly v-model="item.rate" background-color="orange lighten-3"
						        color="yellow accent-4" dense half-increments hover size="22"></v-rating>
						    </v-card-actions>
							</v-card>
						</v-col>
						</template>
					</v-card>
				</v-tab-item>
			    <v-tab-item>
			        <v-card tile style="display: flex;flex-wrap: wrap;" class="px-12">
			        	<template v-for="(item, index) in item4s">
			        	<v-col md="4">
			        		<v-card color='white' class="ma-3" height="290" width="300" raised :to="{ path: '/readwalk/'+item.id }">
			        			
			        			<v-img height="200px" :src="item.cover"></v-img>
			        			<v-list-item>
			        			    <v-list-item-avatar><v-img :src="item.avatar"></v-img></v-list-item-avatar>
			        					<v-list-item-content>
			        						<v-list-item-title class="headline">{{item.title}}</v-list-item-title>
			        						<v-list-item-subtitle>
			        						<v-row justify="space-between">
			        						<v-sheet class="pl-4">{{item.username}}</v-sheet></v-row>
			        						<v-row justify="end"><v-icon small class="pr-3">mdi-heart</v-icon>
			        						<v-sheet class="pr-3">{{item.heart}}</v-sheet>
			        						<v-icon small class="pr-3">mdi-comment-multiple</v-icon>
			        						<v-sheet class="pr-3">{{item.comment}}</v-sheet></v-row>
			        						</v-list-item-subtitle>
			        					</v-list-item-content>						
			        			</v-list-item>
			        		
			        		</v-card>
			        	</v-col>
						</template>
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
			item1s:[],item2s:[],item3s:[],item4s:[],
			
		}
	},
	created() {
		if(localStorage.getItem("id")!=null){
			
		this.$axios.get('api/getnewsuserlist/'+localStorage.getItem("id")).then((res)=>{
			  this.item1s=res.data;
		});
		this.$axios.get('api/getarticleuserlist/'+localStorage.getItem("id")).then((res)=>{
			  this.item2s=res.data;
		});
		this.$axios.get('api/getreviewuserlist/'+localStorage.getItem("id")).then((res)=>{
			  this.item3s=res.data;
		});
		this.$axios.get('api/getwalkuserlist/'+localStorage.getItem("id")).then((res)=>{
			  this.item4s=res.data;
		});
		
		}
	},
	methods:{
		toggle(){
			
		}
	}
}
</script>

<style>
</style>
