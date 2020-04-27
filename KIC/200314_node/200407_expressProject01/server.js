"use strict";

const express = require('express');

const app = express();
// router설정
const router = require('./router/main')(app);

// ejs 템플리트 설정
app.set('views', __dirname + '/views');
app.set('view engine', 'ejs');
app.engine('html', require('ejs').renderFile);

app.use(express.static('public'));

//무한루프 : ctrl+c
app.listen( 3000, () => {
    console.log('wait server 3000 port');
});