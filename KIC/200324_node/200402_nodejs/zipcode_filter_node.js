//node 파일명 동이름

//검색 결과 출력

"use strict";

const fs = require('fs');
//한글입력 확인
if(process.argv.length != 3) {
    console.log('동이름을 입력하세요');
    process.exit(0);
}

const file = '../zipcode_seoul_utf8_type2.csv';
//파일존재여부 검사
const strDong = process.argv[2];

fs.readFile(file, 'utf8', (err, result) => {
    if(err) {
        console.log('에러 발생 ' + err);
        process.exit(0);
    } 
    const datas = result.toString().trim().split('\r\n');
    // console.log(datas);

    let arrFilterData = datas.filter( (data) => {
        let arrData = data.split(',');
        return arrData[3].indexOf(strDong) != -1;
    });

    console.log( arrFilterData );
})
