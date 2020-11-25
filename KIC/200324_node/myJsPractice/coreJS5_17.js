"use strict";

var curry3 = function(func) {
    return function (a) {
        return function (b) {
            return func(a, b);
        };
    };
};

var getMaxWidth10 = curry3(Math.max)(10);
console.log(getMaxWidth10(8));
console.log(getMaxWidth10(25));

var getMinWidth = curry3(Math.min)(10);
console.log(getMinWidth(8));
console.log(getMinWidth(25));