module.exports = {
  "transpileDependencies": [
    "vuetify"
  ],
  lintOnSave: false,
  devServer:{
		hot: true,
			proxy:{
				"/api": {
					target: "http://localhost:8888",
					pathRewrite: {"^/api" : ""},
					secure: false,
					ws: true,
					changOrigin: true
			    }
			}
  },
  pwa:{
    iconPaths:{
		favicon32:'./public/favicon.ico',
		favicon16:'./public/favicon.ico',
		appleTouchTcom:'./public/favicon.ico',
        maskIcon:'./public/favicon.ico',
        msTileImage:'./public/favicon.ico'
    }
	}
}