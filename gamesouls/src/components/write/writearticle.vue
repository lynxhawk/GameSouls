<template>
	<v-container>
		<v-row justify="center" width="800px" class="mt-6">
			<v-card style="width: 800px;" class="px-6" tile>
				<v-row>
				<v-text-field v-model="title" prepend-icon="mdi-format-title" color="green" clearable label="文章标题"></v-text-field>
				<v-btn color="green" text tile height="50" width="70" class="ml-2" @click="upload">
					<strong>提交</strong></v-btn>
				</v-row>
				<v-row>
				<v-text-field v-model="subtitle" color="green" prepend-icon="mdi-subtitles-outline" clearable label="摘要"></v-text-field>
				</v-row>
				<v-row>
					<v-text-field v-model="cover" color="green" prepend-icon="mdi-image" clearable label="文章封面"></v-text-field>
					<!--<v-file-input color="green" v-model="background" placeholder="文章封面" prepend-icon="mdi-image"
					accept="image/png, image/jpeg, image/bmp" show-size></v-file-input>-->
				</v-row>
			</v-card>
		</v-row>
		<v-row justify="center">
			<v-card max-width="800px" tile flat height="900px">
				<quill-editor class="editor" ref="myTextEditor" v-model="content" :options="editorOption"
				@blur="onEditorBlur($event)" @focus="onEditorFocus($event)" @ready="onEditorReady($event)"
				@change="onEditorChange($event)">
				</quill-editor>
			</v-card>
		</v-row>
		<v-snackbar top color="success" class="mt-12" v-model="snackbar">发布成功
		<v-btn dark text @click="snackbar = false">关闭</v-btn></v-snackbar>
	</v-container>
</template>

<script>
	export default {
	    data () {
	        return {
	            content: null,title:'',subtitle:'',cover:'',snackbar:false,
	            editorOption: {
					modules: {
						toolbar: {
						container: [
						["bold", "italic", "underline", "strike"], // 加粗 斜体 下划线 删除线
						["blockquote", "code-block"], // 引用  代码块
						[{ header: 1 }, { header: 2 }], // 1、2 级标题
						[{ list: "ordered" }, { list: "bullet" }], // 有序、无序列表
						[{ script: "sub" }, { script: "super" }], // 上标/下标
						[{ indent: "-1" }, { indent: "+1" }], // 缩进
						// [{'direction': 'rtl'}],                         // 文本方向
						[{ size: ["small", false, "large", "huge"] }], // 字体大小
						[{ header: [1, 2, 3, 4, 5, 6, false] }], // 标题
						[{ color: [] }, { background: [] }], // 字体颜色、字体背景颜色
						[{ font: [] }], // 字体种类
						[{ align: [] }], // 对齐方式
						["clean"], // 清除文本格式
						["link", "image", "video"]// 链接、图片、视频
						], //工具菜单栏配置
						handlers: {
						    image: imageHandler
						}	
							
						}
					},
					placeholder: '请在这里添加正文内容', //提示
					readyOnly: false, //是否只读
					theme: 'snow', //主题 snow/bubble
					//syntax: true, //语法检测
	            }
			}
	    },
	    methods: {
	          // 失去焦点
			onEditorBlur(editor) {},
	          // 获得焦点
			onEditorFocus(editor) {},
	          // 开始
			onEditorReady(editor) {},
	          // 值发生变化
			onEditorChange(editor) {
				this.content = editor.html;
				//console.log(editor);
			},
			upload(){
				let data={
					userid:localStorage.getItem("id"),
					username:localStorage.getItem("username"),
					avatar:localStorage.getItem("avatar"),
					title:this.title,
					subtitle:this.subtitle,
					text:this.content,
					cover:this.cover
				};
				this.$axios.post('http://localhost:8888/addarticle/',data).then((response)=>{
					this.snackbar=true;
					this.$router.go(-1);
				})
				console.log(this.content);
			}
	    },
	    computed: {
	        editor() {
				return this.$refs.myTextEditor.quillEditor;
	        }
	    },
	    mounted() {
	        console.log('this is my editor',this.editor);
	    },
		created() {
			
		}
		 
	}
	function imageHandler() {
		var range = this.quill.getSelection();
	       var value = prompt('请输入图片的URL');
	            if(value){
	                this.quill.insertEmbed(range.index, 'image', value);
	            }
	}
</script>

<style>
.editor {
	line-height: normal !important;
	height: 800px;
}
.ql-snow .ql-tooltip[data-mode=link]::before {
	content: "请输入链接地址:";
}
.ql-snow .ql-tooltip.ql-editing a.ql-action::after {
	border-right: 0px;
	content: '保存';
	padding-right: 0px;
}
.ql-snow .ql-tooltip[data-mode=video]::before {
	content: "请输入视频地址:";
}
.ql-snow .ql-picker.ql-size .ql-picker-label::before,
.ql-snow .ql-picker.ql-size .ql-picker-item::before {
	content: '14px';
}
.ql-snow .ql-picker.ql-size .ql-picker-label[data-value=small]::before,
.ql-snow .ql-picker.ql-size .ql-picker-item[data-value=small]::before {
	content: '10px';
}
.ql-snow .ql-picker.ql-size .ql-picker-label[data-value=large]::before,
.ql-snow .ql-picker.ql-size .ql-picker-item[data-value=large]::before {
	content: '18px';
}
.ql-snow .ql-picker.ql-size .ql-picker-label[data-value=huge]::before,
.ql-snow .ql-picker.ql-size .ql-picker-item[data-value=huge]::before {
	content: '32px';
}
.ql-snow .ql-picker.ql-header .ql-picker-label::before,
.ql-snow .ql-picker.ql-header .ql-picker-item::before {
	content: '文本';
}
.ql-snow .ql-picker.ql-header .ql-picker-label[data-value="1"]::before,
.ql-snow .ql-picker.ql-header .ql-picker-item[data-value="1"]::before {
	content: '标题1';
}
.ql-snow .ql-picker.ql-header .ql-picker-label[data-value="2"]::before,
.ql-snow .ql-picker.ql-header .ql-picker-item[data-value="2"]::before {
	content: '标题2';
}
.ql-snow .ql-picker.ql-header .ql-picker-label[data-value="3"]::before,
.ql-snow .ql-picker.ql-header .ql-picker-item[data-value="3"]::before {
	content: '标题3';
}
.ql-snow .ql-picker.ql-header .ql-picker-label[data-value="4"]::before,
.ql-snow .ql-picker.ql-header .ql-picker-item[data-value="4"]::before {
	content: '标题4';
}
.ql-snow .ql-picker.ql-header .ql-picker-label[data-value="5"]::before,
.ql-snow .ql-picker.ql-header .ql-picker-item[data-value="5"]::before {
	content: '标题5';
}
.ql-snow .ql-picker.ql-header .ql-picker-label[data-value="6"]::before,
.ql-snow .ql-picker.ql-header .ql-picker-item[data-value="6"]::before {
	content: '标题6';
}
.ql-snow .ql-picker.ql-font .ql-picker-label::before,
.ql-snow .ql-picker.ql-font .ql-picker-item::before {
	content: '标准字体';
}
.ql-snow .ql-picker.ql-font .ql-picker-label[data-value=serif]::before,
.ql-snow .ql-picker.ql-font .ql-picker-item[data-value=serif]::before {
	content: '衬线字体';
}
.ql-snow .ql-picker.ql-font .ql-picker-label[data-value=monospace]::before,
.ql-snow .ql-picker.ql-font .ql-picker-item[data-value=monospace]::before {
	content: '等宽字体';
}
</style>
