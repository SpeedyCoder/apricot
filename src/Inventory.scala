import scala.collection.mutable.HashMap

class Order(val buy: Boolean, val comodity: String,
		    val price :Int, var size :Int)  {}

object Inventory {
	private var cash = 0
	private val comodities = new HashMap[String, Int]()
	private val fairPrices = new HashMap[String, Int]()
	private val activeOrders = new HashMap[Int, Order]()
	private val proposedOrders = new HashMap[Int, Order]()
	val book = new Book()

	for (i <- 0 until Constants.equities.length) {
		comodities.update(Constants.equities(i), 0)
		fairPrices.update(Constants.equities(i), -1)
	}
	fairPrices.update("BOND", 1000)

	def addProposedOrder(buy : Boolean, id :Int, comodity: String, price :Int, shares :Int) = {
		val order = new Order(buy, comodity, price, shares)
		proposedOrders.update(id, order)
	}

	def removeProposedOrder(id :Int) = {
		proposedOrders.remove(id)
	}

	def addActiveOrder(id :Int) = {
		val order = proposedOrders.remove(id).get
		activeOrders.update(id, order)
	}

	def cancelActiveOrder(id :Int) = {
		activeOrders.remove(id)
	}

	def getOrder(id :Int): Order = {
		return activeOrders(id)
	}

	def fillOrder(id: Int, comodity: String, isBuy: Boolean, price: Int, size: Int) = {
		activeOrders(id).size -= size

		if (isBuy) {
			buy(comodity, price, size)
		} else {
			sell(comodity, price, size)
		}
	}

	def setCash(newCash :Int) {
		cash = newCash
	}

	def setComodities(name :String, num :Int) = {
		comodities.update(name, num)
	}

	def buy(name :String, num :Int, price :Int) = {
		val old = comodities(name)
		comodities.update(name, old + num)
		cash -= num*price
	}

	def sell(name :String, num :Int, price :Int) = {
		val old = comodities(name)
		comodities.update(name, old - num)
		cash += num*price
	}

	def getFairPrice(name :String): Int = { 
		return fairPrices(name)
	}

	def setFairPrice(name :String, price :Int) = {
		fairPrices.update(name, price)
	}

	def setDefaultFairPrice(name :String) = {
		val price = (book.getBestSell(name)._1 + book.getBestBuy(name)._1)/2
		setFairPrice(name, price)
	}

	def setAllDefaultFairPrices() = {
		for (i<- 1 until Constants.equities.length) {
			setDefaultFairPrice(Constants.equities(i))
		}
	}
}