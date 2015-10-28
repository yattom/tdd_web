package it
import geb.*

class IndexPage extends Page {
  static url = "http://localhost:8999/tdd_todo/index"

  static content = {
	  form { $("form") }
	  todo(required: false) { $("li.todo-item") }
	  todoText(required: false) { todo.$("span.todo") }
  }
  
  def 追加する(text) {
	  form.text = text
	  form.$("input", type: "submit").click()
  }

  def 完了する(text) {
	  def item = todo.filter(text: startsWith(text))
	  item.$('a', text: 'DONE').click()
  }
}
