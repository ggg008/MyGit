"use strict";

const readline = require('readline');

console.log("\n===========|keyboard|============");

//표준입력 :키보드
//표준출력 :모니터
const rl = readline.createInterface({
    input : process.stdin,
    output : process.stdout,
});
//
rl.setPrompt('> ');
rl.prompt();

//process.exit();에 등록
process.on('exit', () => {
    console.log('system exit');
})

//키보드 이벤트 / jQuery
rl.on('line', line => {
    console.log('Hello !', line);
    rl.close();
}).on('close', () => {
    process.exit();
});