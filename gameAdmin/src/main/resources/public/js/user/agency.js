$(function() {
	search();
	
	$("#add_agency").click(function() {
		checkSn();
	});

});
function checkSn() {
	if ($("#agencyName").val() == "") {
		$("#agencyName").focus();
		return;
	}
	var header = $("meta[name='_csrf_header']").attr("content");
	var token = $("meta[name='_csrf']").attr("content");
	var data={"data":{"agencyName" : $("#agencyName").val()}};
	$.ajax({
		url : "/admin/agency/check",
		type : 'post',
		contentType: 'application/json',
		data :JSON.stringify(data) ,
		dataType : 'json',
		timeout : 1000,
		beforeSend: function(xhr){
	        xhr.setRequestHeader(header, token);
	    },
		success : function(data, status) {
			
			if(data.status=10200){
				if(data.data){
					addAgency()
				}
				
			}
			
		
		},
		fail : function(err, status) {
			alert("系统错误，请稍后");
		}
	});

}

function addAgency() {

	
	var header = $("meta[name='_csrf_header']").attr("content");
	var token = $("meta[name='_csrf']").attr("content");
	var data={"data":{"agencyName" : $("#agencyName").val()}};
	$.ajax({
		url : "/admin/agency/save",
		type : 'post',
		contentType: 'application/json',
		data :JSON.stringify(data) ,
		dataType : 'json',
		timeout : 1000,
		beforeSend: function(xhr){
	        xhr.setRequestHeader(header, token);
	    },
		success : function(data) {

			if (data.status=10200) {
				
				search();
			}

		}
	});

}

function search() {

	$('#pager').sjAjaxPager({
		url : "/admin/agency/list",
		pageSize : 10,
		searchParam : {
			/*
			 * 如果有其他的查询条件，直接在这里传入即可
			 */

			id : 1,
			name : 'test'
		},
		beforeSend : function() {

		},
		success : function(data) {

			creatSlideList(data);
		},
		complete : function() {
		}
	});

}
function creatSlideList(data) {
	var html = "";

	if (data.items.length > 0) {
		var list = data.items;
		for (var i = 0; i < list.length; i++) {
			html += "<tr><td>"
			html += list[i].sn
			html += "</td><td><img src='" + data.picPath + "/"
					+ list[i].imgPath + "' /></td>"
					
		 if(list[i].type==1){
			 html += "<td>要闻速递</td>"		 
		 }
		 if(list[i].type==2){
			 html += "<td>A股直击</td>"		 
		 }
		 if(list[i].type==3){
			 html += "<td>名师操盘</td>"		 
		 }
		 if(list[i].type==4){
			html += "<td>黑马池</td>"		 
			 }
			
					
					
			html += "<td>" + list[i].remark + "</td>"

			html += "<td><a href='#' class='on_delete' onclick='delSlide("
					+ list[i].id + ")'>删除</a></td>"
			html += "</tr>"
		}

	}
	$("#slide_data").html("");
	$("#slide_data").html(html);

}

function delSlide(slideid) {
	var fd = new FormData();
	var header = $("meta[name='_csrf_header']").attr("content");
	var token = $("meta[name='_csrf']").attr("content");
	fd.append('id', slideid);
	$.ajax({
		url : "/slide/delSlide",
		type : "POST",
		// Form数据
		data : fd,
		cache : false,
		contentType : false,
		processData : false,
		beforeSend : function(xhr) {
			xhr.setRequestHeader(header, token);
		},
		success : function(data) {

			if (data.success) {

				alert("刪除成功");
				search();
			}

		}
	});
}