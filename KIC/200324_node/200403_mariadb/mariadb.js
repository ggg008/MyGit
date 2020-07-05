"use strict";

const mariadb = require('mariadb');

mariadb.createConnection({
    host : 'localhost',
    user: 'root',
    password: '123456'
})
.then( conn => {
    console.log('connected ', conn.threadId);
    conn.close();
})
.catch( err => {
    console.log('err ', err);
})