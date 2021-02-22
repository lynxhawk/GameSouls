<template>
	<v-img width="1920px" :aspect-ratio="16/9" :src="background">
	<v-container>
		<v-data-table :search="search" :headers="headers" :items="users" sort-by="name" class="elevation-1 mx-auto mt-12" style="height: 600px; width: 800px;">
		    <template v-slot:top>
			    <v-toolbar color="white" dense>
			        <v-toolbar-title>权限管理</v-toolbar-title>
			        <v-spacer></v-spacer>
					<v-text-field v-model="search" prepend-icon="mdi-magnify" label="搜索"
					    single-line hide-details clearable></v-text-field>
			        <v-dialog v-model="dialog" max-width="500px">
						<v-card>
			            <v-card-title>
							<span class="title">修改权限</span>
			            </v-card-title>
						<v-divider></v-divider>
			            <v-card-text>
			                <v-select :items="powers" label="权限等级" v-model="power"></v-select>
			            </v-card-text>
			            <v-card-actions>
							<v-spacer></v-spacer>
							<v-btn color="blue darken-1" text @click="save">提交</v-btn>
							<v-btn color="blue darken-1" text @click="close">取消</v-btn>
			            </v-card-actions>
						</v-card>
			        </v-dialog>
			    </v-toolbar>
			</template>
			<template v-slot:item.actions="{ item }">
			    <v-icon small class="mr-2" @click="editItem(item)">mdi-pencil</v-icon>
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
	export default {
	    data: () => ({
	      dialog: false,powers:['2','3','4'],snackbar1:false,snackbar2:false,
		  power:'',background:'',search:'',
	      headers: [
	        { text: '用户名', align: 'start', sortable: true, value: 'username'},
	        { text: '用户权限', value: 'power' ,sortable:true},
			{ text: '修改', value: 'actions', sortable: false }
	      ],
	      users: [],
		  editedIndex:-1
	    }),
	    watch: {
	      dialog (val) {
	        val || this.close()
	      },
	    },
	    created () {
			this.$axios.get('api/getpower').then((res)=>{
				  this.users=res.data;
			});
			this.background=localStorage.getItem("background");
	    },
	    methods: {
	      editItem (item) {
	        this.editedIndex = this.users.indexOf(item)
	        this.dialog = true
	      },
	      close () {
	        this.dialog = false
	      },
	      save () {
			if(localStorage.getItem("power")==1)
			{
				this.$axios.get('api/updatepower',{
				    params:{
				        username:this.users[this.editedIndex].username,
						power:this.power
				    }
				}).then((response)=>{
					this.snackbar1=true;
					this.users[this.editedIndex].power=this.power;
			});
			}
			else{
				if(this.power>2){
					this.$axios.get('api/updatepower',{
					    params:{
					        username:this.users[this.editedIndex].username,
							power:this.power
					    }
					}).then((response)=>{
						this.snackbar1=true;
						this.users[this.editedIndex].power=this.power;
					});
				}else{
					this.snackbar2=true;
				}
			}
	        this.close();
	      },
	    },
	  }
</script>

<style>
</style>
