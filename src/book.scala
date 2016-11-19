type Price = Int

class Comodity() {
	private var buys:Array[(Int,Int)] = null
	private var sells:Array[(Int,Int)] = null

	def getBuys():Array[(Int, Int)] = {
		return buys
	}

	def getSells():Array[(Int, Int)] = {
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