"use strict";

const fs = require('fs');

console.log("\n===========|file8IO|============");

fs.readFile('./200401_nodejs/ex18_file2.js', (err, data) => {
    if(!err) {
        console.log('success');
        console.log(data.toString());
    } else {
        console.log('fail');
    }
})

console.log("\n===========|file8IO|============");

// const msg = '글자 입력\n글자 입력\n글자 입력\n글자 입력\n글자 입력\n';
const msg = `
글자 입력
글자 입력
글자 입력
글자 입력
글자 입력
`;

fs.writeFile('./test.txt', msg, (err) => {
    if(!err) {
        console.log('success');
    }    
});