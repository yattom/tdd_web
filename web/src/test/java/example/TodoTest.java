package example;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TodoTest {

	private static final String BUY_BREAD = "buy bread";
	private static final String BUY_MILK = "buy milk";
	private Todo todo;

	@Before
	public void setUp() {
		todo = new Todo();
	}

	@Test
	public void TODOを1件追加して取得できる() {
		todo.add(BUY_MILK);
		assertThat(todo.getFirst(), is(BUY_MILK));
	}

	@Test
	public void TODOを1件完了にできる() {
		todo.add(BUY_MILK);
		todo.done(BUY_MILK);
		assertThat(todo.getFirst(), is(nullValue()));
	}

	@Test
	public void TODOを2件追加して取得できる() {
		todo.add(BUY_MILK);
		todo.add(BUY_BREAD);
		assertThat(todo.getFirst(), is(BUY_MILK));
	}

	@Test
	public void TODOを全て取得できる() {
		todo.add(BUY_MILK);
		todo.add(BUY_BREAD);
		assertThat(todo.getAll(), contains(BUY_MILK, BUY_BREAD));
	}

	@Test
	public void TODOを外部から変更できない() {
		todo.add(BUY_MILK);
		todo.getAll().set(0, BUY_BREAD);
		assertThat(todo.getFirst(), is(BUY_MILK));
	}
}
