<%@ include file="../common.jsp" %>

<body ng-app>
<div id="header">Header</div>
<div id="sidebar">
    <h1>
        <a href="index">User Index</a>
    </h1>

    <h1>
        <a href="add">Add User</a>
    </h1>

</div>
<div id="container">
    <div id="content">

        <div class="panel">
            <span class="">current we have <c:out value="${userCount}"></c:out> users;</span>
            <table class="dataTable">
                <thead>
                <th>id</th>
                <th>name</th>
                <th>address</th>
                <th>email</th>
                <th>dob</th>
                </thead>

                <tbody>
                <c:forEach items="${users}" var="u" varStatus="s">
                    <c:if test="${s.index %2 ==0}">
                        <tr class="odd">
                            <td>
                                    ${u.id}
                            </td>

                            <td>
                                    ${u.name}
                            </td>

                            <td>
                                    ${u.address}
                            </td>

                            <td>
                                    ${u.email}
                            </td>

                            <td>
                                <fmt:formatDate value="${u.dob}" pattern="yyyy-MM-dd"></fmt:formatDate>
                            </td>
                        </tr>
                    </c:if>

                    <c:if test="${s.index %2 !=0}">
                        <tr class="odd">
                            <td>
                                    ${u.id}
                            </td>

                            <td>
                                    ${u.name}
                            </td>

                            <td>
                                    ${u.address}
                            </td>

                            <td>
                                    ${u.email}
                            </td>

                            <td>
                                <fmt:formatDate value="${u.dob}" pattern="yyyy-MM-dd"></fmt:formatDate>
                            </td>
                        </tr>
                    </c:if>

                </c:forEach>

                </tbody>
            </table>
        </div>

    </div>

</div>

<div id="footer">copyright 2007-2012</div>
</body>
</html>