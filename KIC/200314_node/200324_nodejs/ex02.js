"use strict"//문법 검사를 하겠다(주석 처리하면 문법 개판이어도 에러없이 실행)

console.log('값 : ' + '내용');
console.log('값 : ', '내용');

console.log('======================================');

// 같은이름 다른변수 취급
// 문제 해결 위해 let / const 사용

var v1 = 100;

function get() {
    var v1 = 300;
    console.log('func : ', v1);
}

get();
console.log('global : ', v1);

console.log('======================================');

// console.log('book :', book); // 호이스트 : 강제로 선언부를 호출전으로 끌어올림 (let x)
let book;
console.log('book :', book);
book = 'test';
console.log('book :', book);

//let book;//재선언 불가

console.log('======================================');

let one = 1, two = 2, three;


console.log('two : ', two);
console.log('three : ', three);

console.log('scope======================================');

let sports = 'soccer';
if(sports) {
    let sports = 'basketball';
    console.log('sports : ', sports);
}
console.log('sports : ', sports);

console.log('const======================================');

const PI = 3.14;

console.log('PI : ' + PI);
// PI = 5.38; //에러
console.log('PI : ' + PI);

console.log('lambda======================================');


function func1() {
    console.log('function 1');
}

let func2 = function() {
    console.log('function 2');
}

let func3 = () => {
    console.log('function 3');
}

func1();
func2();
func3();


console.log('======================================');

let funcB1 = function (num) {
    console.log('funcB1 : ', num);
}

funcB1( 10 );

let funcB2 = (num) => {
    console.log('funcB2 : ', num);
}

funcB2( 10 );

let funcB3 = (num, num2) => {
    console.log('funcB3 : ', num, num2);
}

funcB3( 10, 20 );

let func4 = (num1, num2) => {
    return num1 + num2;
}

console.log('result : ', func4(20, 30));

let func5 = (num1, num2) => num1 + num2; // 리턴 생략

console.log('result2 :', func5(22, 33));

setTimeout( () => console.log('Hello ECMAScript'), 1000)//1초후 실행

console.log('======================================');

let sports2 = () => ( 
    {
        kind1 : "soccer",
        kind2 : "basketball"
    }
);

/**
let sports3 = function(){
    return {
        kind1 : "soccer",
        kind2 : "basketball"
    };
};  
 */
let result1 = sports2();

console.log(result1);

console.log(result1.kind1);
console.log(result1.kind2);
