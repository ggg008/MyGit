"use strict";
console.log('--------------reg exp 4------------');
const str1 = '111';
const str2 = 'abc';
const str3 = 'ABC';

const pattern = /([0-9]|[a-z])/g;

console.log(pattern.test(str1));
console.log(pattern.test(str2));
console.log(pattern.test(str3));



