(function () {

    var val ;

    $('.btn').click(function () {
        val = $('#telphone').val();
        if(val == ''){
            $('.tip').html('请输入手机号').removeClass('hide');
            setTimeout(function () {
                $('.tip').addClass('hide');
            },1500);
            return;
        }
        var reg = new RegExp("^1(3[4-9]|5[012789]|8[78])\\d{8}$");
        if(!reg.test(val)){
            $('.tip').html('请输入中国移动手机号').removeClass('hide');
            setTimeout(function () {
                $('.tip').addClass('hide');
            },1500);
            return;
        }
        $.ajax({
            url:'http://boa.free.ngrok.cc/activity/order/add.do',
            data: {
                "phone":val
            },
            dataType: 'text',
            type:'post',
            success: function (data) {
                var data = data.substring(1,data.length-1);
                 var data1 = JSON.parse(data);
                if(data1.status == 1){
                    window.location.href = 'next.html?giftLevel='+data1.data.giftLevel;
                }else{
                    $('.tip').html(data1.detail).removeClass('hide');
                    setTimeout(function () {
                        $('.tip').addClass('hide');
                    },1500);
                }
                return;
            },
            error:function (data) {
                $('.tip').html('网络错误，请重试').removeClass('hide');
                setTimeout(function () {
                    $('.tip').addClass('hide');
                },1500);
            }
        });
    });






})()