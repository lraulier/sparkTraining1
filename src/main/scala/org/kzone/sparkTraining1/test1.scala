package org.kzone.sparkTraining1

import scala.math.random
import org.apache.spark.{SparkContext, SparkConf}

/**
  * Created by kubu-kzone on 11/11/15.
  * add some comment just for testing pot commit hook
  */
object test1 {
  def main (args: Array[String]) {
    val conf = new SparkConf().setAppName("test1")
    .setMaster("local[2]")

    val spark = new SparkContext(conf)
    val slices = if (args.length > 0) args(0).toInt else 2
    val n = 100000 * slices
    val counter = spark.parallelize(1 to n, slices).map { i =>
      val xx = random * 2 - 1
      val y = random * 2 - 1
      if (xx*xx + y*y < 1) 1 else 0
    }.reduce(_ + _)
    println("DANS LE DELUGE DES MESSAGES D'INFOS LORS DE L'EXECUTION " +
      "DE NOTRE APPLICATION IMPOSSIBLE DE RETROUVER LE PETIT MESSAGE QUI SUIT ALORS AJOUTONS-EN UN MAXIMUM EN MAJUSCULE AVANT :)")
    println("Pi est " + 4.0 * counter / n)
    spark.stop()
  }
}
