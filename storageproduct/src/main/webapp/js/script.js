


$(document).ready(function() {
	 
    $('body').append('<div id="blackout"></div>');
     
    var boxWidth = 400;
    
    
    function centerBox() {
        
    	
        
        
    	var winWidth = $(window).width();
        var winHeight = $(document).height();
        var scrollPos = $(window).scrollTop();
         
        
         
        var disWidth = (winWidth - boxWidth) / 2
        var disHeight = scrollPos+40;
         
        
        $('.popup-box').css({'width' : boxWidth+'px', 'left' : disWidth+'px', 'top' : disHeight+'px'});
        $('#blackout').css({'width' : winWidth+'px', 'height' : winHeight+'px'});
         
        return false;       
    }
    
    
    $(window).resize(centerBox);
    $(window).scroll(centerBox);
    centerBox();  
    
    $('[class*=popup-link]').click(function(e) {
        
        /* Предотвращаем действия по умолчанию */
        e.preventDefault();
        e.stopPropagation();
         
        
        var name = $(this).attr('class');
        var id = name[name.length - 1];
        var scrollPos = $(window).scrollTop();
         
        
        $('#popup-box-'+id).show();
        $('#blackout').show();
        $('html,body').css('overflow', 'hidden');
         
        
        $('html').scrollTop(scrollPos);
    });
     
    $('[class*=popup-box]').click(function(e) { 
        
        e.stopPropagation(); 
    });
    $('html').click(function() { 
        var scrollPos = $(window).scrollTop();
        
        
        $('[id^=popup-box-]').hide(); 
        $('#blackout').hide(); 
        $("html,body").css("overflow","auto");
        $('html').scrollTop(scrollPos);
    });
    $('.close').click(function() { 
        var scrollPos = $(window).scrollTop();
        
        
        $('[id^=popup-box-]').hide(); 
        $('#blackout').hide(); 
        $("html,body").css("overflow","auto");
        $('html').scrollTop(scrollPos);
    });
});
    
