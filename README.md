# Fun Streaming
##Objective
This is a collection of small script to be able to experiment with Streaming.
It's a mix of small script and compiled code.
Most of the code can be run using SBT from the console. This readme will detail how to run each Examples.

##Pre-Requisite
Install Spark on your machine.
The code can be downloaded [Spark Download](https://spark.apache.org/downloads.html])
This code was run with the pre-built distribution: Spark 1.5.1 and Hadoop 2.6+

Set-up variables in bashrc:
```Shell
SCALA_HOME=${HOME}/scala/scala-2.x.x
PATH=$SCALA_HOME/bin:$PATH
SPARK_HOME=${HOME}/spark/spark-1.5.1
PATH=$SPARK_HOME/bin:$PATH
``` 

##Example 1
###Use Case
Use Spark Streaming to listen to a socket server that emits continously a bunch of random events.
Do a "Group by" using a window function to aggregate and print the top 4 results.
###Spark Streaming
Transform a Dstream to a Dataframe and execute the "group by" to find top 4 messages
###Execution
Execute from root folder

Start Coninous echoserver
```Shell
sh script/continous_echoserver.sh
```

Start Interactive Spark Streaming
```Shell
spark-shell -i script/stream.scala
```

###Apache Flink
I as was not able to make it work with Flink
The following library import org.apache.flink.streaming.api.scala._ still has the implicit type issue that has been fixed in import org.apache.flink.api.scala._. Type inference works for Flink DataSet class but does not work for Flink DataStream class.

##Produce message to Kafka
###Use Case
Let's send some messages to Kafka with a KafkaProducer in an infinite loop.


