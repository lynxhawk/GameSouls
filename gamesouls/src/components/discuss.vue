<template>
	<v-container>
		<v-card height="200px" dark tile>
			<v-img src="../../public/static/images/bg_orange.jpg" class="fill-height">
				<v-row style="padding-top: 75px;" justify="center" class="display-2">论坛</v-row>
				</v-img>
		</v-card>
		<v-card tile style="display: flex;flex-wrap: wrap;">
			<template v-for="(item, index) in items">
			<v-col md="4">
			<v-card class="mx-auto" color="white" max-width="400" shaped raised :to="{ path: '/readdiscuss' }">
			    <v-card-title style="overflow: hidden;">
					<v-sheet height="50px" class="title font-weight-bold">{{item.title}}</v-sheet>
			    </v-card-title>
				<v-divider></v-divider>
			    <v-card-text style="overflow: hidden;" class="subtitle-2 font-weight">
				<v-sheet height="95px">{{item.subtitle}}</v-sheet></v-card-text>
				<v-divider></v-divider>
			    <v-card-actions>
					<v-list-item class="grow">
			        <v-list-item-avatar color="grey darken-3">
						<v-img class="elevation-6" src="../../public/static/images/bg_orange.jpg"></v-img>
			        </v-list-item-avatar>
			        <v-list-item-content><v-list-item-title>{{item.name}}</v-list-item-title></v-list-item-content>
			        <v-row align="center" justify="end">
						<span class="subheading mr-4">{{item.time}}</span>
						<v-icon class="mr-2">mdi-comment-text-multiple</v-icon>
						<span class="subheading mr-2">256</span>
			        </v-row>
					</v-list-item>
			    </v-card-actions>
			</v-card>
			</v-col>
			</template>
		</v-card>
		<v-btn color="orange" fab fixed bottom right dark style="margin-bottom: 70px;"
			:to="{ path: '/writediscuss' }">
			<v-icon>mdi-fountain-pen</v-icon>
		</v-btn>
	</v-container>
</template>

<script>
	export default{
		data(){
			return{
				items: [
				        {
						  name: 'mike',
						  title:'"Turns out semicolon-less style is easier and safer in TS because most gotcha edge cases are type invalid as well."',
				          subtitle: "I'll be in your neighborhood doing errands this weekend. Do you want to hang out?I'll be in your neighborhood doing errands this weekend. Do you want to hang out?I'll be in your neighborhood doing errands this weekend. Do you want to hang out?I'll be in your neighborhood doing errands this weekend. Do you want to hang out?",
						  time:'2020-01-22'
				        },
				        {
						  name: 'elf',
						  title:'"Turns out semicolon-less style is easier and safer in TS because most gotcha edge cases are type invalid as well."',
				          subtitle: "Wish I could come, but I'm out of town this weekend.",
						  time:'2020-01-22'
				        },				   
						{
						  name: 'jack',
						  title:'"Turns out semicolon-less style is easier and safer in TS because most gotcha edge cases are type invalid as well."',
				          subtitle: "Do you have Paris recommendations? Have you ever been?",
						  time:'2020-01-22'
				        },				        
				        {
						  name: 'alice',
						  title:'"Turns out semicolon-less style is easier and safer in TS because most gotcha edge cases are type invalid as well."',
				          subtitle: "Have any ideas about what we should get Heidi for her birthday?",
						  time:'2020-01-22'
				        },				       
				        {
						  name:'candy',
						  title:'"Turns out semicolon-less style is easier and safer in TS because most gotcha edge cases are type invalid as well."',
				          subtitle: "We should eat this: Grate, Squash, Corn, and tomatillo Tacos.",
						  time:'2020-01-22'
				        },
						{
						  name: 'jack',
						  title:'"Turns out semicolon-less style is easier and safer in TS because most gotcha edge cases are type invalid as well."',
						  subtitle: "Do you have Paris recommendations? Have you ever been?",
						  time:'2020-01-22'
						}
						]
			}
		}
	}
</script>

<style>
</style>
