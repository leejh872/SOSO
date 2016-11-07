<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="n" uri="http://www.newlecture.com/jsp/tags/control"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%List myphotolist =  (List)request.getAttribute("MYPHOTO_LIST"); %>	

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/SosoMain.css" type="text/css" rel="stylesheet" />
</head>

<body>
   <!-- --------------------header-------------------- -->
   <header> 
   <div class="content-container">
      <h1><a href="main" class="link">SOSOHEA</a></h1>
         <section id="menu">
            <section>
                  <form id="search">
                       <input value="" /> 
                       <input type="submit" value="검색" />
                  </form>
              </section>
            <nav id="main-menu" class="h-menu">
               <ul>
                  <li><a href="user" class="link">JOIN/LOGIN</a></li>
                  <li><a href="mypage" class="link">MY PAGE</a></li>
                  <li><a href="aboutus" class="link">ABOUT US</a></li>
               </ul>
            </nav>
         </section>
      </div>
   </header>
   <!-- --------------------visual-------------------- -->
   <div id="visual">
     
		

	</div>
    </div>
   <!-- --------------------main-------------------- -->
	<main>
		<div class="content-container">
				
	<div id="myphoto" class="left">${n.myphoto}</div>
	<%for (int i = 0 ; i < myphotolist.size() ; i ++) { %>
			<a href="detail?code=1"><img src= "../images/<%=myphotolist.get(i) %>" width="300" height="300"/></a> 
		<%}%>

		</div>
	</main>
	<!-- --------------------footer-------------------- -->
   <footer id="footer">
      <div class="content-container">
         <dl class="soso">
            <dt class="dt">CREATED BY SOSOHEA</dt>
         </dl>
         <button type="button" name="upload" class="upload_button" ><a href="reg" class="link">UPLOAD</a></button>
      </div>
   </footer>
</body>
</html>