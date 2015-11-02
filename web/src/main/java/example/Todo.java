package example;

import java.util.ArrayList;
import java.util.List;

public class Todo {

	private List<String> todo;
	
	public Todo() {
		todo = new ArrayList<>();
	}

	public String first() {
		String first = todo.get(0);
		assert first != null;
		return first;
	}

	public void add(String string) {
		if(string == null) {
			throw new NullPointerException();
		}
		this.todo.add(string);
	}

	public void done(String string) {
		todo.remove(string);
	}

	public boolean left() {
		return !todo.isEmpty();
	}

	public List<String> getAll() {
		return todo;
	}

}
