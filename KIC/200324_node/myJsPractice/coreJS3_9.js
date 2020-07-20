var obj1 = {
    outer: function () {
        console.log(this);
        var innerFunc = function () {
            console.log(this);
        }
        innerFunc(); // 여기서 this는 전역

        var obj2 = {
            innerMethod : innerFunc
        };
        obj2.innerMethod();//this === obj2
    }
};
obj1.outer();////this === obj1

//단순 점으로만 this가 전역객체인지 아닌지를 구분