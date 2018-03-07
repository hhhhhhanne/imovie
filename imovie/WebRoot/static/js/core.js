/**
 * layout javascript
 */
$(document).ready(function() {
	// sidebar
	$('.sidebar li').on('mouseenter', function() {
		$(this).addClass("active");
		$(this).children("ul").fadeIn('fast');
	}).on('mouseleave', function() {
		$('.active li').removeClass('active');
		$(this).removeClass('active');
		$(this).children("ul").fadeOut('fast');
	});

	var width = $('#M14_B_INDEX_2').width();
	redraw(width);
	$(".slide-pic").slidePic({
		width : width,
		height : 460,
		autoSlideTime : 3000,
		controllerLeft : true
	});
	$(window).resize();
});

function redraw(width) {
	$('.slide-pic img').css({
		width : width + "px",
		height : "460px"
	});
	$('.slide-pic').css({
		width : width + "px",
		height : "460px"
	});
}

$(window).resize(function() {
	var width = $('#M14_B_INDEX_2').width();
	redraw(width);
})

$(document).ready(function() {

	$('.box-btn-prev').click(function() {
		var layout_box = $('.box-laytou');
		var block = $('.offset-block');
		var count = block.length;
		var block_width = block.width() + 14; // margin-left 修正
		var laytou_box_width = layout_box.width();
		var present = parseInt(laytou_box_width / block_width); // 当前显示的块数
		var cursor = parseInt(layout_box.attr('cursor')); // 块数游标
		var times = parseInt(layout_box.attr('times')); // 点击次数
		if (cursor > 0) {
			cursor -= present;
			times--;
			var offset = present * block_width * times;
			$('.offset-box').animate({
				left : "-" + offset + "px"
			}, 500);
			layout_box.attr('cursor', cursor);
			layout_box.attr('times', times);
		}
	});

	$('.box-btn-next').click(function() {
		var layout_box = $('.box-laytou');
		var block = $('.offset-block');
		var count = block.length;
		var block_width = block.width() + 14; // margin-left 修正
		var laytou_box_width = layout_box.width();
		var present = parseInt(laytou_box_width / block_width); // 当前显示的块数
		var cursor = parseInt(layout_box.attr('cursor')); // 块数游标
		var times = parseInt(layout_box.attr('times')); // 点击次数
		if (cursor + present <= count && count > present) {
			cursor += present;
			times++;
			var offset = present * block_width * times;
			$('.offset-box').animate({
				left : "-" + offset + "px"
			}, 500);
			layout_box.attr('cursor', cursor);
			layout_box.attr('times', times);
		}

	});
});
$(document).ready(function() {
	$('.weeklist li:lt(2)').find('.num').addClass('topTwo');

	$('.weeklist li').on('mouseenter', function() {
		$('.weeklist li').each(function() {
			if ($(this).hasClass('select'))
				$(this).removeClass('select');
		});
		$(this).addClass("select");
	}).on('mouseleave', function() {
		$(this).removeClass('select');

	});
	$('.weeklist').on('mouseleave', function() {
		if (!$('.weeklist li').hasClass('select')) {
			$('.weeklist li:eq(0)').addClass('select');
		}

	});

});
