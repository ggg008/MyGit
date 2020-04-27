"use strict";

module.exports = function (app) {
    app.get('/', (req, res) => {
        res.render('index.html');
    });

    app.get('/gugudan', (req, res) => {        
        console.log(req.query);
        
        // res.send('GET 방식 응답 완료');
        res.render('gugudan', {
            startDan : req.query.startDan,
            endDan : req.query.endDan
        });
    });
}