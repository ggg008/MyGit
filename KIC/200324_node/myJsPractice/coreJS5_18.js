"use strict";

//커링함수
var curry5 = function(func) {
    return function (a) {
        return function (b) {            
            return function (c) {
                return function (d) {
                    return function (e) {
                        return func(a, b, c, d, e);
                    };
                };
            };
        };
    };
};

var curry5_2 = func => a => b => c => d => e => func(a, b, c, d, e);

var getMax = curry5_2(Math.max);
console.log(getMax(8)(9)(10)(11)(12));