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
  }
}