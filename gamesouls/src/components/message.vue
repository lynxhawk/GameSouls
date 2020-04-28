<template>
	<v-img width="1920px" :aspect-ratio="16/9" src="../../public/static/images/dk3.jpg">
		<v-row justify="center">
			<v-card tile width="800px" height="600px" style="opacity: 0.9;margin-top: 60px;">
				<v-list two-line>
					<template v-for="(item, index) in items" >
						<v-list-item @click="read(index)">
				        <v-list-item-avatar>
							<v-img src="../../public/static/images/lynx.jpg"></v-img>
				        </v-list-item-avatar>
						
				        <v-list-item-content>
							<v-list-item-title v-if="item.state==false"><v-sheet class="black--text">{{item.text}}</v-sheet></v-list-item-title>
							<v-list-item-title v-if="item.state==true"><v-sheet class="grey--text">{{item.text}}</v-sheet></v-list-item-title>
							<v-list-item-subtitle v-text="item.date"></v-list-item-subtitle>
				        </v-list-item-content>
				
				        <v-list-item-action>
							<v-btn icon :key="index" :content="item" :index="index" @click="deletes"><v-icon color="grey">mdi-close</v-icon></v-btn>
				        </v-list-item-action>
						
						</v-list-item>
						<v-divider></v-divider>
					</template>
				</v-list>
			</v-card>
		</v-row>
	</v-img>
</template>

<script>
	export default{
		name: 'App',
		data(){
			return{
				items:[
						{text:'sp在魂学研究上评论了你',date:'2020/04/01 08:00',state:false},
						{text:'球球给你发了新留言',date:'2020/04/01 08:00',state:false},
						{text:'鹦鹉在xx帖子上回复了你',date:'2020/04/01 08:00',state:false},
						{text:'蓝羽龙关注了你',date:'2020/04/01 08:00',state:false},
						{text:'小塔为你的发表点赞',date:'2020/04/01 08:00',state:false}
					]
			}
		},
		methods:{
			read:function(index){
				this.items[index].state=true;
			},
			deletes: function(index) {
				//alert(index);
				this.items.splice(index, 1);
				// if(this.items[index++].state==false){
				// 	this.items[index].state=false;
				// }
			}
		}
	}
</script>

<style>
</style>
