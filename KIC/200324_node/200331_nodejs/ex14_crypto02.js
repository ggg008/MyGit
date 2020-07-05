"use strict";


console.log("\n===========|단방향 암호화|============");
const crypto = require('crypto');    
//단방향 암호화 - 복호화해서 비교 불가 암호상태를 비교
console.log( crypto.createHash('sha512').update('123456').digest('base64') );
console.log( crypto.createHash('sha512').update('123456').digest('base64') );

//데이터 베이스화 - 레인보우테이블
// -> salt -> pdkdf2 방식


console.log("\n===========|양방향 암호화|============");
const cipher = crypto.createCipher('aes-256-cbc', '1234');// 방식, key

// utf8 : 문자열 인코딩, base64 : 암호화된 문자열 인코딩
let result = cipher.update('가나다', 'utf-8', 'base64');
result += cipher.final('base64');

console.log('result :', result);

const decipher = crypto.createDecipher('aes-256-cbc', '1234');
let result2 = decipher.update(result, 'base64', 'utf8');
result2 += decipher.final('utf8');

console.log('result2 :', result2);

console.log("\n===========|양방향 암호화2|============");

const cipher2 = crypto.getCiphers();
console.log(cipher2);
