<template>
	<v-container>
		<v-card height="200px" dark tile>
			<v-img src="../../public/static/images/bg_red.jpg" class="fill-height">
				<v-row style="padding-top: 70px;" justify="center" class="display-2">评测</v-row>
			</v-img>
		</v-card>
		<v-card tile style="display: flex;flex-wrap: wrap;">
			<!--<template v-for="(item, index) in items">-->
			<v-col md="4" v-for="n in 20" :key="n">
				<v-card color='white' class="ma-3" height="205" width="350" raised :to="{ path: '/readreview' }">
					<v-row justify="space-between">
						<v-col cols="7">
							<v-card-title>
							<v-avatar size="30" color="red"></v-avatar>
							<div class="pl-3">Spixii</div>
							</v-card-title>
						<v-sheet class="pl-3" id="v-card--c" height="75">{{text}}</v-sheet>
						</v-col>
						<v-img class="mt-8" height="100px" style="flex-basis: 30px"
						src="../../public/static/images/ori.jpg"></v-img>
					</v-row>
			    <v-divider></v-divider>
			    <v-card-actions class="pl-2">
					<strong>ori and blind forest</strong>
					<v-spacer></v-spacer> 
					<span class="black--text text--lighten-2 caption mr-2">({{ rating }})</span>
					<v-rating readonly v-model="rating" background-color="orange lighten-3"
			        color="yellow accent-4" dense half-increments hover size="22"></v-rating>
			    </v-card-actions>
				</v-card>
			</v-col>
		</v-card>
		<v-btn color="red" fab fixed bottom right dark style="margin-bottom: 70px;"
			:to="{ path: '/writereview' }">
			<v-icon>mdi-fountain-pen</v-icon>
		</v-btn>
	</v-container>
</template>

<script>
	export default{
		data(){
			return{
				rating:5,
				text:'非常精彩的横版式通关动作游戏，画面精美动作流畅关卡设计有挑战性，剧情与世界观的结合非常的好，抱走ori!'
			}
		}
	}
</script>

<style>
</style>
