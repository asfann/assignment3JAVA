<%@include file="jsp/header.jsp"%>

<div class="container">
    <div class="row">
        <h1 class="col-md-11 text-center" style="border-bottom: 3px solid black;">Authorization</h1>
        <br><br><br>
      <div class="col-md-4 login-form">
          <h4>${msg}</h4>
        <form action="login" method="post">
          <div class="form-group">
              <h5><label for="email">Email</label></h5>
            <input type="email" class="form-control" id="email" name="email" placeholder="Email">
          </div>
          <div class="form-group">
              <h5><label for="pass">Password</label></h5>
            <input type="password" class="form-control" id="pass" placeholder="Password" name="pass">
          </div>

          <button type="submit" class="btn btn-primary" id="submitbtn">Sign in</button>
        </form>

      </div>

        <div class="col-md-3">
            <hr><br><hr><br><hr><br><hr><br>
        </div>

    <div class="col-md-4 reg-form">
        <h4>${msgreg}</h4>
      <form action="register" method="post">
        <div class="form-group">
            <h5><label for="fname">First name</label></h5>
          <input type="text" class="form-control" id="fname" name="fname" placeholder="First Name">
        </div>
        <div class="form-group">
            <h5><label for="lname">Last name</label></h5>
          <input type="text" class="form-control" id="lname" placeholder="Last Name" name="lname">
        </div>
        <div class="form-group">
            <h5><label for="emailreg">Email address</label></h5>
          <input type="email" class="form-control" id="emailreg" placeholder="Email" name="emailreg">
        </div>
        <div class="form-group">
            <h5><label for="passreg">Password</label></h5>
            <p>
                It should contain uppercase and lowercase letters and digits
                and its length must be more than 9 symbols
            </p>
          <input type="password" class="form-control" id="passreg" placeholder="Password" name="passreg">
        </div>

        <button type="submit" class="btn btn-primary" id="submitbtn2">Sign up</button>
      </form>

    </div>
  </div>
</div>


  <%@include file="jsp/footer.jps.jsp"%>
