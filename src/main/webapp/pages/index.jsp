<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Report Generator</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" 
    integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
  </head>
  <body>
  
    <div class="container text-bg-light p-3 mt-3">
       <h1 class="pt-3 pb-3">Report Generator Application</h1>
       
         <form:form action="searchData" method="post" modelAttribute="search">
         
           <table>
                 <tr>
                    <td>Plan Name :</td>
                     <td>
                     <form:select path="planName">
                    <form:option value="" label="--Select--"/>
                    <form:options items="${plans}"/> 
                     </form:select>
                    </td>
                    
                     <td>Plan Status :</td>
                     <td>
                     <form:select path="planStatus">
                    <form:option value="" label="--Select--"/>
                    <form:options items="${status}" /> 
                     </form:select>
                    </td>
                    
                     <td>Gender :</td>
                     <td>
                     <form:select path="gender">
                    <form:option value="" label="--Select--"/>
                     <form:option value="Male" label="Male"/>
                      <form:option value="FeMale" label="FeMale"/>
                     </form:select>
                    </td>
                 </tr>
                 
                 <tr>
                      <td>Plan Start Date :</td>
                      <td><form:input path="planStartDate" type="date"/></td>
                      
                       <td>Plan End Date :</td>
                      <td><form:input path="planEndDate" type="date"/></td>
                 </tr>
                 
                 <tr>
                      <td><a href="./" class="btn btn-outline-danger mt-3">clear</a></td>
                      <td><input type="submit" value="search" class="btn btn-outline-success mt-3"></td>
                 </tr>
           </table>
         </form:form>
         
         <hr>
          <table class="table table-striped table-hover">
                  <tr>
                  <th>SN</th> <th>Name</th> <th>Gender</th> <th>Plan Name</th> <th>Plan Start Date </th> <th>Status</th> <th>Plan End Date</th> <th>Benefit Amount</th> 
                  </tr>
                  <tr>
                  <c:if test="${empty citizens}">
                     <td colspan="8" align="center">Citizen plan list is empty</td>
                   
                  </c:if>   
                  </tr>
                  <c:forEach var="citizen" items="${citizens}" varStatus="it">
                  <tr>
                   <td>${it.count }</td><td>${citizen.citizenName }</td> <td>${citizen.citizenGender }</td><td>${citizen.planName }</td> 
                   <td>${citizen.planStartDate }</td><td>${citizen.planStatus }</td><td>${citizen.planEndDate }</td><td>${citizen.benefitAmount }</td>
                   </tr>
                   </c:forEach>
                  
          </table>
         <hr>
         Generate Report : <a href="getExcel" class="btn btn-outline-success"><i class="bi bi-file-earmark-excel-fill"></i>Excel</a> <a href="getPdf" class="btn btn-outline-danger"><i class="bi bi-file-pdf"></i>PDF</a>
    </div>
   
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
  </body>
</html>