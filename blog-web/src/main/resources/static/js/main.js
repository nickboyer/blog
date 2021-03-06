$(function(){
	/* 菜单栏显示和隐藏 */	
	$("#site-nav-toggle").click(function(){
		var node = $("#site-nav-toggle-list");

		if(node.is(":hidden")){
			   node.show(200);
		}else{
			  node.hide(200,function(){node.removeAttr("style");});	  
		}
	});
	
	/* 目录切换 */
	$(".sidebar-nav li").click(function(){
		$(".sidebar-content div,li").removeClass("sidebar-nav-active");
		$(this).addClass("sidebar-nav-active");
		$(".sidebar-content div."+$(this).attr("data-target")).addClass("sidebar-nav-active");
	});

	backToTop();
	
	/* 搜索绑定事件 */
	$("#nickboyer-search").bind('input porpertychange',function(){
		var wd = $(this).val();
		$.ajax({
			type: "GET",
			url: "/search",
			data: {wd:wd},
			dataType: "json",
			success: function(data){
				console.log(data);
				var html = '';
				$.each(data, function(index, comment){
					html = html + '<li class="col-xs-12"><a href="/detail?id='+comment.id+'" class="col-xs-12">'+comment.header+'</a></li>';
				});
				$("#search-result").html(html);
			}	
		});
	});
	
	/* 搜索弹出聚焦 */
	$("#common-search").on('shown.bs.modal', function () {
		  $('#nickboyer-search').focus();
	})
	
});

/*back to top*/
function backToTop() {
    $(window).on('scroll', function () {
		if ($(window).scrollTop() > 100) {
			$('#top-link-block').show('fast');
		}else {
			$('#top-link-block').hide('fast');
		}
		var scrollTop = $(window).scrollTop();
		var docHeight = $(document).height();
		var winHeight = $(window).height();
		var scrollPercent = (scrollTop) / (docHeight - winHeight);
		var scrollPercentRounded = Math.round(scrollPercent*100);
		$('#top-link-block span').html(scrollPercentRounded);
	});
}

function formatDate(date, fmt)
{
    date = date == undefined ? new Date() : date;
    date = typeof date == 'number' ? new Date(date) : date;
    fmt = fmt || 'yyyy-MM-dd HH:mm:ss';
    var obj =
    {
        'y': date.getFullYear(), // 年份，注意必须用getFullYear
        'M': date.getMonth() + 1, // 月份，注意是从0-11
        'd': date.getDate(), // 日期
        'q': Math.floor((date.getMonth() + 3) / 3), // 季度
        'w': date.getDay(), // 星期，注意是0-6
        'H': date.getHours(), // 24小时制
        'h': date.getHours() % 12 == 0 ? 12 : date.getHours() % 12, // 12小时制
        'm': date.getMinutes(), // 分钟
        's': date.getSeconds(), // 秒
        'S': date.getMilliseconds() // 毫秒
    };
    var week = ['天', '一', '二', '三', '四', '五', '六'];
    for(var i in obj)
    {
        fmt = fmt.replace(new RegExp(i+'+', 'g'), function(m)
        {
            var val = obj[i] + '';
            if(i == 'w') return (m.length > 2 ? '星期' : '周') + week[val];
            for(var j = 0, len = val.length; j < m.length - len; j++) val = '0' + val;
            return m.length == 1 ? val : val.substring(val.length - m.length);
        });
    }
    return fmt;
}