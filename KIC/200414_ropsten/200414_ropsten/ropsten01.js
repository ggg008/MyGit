"use strict";

const Web3 = require('web3');
console.log(Web3.version);

const web3 = new Web3(new Web3.providers.HttpProvider('https://ropsten.infura.io/v3/fbd0bf15b2a34fe4b1fb74509ecc368e'));

console.log(web3);

//블록갯수
//CallBack
web3.eth.getBlockNumber( (err, result) => {
    if(err){
        console.error(err);
    } else {
        console.log(result);
    }
})
//Promise
web3.eth.getBlockNumber()
.then( (err, result) => {

    if(err){
        console.error(err);
    } else {
        console.log(result);
    } 
});
//둘의 차이??