"use strict";

const axios = require('axios');
const cheerio = require('cheerio');
const sanitizeHtml = require('sanitize-html');

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

    const $ = cheerio.load( res.data, {decodeEntities : true} );

    const $hrefs = $('ol.ca_l a');
    // 인코딩 위해서는 sanitize-html 외부 모듈 필요
    // console.log($hrefs.html()); 
    
    const encodedHrefs = sanitizeHtml($hrefs, {
        parser : {
            decodeEntities : true
        }
    });
    console.log(encodedHrefs); // 문자열화 유의 

})
.catch( err => {
    console.log('err ', err);
});