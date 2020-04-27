"use strict";

const path = require('path');

console.log("\n===========|path|============");

console.log(__filename); //현재 파일명
console.log(__dirname); // ''

const imgname = __dirname + "/image.png";
console.log(imgname);

console.log('path.sep ', path.sep); //seperater 구분자
console.log('path.delimiter ', path.delimiter);//드라이버

console.log(path.dirname(__filename));
console.log(path.extname(__filename));
console.log(path.basename(__filename));


console.log("\n===========|path2|============");

const pathinfo = path.parse(__filename);
console.log(pathinfo);
console.log(pathinfo.ext);

//역순으로
const pathobj = {
    root: '/',
    dir: '/home/master/node/200331_nodejs',
    base: 'ex16_path.js',
    ext: '.js',
    name: 'ex16_path'
};

const filename = path.format(pathobj);
console.log(filename);


console.log( path.normalize('/user/tmp/../local///bin/') );
console.log( path.normalize('./ex16_path.js') );

console.log( path.join(__dirname, '..', '..', '/home', '/master') );

