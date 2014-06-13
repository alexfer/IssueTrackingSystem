<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="segment" value="user"></c:set>
    <!DOCTYPE html>
    <html lang="en-US">
    <%@include file="partial/head.jspf" %>
    <body>
        <%@include file="partial/navbar.jspf" %>
        <div class="container" id="container">
            <c:choose>
                <c:when test="${!empty users}">
                    <h1>Users</h1>
                    <table class="table">
                        <tr>
                            <th>ID</th>
                            <th>Email</th>
                            <th>Created At</th>
                            <th>Updated At</th>
                            <th>Actions</th>
                        </tr>
                        <c:forEach var="user" items="${users}">
                            <tr>
                                <td><c:out value="${user.getId()}"></c:out></td>
                                <td><c:out value="${user.getEmail()}"></c:out></td>
                                <td><c:out value="${user.getCreatedAt()}"></c:out></td>
                                <td><c:out value="${user.getUpdatedAt()}"></c:out></td>
                                <td><a href="/user/${user.getId()}">Edit</a> <a class="delete-user" data-id="${user.getId()}" href="#">Delete</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:when>
                <c:otherwise>
                    <c:choose>
                        <c:when test="${!empty user.id}">
                            <c:set var="action" value="edit"></c:set>
                        </c:when>
                        <c:otherwise>
                            <c:set var="action" value="new"></c:set>
                        </c:otherwise>
                    </c:choose>
                    <form method="POST" name="<c:out value="${action}-user"></c:out>" id="<c:out value="${action}-user"></c:out>" action="/users">
                        <legend><c:out value="${action}"></c:out> User</legend>
                            <div class="alert"></div>
                            <div class="row">
                                <div class="form-group col-xs-4">
                                    <label for="email">Email:</label>
                                    <input id="email" class="form-control" type="text" value="${user.email}" placeholder="Email" name="email">
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-xs-4">
                                <label for="password">Password:</label>
                                <input id="password" class="form-control" type="password" value="" placeholder="Password" name="password">
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-xs-4">
                                <button class="btn btn-primary" type="submit">Save</button>
                                <button class="btn btn-default cancel" type="button">Cancel</button>
                            </div>
                        </div>
                    </form>
                </c:otherwise>
            </c:choose>
        </div>
        <%@include file="partial/scripts.jspf" %>
    </body>
</html>
