package streaming

/**
 * Created by ldurette on 11/4/15.
 */
import org.apache.flink.api.scala._

object WordCountJob {
  def main(args: Array[String]) {

    // set up the execution environment
    val env = ExecutionEnvironment.getExecutionEnvironment

    // get input data
    val text = env.fromElements("To be, or not to be,--that is the question:--",
      "Whether 'tis nobler in the mind to suffer", "The slings and arrows of outrageous fortune",
      "Or to take arms against a sea of troubles,")

    val counts = text.flatMap { _.toLowerCase.split("\\W+") }
      .map { (_, 1) }
      //.groupBy(0)
      //.sum(1)

    counts.print()
    // emit result


    // execute program
    //env.execute("WordCount Example")

  }
}