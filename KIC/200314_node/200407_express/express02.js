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

http://localhost:3000/
app.get('/', (req, res) => {
    // res.status(403).end();
    // res.status(400).send('bad request');
    // 위와 같음
    res.sendStatus(400);
});


