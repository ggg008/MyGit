"use strict";

console.log("\n===========|filename|============");
console.log(__filename); //현재 파일명
console.log(__dirname); // ''


console.log("\n===========|process|============");
console.log(process.version);
console.log(process.arch);
console.log(process.platform);
console.log(process.pid);
console.log(process.uptime());
console.log(process.cpuUsage());


console.log("\n===========|process argv|============");

//argv : 실행 명령 파라미터
console.log(process.argv); 
//console.log(process.argv[0]);
//console.log(process.argv[1]);
//console.log(process.argv[2]);
//console.log(process.argv[3]);


for (let elt of process.argv) {
    console.log("fof |", elt);
}
//nodejs 내장 : process.argv, foreach : JS
process.argv.forEach( (val, index) => {
    console.log(`${index}: ${val}`);
}); 


let strArray = process.argv[2].split(' ');

strArray.forEach( (val, idx) => {
    strArray[idx] = val.substring(0, 1).toUpperCase() + val.substring(1);    
});
console.log("변환 :", strArray.join(' '));





