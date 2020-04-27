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

getHtml('https://www.bithumb.com/')
.then( res => {
    // console.log('res ', res);

    const $ = cheerio.load( res.data, {decodeEntities : true} );

    const $hrefs = $('#sise_list .coin_list tr');
    // 인코딩 위해서는 sanitize-html 외부 모듈 필요
    // console.log($hrefs.html()); 

    // console.log( $hrefs.each(idx, elt) => {

    // }  ); 
    // const list = $hrefs.toArray();
    // list.array.forEach(element => {
    //     console.log(element);
    // });    

    $hrefs.each( (idx, elt) => {
        const coin = $(elt).attr('data-coin');
        const tds = $(elt).children('td');
        const coinSise = $(tds).eq(1).eq(0).text();

        
        console.log(idx, "|" , coin, ":", coinSise );
    });

    
    
    // const encodedHrefs = sanitizeHtml($hrefs, {
    //     parser : {
    //         decodeEntities : true
    //     }
    // });
    // console.log(encodedHrefs); // 문자열화 유의 

})
.catch( err => {
    console.log('err ', err);
});