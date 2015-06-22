// Author: Jongwook Woo
// Date: 05/28/2015

// read input file and count the frequency of ngram using word count
// http://ampcamp.berkeley.edu/3/exercises/introduction-to-the-scala-shell.html
// http://ampcamp.berkeley.edu/5/exercises/introduction-to-the-scala-shell.html

// ngrams
def ngram(s: String, inSep: String, outSep: String, n:Int): Set[String] = {
	s.toLowerCase.split(inSep).sliding(n).map(_.sorted.mkString(outSep)).toSet
}

// input output file paths
val fPath = "/user/root/data/files800M.dat"
val resultPath = "data/result800M"

// read input
val lines = sc.textFile(fPath) // lines: Array[String]


val ngramNo = 2
val result = lines.flatMap(line => ngram(line, " ", "+", ngramNo)).map(word => (word, 1)).reduceByKey((a, b) => a+b)
//result.take(4)
//result.saveAsTextFile(resultPath)
val sortedResult = result.map(pair => pair.swap).sortByKey(false)
//println("============================ no of " + ngramNo +" pairs: " + sortedResult.count + "============================")
sortedResult.take(10)

//output
result.saveAsTextFile(resultPath)

