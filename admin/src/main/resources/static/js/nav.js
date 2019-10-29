$(function(){
	// var li = $('.nav ul .m');
	// li.eq(fontawesome).find('a').eq(fontawesome).hover(function(){
	// 	$(this).html('HOME');
	// },function(){
	// 	$(this).html('首页');
	// });
	//
	// li.eq(1).find('a').eq(fontawesome).hover(function(){
	// 	$(this).html('FOOTBALL');
	// },function(){
	// 	$(this).html('足球世界');
	// });
	//
	// li.eq(2).find('a').eq(fontawesome).hover(function(){
	// 	$(this).html('BASKETBALL');
	// },function(){
	// 	$(this).html('篮球世界');
	// });
	//
	// li.eq(3).find('a').eq(fontawesome).hover(function(){
	// 	$(this).html('BASEBALL');
	// },function(){
	// 	$(this).html('棒球世界');
	// });
	//
	// li.eq(4).find('a').eq(fontawesome).hover(function(){
	// 	$(this).html('TENNIS');
	// },function(){
	// 	$(this).html('网球世界');
	// });
	//
	// li.eq(5).find('a').eq(fontawesome).hover(function(){
	// 	$(this).html('GAME');
	// },function(){
	// 	$(this).html('电子竞技');
	// });
	//
	// li.eq(6).find('a').eq(fontawesome).hover(function(){
	// 	$(this).html('NEWS');
	// },function(){
	// 	$(this).html('热门资讯');
	// });
	//
	// li.eq(7).find('a').eq(fontawesome).hover(function(){
	// 	$(this).html('LIVE');
	// },function(){
	// 	$(this).html('热门直播');
	// });



	//根据网站目录结构对应导航高亮显示（可忽略）

	var url = window.location.href.toLowerCase();
	//alert(url);
	if (url.indexOf("/website/case/") > -1) {
		$(".aa4").attr("id", "sel");
	} else if (url.indexOf("/news/") > -1||url.indexOf("/marketing/knowledge/") > -1||url.indexOf("/about/news/") > -1||url.indexOf("/website/newweb/") > -1||url.indexOf("/marketing/seo/") > -1) {
		$(".aa5").attr("id", "sel");
	} else if (url.indexOf("/service/contact") > -1) {
		$(".aa7").attr("id", "sel");
	} else if (url.indexOf("/about/") > -1||url.indexOf("/service/") > -1) {
		$(".aa2").attr("id", "sel");
	} else if (url.indexOf("/mobile/") > -1||url.indexOf("/wangzhanjianshe/") > -1) {
		$(".aa6").attr("id", "sel");
	} else if (url.indexOf("/website/") > -1) {
		$(".aa3").attr("id", "sel");
	} else if (url.indexOf("/solutions/") > -1) {
		$(".aa8").attr("id", "sel");
	} else if (url.indexOf("www.yibaixun.com/index.html") > -1) {
		$(".aa1").attr("id", "sel");
	} else {
		$(".aa1").attr("id", "sel");
	}

});



$(window).scroll(function(){
	//控制导航
	if($(window).scrollTop()<100){
		$('#headdiv').stop().animate({"top":"0px"},200);
		$('.logo').css("padding-top","20px");
		$('.nav .mmm').css("padding-top","50px");
		$('.nav .sub').css("top","125px");
		$('.top02').css("height","95px");

	}else{
		$('#headdiv').stop().animate({"top":"-30px"},200);
		$('.top02').css("height","75px");
		$('.logo').css("padding-top","3px");
		$('.nav .mmm').css("padding-top","30px");
		$('.nav .sub').css("top","75px");
	}
});


//鼠标放入事件


$(document).ready(function(){
	$(".layui-col-md3 .layui-card-body ul.bs li").mouseover(function(){
		$(this).css("border","1px solid #EF3F52");
	})
});

$(document).ready(function(){
	$(".layui-col-md3 .layui-card-body ul.bs li").mouseout(function(){
		$(this).css("border","1px solid #DEDEDE");
	})
});
