//node 파일명 동이름

//검색 결과 출력

"use strict";

const fs = require('fs');


fs.readFile('./zipcode_seoul_utf8_type2.csv', (err, data) => {
    if(!err) {
        console.log('success');
        // console.log(data.toString());
        const list = data.toString().split('\n');
        list.forEach( (val, idx) => {
            if(val.split(',')[3].indexOf(process.argv[2]) != -1) {
                console.log(val);
            }
        });
        
    } else {
        console.log('fail');
    }
})

console.log('input :', process.argv[2]);