"use strict";

const fs = require('fs');


console.log("\n===========|file3Mk|============");

console.log('start');
//로컬디렉토리에 생성
//비동기 방식
//system -> 함수(콜백함수)를 호출 (이벤트 느낌)
fs.mkdir('./dir1', (err) => {
    if(!err) {
        console.log('success');
    } else {
        console.error('fail');
    }
});
console.log('end');

console.log("\n===========|file4|============");

//동기 방식
console.log('start2');
try {
    fs.mkdirSync('./dir2');    
    console.log('success2');
} catch (error) {
    console.log('fail2');
}
console.log('end2');