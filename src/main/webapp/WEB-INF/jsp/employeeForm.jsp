<%@ page isELIgnored ="false" session="false"%>

<%-- 
I have no idea why the tag library doesn't work but every other thing does 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>  --%>
<!DOCTYPE html>

<html lang="en">
  <head>
    <!-- 
      This is an HTML comment
      You can write text in a comment and the content won't be visible in the page
    -->

    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="icon" href="https://glitch.com/favicon.ico" />

    <!--
      This is the page head - it contains info the browser uses
      Like the title, which appears on the browser tab but not inside the page
      Further down you'll see the content that displays in the page
    -->
    <title>Hello World!</title>

    <!-- The website stylesheet -->
    <link rel="stylesheet" href="css/style.css"/>

    <!-- The website JavaScript file -->
    <script src="js/script.js" defer></script>
  </head>
  <body>
      <img class="fixed" src="https://us-tuna-sounds-images.voicemod.net/dfe00298-0efe-4ccb-a1c4-8b456326ccb2-1659033930989.jpg" alt="Zarcillos">
  
    <div class="test">
      <button class="btn--remix" id="1">Add Employee</button>
      <button class="btn--remix" id="2">Get Employee</button>
      <button class="btn--remix" id="3">Get All Employee</button>
      <button class="btn--remix" id="4">Update Employee</button>
      <button class="btn--remix" id="5">Delete Employee </button>
    </div>
    <!--
      The body includes the content you see in the page
      Each element is defined using tags, like this <div></div>
      The attributes like class="wrapper" let us style elements in the CSS
    -->
    <table class="" role="table" border="1" cellspacing="0" cellpadding="0" 
           summary="My Employees">
      <thead>
        <tr>
            <th colspan="4">Employee</th>
        </tr>
      <tr>
        <th scope="col">ID</th>
        <th scope="col">Salary</th>
        <th scope="col">FirstName</th>
        <th scope="col">LastName</th>
      </tr>
      </thead>
      
      <!-- For Future use
      var stuff = document.getElementsByTagName("tbody")[0]
    -->
      <tbody id="placement">
     
      <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
      </tr>
      
      </tbody>
    </table>
<form class="toggle" action="/save" >
  <div class="container" id="add">
    <h1>Add</h1>
    <p>Fill in details of Employee to add</p>
    <hr>

    <label for="Id"><b>Id</b></label>
    <input type="text" placeholder="Enter Employee ID" name="AddId" id="AddId">

    <label for="Salary"><b>Salary</b></label>
    <input type="text" placeholder="Enter Salary" name="AddSalary" id="AddSalary">

    <label for="FirstName"><b>FirstName</b></label>
    <input type="text" placeholder="Enter FirstName" name="AddFirstName" id="AddFirstName">
    
    <label for="LastName"><b>LastName</b></label>
    <input type="text" placeholder="Enter LastName" name="AddLastName" id="AddLastName">
    <hr>

    <button type="submit" class="submit" >Submit</button>
  </div>
</form>
<form class="toggle">
  <div class="container" id="get">
    <h1>Get</h1>
    <p>Fill in ID of Employee to get their information</p>
    <hr>
    <label for="Id"><b>Id</b></label>
    <input type="text" placeholder="Enter Employee ID" name="GetId" id="GetId">
    <hr>
    <button type="submit" class="submit">Submit</button>
  </div>
</form>
<script>

</script>
 <form class="toggle" action="/update">
  <div class="container" id="update">
    <h1>Update</h1>
    <p>Fill in updated details of Employee</p>
    <hr>

    <label for="Id"><b>Id</b></label>
    <input type="text" placeholder="Enter Employee ID" name="Id" id="Id">

    <label for="Salary"><b>Salary</b></label>
    <input type="text" placeholder="Enter Salary" name="Salary" id="Salary">

    <label for="FirstName"><b>FirstName</b></label>
    <input type="text" placeholder="Enter FirstName" name="FirstName" id="FirstName">
    
    <label for="LastName"><b>LastName</b></label>
    <input type="text" placeholder="Enter LastName" name="LastName" id="LastName">
    <hr>

    <button type="submit" class="submit">Submit</button>
  </div>
</form>
<form class="toggle" action="/delete">
  <div class="container" id="delete">
    <h1>Delete</h1>
    <p>Fill in ID of Employee to get their information</p>
    <hr>
    <label for="Id"><b>Id</b></label>
    <input type="text" placeholder="Enter Employee ID" name="DelId" id="DelId">
    <hr>
    <button type="submit" class="submit">Submit</button>
  </div>
</form>
    
  </body>
</html>