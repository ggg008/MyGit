"use strict";

// setTimeout(function () {
//     console.log('1.5초 후에 실행');
// }, 1500);


// const timeout = setTimeout( () => {
//     console.log('3초 후에 실행');
// }, 3000);

//설정된 객체 정보
// console.log(timeout);

//무한루프
const interval = setInterval( ()=> {
    console.log('2초 땡');
}, 2000 );

setTimeout( () => {
    clearInterval(interval);
    console.log('끝');
}, 10000)