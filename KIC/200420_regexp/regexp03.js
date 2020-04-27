"use strict";
console.log('--------------reg exp 3------------');
const str1 = 'ban';
const str2 = 'banana';

const pattern = /(na)+/;

console.log(pattern.test(str1)); // false
console.log(pattern.test(str2)); // true



