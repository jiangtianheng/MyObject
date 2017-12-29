jQuery(function() {
	menujs();
})

function menujs() {
	var chart = "";
	$
			.ajax({
				url : "menu/getMenuInfos",
				type : "get",
				data : {
					"role" : 1
				},
				dataType : "json",
				async : false,
				success : function(result) {
					console.log(result);
					for ( var i = 0, l = result.length; i < l; i++) {
						if (result[i].pid == null) {
							var id = result[i].id;
							chart = chart
									+ "<li ><a href=\"\"><i class=\"fa fa-th-large\"></i>"
									+ "<span class=\"nav-label\">"
									+ result[i].name + "</span></a>"
									+ "<ul class=\"nav nav-second-level\">";
							for ( var j = 0, ls = result.length; j < ls; j++) {
								if (result[j].pid == id) {
									chart = chart + "<li><a href=\"#\">"
											+ result[j].name + "</a></li>"
								}
							}
							chart = chart + "</ul></li>";
						}
					}
				}
			});
	$("#test").after(chart);
	console.log(chart);
}