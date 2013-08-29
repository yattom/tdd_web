package it
import geb.*
import geb.junit4.*
import org.junit.Test

import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4)
class HelloIntegrationTest extends GebReportingTest {

  @Test
  void "挨拶できること"() {
    to HelloPage
    assert 本文 == 'Hello World!'
  }
}
