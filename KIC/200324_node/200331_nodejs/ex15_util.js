"use strict";

console.log("\n===========|utility|============");
const util = require('util');
// console.log(utill);

// const dontuseme = util.deprecate( (x, y) => {
//     console.log(x + y);
// }, '2020년 12월까지만 지원됨');

// dontuseme(2, 3);


console.log("\n===========|utility : format 문자열|============");

const str1 = util.format('%d + %d = %d', 1, 2, 1+2);
console.log(str1);

console.log("\n===========|utility : Class|============");

//상속구조
//클래스 - 함수를 통해서 생성

//함수명이 대문자면 클래스 선언
function Parent() {
    
}

Parent.prototype.sayHello = function () {
    console.log(this, ": Hello!");
}

const parent = new Parent();
console.log(typeof parent);
parent.sayHello();

function Child() {
    
}

util.inherits(Child, Parent);

const child = new Child();
child.sayHello();