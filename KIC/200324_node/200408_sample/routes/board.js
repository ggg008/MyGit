var express = require('express');
var router = express.Router();


router.get('/', function(req, res, next) {
  // res.send('respond with a resource');
  res.render('board', { title: 'im Board' });
});

module.exports = router;
