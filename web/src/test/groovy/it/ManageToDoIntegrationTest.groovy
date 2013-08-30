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
        todoTile = "朝食"
    }
    $('input', type: 'submit').click()
//    
//    at IndexPage
//    assert todo == '朝食'
  }
}
