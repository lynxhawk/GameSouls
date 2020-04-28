<template>
	<v-container>
		<v-row justify="center">
		<v-card width="800px" tile>
			<v-row>
			<v-col>
				<v-avatar class="ml-6 mt-6" size="40"><v-img src="../../../public/static/images/lynx.jpg"></v-img></v-avatar>
				<v-sheet class="subtitle-1 ml-6">{{nickname}}</v-sheet>
				<v-sheet class="subtitle-1 ml-6">{{date}}</v-sheet>
				<v-row class="ml-4 mt-4">
					<v-btn rounded dark color="orange" class="mr-1"><v-icon>mdi-bookmark-outline</v-icon>{{bookmark}}</v-btn>
					<v-btn small fab dark color="orange" class="mr-1"><v-icon>mdi-comment-alert-outline</v-icon></v-btn>
					<v-btn small fab dark color="orange"><v-icon>mdi-share-outline</v-icon></v-btn>
				</v-row>
			</v-col>
			<v-col md="9">
				<v-row justify="start" class="title">{{title}}</v-row>
				<v-row justify="start">
					<p>{{text}}</p>
				</v-row>
				<v-img width="400px" src="../../../public/static/images/dk3.jpg"></v-img>
			</v-col>
			</v-row>
			<v-divider></v-divider>
			<v-list>
				<template v-for="(item, index) in items">
				<v-list-item>
					<v-list-item-avatar>
					    <v-img :src="item.avatar"></v-img>
					</v-list-item-avatar>
					<v-list-item-content>
					    <v-list-item-title v-html="item.title"></v-list-item-title>
						<v-list-item-subtitle v-html="item.subtitle"></v-list-item-subtitle>
					</v-list-item-content>
				</v-list-item>
				<v-divider></v-divider>
				</template>
			</v-list>
			<v-pagination color="orange" class="my-6" :length="20" v-model="page" total-visible="8"></v-pagination>
		</v-card>
		<v-card width="800px" tile>
			<v-row class="px-8 py-1 title">回复</v-row>
			<v-row>
			<v-textarea color="orange" class="pl-6 pt-1" label="评论" :value="value" outlined clearable></v-textarea>
			<v-btn text color="orange" class="mt-6 mr-6 ml-2" tile>提交</v-btn></v-row>
			<v-divider></v-divider>
		</v-card>
		</v-row>
	</v-container>
</template>

<script>
	export default{
		data(){
			return{
				heart:20,bookmark:30,comment:20,page:1,
				nickname:'lynxhawk',
				title:'魂学研究',
				date:'2020-01-22',
				text:'黑暗之魂的世界观主要基于欧洲中世纪时期，从角色的职阶上可以看出，骑士、战士、咒术师、法师、盗贼、刺客等，战斗系统主要包含近战，魔法，奇迹，咒术',
				items: [
				        {
				          avatar: 'https://cdn.vuetifyjs.com/images/lists/1.jpg',
						  title: 'mike',
				          subtitle: "I'll be in your neighborhood doing errands this weekend. Do you want to hang out?",
				        },
				        {
				          avatar: 'https://cdn.vuetifyjs.com/images/lists/2.jpg',
						  title: 'elf',
				          subtitle: "Wish I could come, but I'm out of town this weekend.",
				        },				   
				        {
				          avatar: 'https://cdn.vuetifyjs.com/images/lists/3.jpg',
						  title: 'jack',
				          subtitle: "Do you have Paris recommendations? Have you ever been?",
				        },				        
				        {
				          avatar: 'https://cdn.vuetifyjs.com/images/lists/4.jpg',				          
						  title: 'alice',
				          subtitle: "Have any ideas about what we should get Heidi for her birthday?",
				        },				       
				        {
				          avatar: 'https://cdn.vuetifyjs.com/images/lists/5.jpg',				          
						  title:'candy',
				          subtitle: "We should eat this: Grate, Squash, Corn, and tomatillo Tacos.",
				        },
						]
			}
		}
	}
</script>

<style>
</style>
