import org.apache.log4j.Logger;
import org.apache.spark.sql.SparkSession

object App {
     
    val log = Logger.getLogger(App.getClass().getName())

    def createSession = {
         val builder = SparkSession.builder.appName("Spark Batch")
        //.config("spark.eventLog.enabled", true)
        //.config("spark.eventLog.dir", "./spark-logs")
        builder.getOrCreate()
    }
    
    def run(in: String, out: String) = {
        log.info("Starting App")
        val spark = createSession
        val df = spark.read.option("header", true).csv(in)
        df.write.mode("Overwrite").json(out)
        createSession.close
        log.info("Stopping App")
    }

    def main(args: Array[String]) = args match {
        case Array(in, out) => run(in, out)
        case _ => println("usage: spark-submit app.jar <in.csv> <out.json>")
    }
}