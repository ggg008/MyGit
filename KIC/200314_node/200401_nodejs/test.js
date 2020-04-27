"use strict";

function testFunc() {
		
	const crypto = require('crypto');

    // This is base64 encoded
    var secret = '0d36ceb003ff286dcbf4a48cabfad8bee3527678e7bd969d9ae4bf8c01e9a0b003f19b8dcbc3d801f4f1b1338eda62cfb461a5d93d85211fb9d2702a39d17acc';

    var nonce = Date.now();
    var requestPath = "/v1/users/70e3a52a-4fda-464d-b4af-029f55cbd9be/accounts/123/rebalance_period";
    
    var body = JSON.stringify({
        rebalancePeriod: 24
    });

    var method = "POST";

    // create the prehash string by concatenating required parts
    var prehashString = requestPath + method + nonce + body;

    // decode the base64 secret
    var key = Buffer(secret, 'base64');

    // create a sha256 hmac with the secret
    var hmac = crypto.createHmac('sha256', key);
    

    // hash the prehash string and base64 encode the result
    return hmac.update(prehashString).digest('base64');
}

console.log(testFunc());