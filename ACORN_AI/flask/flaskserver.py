from flask import Flask, request, render_template, redirect
import os
from flask import session

app = Flask(__name__)
app.secret_key="abc12340909"

@app.route("/")
def index():
	return render_template("index.html") # jinja 서버측 스크립트 이름 html5 + css + javascript

@app.route("/tabletest")
def tabletes():
	return render_template("tebletest.html")

@app.route("/carousel")
def carousel():
	return render_template("carousel.html")

@app.route("/form_select")
def form_select():
	return render_template("form_select.html")

# cmd 상에 실행할때
if __name__ == '__main__': # 인터프리터에서 직접 실행할 경우 __main__이 담김 (모듈로 실행시는 원래 파일이름 flaskserver.fy)
	app.run(debug=True) # default 5000번 포트로 서비스 # 즉, 인터프리터로 실행시에만 app run