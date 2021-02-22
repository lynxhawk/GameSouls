<template>
	<v-img width="1920px" :aspect-ratio="16/9" :src="background">
	<v-row justify="center">
	<v-card tile width="800px" height="600px" style="opacity: 0.9;margin-top: 60px;">
		<v-tabs vertical>
	      <v-tab>
	        <v-icon left>mdi-comment-text-multiple</v-icon>
			我的评论
	      </v-tab>
	      <v-tab>
	        <v-icon left>mdi-message-reply-text</v-icon>
	        我的回复
	      </v-tab>
	
	    <v-tab-item>
	        <v-card flat height="610px" style="overflow-y: auto;">
	        <v-list three-line>
				<template v-for="(item, index) in items">
	                <v-list-item @click="opencomment(index)">
					<v-row>
						<v-sheet class="mr-2 light-blue--text">你在</v-sheet>
						<strong>{{item.type}}{{item.title}}</strong>
						<v-sheet class="mx-2 light-blue--text">中评论了</v-sheet>
						<strong>{{item.text}}</strong>
					</v-row>
					</v-list-item>
					<v-divider></v-divider>
	                </template>
	            </v-list>
	        </v-card>
		</v-tab-item>
	    <v-tab-item>
			<v-card flat height="610px" style="overflow-y: auto;">
			<v-list three-line>
				<template v-for="(item, index) in item1s">
			        <v-list-item @click="openreply(index)">
						<v-row>
							<v-sheet class="mr-2 light-blue--text">你在</v-sheet>
							<strong>{{item.title}}</strong>
							<v-sheet class="mx-2 light-blue--text">中回复了</v-sheet>
							<strong>{{item.text}}</strong>
						</v-row>
					</v-list-item>
					<v-divider></v-divider>
			        </template>
			    </v-list>
			</v-card>
	    </v-tab-item>
	    </v-tabs>
	</v-card>
	</v-row>
	
	</v-img>
</template>

<script>
	export default {
		name: 'App',
		data() {
			return {
				background:'',
				items:[],item1s:[]
			}
		},
		created(){
			if(localStorage.getItem("id")!=null){
				this.background=localStorage.getItem("background");
			}
			this.$axios.get('http://localhost:8888/getcommentlist/'+localStorage.getItem("id")).then((res)=>{
				this.items=res.data;
			});
			this.$axios.get('http://localhost:8888/getreplylist/'+localStorage.getItem("id")).then((res)=>{
				this.item1s=res.data;
			});
		},
		methods:{
			opencomment(index){
				if(this.items[index].type=="资讯"){
					this.$router.push({path: '/readnews/' + this.items[index].workid});
				}
				if(this.items[index].type=="文章"){
					this.$router.push({path: '/readarticle/' + this.items[index].workid});
				}
				if(this.items[index].type=="评测"){
					this.$router.push({path: '/readreview/' + this.items[index].workid});
				}
				if(this.items[index].type=="攻略"){
					this.$router.push({path: '/readwalk/' + this.items[index].workid});
				}
			},
			openreply(index){
				this.$router.push({path: '/readdiscuss/' + this.item1s[index].workid});
			}
		}
	}
</script>

<style>
</style>
