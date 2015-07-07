package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

@WebServlet("/addContactPost")
public class AddContactServletPost extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// get response writer
		PrintWriter out = resp.getWriter();
		
		// get request parameters
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		String birthString = req.getParameter("birth");

		Calendar birth = null;
		
		try {
			
			Date birthDate = new SimpleDateFormat("dd/MM/yyyy").parse(birthString);
			birth = Calendar.getInstance();
			birth.setTime(birthDate);
			
		} catch (Exception e) {
			out.println("Erro de conversão da data");
			return; // return ERROR message
		}
		
		Contato contato = new Contato();
		
		contato.setNome(name);
		contato.setEmail(email);
		contato.setEndereco(address);
		contato.setDataNascimento(birth);
		
		ContatoDAO dao = new ContatoDAO();
		dao.adiciona(contato);
		
		out.println("<html>");
		out.println("<body>");
		out.println("Contact " + contato.getNome() +
		" successfuly add!");
		out.println("</body>");
		out.println("</html>");
	}
}
