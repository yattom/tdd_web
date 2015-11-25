package example;

import java.util.ArrayList;
import java.util.List;

public class Todo {

	public static class TodoEntry {
		private String label;
		public TodoEntry(String label) {
			if(label.trim().length() == 0 ) {
				throw new IllegalArgumentException("Enter TODO");
			}
			this.label = label;
		}

		public String getLabel() {
			return label;
		}
	}

	private List<TodoEntry> todo = new ArrayList<>();

	public TodoEntry getFirst() {
		if (todo.size() == 0) {
			return null;
		}
		return todo.get(0);
	}

	public void add(TodoEntry entry) {
		if(entry.label.trim().length() == 0 ) {
			throw new IllegalArgumentException("Enter TODO");
		}
		this.todo.add(entry);
	}

	public void done(String string) {
		for (int i = 0; i < todo.size(); i++) {
			if (todo.get(i).label.equals(string)) {
				todo.remove(i);
				return;
			}
		}
	}

	public List<TodoEntry> getAll() {
		return new ArrayList<>(todo);
	}
}
