<%@page import="br.com.Univercode.WebStudy.domain.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="java.util.Date, java.text.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP - java scriptlet file</title>
</head>
<body>
	<% 

	class exercicio{
		public int fat(int i){
			if(i<2)
				return 1;
			return fat(i-1)*i;
		}
		public int fibo(int i){
			if(i<3)
				return 1;
			return fibo(i-1)+fibo(i-2);
		}
		public boolean primo(int i){
			int divisivelPor =0;
			for(int w = 1; w<= i; w++)
				divisivelPor+= (i%w == 0)? 1 : 0;
			return divisivelPor<3;
		}
		public String placa(String placa){
			int dia = Integer.parseInt(""+placa.charAt(7));
			return (dia == 1 || dia == 2)? "seg" : 
				
				(dia == 3 || dia == 4)?  "ter" : 
								
				(dia == 5 || dia == 6)? "qua" :
					
				(dia == 7 || dia == 8)? "qui" :  "sex";
				
		}
	}
	
	out.println("<h1> fatorial de 4 = "+new exercicio().fat(5)+"</h1>");
	out.println("<h1> fibo de 10 = "+new exercicio().fibo(10)+"</h1>");
	out.println("<h1> 3 eh primo? = "+(new exercicio().primo(3)? "sim" : "nao")+"</h1>");
	out.println("<h1> abc-0000 eh que rodizio = "+new exercicio().placa("abc-0000")+"</h1>");
	
%>
	MEUS USUARIOS
	<table>
		<tr>
			<th>name</th>
		</tr>
		<tr>
			<% 
if(request.getAttribute("usuarios") != null){
ArrayList<User> usuarios = (ArrayList<User>)request.getAttribute("usuarios");
for(User a : usuarios){
	out.print("<td>"+a.getLogin()+"</td>");
}
	
}

%>
		</tr>
	</table>

</body>
</html>