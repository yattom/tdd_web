package it
import geb.*
import geb.junit4.*
import org.junit.Ignore
import org.junit.Test

import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4)
class TodoIntegrationTest extends GebReportingTest {

	@Test
	void "TODO"() {
		to IndexPage
		追加する("buy milk")
		assert todo*.text() == ["buy milk DONE"]
		追加する("buy bread")
		assert todo*.text() == ["buy milk DONE", "buy bread DONE"]
		完了する("buy milk")
		assert todo.size() == 1
		完了する("buy bread")
		assert todo.size() == 0
	}

	@Ignore
	@Test
	void "TODOのバリデーション"() {
		to IndexPage
		assert todo*.text() == []
		追加する("")
		assert errors.text() == "Enter TODO"
		assert todo*.text() == []
	}
}
