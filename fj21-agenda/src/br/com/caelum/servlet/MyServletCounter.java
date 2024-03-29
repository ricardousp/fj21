package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/myServletCounter")
public class MyServletCounter extends HttpServlet {
	int counter;
	public MyServletCounter() {
		counter = 1;
	}
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		log("Iniciando a servlet");
		counter++;
	}
	public void destroy() {
		super.destroy();
		log("Destruindo a servlet");
		counter++;
	}
	protected void service(HttpServletRequest request,
			HttpServletResponse response)
					throws IOException, ServletException {
		//código do seu método service
		PrintWriter out = response.getWriter();
		// escreve o texto
		counter++; 
		out.println("<html>");
		out.println("<body>");
		out.println("Servlet called "+counter+" times!");
		out.println("</body>");
		out.println("</html>");
	}
}