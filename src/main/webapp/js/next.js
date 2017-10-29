(function () {



    var giftLevel = getRequest();
    console.log(giftLevel);
    console.log(giftLevel.giftLevel);
    $('.prize').css({'background':'url("imgs/prize'+giftLevel.giftLevel+'.png") 0 0 no-repeat','background-size':'100% 100%'});

    function getRequest() {
        var url = location.search; //获取url中"?"符后的字串
        var theRequest = new Object();
        if (url.indexOf("?") != -1) {
            var str = url.substr(1);
            strs = str.split("&");
            for (var i = 0; i < strs.length; i++) {
                theRequest[strs[i].split("=")[0]] = (strs[i].split("=")[1]);
            }
        }
        return theRequest;
    }



})()
