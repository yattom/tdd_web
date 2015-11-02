package example;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.Theories;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class TodoTest {

	public static class Todo1件の場合 {
		private Todo todo;

		@Before
		public void setUp() {
			todo = new Todo();
		}

		@Test
		public void 先頭を取得できる() {
			todo.add("buy milk");
			assertThat(todo.first(), is("buy milk"));
		}

		@Test
		public void TODOを1件完了にできる() {
			todo.add("buy milk");
			todo.done("buy milk");
			assertThat(todo.left(), is(false));
		}

		@Test
		public void left_残ってる場合() {
			todo.add("buy milk");
			assertThat(todo.left(), is(true));
		}

	}

	public static class Todo2件の場合 {
		private Todo todo;

		@Before
		public void setUp() {
			todo = new Todo();
		}

		@Test
		public void 先頭を取得できる() {
			todo.add("buy milk");
			todo.add("walk dog");
			assertThat(todo.first(), is("buy milk"));
		}

		@Test
		public void すべて取得できる() {
			todo.add("buy milk");
			todo.add("walk dog");

			List<String> actual = todo.getAll();
			assertThat(actual, contains("buy milk", "walk dog"));
		}
	}

	public static class Todo0件の場合 {
		private Todo todo;

		@Before
		public void setUp() {
			todo = new Todo();
		}

		@Test
		public void testLeft() {
			assertThat(todo.left(), is(false));
		}
	}

	public static class 異常系 {
		private Todo todo;

		@Before
		public void setUp() {
			todo = new Todo();
		}

		@Test(expected = NullPointerException.class)
		public void TODOとしてnullを追加できない() {
			todo.add(null);
		}
	}
}
