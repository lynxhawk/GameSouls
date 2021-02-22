<template>
	<v-container>
		<v-card height="200px" dark tile>
			<v-img src="../../public/static/images/bg_purple.jpg" class="fill-height">
				<v-row style="margin-top: 75px;" justify="center" class="display-2">搜索</v-row>
			</v-img>
		</v-card>
		<v-card tile>
		<v-row class="px-3">
		<v-combobox style="width: 200px;" v-model="chips" :items="items" chips clearable label="搜索内容"
		    multiple solo item-color="purple" prepend-inner-icon="mdi-magnify">
		    <template v-slot:selection="{ attrs, item, select, selected }">
				<v-chip v-bind="attrs" :input-value="selected" close label ripple
				@click="select" @click:close="remove(item)">
		        <strong>{{ item }}</strong>
				</v-chip>
		    </template>
		</v-combobox>
		<v-btn text tile height="50px" color="purple" @click="searchall">搜索</v-btn>
		</v-row>
		
		<v-row class="subtitle-1 pl-6 pb-4">搜索历史</v-row>
		<v-chip v-for="history in historys" :key="history.search" label class="mx-4 mb-4" outlined color="purple" ripple
			@click="addhistory(history)">
			{{history.search}}
		</v-chip>

		</v-card>
		
		<v-card tile>
		<v-sheet class="title pa-4">搜索结果</v-sheet>
		<v-divider></v-divider>
		
		<v-card tile style="display: flex;flex-wrap: wrap;" class="px-12">
			<template v-for="(item, index) in item1s">
			<v-col md="3">
			<v-card color='white' class="ma-3" height="200" width="200" raised 
			:to="{ path: '/readnews/'+item.id }">
				<v-img height="100px" :src="item.cover"></v-img>
				<v-card-title class="subtitle-1">{{item.title}}</v-card-title>
				<v-card-subtitle class="pb-0">{{item.date}}</v-card-subtitle>
			</v-card>
			</v-col>
			</template>
		
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
		
			<template v-for="(item, index) in item3s">
			<v-col md="4">
				<v-card color='white' class="ma-3" height="205" width="350" raised :to="{ path: '/readreview/'+item.id }">
					<v-row justify="space-between">
						<v-col cols="7">
							<v-card-title>
							<v-avatar size="30"><v-img :src="item.avatar"></v-img></v-avatar>
							<div style="height: 30px;width: 80px;overflow: hidden; text-overflow:ellipsis;" class="pl-3">{{item.username}}</div>
							</v-card-title>
						<v-sheet class="pl-3" id="v-card--c" height="75">{{item.text}}</v-sheet>
						</v-col>
						<v-img class="mt-8" height="100px" style="flex-basis: 30px"
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
		
		<template v-for="(item, index) in item5s">
		<v-col md="4">
		<v-card class="mx-2" color="white" width="400" shaped raised :to="{ path: '/readdiscuss/'+item.id }">
		    <v-card-title style="overflow: hidden;">
				<v-sheet height="50px" class="title font-weight-bold">{{item.title}}</v-sheet>
		    </v-card-title>
			<v-divider></v-divider>
		    <v-card-text style="overflow: hidden;" class="subtitle-2 font-weight">
			<v-sheet height="95px">{{item.text}}</v-sheet></v-card-text>
			<v-divider></v-divider>
		    <v-card-actions>
				<v-list-item class="grow">
		        <v-list-item-avatar>
					<v-img class="elevation-6" :src="item.avatar"></v-img>
		        </v-list-item-avatar>
		        <v-list-item-content><v-list-item-title>{{item.username}}</v-list-item-title></v-list-item-content>
		        <v-row align="center" justify="end">
					<span class="subheading mr-4">{{item.date}}</span>
					<v-icon class="mr-2">mdi-comment-text-multiple</v-icon>
					<span class="subheading mr-2">{{item.comment}}</span>
		        </v-row>
				</v-list-item>
		    </v-card-actions>
		</v-card>
		</v-col>
		</template>
		
		<template v-for="(item, index) in item6s">
		<v-col md="4">
		<v-card class="mx-2" color="white" width="400" shaped raised :to="{ path: '/myspace/'+item.id }">
			<v-card-title style="overflow: hidden;">		    
				<v-sheet height="50px" class="title font-weight-bold">
				<v-avatar><v-img class="elevation-6" :src="item.avatar"></v-img></v-avatar>
				{{item.username}}</v-sheet>
		    </v-card-title>
			<v-divider></v-divider>
		    <v-card-text style="overflow: hidden;" class="subtitle-2 font-weight">
			<v-sheet height="50px">{{item.introduce}}</v-sheet></v-card-text>
		</v-card>
		</v-col>
		</template>
		</v-card>
		</v-card>
	</v-container>
