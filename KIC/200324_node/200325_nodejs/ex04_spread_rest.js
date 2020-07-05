"use strict";

console.log("===========|spread 연산자|============");

let spreadObj1 = ['music'];
console.log(spreadObj1);
console.log(spreadObj1.length);

let spreadObj2 = [...'music'];
console.log(spreadObj2);
console.log(spreadObj2.length);
console.log(spreadObj2[0]);
console.log(spreadObj2[1]);

let oneA = [11, 12];
let spreadObj3 = [...oneA];//분해후 재할당
console.log(spreadObj3);
console.log(spreadObj3.length);

const data1 = [1, 2];
const data2 = [3, 4];

const result = [0, ...data1, ...data2, 5];
console.log(result); // [0,1,2,3,4,5]
console.log(result.length); // 6


let get = (param, param2, param3) => {
    console.log(`oneB :${param}, twoB : ${param2}, threeB : ${param3}`);
}

const values = [10, 20, 30];

get(...values);

console.log("===========|rest 연산자|============");

function test(a, b, ...arr) {
    console.log(arr);
}
test(1, 2, 3, 4, 5); // [3 ,4 ,5] 출력

let [rest1, rest2, rest3 ] = [1, 2, 3, 4];
console.log(rest1, rest2, rest3);

let [rest4, rest5, ...rest6 ] = [1, 2, 3, 4];
console.log(rest4, rest5, rest6);//연결
