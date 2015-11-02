package example;

import java.util.ArrayList;
import java.util.List;

public class Todo {

	private List<String> todo = new ArrayList<String>();

	public String getFirst() {
		if (todo.size() == 0) {
			return null;
		}
		return todo.get(0);
	}

	public void add(String string) {
		this.todo.add(string);
	}

	public void done(String string) {
		for (int i = 0; i < todo.size(); i++) {
			if (todo.get(i).equals(string)) {
				todo.remove(i);
				return;
			}
		}
	}

	public List<String> getAll() {
		return new ArrayList<>(todo);
	}
}
