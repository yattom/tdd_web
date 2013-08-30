package it
import geb.*

class IndexPage extends Page {
  static url = "http://localhost:8999/tdd_todo/create"
  static content = {
    todo { $(".todo").text() }
  }
}
