package it
import geb.*

class HelloPage extends Page {
  static url = "http://localhost:8999/bare-eclipse-web/hello"
  static content = {
    本文 { $("body").text() }
  }
}
