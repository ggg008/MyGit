"use strict";

const mariadb = require('mariadb');

mariadb.createConnection({
    host : 'localhost',
    user : 'root',
    password : '123456', 
    database : 'project'   
})
.then( conn => {
    // console.log('success');
    // conn.query('INSERT INTO testtbl VALUES (?)', ['bbb'])
    // conn.query('SELECT * FROM testtbl')
    conn.query('SELECT * FROM zipcode LIMIT 0, 100')
    .then( rows => {
        // console.log('res :', rows );
        // console.log('res :', rows.length );
        rows.forEach(rows => {
            console.log(rows);
            // console.log(rows.name);//컬럼명
        });


        conn.close();
    })    
    .catch( err => {
        console.log('err ', err );
        conn.close();
    })

    

})
.catch( err => {
    console.log(err);
});