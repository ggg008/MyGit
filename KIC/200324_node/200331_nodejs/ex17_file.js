"use strict";

const fs = require('fs');
const path = require('path');

console.log("\n===========|file|============");

// const file = 'ex17_file.js';
const file = __filename;

// Check if the file exists in the current directory.
fs.access(file, fs.constants.F_OK, (err) => {
    console.log(`${file} ${err ? 'does not exist' : 'exists'}`);
});

// Check if the file is readable.
fs.access(file, fs.constants.R_OK, (err) => {
    console.log(`${file} ${err ? 'is not readable' : 'is readable'}`);
});

// Check if the file is writable.
fs.access(file, fs.constants.W_OK, (err) => {
    console.log(`${file} ${err ? 'is not writable' : 'is writable'}`);
});

// Check if the file exists in the current directory, and if it is writable.
fs.access(file, fs.constants.F_OK | fs.constants.W_OK, (err) => {
    if (err) {
        console.error(
            `${file} ${err.code === 'ENOENT' ? 'does not exist' : 'is read-only'}`);
    } else {
        console.log(`${file} exists, and it is writable`);
    }
});

