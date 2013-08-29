package it
import geb.*

class HelloJspPage extends Page {
  static url = "http://localhost:8999/tdd_todo/hellojsp"
  static content = {
    本文 { $("body").text() }
  }
}
