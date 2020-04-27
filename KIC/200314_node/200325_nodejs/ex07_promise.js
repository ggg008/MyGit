// "use strict";

console.log("===========|Promise2|============");

function get(url) {
    return new Promise(function (resolve, reject) {

        var XMLHttpRequest = require('xmlhttprequest').XMLHttpRequest;
        var req = new XMLHttpRequest(); 
        req.open('GET', url);
        req.onload = function () {
            if (req.status == 200) {
                resolve(req.responseText);
            } else {
                reject(Error(req.statusText));
            }
        };
        req.onerror = function () {
            reject(Error("Network Error"));
        };
        req.send();
    });
}

get('https://www.naver.com').then(function (response) {
    console.log("Success!", response);
}, function (error) {
    console.error("Failed!", error);
})