"use strict";

const fs = require('fs');

console.log("\n===========|file7unlink|============");

const file = '.';
//파일삭제
fs.unlink('./test.txt', (err) => {
    if(!err) {
        console.log('success');
    } else {
        console.error('fail');
    }
})