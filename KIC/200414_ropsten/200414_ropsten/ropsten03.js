"use strict";

const Web3 = require('web3');
console.log(Web3.version);

const web3 = new Web3(new Web3.providers.HttpProvider('https://ropsten.infura.io/v3/fbd0bf15b2a34fe4b1fb74509ecc368e'));

web3.eth.getBalance('0x8a20A400947F5783CBd229664c026a8126df4298', (err, result) => {
    console.log('Balance-Wei :',  result);
    console.log('Balance-Ether :',  web3.utils.fromWei(result) );
})