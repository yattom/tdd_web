package example;

import java.util.ArrayList;
import java.util.List;

public class Todo {

	private List<String> todo;
	
	public Todo() {
		todo = new ArrayList<>();
	}

	public String first() {
		return todo.get(0);
	}

	public void add(String string) {
		this.todo.add(string);
	}

	public void done(String string) {
		todo.remove(string);
	}

	public boolean left() {
		return todo.isEmpty();
	}

	public List<String> getAll() {
		return todo;
	}

}
