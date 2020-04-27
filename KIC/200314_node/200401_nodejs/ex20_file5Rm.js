"use strict";

const fs = require('fs');

console.log("\n===========|file4Rm|============");

//dir1을 삭제하는 함수 rmdir, rmdirSync
//삭제 프로그램 작성
console.log('start');
//로컬디렉토리에 생성
//비동기 방식
//system -> 함수(콜백함수)를 호출 (이벤트 느낌)
fs.rmdir('./dir1', (err) => {
    if(!err) {
        console.log('successRM');
    } else {
        console.error('failRM');
    }
});
console.log('end');

console.log("\n===========|file4|============");

//동기 방식
console.log('start2');
try {
    fs.rmdirSync('./dir2');    
    console.log('successRM2');
} catch (error) {
    console.log('failRM2');
}
console.log('end2');