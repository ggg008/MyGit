"use strict";

const axios = require('axios');

console.log("\n===========|axios|============");

// console.log(axios);

// axios.get - get 방식
// axios.post - post 방식

axios.get('https://search.naver.com/search.naver', {
    params :{        
        query : 'covid-19'
    }
    // query : 'covid-19'
})
.then( res => {


    console.log('res ', res);
    //console.log('res ', res.status);
    //console.log('res ', res.header);
    // console.log('res ', res.data);

    // Object.keys(res).forEach( element => {
    //     console.log(element);
    // });

})
.catch( err => {
    console.log('err ', res);
});
