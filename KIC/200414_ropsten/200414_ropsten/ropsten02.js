"use strict";

const Web3 = require('web3');
console.log(Web3.version);

const web3 = new Web3(new Web3.providers.HttpProvider('https://mainnet.infura.io/v3/fbd0bf15b2a34fe4b1fb74509ecc368e'));

web3.eth.getBlock(1, (err, result) => {
    console.log( 'Block Info :', result );
})