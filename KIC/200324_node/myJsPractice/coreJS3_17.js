var obj = {
    0: 'a',
    1: 'b',
    2: 'c',
    length: 3
};
Array.prototype.push.call(obj, 'd');
console.log(obj);

var arr = Array.prototype.slice.call(obj);
console.log(arr);

var arr2 = obj.slice(0);
console.log(arr2);