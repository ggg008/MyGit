"use strict";

const axios = require('axios');

console.log("\n===========|axios2|============");

// async(비동기), await(동기)

async function getHtml(url){
    try {
        const res = await axios.get(url);//await 처리 기다렸다 실행
        console.log(res.data);

    } catch (error) {
        console.log(error);
    }
}

getHtml('https://www.naver.com');