<template>
	<v-container>
		<v-card height="200px" dark tile>
			<v-img src="../../public/static/images/bg_cyan.jpg" class="fill-height">
				<v-row style="padding-top: 70px;" justify="center" class="display-2">资讯</v-row>
			</v-img>
		</v-card>
		<v-card tile style="display: flex;flex-wrap: wrap;" class="px-12">
			<!--<template v-for="(item, index) in items">-->
			<v-col md="3" v-for="n in 20" :key="n">
			<v-card color='white' class="ma-3" height="200" width="200" raised 
			:to="{ path: '/readnews' }">
				<v-img height="100px" src="../../public/static/images/life2.jpg"></v-img>
				<v-card-title class="subtitle-1">《奇异人生2》解锁新章节</v-card-title>
				<v-card-subtitle class="pb-0">5小时前</v-card-subtitle>
			</v-card>
			</v-col>
		</v-card>
		<v-btn color="cyan" dark fab fixed bottom right style="margin-bottom: 70px;"
			:to="{ path: '/writenews' }">
			<v-icon>mdi-fountain-pen</v-icon>
		</v-btn>
	</v-container>
</template>

<script>
</script>

<style>
</style>
