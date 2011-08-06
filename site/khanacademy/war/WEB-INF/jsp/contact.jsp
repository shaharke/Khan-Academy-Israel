<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>Khan Academy Israel</title>

<link rel="stylesheet" type="text/css" href="/files/css/main.css"
	media="all" />
<link rel="stylesheet" type="text/css" href="/files/css/layout.css"
	media="all" />

<script type="text/javascript"
	src="https://www.google.com/jsapi?key=ABQIAAAAO3wpC0uwj5Q1sMGWhHs7LxSpY6j3JegbGxS1auK978Lba2TfJRR_ua4aguukER9HuzxBWfAJIF5Yzg"></script>


<!-- 
<script type="text/javascript">
	google.load("jquery", "1.6.2");

	google.setOnLoadCallback(OnLoad);

	function OnLoad() {
		var status = $('#status').val();
		if (status) {
			var message = $('#statusMessage').css('color', 'green');
		} else {
			var message = $('#statusMessage').css('color', 'red');
		}
	}
</script>
 -->
</head>

<body>
	<div class="wrapper">
		<jsp:include page="nojs.jsp" />
		<!-- HEADER -->
		<jsp:include page="header.jsp"></jsp:include>
		<!-- MAIN -->
		<div class="main">
			<h2>דעתכם חשובה לנו!</h2>
			<span>מורים, הורים, תלמידים או סתם אנשים שאיכפת להם - דעתכם
				חשובה לנו. נשמח אם תיצרו עימנו קשר בכל נושא ועניין:</span>
			<form:form acceptCharset="UTF-8" method="POST" commandName="feedback">
				<div class="feedback_form" style="width: 500px">
					<table>
						<tr>
							<td style="vertical-align: top">שם:<span
								class="mandatory_field_asterix"> * </span></td>
							<td>
								<div>
									<form:input path="name" />
									<br>
									<form:errors path="name" cssClass="error" />
								</div></td>
						</tr>
						<tr>
							<td style="vertical-align: top">כתובת מייל:</td>
							<td><form:input path="email" />
							</td>
						</tr>
						<tr>
							<td style="vertical-align: top">נושא:<span
								class="mandatory_field_asterix"> * </span></td>
							<td>
								<div>
									<form:input path="subject" />
									<br>
									<form:errors path="subject" cssClass="error" />
								</div></td>
						</tr>
						<tr>
							<td>הודעה:<span class="mandatory_field_asterix"> * </span></td>
							<td><div>
									<form:textarea path="message" cssClass="message_area" />
									<br>
									<form:errors path="message" cssClass="error" />
								</div>
							</td>
						</tr>
						<tr>
							<td></td>
							<td><div>
									<input type="submit" value="שלח" class="submit_feedback_button" />
									<c:choose>
										<c:when test="${status.success}">
											<label id="statusMessage" style="color:green">${status.message}</label> 
									</c:when>
									<c:otherwise>
										<label id="statusMessage" style="color:red">${status.message}</label>
									</c:otherwise>
									</c:choose>
								</div></td>
						</tr>
					</table>
					<br> <span>שדות המסומנים ב-<span
						class="mandatory_field_asterix">*</span> הינם שדות חובה.</span>
				</div>
			</form:form>
		</div>
		<!-- FOOTER -->
		<jsp:include page="footer.jsp"></jsp:include>

	</div>

</body>
</html>
