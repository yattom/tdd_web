package example;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/create")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Todo todo = (Todo) request.getSession().getAttribute("example.todo");
		if (todo == null) {
			todo = new Todo();
			request.getSession().setAttribute("example.todo", todo);
		}
		todo.add(request.getParameter("text"));
		response.sendRedirect("index");
	}
}
