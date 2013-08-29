package it
import geb.*
import geb.junit4.*
import org.junit.Test

import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4)
class HelloJspIntegrationTest extends GebReportingTest {

  @Test
  void "挨拶できること"() {
    to HelloJspPage 
    assert 本文 == 'Hello JSP!'
  }
}
