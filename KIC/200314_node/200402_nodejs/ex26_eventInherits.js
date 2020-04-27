"use strict";

const util = require('util');
const EventEmitter = require('events');

console.log("\n===========|events inherits|============");

const Person = function(){};

util.inherits(Person, EventEmitter);

const person = new Person();
person.on( 'howAreYou', () => {
    console.log('Fine, Thank you and you?');
})

person.emit('howAreYou');

console.log("\n===========|events inherits2|============");

class Person2 extends EventEmitter {}

const person2 = new Person2();
person2.on( 'howAreYou2', () => {
    console.log('Fine, Thank you and you?');
})

person2.emit('howAreYou2');
