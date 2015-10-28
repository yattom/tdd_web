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
		assert todoText*.text() == ["buy milk"]
		追加する("walk dog")
		assert todoText*.text() == ["buy milk", "walk dog"]
		完了する("buy milk")
		assert todo.size() == 1
		assert todoText*.text() == ["walk dog"]
	}
}
