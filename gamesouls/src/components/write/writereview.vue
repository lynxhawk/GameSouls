<template>
	<v-row justify="center" width="800px" class="mt-6">
		<v-card style="width: 800px;" class="px-6" tile>
			<v-row class="pt-4">
			<v-text-field prepend-icon="mdi-microsoft-xbox-controller" color="red" clearable label="游戏名"></v-text-field>
			<v-btn color="red" text tile height="50" width="70" class="ml-2">
				<strong>提交</strong></v-btn>
			</v-row>
			<v-row align="center">
				<v-sheet>评分</v-sheet>
				<v-rating v-model="rating" background-color="orange lighten-3"
				color="yellow accent-4" half-increments hover size="30"></v-rating>
			</v-row>
			<v-row>
				<v-textarea color="red" class="pt-2" label="评论" :value="value" clearable></v-textarea>
			</v-row>
			<v-row>
				<v-file-input color="red" v-model="background" placeholder="评测封面" prepend-icon="mdi-image"
				accept="image/png, image/jpeg, image/bmp" show-size></v-file-input>
			</v-row>
		</v-card>
	</v-row>
</template>

<script>
	export default{
		data(){
			return{
				rating:0,
			}
		}
	}			
</script>

<style>
</style>
