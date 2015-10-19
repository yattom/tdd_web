package example;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

import org.hamcrest.core.IsNull;
import org.junit.Test;

public class TodoTest {

	@Test
	public void TODOを1件追加して取得できる() {
		Todo todo = new Todo();
		todo.add("buy milk");
		String actual = todo.first();
		assertThat(actual , is("buy milk"));
	}

	@Test
	public void TODOを1件完了にできる() {
		Todo todo = new Todo();
		todo.add("buy milk");
		todo.done("buy milk");
		String actual = todo.first();
		assertThat(actual, is(nullValue()));
	}
}
