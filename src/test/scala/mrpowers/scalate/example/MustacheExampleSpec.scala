package mrpowers.scalate.example

import org.fusesource.scalate.TemplateEngine
import org.scalatest.FunSpec

class MustacheExampleSpec extends FunSpec {

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

  it("creates a list example") {
    val sourceDataPath = new java.io.File("./src/test/resources/list_example.mustache").getCanonicalPath
    val engine = new TemplateEngine
    val someAttributes = Map(
      "repo" -> List(
        Map("name" -> "resque"),
        Map("name" -> "hub"),
        Map("name" -> "rip")
      )
    )
    val expected = """<b>resque</b>
                     |<b>hub</b>
                     |<b>rip</b>
                     |""".stripMargin
    assert(engine.layout(sourceDataPath, someAttributes) == expected)
  }

  it("creates a simple example") {
    val sourceDataPath = new java.io.File("./src/test/resources/simple_example.mustache").getCanonicalPath
    val engine = new TemplateEngine
    val someAttributes = Map(
      "programming_language" -> "Scala",
      "code_description" -> "pretty"
    )
    val expected = """I like Scala
                     |The code is pretty
                     |""".stripMargin.stripLineEnd
//    println(engine.layout(sourceDataPath, someAttributes))
    assert(engine.layout(sourceDataPath, someAttributes) == expected)
  }

  it("creates a list of popular Scala projects") {
    val sourceDataPath = new java.io.File("./src/test/resources/scala_projects.mustache").getCanonicalPath
    val engine = new TemplateEngine
    val someAttributes = Map(
      "popular_projects" -> List(
        Map("name" -> "Spark"),
        Map("name" -> "Play"),
        Map("name" -> "Akka")
      )
    )
    val expected = """<b>Spark</b>
                     |<b>Play</b>
                     |<b>Akka</b>
                     |""".stripMargin
//    println(engine.layout(sourceDataPath, someAttributes))
    assert(engine.layout(sourceDataPath, someAttributes) == expected)
  }

  it("creates a boolean string") {
    val sourceDataPath = new java.io.File("./src/test/resources/boolean_example.mustache").getCanonicalPath
    val engine = new TemplateEngine
    val someAttributes = Map(
      "loves_scala?" -> true
    )
    println(engine.layout(sourceDataPath, someAttributes))
  }

  it("applies a function") {
    val sourceDataPath = new java.io.File("./src/test/resources/function_example.mustache").getCanonicalPath
    val engine = new TemplateEngine
    val someAttributes = Map(
      "column_names" -> "first_name|last_name|age",
      "comma_delimited" -> ((cols: String) => cols.replaceAll("\\|", ",")),
      "table_name" -> "fun_people"
    )
    println(engine.layout(sourceDataPath, someAttributes))
  }

}
