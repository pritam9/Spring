/*
*
Created By: Niranjan Ravichandran
Date: 11/01/2015
*
*/

//jQuery to collapse the navbar on scroll
$(window).scroll(function() {
    if ($(".navbar").offset().top > 50) {
        $(".navbar-fixed-top").addClass("top-nav-collapse");
    } else {
        $(".navbar-fixed-top").removeClass("top-nav-collapse");
    }
});

//jQuery for page scrolling feature - requires jQuery Easing plugin
$(function() {
    $('a.page-scroll').bind('click', function(event) {
        var $anchor = $(this);
        $('html, body').stop().animate({
            scrollTop: $($anchor.attr('href')).offset().top
        }, 1500, 'easeInOutExpo');
        event.preventDefault();
    });
});

$(window).scroll(function() {
		$('#team-pic1, #team-pic2').each(function(){
		var imagePos = $(this).offset().top;

		var topOfWindow = $(window).scrollTop();
      if (imagePos < topOfWindow+100){
        $('iphone-div').addClass('slideRight');
      }
			if (imagePos < topOfWindow+500) {
				$(this).addClass("fadeIn");
			}
		});
	});

  // Custom Tab styles
  $(document).ready(function($) {
  	$(".i-div").on('click', function() {
  	      //  $(".android-div").fadeOut();
  	       $(".iphone-div").fadeIn();
  	});

  	$(".a-div").on('click', function() {
  	      //  $(".android-div").fadeIn();
  	       $(".iphone-div").fadeOut();
  	});
});
