import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/components/Index'

import myspace from '@/components/myspace'
import message from '@/components/message'
import publish from '@/components/publish'
import follow from '@/components/follow'
import collection from '@/components/collection'
import comment from '@/components/comment'
import feedback from '@/components/feedback'
import setting from '@/components/setting'

import article from '@/components/article'
import discuss from '@/components/discuss'
import news from '@/components/news'
import post from '@/components/post'
import review from '@/components/review'
import search from '@/components/search'
import walkthrough from '@/components/walkthrough'

import readnews from '@/components/read/readnews'
import readarticle from '@/components/read/readarticle'
import readreview from '@/components/read/readreview'
import readwalk from '@/components/read/readwalk'
import readdiscuss from '@/components/read/readdiscuss'

import writenews from '@/components/write/writenews'
import writearticle from '@/components/write/writearticle'
import writereview from '@/components/write/writereview'
import writewalk from '@/components/write/writewalk'
import writediscuss from '@/components/write/writediscuss'

import managecheck from '@/components/manage/check.vue'
import managefeedback from '@/components/manage/feedback.vue'
import managereport from '@/components/manage/report.vue'
import managepower from '@/components/manage/userpower.vue'

import Vuetify from 'vuetify'
import 'vuetify/dist/vuetify.min.css' // Ensure you are using css-loader
import '@mdi/font/css/materialdesignicons.css'
import 'material-design-icons-iconfont/dist/material-design-icons.css'
import VueQuillEditor from 'vue-quill-editor'
import 'quill/dist/quill.core.css' // import styles
import 'quill/dist/quill.snow.css' // for snow theme
import 'quill/dist/quill.bubble.css' // for bubble theme
import axios from 'axios'
import VueAxios from 'vue-axios'

Vue.prototype.$axios = axios
Vue.use(Vuetify, {
  iconfont: 'mdi'
})
Vue.use(Router)
Vue.use(VueQuillEditor);

export default new Router({
	mode:'history',
	base:__dirname,
  routes: [
    {	path: '/',component: Index	},
	{	path:'/myspace',component:myspace	},
	{	path:'/message',component:message	},
	{	path:'/publish',component:publish	},
	{	path:'/follow',component:follow		},
	{	path:'/collection',component:collection	},
	{	path:'/comment',component:comment	},
	{	path:'/feedback',component:feedback		},
	{	path:'/setting',component:setting	},
	
	{	path:'/article',component:article	},
	{	path:'/discuss',component:discuss	},
	{	path:'/news',component:news		},
	{	path:'/post',component:post		},
	{	path:'/review',component:review		},
	{	path:'/search',component:search		},
	{	path:'/walkthrough',component:walkthrough	},
	
	{	path:'/readnews',component:readnews		},
	{	path:'/readarticle',component:readarticle	},
	{	path:'/readreview',component:readreview		},
	{	path:'/readwalk',component:readwalk		},
	{	path:'/readdiscuss',component:readdiscuss	},
	
	{	path:'/writenews',component:writenews	},
	{	path:'/writearticle',component:writearticle		},
	{	path:'/writereview',component:writereview	},
	{	path:'/writewalk',component:writewalk	},
	{	path:'/writediscuss',component:writediscuss	},
	
	{	path:'/managecheck',component:managecheck	},
	{	path:'/managefeedback',component:managefeedback	},
	{	path:'/managereport',component:managereport	},
	{	path:'/managepower',component:managepower	}
	
  ]
})
