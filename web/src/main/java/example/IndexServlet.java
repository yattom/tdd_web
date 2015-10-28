package example;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		storeTodos(request, getTodo(request).getAll());
		request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request,
				response);
	}

	private Todo getTodo(HttpServletRequest request) {
		Todo todo = (Todo) request.getSession().getAttribute("example.todo");
		assert todo != null;
		return todo;
	}

	private void storeTodos(HttpServletRequest request, List<String> todos) {
		request.setAttribute("todos", todos);
	}
}
