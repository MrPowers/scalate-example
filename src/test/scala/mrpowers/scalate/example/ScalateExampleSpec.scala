package mrpowers.scalate.example

import org.fusesource.scalate.TemplateEngine
import org.scalatest.FunSpec

class ScalateExampleSpec extends FunSpec {

  it("creates a template string") {
    val sourceDataPath = new java.io.File("./src/test/resources/some_template.mustache").getCanonicalPath
    val engine = new TemplateEngine
    val someAttributes = Map[String, Any](
      "name" -> "Chris",
      "value" -> 10000,
      "taxed_value" -> (10000 - (10000 * 0.4)),
      "in_ca" -> true
    )
    val expected = """Hello Chris
                     |You have just won $10,000!
                     |Well, $6,000, after taxes.
                     |""".stripMargin
    assert(engine.layout(sourceDataPath, someAttributes) == expected)
  }

}
