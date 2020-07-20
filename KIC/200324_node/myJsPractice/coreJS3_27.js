var obj = {
    outer: function () {
        console.log(this);
        var innerFunc = function () {
            console.log(this);
        }.bind(this);
        innerFunc(); // 여기서 this는 전역 <- bind로 의도대로 this 전달
    }
};
obj.outer();////this === obj