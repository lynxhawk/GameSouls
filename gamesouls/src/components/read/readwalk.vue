<template>
	<v-container>
		<v-row justify="center">
		<v-card width="800px" tile>
			<v-row justify="center" class="display-1 pt-12 pb-12">{{title}}</v-row>
			<v-row align="center" class="pl-12 pb-6">
				<v-avatar size="40"><v-img src="../../../public/static/images/lynx.jpg"></v-img></v-avatar>
				<v-sheet class="subtitle-1 ml-6">{{nickname}}</v-sheet>
				<v-sheet class="subtitle-1 ml-6">{{date}}</v-sheet>
				<v-spacer></v-spacer>
				<v-btn small fab dark color="yellow" class="mx-1"><v-icon>mdi-heart-outline</v-icon></v-btn>
				<v-btn small fab dark color="yellow" class="mx-1"><v-icon>mdi-bookmark-outline</v-icon></v-btn>
				<v-btn small fab dark color="yellow" class="mx-1"><v-icon>mdi-share-outline</v-icon></v-btn>
				<v-tooltip top><template v-slot:activator="{ on }">
					<v-btn small fab dark color="yellow" v-on="on" class="ml-1 mr-6"><v-icon>mdi-file-document-edit-outline</v-icon></v-btn>
				</template>编辑申请</v-tooltip>
			</v-row>
			<v-row class="px-12">
				<p>{{text}}</p>
				<v-img src="../../../public/static/images/acs.jpg"></v-img>
				<p>{{text}}</p>
			</v-row>
			<v-row class="px-12 py-6">
				<v-btn rounded dark color="yellow" class="mx-1"><v-icon>mdi-heart-outline</v-icon>{{heart}}</v-btn>
				<v-btn rounded dark color="yellow" class="mx-6"><v-icon>mdi-bookmark-outline</v-icon>{{bookmark}}</v-btn>
				<v-spacer></v-spacer>
				<v-btn small fab dark color="yellow" class="ml-6 mr-4"><v-icon>mdi-comment-alert-outline</v-icon></v-btn>
				<v-btn small fab dark color="yellow" class="ml-6 mr-4"><v-icon>mdi-share-outline</v-icon></v-btn>
			</v-row>
		</v-card>
		<v-card width="800px" tile>
			<v-row class="px-12 py-6 title">评论·{{comment}}</v-row>
			<v-divider></v-divider>
			<v-row>
			<v-textarea color="yellow" class="pl-6 pt-6" label="评论" :value="value" outlined clearable></v-textarea>
			<v-btn text color="yellow" class="mt-6 mr-6 ml-2" tile>提交</v-btn></v-row>
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
				</template>
			</v-list>
		</v-card>
		</v-row>
	</v-container>
</template>

<script>
	export default{
		data(){
			return{
				heart:20,bookmark:30,comment:20,
				nickname:'lynxhawk',
				title:'刺客信条攻略',
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
