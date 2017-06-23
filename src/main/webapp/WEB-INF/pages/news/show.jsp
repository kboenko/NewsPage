<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/news.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.css"/>">
        <script type="text/javascript" src="<c:url value="/resources/js/bootstrap.js" /> "></script>
</head>
<body>
<form:form action="back" method="get" modelAttribute="news">
        <table border="0">
                <tr>
                        <td ><div class="newsHead"><h1>${news.head}</h1></div></td>
                </tr>
        <tr>
                <td ><div class="newsDate">${news.date}</div></td>
        </tr>
        <tr>
                <td><div class="newsBody">${news.body}</div></td>
        </tr>
        <tr>
                <td><div class="picHead"><spring:message code="picture.head" /></div>
                        <div class="newsPic"><img src="/picture/${news.id}" id="myImg"></div>
                </td>
        </tr>
        <tr>
                <td><div class="newsBack"><button type="submit"><spring:message code="button.back" /></button></div></td>
        </tr>

        </table>

        <div id="myModal" class="modal">
                <span class="close" onclick="document.getElementById('myModal').style.display='none'">&times;</span>
                <img class="modal-content" id="img01">
                <div id="caption"></div>
        </div>

</form:form>

<script>
        var modal = document.getElementById('myModal');

        var img = document.getElementById('myImg');
        var modalImg = document.getElementById("img01");
        var captionText = document.getElementById("caption");
        img.onclick = function(){
                modal.style.display = "block";
                modalImg.src = this.src;
                captionText.innerHTML = this.alt;
        };

        var span = document.getElementsByClassName("close")[0];

        span.onclick = function() {
                modal.style.display = "none";
        }
</script>

</body>
</html>
