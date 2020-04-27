"use strict";

const EventEmitter = require('events');

console.log("\n===========|events|============");

//class
const myEmitter = new EventEmitter();

//전통적 이벤트 등록
myEmitter.addListener('event1', () => {
    console.log('event 1 emit');
});

//jQuery식 이벤트 등록
myEmitter.on('event2', () => {
    console.log('event 2-1 emit');
});
myEmitter.on('event2', () => {
    console.log('event 2-2 emit');
});

console.log('event count :', myEmitter.listenerCount('event2'));

myEmitter.emit('event1');
myEmitter.emit('event2');

console.log("\n===========|events2|============");

//일회용
myEmitter.once('event3', () => {
    console.log('event 3 emit');
});

myEmitter.emit('event3');
myEmitter.emit('event3');
myEmitter.emit('event3');


