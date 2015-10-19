package example;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class TodoTest {

	@Test
	public void TODOを1件追加して取得できる() {
		Todo todo = new Todo();
		todo.add("buy milk");
		String actual = todo.first();
		assertThat(actual , is("buy milk"));
	}

}
