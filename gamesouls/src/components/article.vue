<template>
	<v-container>
		<v-card height="200px" dark tile>
			<v-img src="../../public/static/images/bg_green.jpg" class="fill-height">
				<v-row style="padding-top: 70px;" justify="center" class="display-2">文章</v-row>
			</v-img>
		</v-card>
		<v-card tile style="display: flex;flex-wrap: wrap;" class="pr-5">
			<!--<template v-for="(item, index) in items">-->
			<v-col md="3" v-for="n in 20" :key="n">
			<v-card color='white' class="ma-3" height="350" width="300" raised :to="{ path: '/readarticle' }">
				<v-list-item>
				    <v-list-item-avatar color="green"></v-list-item-avatar>
						<v-list-item-content>
							<v-list-item-title class="headline">魂学研究</v-list-item-title>
							<v-list-item-subtitle>by LynxHawk</v-list-item-subtitle>
				        </v-list-item-content>
				</v-list-item>
				<v-img height="180px" src="../../public/static/images/dk3.jpg"></v-img>
				<v-card-title class="subtitle-1">来讲讲魂的世界观</v-card-title>
				<v-card-subtitle> 
				<v-row justify="end">
				<v-sheet>2019/09/19</v-sheet>
				<v-icon small class="pl-12 pr-2">mdi-heart</v-icon>25
				<v-icon small class="pl-4 pr-2">mdi-comment-multiple</v-icon>
				<v-sheet class="pr-2">33</v-sheet></v-row>
				</v-card-subtitle>
			</v-card>
			</v-col>
		</v-card>
		<v-btn color="green" fab fixed bottom right dark style="margin-bottom: 70px;"
			:to="{ path: '/writearticle' }">
			<v-icon>mdi-fountain-pen</v-icon>
		</v-btn>
	</v-container>
</template>

<script>
</script>

<style>
</style>
