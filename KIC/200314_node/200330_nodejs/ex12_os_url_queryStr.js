"use strict";

console.log("\n===========|os|============");

const os = require("os");

// console.log( os);

//운영체제
console.log(os.arch());
console.log(os.platform());
console.log(os.type());
console.log(os.hostname());
console.log(os.release());

//모니터링에 유용

//운영체제 경로
console.log(os.homedir());
console.log(os.tmpdir());

//cpu
console.log(os.cpus());

//memory
console.log(os.totalmem());
console.log(os.freemem());


console.log("\n===========|url|============");

const url = require('url');
const strUrl = 'https://search.naver.com/search.naver?sm=top_sug.pre&fbm=1&acr=1&acq=covid&qdt=0&ie=utf8&query=covid-19';
const parsedUrl = url.parse(strUrl);

// console.log(parsedUrl);
console.log(parsedUrl.protocol);
console.log(parsedUrl.query);

console.log("\n===========|url2|============");

const parsedUrl2 = url.parse(strUrl, true);

// console.log(parsedUrl2);
console.log(parsedUrl2.protocol);
console.log(parsedUrl2.query);

console.log("\n===========|url만들기|============");
const urlObj = {
    protocol: 'http',
    host: 'idols.com',
    pathname: 'schedule/radio',
    search: 'time=9pm&day=monday'
}
const urlStr = url.format(urlObj);//format
// http://idols.com/schedule/radio?time=9pm&day=monday
console.log(urlStr);

console.log("\n===========|queryString|============");
const querystring = require('querystring');

const parsedUrl3 =
    url.parse('https://search.naver.com/search.naver?sm=top_sug.pre&fbm=1&acr=1&acq=covid&qdt=0&ie=utf8&query=covid-19');

const query = querystring.parse(parsedUrl3.query);

console.log(query);// 위와 같다 == .parse(strUrl, true);
console.log(query.query);

console.log("\n===========|쿼리문자열 만들기|============");

const queryObj = {
    name: 'IU',
    best: '좋은날'
};
const queryStr = querystring.stringify(queryObj);//문자열화 함수
// name=IU&best=%EC%A2%8B%EC%9D%80%EB%82%A0
console.log(queryStr);