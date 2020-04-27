"use strict";

const Web3 = require('web3');
console.log(Web3.version);
const EtehreumTx = require('ethereumjs-tx').Transaction;


const web3 = new Web3(
    new Web3.providers.HttpProvider('https://ropsten.infura.io/v3/fbd0bf15b2a34fe4b1fb74509ecc368e')
);

const send_account = '0x8a20A400947F5783CBd229664c026a8126df4298';
const private_key = Buffer.from('45188013046DA388C9FEF1216B6FBA1B309948615F7F9CE49B453AE0C8065184', 'hex');

const receive_account = '0xD702342142a03307b0E46a3ae46ead403C802BBd';


web3.eth.getTransactionCount(send_account, function(error, result) {    
    // console.log( web3.utils.toHex(21000) );    
    // console.log( web3.utils.toHex(web3.utils.toWei('5', 'gwei') ) );
    // console.log( web3.utils.toHex(web3.utils.toWei('1', 'ether') ) );
    // console.log( 'nonce : ', web3.utils.toHex(result) );

    //전송을 위한 객체
    const rawTex = {
        to : receive_account,
        nonce : web3.utils.toHex(result),
        //gas * gasPrice = fee
        gas : web3.utils.toHex(2100000),
        gasPrice :  web3.utils.toHex(web3.utils.toWei('5', 'gwei')),
        //보낼 이더
        value :  web3.utils.toHex(web3.utils.toWei('1', 'ether'))
    }

    const ethereumTx = new EtehreumTx(rawTex, {chain : 'ropsten'});
    ethereumTx.sign(private_key);

    //
    const serializedTx = ethereumTx.serialize();
    const raw = '0x' + serializedTx.toString('hex');

    // 전송( waiting이 있음 )
    web3.eth.sendSignedTransaction(raw, (err, transactionHash) => {
        if(!err) {
            console.log('전송 트랜잭션 :', transactionHash );
        } else {
            console.error(err);
        }
    });

});