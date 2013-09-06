package example;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/create")
public class ToDoCreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String todoTitle = request.getParameter("todoTitle");
        request.setAttribute("todoTitle", todoTitle);
        request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
    }
}

