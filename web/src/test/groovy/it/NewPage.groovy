package it
import geb.*

class NewPage extends Page {
  static url = "http://localhost:8999/tdd_todo/new"
  static at = { assert title ==  'ToDo入力' }
  static content = {
    form { $("form") }
  }

  def "送信する"() {
    $('input', type: 'submit').click()
  }

}
