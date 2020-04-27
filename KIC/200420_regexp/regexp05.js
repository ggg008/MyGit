"use strict";
console.log('-----reg exp 5 Prac B-16 hangul check-----');

var isKoreanName = function (string) {
    // 변수를 선언합니다
    var regExp = /([가-횡])/g;
    // 메서드를 사용합니다
    var replacedString = string.replace(regExp, '');
    // 확인합니다
    if (replacedString.length == 0) {
        return true;
    } else {
        return false;
    }
}
console.log(isKoreanName('윤인성'));

console.log('-----reg exp 5 Prac B-17 Email check-----');
var isEmail = function (string) {
    //  변수를 선언합니다
    var regExp = /\w+@\w+\.\w+/;
    //  확인합니다.
    return regExp.test(string);
}
console.log(isEmail('rintiantta@naver.com'));


console.log('-----reg exp 5 Prac B-18 comma-----');

var addComma = function (number) {
    var regExp = /(^[+-]?\d+)(\d{3})/; 
    // 첫글자로+,-가 붙을수도 있고(무시) 
    // 숫자가 적어도 하나 이상인게 그룹1 
    // 그룹1에서 숫자가 3개인게 그룹2
    var string = String(number);
    while (regExp.test(string)) {
        string = string.replace(regExp, '$1,$2');//그룹1 그룹2
        console.log(string);
    }
    return string;
}
console.log(addComma('1000000000'));