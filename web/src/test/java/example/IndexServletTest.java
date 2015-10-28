package example;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;

public class IndexServletTest {
	private IndexServlet sut;
	private HttpServletRequest request;
	private HttpServletResponse response;

	@Before
	public void setUp() {
		sut = new IndexServlet();
		request = mock(HttpServletRequest.class, RETURNS_DEEP_STUBS);
		response = mock(HttpServletResponse.class);
	}

	@Test
	public void testDoGet_1件ある場合() throws ServletException, IOException {
		prepareTodo("buy milk");
		sut.doGet(request, response);
		verify(request).setAttribute("todos", stringList("buy milk"));
	}

	@Test
	public void testDoGet_2件ある場合() throws ServletException, IOException {
		prepareTodo("buy milk", "walk dog");
		sut.doGet(request, response);
		verify(request).setAttribute("todos",
				stringList("buy milk", "walk dog"));
	}

	private List<String> stringList(String... s) {
		List<String> expectedTodos;
		expectedTodos = Arrays.asList(s);
		return expectedTodos;
	}

	@Test
	public void testDoGet_1件もない場合() throws ServletException, IOException {
		when(request.getSession().getAttribute("example.todo"))
				.thenReturn(null);
		sut.doGet(request, response);
		verify(request).setAttribute("todos", stringList());
	}

	@Test
	public void testDoGet_1件あってnullの場合() throws ServletException, IOException {
		prepareTodo((String) null);
		sut.doGet(request, response);
		verify(request).setAttribute("todos", stringList());
	}

	private void prepareTodo(String... s) {
		Todo todo = new Todo();
		for (int i = 0; i < s.length; i++) {
			todo.add(s[i]);
		}
		when(request.getSession().getAttribute("example.todo"))
				.thenReturn(todo);
	}

}
