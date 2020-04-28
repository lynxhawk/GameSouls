<template>
	<v-row justify="center" width="800px" align="center">
		<v-card style="width: 800px;" class="px-6" tile>
			<v-row class="pt-4">
			<v-text-field prepend-icon="mdi-format-title" color="orange" clearable label="帖子标题"></v-text-field>
			<v-btn color="orange" text tile height="50" width="70" class="ml-2">
				<strong>提交</strong></v-btn>
			</v-row>
			<v-row>
				<v-textarea color="orange" class="pt-2" label="帖子内容" :value="value" clearable></v-textarea>
			</v-row>
			<v-row>
				<v-file-input color="orange" v-model="files" placeholder="上传图片" prepend-icon="mdi-image"
				accept="image/png, image/jpeg, image/bmp" show-size multiple></v-file-input>
			</v-row>
		</v-card>
	</v-row>
</template>

<script>
	export default{
		data(){
			return{
				files:[]
			}
		}
	}			
</script>

<style>
</style>
