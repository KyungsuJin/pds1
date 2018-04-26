<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> <!-- getNoticeList 에 jsp 관련 주석은 거의 다 달아놓았음. -->
	<jsp:include page="header.jsp"></jsp:include><!-- header 가져와 쓴다  -->
</head>
<body>
	<jsp:include page="body.jsp"></jsp:include><!-- body가져와쓴다. -->
	<form action="${pageContext.request.contextPath}/addNotice" method="post" enctype="multipart/form-data">
	<!-- action 태그는 무언가를 액션 말그대로 싱행 혹은 움직이게하는 태그로 알고있다. 검색해보니 한가지의 일을 하는게 아니고 여러가지 일을 하는것 같아서 좀더 자세히 봐야겠다. -->
	<!-- enctype="multipart/form-data" 라는 부분을 적어야 이름만 넘어가는게 아니고 값도 같이 넘어가서 적어야되고  총 디폴트 ,
	application/www-form-urlencoded 디폴트 형식이고,  multipart/form-data 파일 등을 넘길때는 이런 형식을쓴다. text/plain 인코딩을 하지 않은 형태일떄는
	이런 방식을 쓴다고 나와있었다. 참조한 주소는 이곳이다. http://tibang.tistory.com/entry/form%ED%83%9C%EA%B7%B8%EC%9D%98-enctype-%EC%86%8D%EC%84%B1
 -->
	
		<div>noticeTitle : <input type="text" name="noticeTitle"> </div>
		<!-- input type 이 text 타입이다.
		id 와 name 으로 구분해서 쓰는 이유가 궁금해서 검색 과 문기에게 질문을 해 보았는데,
		id는 일단 중복이 안되고 name은 중복이된다. value 나 length를 사용할떄 name이 같아도 뒤에 배열[0]을 써줘야 뒤에 배열에 따라서 정렬이 되서 구분이 된다고한다. -->
		<div>noticeContent : <input type="text" name="noticeContent"> </div>
		<!-- 이하동문 -->
		<div>noticeTitle : <input multiple="multiple" type="file" name="multipartFile"> </div>
		<!-- 파일을 배열형식으로 사용해서 여러개 넣기 위해서 multiple="multiple"부분을 해줬다고경수에게 설명을 들었음. -->
		
	</form> 
</body>
</html>