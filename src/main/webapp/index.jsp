<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <link href="<c:url value="/main.css"/>" rel="stylesheet" type="text/css"/>
  <title>OAuth2 Example Client</title>
</head>
<body>
<div id="container">

    <ul id="mainlinks">
      <li><a href="<c:url value="/index.jsp"/>" class="selected">home</a></li>
      <authz:authorize ifNotGranted="ROLE_USER">
        <li><a href="<c:url value="/login.jsp"/>">login</a></li>
      </authz:authorize>
      <li><a href="<c:url value="/account"/>">account</a></li>
    </ul>

  <div id="content">
    <h1>Welcome to Tonr.com!</h1>
    
    <p>
      This demonstrates how to use an external OAuth provider for authentication
      &amp; how to retrieve user details from the OAuth provider. 
    </p>

    <p>Tonr.com has only two users: "marissa" and "sam".  The password for "marissa" is password is "wombat" and for "sam" is password is "kangaroo".</p>

    <authz:authorize ifNotGranted="ROLE_USER">
      <p><a href="<c:url value="login.jsp"/>">Login to Tonr</a></p>
    </authz:authorize>
    <authz:authorize ifAllGranted="ROLE_USER">
      <p><a href="<c:url value="/account"/>">View my account</a></p>
    </authz:authorize>
  </div>
</div>
</body>
</html>