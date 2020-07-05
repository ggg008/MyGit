"use strict";

const fs = require('fs');

console.log("\n===========|file6|============");

// const path = '../node';
// const path = '..';
// const path = '.';
const path = './200331_nodejs';

//파일기능을 배우면 탐색기를 모방하여 연습!
fs.readdir(path, (err, files) => {
    if(!err){
        console.log('files');
        console.log(files);
        
        for (let file of files) {
            const stat = fs.statSync(path + '\\' + file);
            console.log( stat.isFile());

            // console.log(path + path.sep + file);
        }

        console.log("========================");
        // files.forEach((val, idx) => {
        //     // console.log(fs.statSync(val));
        //     let stat = fs.statSync(val);
        //     if(stat.isDirectory()) {
        //         console.log(`[${val}]`);
        //     } else {
        //         console.log(`file: ${val}`);
        //     }
        // });

    } else {
        console.error('fail');
    }
})