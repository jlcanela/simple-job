# Simple Job Spark Project
Sample Job Spark project that may be compiled into a JAR for running via `spark-submit`.

## Building
To build a JAR for submission via `spark-submit` use the `assembly` SBT task.

```bash
sbt assembly 
```

## Run
To run the Spark job
```
spark-submit target/scala-2.12/sample-job-assembly-1.0.jar data/sample.csv data/sample.json
```
