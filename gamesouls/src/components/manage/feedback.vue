<template>
	<v-img width="1920px" :aspect-ratio="16/9" src="../../../public/static/images/dk3.jpg">
	<v-container>
		<v-data-table :headers="headers" :items="feedbacks" sort-by="read" class="elevation-1" style="height: 500px;">
		    <template v-slot:top>
			    <v-toolbar flat color="white">
			        <v-toolbar-title>反馈管理</v-toolbar-title>
			        <v-spacer></v-spacer>
			        <v-dialog v-model="dialog" max-width="500px">
						<v-card>
			            <v-card-title>
							<span class="title">反馈详情</span>
			            </v-card-title>
						<v-divider></v-divider>
			            <v-card-text>
			                {{feedback.text}}
			            </v-card-text>
			            <v-card-actions>
							<v-spacer></v-spacer>
							<v-btn color="blue darken-1" text @click="close">关闭</v-btn>
			            </v-card-actions>
						</v-card>
			        </v-dialog>
			    </v-toolbar>
			</template>
			<template v-slot:item.actions="{ item }">
			    <v-icon small class="mr-2" @click="openItem(item)">mdi-pencil</v-icon>
			</template>
		</v-data-table>
		<v-snackbar top color="success" v-model="snackbar1" class="mt-12">修改成功
			<v-btn dark text @click="snackbar1 = false">关闭</v-btn></v-snackbar>
		<v-snackbar top color="error" v-model="snackbar2" class="mt-12">修改失败
			<v-btn dark text @click="snackbar2 = false">关闭</v-btn></v-snackbar>
	</v-container>
	</v-img>
</template>

<script>
</script>

<style>
</style>
