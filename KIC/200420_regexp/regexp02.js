"use strict";
console.log('--------------meta string------------');

//-를 중심 앞에 6자리, 뒤에 7자리 문자가 나오는 형태
const str1 = '123456-1234567a';

const pattern1 = /......-......./; 
const pattern2 = /^......-...../; 
const pattern3 = /^[0-9][0-9][0-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9][0-9][0-9][0-9]/; 
const pattern4 = /^\d\d\d\d\d\d-\d\d\d\d\d\d\d\d/; 
const pattern5 = /^\d{6}-[1234]\d{6}/; 
console.log( pattern1.test(str1) ); //패턴 채워지면 true
console.log( pattern2.test(str1) ); //맨앞문자 그냥 집어넣기 (+개소리)
console.log( pattern3.test(str1) ); //범위안의 숫자일경우 true
console.log( pattern4.test(str1) ); //숫자일경우 true
console.log( pattern5.test(str1) ); 

