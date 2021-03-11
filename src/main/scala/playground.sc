import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

val spark = SparkSession
  .builder()
  .master("local")
  .getOrCreate()

spark.sparkContext.setLogLevel("ERROR")

val siteDF = spark.read.parquet("/abs/path/local.parquet")
siteDF.createOrReplaceTempView("view")

siteDF.groupBy("study__v")
  .agg(count("study__v"))
  .sort(asc("count(study__v)"))
  .show(truncate = false)

spark.sql(
  """
    select count(1) from view
"""
).show(truncate = false)
