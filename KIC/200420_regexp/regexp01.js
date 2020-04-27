"use strict";
console.log('--------------reg exp------------');

const str1 = 'abc';
const str2 = 'bcd';

//str1과 str2 중 abc로 시작하는 문자열을 찾고 싶다면?

// 1. 문자열 클래스의 메서드를 이용
// 2. 정규표현식을 이용 - 특수 기호의 사용법
// ^ / $

const pattern1 = /^abc/;//abc로 시작...
console.log(pattern1.test(str1)); // true
console.log(pattern1.test(str2)); // false

//객체화
const pattern2 = new RegExp('^abc');
console.log(pattern2.test(str1)); // true
console.log(pattern2.test(str2)); // false

//문자열 검사 용이
console.log('--------------여러줄 검사------------');

const str3 = 'bcd\nabc\ncde';
const pattern3 = /^abc/;
const pattern4 = /^abc/m; //여러줄 검사 p16
console.log(str3); 
console.log(pattern3.test(str3)); 
console.log(pattern4.test(str3)); 

