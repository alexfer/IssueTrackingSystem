<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <c:set var="title" value="404 - Page Not Found"></c:set>
    <%@include file="../partial/head.jspf" %>
    <body>
        <%@include file="../partial/navbar.jspf" %>
        <div class="container" id="container">
            <h1>404</h1>
            <p>Page Not Found</p>
        </div>
        <%@include file="../partial/scripts.jspf" %>        
    </body>
</html>
