"use strict";

const express = require('express');

const app = express();

//미들웨어 : 설정
app.use( express.urlencoded({ extended : true}) );

//무한루프 : ctrl+c
app.listen( 3000, () => {
    console.log('wait server 3000 port');
});

// middle ware ( in router )
//controller -> router
// app.get / app.post / app.user(둘다)

// http://localhost:3000/
app.get('/', (req, res) => {

    // console.log(req.headers );
    console.log(req.ip );//::ffff:127.0.0.1

    res.send('Hello Express');    
});

app.get('/form', (req, res) => {
    res.sendFile(__dirname + '/form.html');    
});


app.get('/form_ok', (req, res) => {
    console.log(req.query);
    console.log(req.query.data);

    res.send('GET 방식 응답 완료');
});

app.post('/form_ok', (req, res) => {

    console.log(req.body);//사용하려면 옵션 필요 //app.use
    

    res.send('POST 방식 응답 완료');
});