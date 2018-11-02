$(function(){
    hljs.initHighlightingOnLoad();
	$("#demo4").jqPaginator({
        totalPages: 1,
        visiblePages: 1,
        currentPage: 1,
        first : '<li class="first"><a href="javascript:void(0);">First</a></li>',
		prev : '<li class="prev"><a href="javascript:void(0);">Previous</a></li>',
		next : '<li class="next"><a href="javascript:void(0);">Next</a></li>',
		last : '<li class="last"><a href="javascript:void(0);">Last</a></li>',
		page : '<li class="page"><a href="javascript:void(0);">{{page}}</a></li>',
        //prev: '<li class="prev"><a href="javascript:void(0);">Previous<\/a><\/li>',
        //next: '<li class="next"><a href="javascript:void(0);">Next<\/a><\/li>',
       // page: '<li class="page"><a href="javascript:void(0);">{{page}}/{{totalPages}}<\/a><\/li>',
        onPageChange: function (n) {
            initData(n);
        }
    });
});

function getJsonList(url){
	$('#tbody').html("");
	$.getJSON(url, function (res) {
		var totalPages = res.totalPages;
        var totalSize = res.totalSize;
        $("#totalSize").html(totalSize);
        if(totalPages>0){
            $('#demo4').jqPaginator('option', {
                totalPages: totalPages//总页数
            });
        }
        renderPage(res);
        
	});
}