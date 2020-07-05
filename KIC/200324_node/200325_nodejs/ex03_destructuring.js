"use strict"


console.log("\n===========lambda============");

/*
var calculateVolume = function(a, b, c) {
    var volume = a * b * c;
    return volume;
    }
    var result = calculateVolume(1 ,2,3);
    console.log(result); // 6  
    */

let calculateVolume = (a, b, c) => {
    let volume = a * b * c;
    return volume;
}
let result = calculateVolume(1, 2, 3);
console.log(result); //6


console.log("\n===========class============");

class Animal {
    constructor(name) {
        //동적 생성
        this.name = name;
        this.type = 'animal';
    }

    getName() {
        return this.name;
    }

}

let animal = new Animal("lion");
console.log(animal.getName()); // lion
console.log(typeof Animal);

class Lion extends Animal {
    constructor(name) {
        super(name);
        this.type = "lion";
    }
}
let lion = new Lion("king");
console.log(lion instanceof Animal); //true
console.log(lion.getName()); //king


//클래스 메서드
// class Animal {
//     static getName() {
//         return "Animal";
//     }
// }

// console.log(Animal.getName()); // Animal 

console.log("\n============================");

let type = 'Type';
let type2 = 'Type';

class Sports1 {
    //
    static ['get' + type](kind) {//문자열로 함수이름 생성
        return kind ? 'sport' : 'music';
    }
}

console.log(Sports1['getType'](1));


console.log("\n===========template 문자열============");

console.log('1 : ', '123ABC가나다');
//template 문자열
console.log('1 : ', `123ABC
가나다`);//기호가 다름 `'

let one = 1, two = 2;
console.log('1 + 2 = ${one + two}');
// String.format == EL
console.log(`1 + 2 = ${one + two}`);

let a = 1;
let b = 2;
let strArray = `${a} 더하기 ${b}는 ${a+b} 이다` ;
console.log(strArray); // 1 더하기 2는 3 이다


console.log("\n===========destructuring : 구조 분해============");


let oneB, twoB, threeB;
const value = [1, 2, 3];

// oneB = value[0];
// twoB = value[1];
// threeB = value[2];
// ==

//[oneB, twoB, threeB] = value;

[oneB, twoB] = value; // array desturcturing

console.log('1| oneB: ', oneB, ' | twoB : ', twoB, ' | threeB :', threeB);

let fourB;

[oneB, twoB, threeB, fourB] = value;

console.log('2| oneB: ', oneB, ' | twoB : ', twoB, ' | threeB :', threeB, ' | fourB :', fourB);

if(fourB == undefined){
    console.log('fourB is undi!');
}

[oneB, twoB, threeB, fourB] = [1, 2, [73, 74] ];
console.log('3| oneB: ', oneB, ' | twoB : ', twoB, ' | threeB :', threeB, ' | fourB :', fourB);

[oneB, twoB, [threeB, fourB]] = [1, 2, [73, 74] ];
console.log('4| oneB: ', oneB, ' | twoB : ', twoB, ' | threeB :', threeB, ' | fourB :', fourB);


[oneB, , , fourB] = [91, 92, 93, 94 ];
console.log('4| oneB: ', oneB, ' | twoB : ', twoB, ' | threeB :', threeB, ' | fourB :', fourB);



let { oneC, twoC } = { oneC :1, nine : 2}// obj 필드명 맞추서... // json desturcturing

console.log(oneC, twoC);

function total({ one, two }) {
    console.log( one, two);
}

total( { one :1, two : 2} ); //객체 인자 // 프로퍼티 값은 같아야...

const obj = {
    name: "Nick",
    age: "31",
    job: "Software Engineer"
}
let { name, age, job } = obj;
console.log(name, age, job); //"Nick" , "31", "Software Engineer"

console.log("초기값 지정도 가능");
let [ oneD = 10, twoD = 20, threeD = 30 ] = [ 1, 2 ];
console.log(oneD, twoD, threeD);
