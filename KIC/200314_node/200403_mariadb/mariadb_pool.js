"use strict";

const mariadb = require('mariadb');

const pool = mariadb.createPool({
    host : 'localhost',
    user: 'root',
    password: '123456',
    database : 'mysql',
    connectionLimit : 5,
});

pool.getConnection()
    .then(conn => {
        console.log('connected ', conn.threadId);
        //객체화 + 메타도 같이 출력
        // conn.query("select host, user from mysql.user")
        conn.query("select host, user from user")
            .then(rows => {
                console.log('rows :');
                console.log(rows);
            })
            .then(res => {
                console.log('res :', res);
                conn.release();
            })
            .catch(err => {                
                conn.release();
            })
    })
    .catch(err => {
        console.log('err :', err);
    })