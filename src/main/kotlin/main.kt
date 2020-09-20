val Demographics = arrayOf("Socialists","Progressives","Centrists","Conservatives","Nationalists","Memers","Boomers","Upper Class","Working Class")
val DemMapRawValues = mutableMapOf<String,Int>()
var DemMapPercentages = mutableMapOf<String,Double>()
val Percentages = mutableMapOf<String,Double>()

fun main(args: Array<String>) {
    var sum=0
    for(a in Demographics)
    {
        val x=(1..100).random()
        DemMapRawValues[a] = x
        sum+=x
        Percentages[a]=(1..100).random().toDouble()/100
    }
    for(a in Demographics)
    {
        DemMapPercentages[a]= DemMapRawValues[a]!!.toDouble() / sum
    }
    val voterShares = mutableMapOf<String,Double>()
    DemMapPercentages.forEach { (a,b) -> voterShares[a]= b*Percentages[a]!!*100}
    val finalVote = voterShares.map{(_,b)->b}.sum()
    println(voterShares)
    println("%.2f%%".format(finalVote))
}