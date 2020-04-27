"use strict";

module.exports = function (app) {
    app.get('/', (req, res) => {
        res.render('index.html');
    });

    app.get('/about', (req, res) => {
        res.render('about.html');
    });

    app.get('/test1', (req, res) => {
        res.render('test', {
            title1 : 'EJS Hompage',
            length : 15
        });
    });

    app.get('/gugudan', (req, res) => {
        res.render('test', {
            title1 : 'EJS Hompage',
            length : 15
        });
    });
}