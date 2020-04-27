"use strict";

const Web3 = require('web3');
console.log(Web3.version);

const web3 = new Web3(new Web3.providers.HttpProvider('https://ropsten.infura.io/v3/fbd0bf15b2a34fe4b1fb74509ecc368e'));


const transactionHash = '0x704f4ece11869fa407d242207c3d61884a7fca477b91ff8d7ebc858f3290c960'; //트랜잭션해시

web3.eth.getTransactionReceipt( transactionHash, (err, receipt) => {
    console.log( receipt );
    console.log( receipt.to );
} )