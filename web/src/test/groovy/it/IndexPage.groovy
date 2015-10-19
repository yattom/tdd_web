package it
import geb.*

class IndexPage extends Page {
  static url = "http://localhost:8999/tdd_todo/index"

  static content = {
	  form { $("form") }
  }
  
  def 追加する(text) {
	  form.text = text
	  form.$("input", type: "submit").click()
  }
}
