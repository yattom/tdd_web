package it
import geb.*
import geb.junit4.*
import org.junit.Test

import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4)
class TodoIntegrationTest extends GebReportingTest {

	@Test
	void "TODO"() {
		to IndexPage
		追加する("buy milk")
		assert TODO == ["buy milk"]
		完了する("buy milk")
		assert TODO == []
	}
}
