<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="n" uri="http://www.newlecture.com/jsp/tags/control"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AboutUs Page</title>
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
         <div class="content-container"></div>
    </div>
   <!-- --------------------main-------------------- -->
   <div id="body">
      <div class="content-container clearfix">
         <aside id="aside">
               <dl>
                  <dt>안녕하세요,</dt>
                  <dt>‘소소해’는 사진 기반의 익명 SNS 입니다. </dt>
                  <dt>.</dt>
                  <dt>건의사항 및 문의사항은</dt>
                  <dt>아래 이메일로 보내주세요 :)</dt>
                  <dt>.</dt>
                  <dt>qkshdls@gmail.com</dt>
               </dl>
         </aside>
         <main> 
            <div class="content-container">
               
               <img src="../images/1160820780_59.jpg" width="500" height="500"/>
            </div>
         </main>
      </div>
   </div>
   
   <!-- --------------------footer-------------------- -->
   <footer id="footer">
      <div class="content-container">
         <dl class="soso">
            <dt class="dt">CREATED BY SOSOHEA</dt>
         </dl>
         <button type="button" name="upload" class="upload_button" ><a href="upload" class="link">UPLOAD</a></button>
      </div>
   </footer>
</body>
</html>