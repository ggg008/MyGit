"use strict";

const fs = require('fs');

console.log("\n===========|file2|============");

// const stats = fs.statSync('../node');
// const stats = fs.statSync('./200401_nodejs');
const stats = fs.statSync('./200401_nodejs/ex18_file2.js');

console.log(stats);
console.log(stats.birthtime);
console.log(stats['birthtime']);

console.log(stats.size);

// 많이씀
console.log(stats.isFile());
console.log(stats.isDirectory());

// console.log(stats.);
