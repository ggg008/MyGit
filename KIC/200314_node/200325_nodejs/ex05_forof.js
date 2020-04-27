"use strict";

console.log("===========|for of|============");

var arr = [10, 20, 30];//기존
for(let value in arr){    
    //index
    console.log(arr[value]);
}

for(let value of [10, 20, 30]){
    //value
    console.log(value);
}

for(let value of '반갈죽'){
    console.log(value);
}

console.log('--json--');

let imjsonArr = [
    {item : '선물1', amount: 20},
    {item : '선물2', amount: 30},
]

for(let {item: val1, amount: val2} of imjsonArr){
    console.log('case 1', val1, val2);
}

let imjsonArr2 = [
    {item : '선물1', amount: { apple: 20, candy: 20 }},
    {item : '선물2', amount: { apple: 20, candy: 20 }},
]

for(let {item: val1, amount: {apple : val2_1, candy: val2_2 }} of imjsonArr2){
    console.log('case 2', val1, val2_1, val2_2);
}

const animals = {
    lion: "사자",
    tiger: "호랑이"
};
const keys = Object.keys(animals);

for (let key of keys) {
    console.log("of |", key, animals[key]);
}

for (let key in animals) {
    console.log("in |",key, animals[key]);
}

console.log("===========||============");

console.log(Math.pow(3, 3));

console.log(3 ** 3);
