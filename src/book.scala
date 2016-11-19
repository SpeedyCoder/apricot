import scala.collection.mutable.HashMap

class Comodity() {
	private var buys :Array[(Int,Int)] = null
	private var sells :Array[(Int,Int)] = null

	def getBuys() :Array[(Int, Int)] = {
		return buys
	}

	def getSells() :Array[(Int, Int)] = {
		return sells
	}

	def updateSells(newSells :Array[(Int, Int)]) = {
		sells = newSells
	}

	def updateBuys(newBuys :Array[(Int, Int)]) = {
		buys = newBuys
	}

	def getBestBuy(): (Int, Int) = {
		return buys(0)
	}

	def getBestSell(): (Int, Int) = {
		return sells(0)
	}
}

class Book() {
	val equities = Array(
		"BOND",  // worth 1000 all the time
		"VALBZ", // regular
		"GS",    // regular
		"MS",    // regular
		"WFC",    // regular
		"VALE",  // ETF for VALBZ
		"XLF"    // ETF
	)

	val etfs = Array(
		"VALE",  // ETF for VALBZ
		"XLF"    // ETF
	)

	private val comodities = new HashMap[String, Comodity]()
	for (i <- 0 until equities.length) {
		comodities.put(equities(i), new Comodity())
	} 

	def getBuys(name: String) :Array[(Int, Int)] = {
		return comodities(name).getBuys
	}

	def getSells(name: String) :Array[(Int, Int)] = {
		return comodities(name).getSells
	}

	def updateSells(name: String, newSells :Array[(Int, Int)]) = {
		comodities(name).updateSells(newSells)
	}

	def updateBuys(name: String, newBuys :Array[(Int, Int)]) = {
		comodities(name).updateBuys(newBuys)
	}

	def getBestBuy(name: String): (Int, Int) = {
		return comodities(name).getBestBuy
	}

	def getBestSell(name: String): (Int, Int) = {
		return comodities(name).getBestSell
	}

}

class Inventory() {
	private var cash = 0
}





