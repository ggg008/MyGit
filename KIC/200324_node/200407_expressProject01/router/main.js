"use strict";

module.exports = function (app) {
    app.get('/', (req, res) => {
        res.render('index.html');
    });

    app.get('/about', (req, res) => {
        res.render('about.html');
    });

    app.get('/test1', (req, res) => {
        res.render('test1', {
            title : 'EJS Hompage',
            length : 15
        });
    });

}