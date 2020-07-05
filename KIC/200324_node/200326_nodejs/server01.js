//server01.js
const http = require('http');

console.log('start');
http.createServer( function (req, rsp) {
    rsp.writeHead(200, {'Content-Type' : 'text/html'});
    rsp.end('<h1>Hello NodeJS');    

    console.log('...ing');    
}).listen(3000);
console.log('end');
