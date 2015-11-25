package example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    	Todo todo = (Todo)request.getSession().getAttribute("example.todo");
    	if(todo == null || todo.getFirst() == null) {
        	request.setAttribute("todos", new ArrayList<>());
    	} else {
    		String text = todo.getFirst().getLabel();
    		if(text != null) {
				throw new RuntimeException();
//	    		List<String> todos = todo.getAll();
//	    		request.setAttribute("todos", todos);
    		}
    	}
        request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
    }
}

