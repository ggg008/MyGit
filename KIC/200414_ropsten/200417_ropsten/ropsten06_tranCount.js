"use strict";

const Web3 = require('web3');
console.log(Web3.version);

const web3 = new Web3(new Web3.providers.HttpProvider('https://ropsten.infura.io/v3/fbd0bf15b2a34fe4b1fb74509ecc368e'));


web3.eth.getTransactionCount('0x8a20A400947F5783CBd229664c026a8126df4298', function(error, result) {
    console.log(result);
    //이더 전송을 위해

    //필요가스량 산출도 가능
    //Hex 값으로 산출
    console.log( web3.utils.toHex(21000) );    
    console.log( web3.utils.toHex(web3.utils.toWei('5', 'gwei') ) );
    console.log( web3.utils.toHex(web3.utils.toWei('1', 'ether') ) );

    //nonce(거래에 대한 고유값)
    console.log( 'nonce : ', web3.utils.toHex(result) );

});