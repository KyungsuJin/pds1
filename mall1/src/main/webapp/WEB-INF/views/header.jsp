<!-- [진경수] -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="utf-8">
<!-- 사이트가 IE에서 올바로 표시되지 않는다면, 가장 최신 웹 표준 지원을 위해 사이트를 업데이터하거나,(권장)
IE를  이전 버전의 브라우저에서 보는 것처럼 내용을 표시하도록 할 수 있습니다. 하지만 기능들이 정상적으로 작동하지 않을수도 있습니다.
화면에 보이는 것만 정상적으로 보일수 있다. -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- 어떤 디바이스에서든 해당 디바이스에 맞는 화면크기를 보여주기위하여 사용. -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
<title>addMember</title>
<!-- 부트스트랩 기본 css-->
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<!-- 로그인 모달부분 css 처리하기~ -->
<link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet">
<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다.) 그런데 나는 자바스크랩트 최신버전으로 새로 받은거임~ -->
<style>
	.addMemberForm{width:300px;}
	.input-group{width:100%;}
	.input-group-addon{top:0 !important;}
}
</style>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
<!-- 로그인 버튼 누르면 submit시키려고~ -->
<script src="${pageContext.request.contextPath}/resources/js/topMenu.js"></script>
<!-- 모든 컴파일된 플러그인을 포함합니다 -->
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script>
$(document).ready(function(){
	$("#loginBtn").click(function(e){
		console.log("t1");
		$("#loginForm").submit();
		console.log("t2");
	});
	
	
	$(".member-id span").hide();
	$(".member-pw span").hide();
	$(".member-pw-check span").hide();
	$(".member-addr span").hide();
	
	$(".update-member-pw span").hide();
	$(".update-member-pw-check span").hide();
	
	$("#memberIdCheckHelp").hide();
	$("p").hide();
	
	$("#memberBtn").click(function(e) {
		if ($("#memberId").val().length < 4) {
			$("#memberId").focus();
		} else if ($("#memberPw").val().length < 4) {
			$("#memberPw").focus();
		} else if ($("#memberPw").val() != $("#memberPwCheck").val()) {
			$("#memberPwCheck").focus();
		} else {
			$("#memberForm").submit();
		}
	});
	
	$("#updateMemberBtn").click(function(e) {
		if ($("#uMemberPw").val().length < 4) {
			$("#uMemberPw").focus();
		} else if ($("#uMemberPw").val() != $("#uMemberPwCheck").val()) {
			$("#uMemberPwCheck").focus();
		} else {
			$("#uMemberForm").submit();
		}
	});
	
	//아래서 원래 사용하던 코드의 내용이중복되기때문에, 함수형태로 만들어줬다. 이건 나중에 keyup이벤트할때도 쓸것임!
	var memberSuccess = function(memberSuccessForm){
		memberSuccessForm.removeClass("text-danger");
		memberSuccessForm.removeClass("has-error");
		memberSuccessForm.find("span").removeClass("glyphicon glyphicon-remove-circle");
		memberSuccessForm.find("p").hide();
		memberSuccessForm.find("span").addClass("glyphicon glyphicon-ok");
		memberSuccessForm.addClass("text-success");
		memberSuccessForm.addClass("has-success");
	}
	
	var memberFail = function(memberFailForm){
		memberFailForm.removeClass("text-success");
		memberFailForm.removeClass("has-success");
		memberFailForm.find("span").removeClass("glyphicon glyphicon-ok");
		memberFailForm.addClass("text-danger");
		memberFailForm.addClass("has-error");
		memberFailForm.find("span").addClass("glyphicon glyphicon-remove-circle");
		memberFailForm.find("p").show();
	}
	var percentTotal=0;
	var percentId=0;
	var percentPw=0;
	var percentPwCheck=0;
	
	var percentMerge = function(){
		percentTotal = percentId+percentPw+percentPwCheck;
		$(".progress div").width(percentTotal+"%");
	}
	
	//ajax로 키를 누를때만다 해당 함수를 비동기호출하여, 리턴값을통해 아이디가 존재하는지 하지않는지를 추출하려고함.
	$("#memberId").keyup(function(){
		var memberCheckId = $("#memberId").val();
		var request = $.ajax({
			method : "POST"
			,url : "memberCheck"
			,dataType : "JSON"
			,data : { memberId : memberCheckId }
		});
		
		/* 일단 ajax로 보내고 리턴 받앗을때 처리해주는부분 */
		request.done( function(msg){
			$(".member-id span").show();
			if($("#memberId").val().length < 4){
				$(".member-id").find("p").text("아이디를 4자 이상 입력 해 주세요.");
				memberFail($(".member-id"));
				percentId = 0;
			} else if(msg.data == 1){
				$(".member-id").find("p").text("이미 존재하는 이름 입니다.");
				memberFail($(".member-id"));
				percentId = 0;
			} else{
				memberSuccess($(".member-id"));
				percentId = 33;
			}
			percentMerge();
		});
		
		/* 이건 실패했을때 */
		request.fail( function(){
		});
	});
	
	$("#memberPw").blur(function(){
		$(".member-pw span").show();
		if($("#memberPw").val().length < 4){
			memberFail($(".member-pw"));
			percentPw = 0;
		} else {
			memberSuccess($(".member-pw"));
			percentPw = 33;
		}
		percentMerge();
	});
	
	$("#memberPwCheck").blur(function(){
		$(".member-pw-check span").show();
		if(($("#memberPw").val() != $("#memberPwCheck").val()) || ($("#memberPwCheck").val().length < 4)){
			memberFail($(".member-pw-check"));
			percentPwCheck = 0;
		} else {
			memberSuccess($(".member-pw-check"));
			percentPwCheck = 34;
		}
		percentMerge();
	});
	
	$("#uMemberPw").blur(function(){
		$(".update-member-pw span").show();
		if($("#uMemberPw").val().length < 4){
			memberFail($(".update-member-pw"));
			percentPw = 0;
		} else {
			memberSuccess($(".update-member-pw"));
			percentPw = 50;
		}
		percentMerge();
	});
	
	$("#uMemberPwCheck").blur(function(){
		$(".update-member-pw-check span").show();
		if(($("#uMemberPw").val() != $("#uMemberPwCheck").val()) || ($("#uMemberPwCheck").val().length < 4)){
			memberFail($(".update-member-pw-check"));
			percentPwCheck = 0;
		} else {
			memberSuccess($(".update-member-pw-check"));
			percentPwCheck = 50;
		}
		percentMerge();
	});
	
	$("#checkAddr").click(function(){ 
		if($("#checkAddr").prop("checked")) {
			$("input[type=checkbox]").prop("checked",true);
		} else {
			$("input[type=checkbox]").prop("checked",false); 
		} 
	});
	
	$("#memberAddrBtn").click(function(){ 
		if($("#memberAddress").val().length < 1) {
			
		} else {
			console.log($("#memberAddrCount").val());
			if($("#memberAddrCount").val() >= 5){
				$("p").show();
			} else{
				$("p").hide();
				$("#memberAddrForm").submit();
			}
		}
	});
	
	$("#removeAddrBtn").click(function(){ 
		$(".form-check").attr("action", "removeMemberAddr.jk?memberNo=${param.memberNo}");
		$(".form-check").submit();
	});
	
 	var addressCount = $(".addressCount");
	var changeLink = $(".changeLink");
	for (var i = 0; i < addressCount.length; i++) {
		console.log(addressCount[i].value);
 		if(addressCount[i].value > 0 ){
 			$(changeLink[i]).attr('href','#');
		}
	}
	
	
	var myTimer = setTimeout(function() {
		$(this).closest("tr").removeClass("danger");
	}, 3000);
		
	$(".changeLink").click(function(){
		console.log($(this).attr("href"));
		if($(this).attr("href") == "#"){
			$(this).closest("tr").addClass("danger");
			myTimer();
			clearTimeout(myTimer);
		}
	});
	
	
});
</script>