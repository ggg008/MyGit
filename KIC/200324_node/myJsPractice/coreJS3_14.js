var func = function (a, b, c) {
    console.log(this, a, b, c);    
}

func(1, 2, 3);

func.call(obj1 = {x: 1}, 4, 5, 6);

console.log(obj1);