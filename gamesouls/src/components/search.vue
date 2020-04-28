<template>
	<v-container>
		<v-card height="200px" dark tile>
			<v-img src="../../public/static/images/bg_purple.jpg" class="fill-height">
				<v-row style="margin-top: 75px;" justify="center" class="display-2">搜索</v-row>
			</v-img>
		</v-card>
		<v-card tile>
		<v-row class="px-3">
		<v-combobox v-model="chips" :items="items" chips clearable label="搜索内容"
		    multiple solo item-color="purple" prepend-inner-icon="mdi-magnify">
		    <template v-slot:selection="{ attrs, item, select, selected }">
				<v-chip v-bind="attrs" :input-value="selected" close label ripple
				@click="select" @click:close="remove(item)">
		        <strong>{{ item }}</strong>
				</v-chip>
		    </template>
		</v-combobox>
		<v-btn text tile height="50px" color="purple">搜索</v-btn>
		</v-row>
		
		<v-row class="subtitle-1 pl-6 pb-4">搜索历史</v-row>
		<v-chip v-for="history in historys" :key="history" label class="mx-4 mb-4" outlined color="purple" ripple
			@click="addhistory(history)">
			{{history}}
		</v-chip>
		
		</v-card>
		
		<v-card tile>
		<v-sheet class="title pa-4">搜索结果</v-sheet>
		<v-divider></v-divider>
		<!--<v-list three-line>
		    <v-list-item v-for="(item, i) in searching" :key="i" ripple @click="() => {}">
		        <v-img :src="item.image" class="mr-4" max-width="64" min-width="64"></v-img>
				
		        <v-list-item-content>
		          <span class="text-uppercase font-weight-regular caption" v-text="item.category"
		          ></span>
		          <div v-text="item.title"></div>
		        </v-list-item-content>
		    </v-list-item>
		</v-list>-->
		</v-card>
	</v-container>
</template>

<script>
	export default {
	    data () {
	      return {
			checkbox1:false,checkbox2:false,checkbox3:false,checkbox4:false,checkbox5:false,
			search: [],chips:[],
	        items: ['资讯', '文章','评测','攻略','论坛'],
			attrs:[],
			historys:['黑暗之魂','刺客信条'],
	      }
	    },
	    methods: {
			remove (item) {
				this.chips.splice(this.chips.indexOf(item), 1)
				this.chips = [...this.chips]
			},
			addhistory(history){
				this.chips.splice(0,0,history)
				this.chips = [...this.chips]
			}
	    },
	  }
</script>

<style>
</style>
