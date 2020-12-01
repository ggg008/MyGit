var arr = [1, 2]
Array.prototype.toString.call(arr)
Object.prototype.toString.call(arr)
console.log(arr.toString());

arr.toString = function () {
    // return this.join('_');
    return this[0];
}
console.log(arr.toString());