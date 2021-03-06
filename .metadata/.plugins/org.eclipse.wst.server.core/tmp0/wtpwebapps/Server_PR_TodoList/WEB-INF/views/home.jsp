<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link href="${rootPath}"/>
<style>
form.v1 {
	width: 80%;
	margin: 10px auto;
}

form.v1 fieldset {
	border: 1px solid black;
	border-radius: 10px;
	padding: 5px
}

form.v1 input {
	display: inline-block;
	padding: 5px;
	margin: 5px;
}

form.v1 input {
	width: 300px;
	border: 1px solid black;
	border-radius: 5px;
}

form.v1 button {
	outline: 0;
	border: 0;
	width: 100px;
	color: white;
	padding: 5px;
}

form.v1  button {
	background-color: green;
}

form.v1 button:hover {
	box-shadow: 2px 2px 2px rgba(0, 0, 0, 0.3);
}
tr {

}
</style>
<script>
document.addEventListener("DOMContentLoaded",function() {
			document.querySelector("button.btn_save").addEventListener("click",function(ev) {
				let dom = document;
				let td_date = dom
						.querySelector("input[name='td_date']");
				let td_time = dom
						.querySelector("input[name='td_time']");
				let td_work = dom
						.querySelector("input[name='td_work']");
				let td_place = dom
						.querySelector("input[name='td_place']");
				
						if(td_date.value == "") {
							alert("날짜는 반드시 입력해야합니다");
							td_date.focus(); 
							return false;
						}
						if(td_time.value == ""){
							alert("시간은 반드시 입력해야합니다");
							td_time.focus()
							return false;
						}
						if(td_work.value == ""){
							alert("할일은 반드시 입력해야합니다");
							td_work.focus();
							return false;
						}
						
						alert("저장버튼" + td_date.value + "\n"
							+ td_time.value + "\n"
							+ td_work.value + "\n"
							+ td_place.value + "\n"
						)
						alert("저장")
						dom.querySelector("form.v1").submit();
						
			})
})

</script>
</head>
<body>
	<form action ="todo/insert" class="v1" method="POST" >
		<h1>TO DO LIST</h1>
		<fieldset>

			<div>
				<input name="td_date" type="date" placeholder="작성일자"
					value="${TD.td_date}">
				 <input name="td_time" type="time"
					placeholder="작성시각" value="${TD.td_time}">
			</div>

			<div>
				<input name="td_work" type="text" style="width: 1000px;"
					placeholder="할일" value="${TD.td_work}">
			</div>
			<div>
				<input name="td_place" type="text" placeholder="장소"
					value="${TD.td_place}"> <label></label>
				<button class="btn_save" type="button">추가</button>

			</div>
		</fieldset>
	</form>
	<table>
		<c:forEach items="${TDLIST}" var="TD">
		<tr>
			<td>${TD.td_num}</td>

			<td>${TD.td_work}</td>

			<td>${TD.td_date}</td>
			
			<td>${TD.td_time}</td>

			<td>${TD.td_place}</td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>