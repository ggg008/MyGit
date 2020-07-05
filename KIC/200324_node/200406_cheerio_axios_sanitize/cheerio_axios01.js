"use strict";

const axios = require('axios');
const cheerio = require('cheerio');

console.log("\n===========|axios-cheerio1|============");

// async(비동기), await(동기)

async function getHtml(url){
    try {
        const res = await axios.get(url);//await 처리 기다렸다 실행
        // console.log(res.data);
        return res;

    } catch (error) {
        console.log(error);        
    }
}

getHtml('https://www.naver.com')
.then( res => {
    // console.log('res ', res);
    // console.log('res END');

    const $ = cheerio.load( res.data );

    // const $hrefs = $('ol.ca_l a');//뭘 출력하려고 했던걸까? 200705
    const $hrefs = $('.title');
    // 인코딩 위해서는 sanitize-html 외부 모듈 필요
    // console.log($hrefs.html()); 
    console.log($hrefs.text());

})
.catch( err => {
    console.log('err ', err);
});