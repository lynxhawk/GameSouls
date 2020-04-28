<template>
	<v-container>
		<v-card height="200px" dark tile>
			<v-img src="../../public/static/images/bg_yellow.jpg" class="fill-height">
				<v-row style="padding-top: 70px;" justify="center" class="display-2">攻略</v-row>
			</v-img>
		</v-card>
		<v-card tile style="display: flex;flex-wrap: wrap;" class="px-12">
			<!--<template v-for="(item, index) in items">-->
			<v-col md="4" v-for="n in 20" :key="n">
				<v-card color='white' class="ma-3" height="290" width="300" raised :to="{ path: '/readwalk' }">
					
					<v-img height="200px" src="../../public/static/images/acs.jpg"></v-img>
					<v-list-item>
					    <v-list-item-avatar color="yellow"></v-list-item-avatar>
							<v-list-item-content>
								<v-list-item-title class="headline">刺客信条枭雄</v-list-item-title>
								<v-list-item-subtitle>
								<v-row justify="space-between">
								<v-sheet class="pl-4">by 球球</v-sheet></v-row>
								<v-row justify="end"><v-icon small class="pr-3">mdi-heart</v-icon>
								<v-sheet class="pr-3">25</v-sheet>
								<v-icon small class="pr-3">mdi-comment-multiple</v-icon>
								<v-sheet class="pr-3">33</v-sheet></v-row>
								</v-list-item-subtitle>
							</v-list-item-content>						
					</v-list-item>
				
				</v-card>
			</v-col>
		</v-card>
		<v-btn color="yellow" dark fab fixed bottom right dark style="margin-bottom: 70px;"
			:to="{ path: '/writewalk' }">
			<v-icon>mdi-fountain-pen</v-icon>
		</v-btn>
	</v-container>
</template>

<script>
</script>

<style>
</style>
