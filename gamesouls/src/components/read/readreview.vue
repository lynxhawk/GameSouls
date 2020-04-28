<template>
	<v-container>
		<v-row justify="center">
		<v-card width="800px" tile>
			<v-img class="mx-auto" width="400px" src="../../../public/static/images/ori.jpg"></v-img>
			<v-row justify="center" class="display-1 pt-12">{{title}}</v-row>
			<v-row justify="center">
				<v-rating v-model="rating" background-color="orange lighten-3" readonly
				color="yellow accent-4" half-increments hover size="30"></v-rating></v-row>
			<v-row align="center" class="pl-12 pb-6">
				<v-avatar size="40"><v-img src="../../../public/static/images/lynx.jpg"></v-img></v-avatar>
				<v-sheet class="subtitle-1 ml-6">{{nickname}}</v-sheet>
				<v-sheet class="subtitle-1 ml-6">{{date}}</v-sheet>
				<v-spacer></v-spacer>
				<v-row justify="end">
				<v-btn small fab dark color="red" class="mx-1"><v-icon>mdi-heart-outline</v-icon></v-btn>
				<v-btn small fab dark color="red" class="mx-1"><v-icon>mdi-bookmark-outline</v-icon></v-btn>
				<v-btn small fab dark color="red" class="ml-1 mr-6"><v-icon>mdi-share-outline</v-icon></v-btn>
				</v-row>
			</v-row>
			<v-row class="px-12">
				<p>{{text}}</p>
				<p>{{text}}</p>
			</v-row>
			<v-row class="px-12 py-6">
				<v-btn rounded dark color="red" class="mx-1"><v-icon>mdi-heart-outline</v-icon>{{heart}}</v-btn>
				<v-btn rounded dark color="red" class="mx-6"><v-icon>mdi-bookmark-outline</v-icon>{{bookmark}}</v-btn>
				<v-spacer></v-spacer>
				<v-btn small fab dark color="red" class="ml-6 mr-4"><v-icon>mdi-comment-alert-outline</v-icon></v-btn>
				<v-btn small fab dark color="red" class="ml-6 mr-4"><v-icon>mdi-share-outline</v-icon></v-btn>
			</v-row>
		</v-card>
		<v-card width="800px" tile>
			<v-row class="px-12 py-6 title">评论·{{comment}}</v-row>
			<v-divider></v-divider>
			<v-row>
			<v-textarea color="red" class="pl-6 pt-6" label="评论" :value="value" outlined clearable></v-textarea>
			<v-btn text color="red" class="mt-6 mr-6 ml-2" tile>提交</v-btn></v-row>
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
				title:'ori and bind forest',
				rating:5,
				date:'2020-01-22',
				text:'非常精彩的横版式通关动作游戏，画面精美动作流畅关卡设计有挑战性，剧情与世界观的结合非常的好，抱走ori!',
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
