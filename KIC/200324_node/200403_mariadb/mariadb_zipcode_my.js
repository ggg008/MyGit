"use strict";

const mariadb = require('mariadb');
const readline = require('readline');
const rl = readline.createInterface({
    input : process.stdin,
    output : process.stdout,
});



rl.setPrompt('input search dong > ');
rl.prompt();

mariadb.createConnection({
    host: 'localhost',
    user: 'root',
    password: '123456',
    database: 'project'
})
.then(conn => {
    // console.log('success');
    rl.on('line', line => {
        let serchDong = line;        
        serchDong += '%';

        // console.log(serchDong);

        conn.query('SELECT * FROM zipcode WHERE dong like ?', [serchDong])
        .then(rows => {
            // console.log('res :', rows );
            // console.log('res :', rows.length );
            rows.forEach(rows => {
                console.log(rows);
                // console.log(rows.name);//컬럼명
            });
            
            conn.close();
            rl.close();
        })
        .catch(err => {
            console.log('err ', err);
            conn.close();
            rl.close();
        })
    })
    .on('close', () => {
        console.log('proc exit!')
        process.exit();
    });

})
.catch( err => {
    console.log(err);
});
