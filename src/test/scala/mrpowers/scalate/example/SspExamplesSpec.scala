package mrpowers.scalate.example

import org.fusesource.scalate.TemplateEngine
import org.scalatest.FunSpec

object FunStuff {
  val dinnertime = "eating stuff!"
}

class SspExamplesSpec extends FunSpec {
  it("creates a simple example") {
    val sourceDataPath = new java.io.File("./src/test/resources/simple_example.ssp").getCanonicalPath
    val engine = new TemplateEngine
    println(engine.layout(sourceDataPath))
  }
}
