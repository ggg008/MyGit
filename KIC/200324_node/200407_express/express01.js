"use strict";

const express = require('express');

const app = express();

//무한루프 : ctrl+c
app.listen( 3000, () => {
    console.log('wait server 3000 port');
});

// middle ware ( in router )
//controller -> router
// app.get / app.post / app.user(둘다)

// http://localhost:3000/
app.get('/', (req, res) => {
    res.send('Hello Express');
    // res.end('Hello Express');
});

// http://localhost:3000/user
app.get('/user', (req, res) => {
    res.send('user get');    
});

// http://localhost:3000/html
app.get('/html', (req, res) => {
    const html = `<!doctype html>
    <html>
    <head>
    <meta charset="utf-8"/>
    </head>
    <body>
    <b>Hello Express</b>
    </body>
    </html>
    `;

    res.send(html);    
});

app.get('/file', (req, res) => {
 
    res.sendFile(__dirname + '/testIndex.html');    
});
