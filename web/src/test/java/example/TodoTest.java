package example;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

public class TodoTest {

	@Test
	public void TODOを1件追加して取得できる() {
		Todo todo = new Todo();
		todo.add("buy milk");
		assertThat(todo.first(), is("buy milk"));
	}

	@Test
	public void TODOを2件追加して取得できる() {
		Todo todo = new Todo();
		todo.add("buy milk");
		todo.add("walk dog");
		assertThat(todo.first(), is("buy milk"));
	}
	
	@Test(expected=NullPointerException.class)
	public void TODOとしてnullを追加できない() {
		Todo todo = new Todo();
		todo.add(null);
	}

	@Test
	public void TODOを1件完了にできる() {
		Todo todo = new Todo();
		todo.add("buy milk");
		todo.done("buy milk");
		assertThat(todo.left(), is(true));
	}

	@Test
	public void empty_残っている場合() {
		Todo todo = new Todo();
		assertThat(todo.left(), is(true));
	}

	@Test
	public void empty_残ってない場合() {
		Todo todo = new Todo();
		todo.add("buy milk");
		assertThat(todo.left(), is(false));
	}

	@Test
	public void すべて取得できる() {
		Todo todo = new Todo();
		todo.add("buy milk");
		todo.add("walk dog");

		List<String> actual = todo.getAll();
		assertThat(actual, contains("buy milk", "walk dog"));
	}
}
