"use strict";

console.log("===========|Promise|============");

//callback 구조
function getData1(callback){
    let data = 123;
    return callback(data);
}

getData1( function( x ) {
    console.log(x);    
});

let getData2 = function () {
    return new Promise( function (resolve, reject) {
       let data = 321;
       resolve(data);
    });
}

getData2().then(function (resolveData) {
    console.log(resolveData)
})

function cmd(){
    console.log('cmd 실행');
}

//setTimeout(cmd, 1000);


// addTenValue1(10, function (x) {
//     console.log(x);
// })




function addTenValue1(x, callback) {
    setTimeout(function () {
        return callback( x + 10);
    }, 1000);
}

//1초마다 10식 더하라
//콜백지옥
// addTenValue1(10, (x1) => {
//     // console.log(x1);
//     addTenValue1(x1, (x2) =>{
//         // console.log(x2);
//         addTenValue1(x2, (x3) =>{
//             console.log(x3);
//         });
//     });
// });

function addTenValue2(x) {
    return ( new Promise(function (resolve, reject) {
        setTimeout(() => {
            if(typeof x != "number"){
                reject('유효한 타입이 아님');
            } else {
                resolve(x + 10);
            }

        }, 1000);        
    }))
}

// addTenValue2(10).then((resolveData) => {console.log(resolveData)});

//https://smilerici.tistory.com/43?category=714049

/*
console.log('start');
addTenValue2(10).then(function (resolveData) {   
    console.log(resolveData);
    return addTenValue2(resolveData);
}).then(function (resolveData) {   
    console.log(resolveData);
    return addTenValue2(resolveData);
}).then(function (resolveData) {    
    console.log(resolveData);
});
console.log('end');
*/
// addTenValue2(10).then(function (resolveData) {   
//     console.log(resolveData);
//     return addTenValue2('d');
// }).then(function (resolveData) {   
//     console.log(resolveData);
//     return addTenValue2(10);
// }).catch(function (msg) {    
//     console.log('error', msg);
// }).finally(function () {   
//     console.log('항상 처리');
// });

// const promise1 = new Promise(function(resolve, reject) {
//     setTimeout(resolve, 3000, 'call resolve');
// });
// const promise2 = new Promise(function(resolve, reject) {
//     setTimeout(reject, 2000, 'call reject');
// });
// Promise.race([promise1, promise2]).then(function(value) {
//     console.log('resolve :', value); // "b"
// }).catch(function (value) {
//     console.log('reject :', value);  // "b"
// });

// const promise1 = new Promise(function(resolve, reject) {
//     setTimeout(resolve, 2000, 'a');
// });
// const promise2 = new Promise(function(resolve, reject) {
//     setTimeout(resolve, 1000, 'b');
// });

// Promise.all([promise1, promise2]).then(function(value) {
//     console.log(value);    // ['a','b']
// });

const promise1 = new Promise(function(resolve, reject) {
    setTimeout(resolve, 200, 'a');
});
const promise2 = new Promise(function(resolve, reject) {
    setTimeout(resolve, 100, 'b');
});
Promise.all([promise1, promise2]).then(function(value) {
    console.log("resolve", value);
}).catch(function (value) {
    console.log("reject", value);  // "b"
});