</template>

<script>
	export default {
	    data () {
	      return {
			checkbox1:false,checkbox2:false,checkbox3:false,checkbox4:false,checkbox5:false,
			search:[],chips:[],checkbox6:false,
	        items: ['资讯', '文章','评测','攻略','论坛','用户'],
			attrs:[],
			historys:[],
			item1s:[],item2s:[],item3s:[],item4s:[],item5s:[],item6s:[]
	      }
	    },
	    methods: {
			remove (item) {
				this.chips.splice(this.chips.indexOf(item), 1)
				this.chips = [...this.chips]
			},
			addhistory(history){
				this.chips.splice(0,0,history.search)
				this.chips = [...this.chips]
			},
			searchall(){
				for(var i=0; i<this.chips.length; i++) {
				    if(this.chips[i] == "资讯"){
						this.checkbox1=true;
						this.chips.splice(i, 1);
				    }
					if(this.chips[i] == "文章"){
						this.checkbox2=true;
						this.chips.splice(i, 1);
					}
					if(this.chips[i] == "评测"){
						this.checkbox3=true;
						this.chips.splice(i, 1);
					}
					if(this.chips[i] == "攻略"){
						this.checkbox4=true;
						this.chips.splice(i, 1);
					}
					if(this.chips[i] == "论坛"){
						this.checkbox5=true;
						this.chips.splice(i, 1);
					}
					if(this.chips[i] == "用户"){
						this.checkbox6=true;
						this.chips.splice(i, 1);
					}
				}
				if(this.checkbox1==true){
					this.$axios.get('api/getnewssearch/'+this.chips[0]).then((res)=>{
						this.item1s=res.data;
					});
				}
				if(this.checkbox2==true){
					this.$axios.get('api/getarticlesearch/'+this.chips[0]).then((res)=>{
						this.item2s=res.data;
					});
				}
				if(this.checkbox3==true){
					this.$axios.get('api/getreviewsearch/'+this.chips[0]).then((res)=>{
						this.item3s=res.data;
					});
				}
				if(this.checkbox4==true){
					this.$axios.get('api/getwalksearch/'+this.chips[0]).then((res)=>{
						this.item4s=res.data;
					});
				}
				if(this.checkbox5==true){
					this.$axios.get('api/getdiscusssearch/'+this.chips[0]).then((res)=>{
						this.item5s=res.data;
					});
				}
				if(this.checkbox6==true){
					this.$axios.get('api/searchuser/'+this.chips[0]).then((res)=>{
						this.item6s=res.data;
					});
				}
				if(this.checkbox1==false&&this.checkbox2==false&&this.checkbox3==false&&this.checkbox4==false&&this.checkbox5==false){
					this.$axios.get('api/getnewssearch/'+this.chips[0]).then((res)=>{
						this.item1s=res.data;
					});
					this.$axios.get('api/getarticlesearch/'+this.chips[0]).then((res)=>{
						this.item2s=res.data;
					});
					this.$axios.get('api/getreviewsearch/'+this.chips[0]).then((res)=>{
						this.item3s=res.data;
					});
					this.$axios.get('api/getwalksearch/'+this.chips[0]).then((res)=>{
						this.item4s=res.data;
					});
					this.$axios.get('api/getdiscusssearch/'+this.chips[0]).then((res)=>{
						this.item5s=res.data;
					});
				}
				if(localStorage.getItem("id")!=null){
					this.$axios.get('api/addsearch/'+localStorage.getItem("id"),{
					params:{
					   search:this.chips[0]
					}
				}).then((res)=>{

				});
				}
			}
	    },
		created() {
			this.$axios.get('api/getsearch/'+localStorage.getItem("id")).then((res)=>{
				  this.historys=res.data;
			});
		}
	  }
</script>

<style>
</style>
