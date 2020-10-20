<%@include file="jsp/header.jsp"%>

<%
    String e;
    String asd = (String) request.getAttribute("err");
    if(asd.equals("err"))
    {
        e = "Go back to form";
    }
    else
    {
        e = "Log out";
    }
%>

<div class="container container-login">
    <div class="row">
        <div class="col-md-4">
            <form action="logout" method="get">
                <div class="form-group">
                    <h2>${msg}</h2>
                </div>

                <input type="text" style="display: none" readonly name="err" value="<%=e%>">

                <div class="form-group">
                    <button type="submit" class="btn btn-primary" id="submitbtn"><%=e%></button>
                </div>
            </form>
        </div>

    </div>
</div>
<%@include file="jsp/footer.jps.jsp"%>
