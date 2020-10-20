<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#">Shop</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <%
                HttpSession sessions = request.getSession();
                PriorityQueue<String> pq = (PriorityQueue<String>) sessions.getAttribute("categories");
                String clas = "";
                for(String ss : pq)
                {
            %>
                    <li class="nav-item"><a class="nav-link <%=clas%>" href="${pageContext.servletContext.contextPath}/jsp/<%=ss%>.jsp"><%=ss%></a></li>
            <%
                }
            %>
        </ul>
        <div class="navbar-nav form-inline d-flex justify-content-end" style="width: 100%">
            <li><a href="#"><span class="glyphicon glyphicon-user"></span>
                <%Cookie[] cc = request.getCookies();
                    for(Cookie cs : cc)
                    {
                        if(cs.getName().equals("login"))
                        {
                            out.println(cs.getValue());
                        }
                    }
                %>
            </a>
            </li>
            <li class="nav-item">
                <form action="${pageContext.request.contextPath }/logout" method="post" style="display: flex; flex-direction: row; justify-content: space-between;">
                    <span class="glyphicon glyphicon-log-in"></span>
                    <input type="submit" name="logout" class="" value="LogOut">
                </form>
            </li>
        </div>
    </div>
</nav>
