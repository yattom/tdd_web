package example;

public class Todo {

	private String todo;

	public String first() {
		return todo;
	}

	public void add(String string) {
		this.todo = string;
	}

	public void done(String string) {
		if(string.equals(todo)) {
			todo = null;
		}
	}

}
