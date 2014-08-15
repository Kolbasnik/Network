<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>Многократное использование JavaBeans в JSP</TITLE>
<LINK REL=STYLESHEET
      HREF="My-Style-Sheet.css"
      TYPE="text/css">
</HEAD>

<BODY>

<CENTER>
<TABLE BORDER=5>
  <TR><TH CLASS="TITLE">
      Multy using JavaBeans with JSP</TABLE>
</CENTER>
<P>


             
<jsp:useBean id="test" class="org.hillel.it.network.serviceImpl.SimpleBean" />

<jsp:setProperty name="test" 
                 property="message" 
                 value="Hi2All" />
                          
<H1>Message: <I>
<jsp:getProperty name="test" property="message" />
</I></H1>
             
</BODY>
</HTML>