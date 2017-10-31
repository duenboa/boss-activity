/**
 * Particleground demo
 * @author Jonathan Nicol - @mrjnicol
 */

$(document).ready(function () {
    $('#particles').particleground({
        dotColor: '#e7e7eb',
        lineColor: '#e7e7eb'
    });
    $('.intro').css({
        'margin-top': -($('.intro').height() / 2)
    });



    $('.register').click(function () {
        var username = $('.username').val();
        var password = $('.password').val();

        if((username == '') || (password == '')){
            $('.tip').html('用户名或密码不能为空').removeClass('hide');
            return;
        }
        //登录接口
        $.ajax({
            url:'http://boa.free.ngrok.cc/sys/login.do',
            data: {
                'username':username,
                'password':password
            },
            dataType: 'text',
            type:'post',
            success: function (data) {
                var data = data.substring(1,data.length-1);
                var data1 = JSON.parse(data);
                if(data1.status == 1){
                    window.location.href = '/page/admin-manage.html';
                }else{
                    $('.tip').html(data1.detail).removeClass('hide');
                }
            },
            error:function (data) {
                $('.tip').html('网络错误，请重试').removeClass('hide');
            }
        });
    });
});