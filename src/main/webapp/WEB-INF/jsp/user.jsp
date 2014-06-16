<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                    <div class="table-responsive">
                        <table class="table table-striped table-hover table-bordered">
                            <thead>
                                <tr>
                                    <th class="text-center">ID</th>
                                    <th>Email</th>
                                    <th>Created At</th>
                                    <th>Updated At</th>
                                    <th class="text-center">Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="user" items="${users}">
                                    <tr>
                                        <td class="text-center"><c:out value="${user.getId()}"></c:out></td>
                                        <td><a href="mailto:<c:out value="${user.getEmail()}"></c:out>"><c:out value="${user.getEmail()}"></c:out></a></td>
                                        <td><fmt:formatDate value="${user.getCreatedAt()}" pattern="yyyy-MM-dd HH:mm" /></td>
                                        <td><fmt:formatDate value="${user.getUpdatedAt()}" pattern="yyyy-MM-dd HH:mm" /></td>
                                        <td class="text-center">
                                            <a class="btn btn-default btn-xs" href="/user/${user.getId()}" role="button"><i class="glyphicon glyphicon-pencil"></i> Edit</a> 
                                            <a class="delete-user btn btn-default btn-xs" data-id="${user.getId()}" href="#" role="button"><i class="glyphicon glyphicon-trash"></i> Delete</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
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
