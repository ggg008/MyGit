"use strict"

const axios = require( 'axios' );
const cheerio = require( 'cheerio' );
const sanitizeHtml = require( 'sanitize-html' );

async function getHtml( url ) {
    try {
        return await axios.get( url );
    } catch( error ) {
        console.error( error );
    }
}

getHtml( 'https://www.bithumb.com/' )
.then( response => {
    // 
    const $ = cheerio.load( response.data );

    //
    const $trs =$( '#sise_list' ).find( 'tr' );

    $trs.each( ( index1, element1 ) => {
        //
        const $tds =$( element1 ).children( 'td' );

        $tds.each( ( index2, element2 ) => {
            let data = $( element2 ).text().trim();
            if( data != "") {
                console.log( index2, data );
            }
        });
    });
})
.catch( err => {
    console.log( err );
})