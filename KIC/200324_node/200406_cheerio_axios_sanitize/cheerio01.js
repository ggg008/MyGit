//like jQuery 

"use strict";

const cheerio = require('cheerio');
console.log("\n===========|cheerio|============");

const html = `<ul id="fruits">
<li class="apple">Apple</li>
<li class="orange">Orange</li>
<li class="pear">Pear</li>
</ul>`;

console.log(typeof html);

const $ = cheerio.load(html); // 펑션화

console.log('$ is ..', typeof $);

// console.log($.html());
// console.log($.text());

console.log( $('ul').html() );
console.log( $('li').html() );// 내용 하나면 value값 검출

console.log( $('.apple', '#fruits').text() );
//=> Apple
 
console.log( $('ul .pear').attr('class') );
//=> pear
 
console.log( $('li[class=orange]').html() );
//=> Orange


