<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
  <title>List Customers</title>
  <!--Reference our style sheet-->

  <link type="text/css"
  rel="stylesheet"
  href="${pageContext.request.contextPath}/resources/static/css/style.css"/>
</head>

<body>
List Customers - coming soon...

<div id="wrapper">
  <div id="header">
    <h2>CRM - Customer Relationship Manager</h2>
  </div>
</div>

<div id="container">
  <div id="content">

    <!-- put new button: Add Customer  -->
    <input type="button" value="Add Customer"
    onclick="window.location.href='showFormForAdd'; return false;"
    class="add-button"/>

<!--Add our html table here -->

    <table>

      <tr>
        <th>First Name</th>
        <p>

        </p>
        <th>Last Name</th>
        <p>

        </p>
        <th>Email Name</th>
      </tr>

      <!--Loop over and print our customers -->
      <c:forEach var="tempCustomer" items="${customerList}">
          <tr>
            <td>
              ${tempCustomer.firstName}
            </td>

            <td>
              ${tempCustomer.lastName}
            </td>

            <td>
              ${tempCustomer.email}
            </td>
          </tr>
      </c:forEach>

    </table>

  </div>
</div>


</body>
</html>