package it
import geb.*
import geb.junit4.*
import org.junit.Test

import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4)
class ManageToDoIntegrationTest extends GebReportingTest {

  @Test
  void "入力したToDoが表示できること"() {
    to NewPage
    at NewPage
    form.with {
        todoTitle = "breakfast"
    }
    $('input', type: 'submit').click()
    
    at IndexPage
    assert todo == 'breakfast'
  }
}
