object MyManager extends Manager{
	val sender = new SenderHelp(ConcreteSender)

	def hello(cash :Int, syms :Array[(String, Int)]) = {
		Inventory.setCash(cash)
		for( i <- 0 until syms.length) {
			Inventory.setComodities(syms(i)._1, syms(i)._2)
		}
	}

	def open(l :Array[String]) = {

	}

	def close(l :Array[String]) = {
		
	}

	def ack(id: Int): Unit = {
		Inventory.addActiveOrder(id)
	}

	// Order has been rejected
  	def reject(id: Int, msg: String): Unit = {
  		println(msg)
  		Inventory.removeProposedOrder(id)
  	}

  	def book(sym: String, buys: Array[(Int, Int)], sells: Array[(Int, Int)]): Unit = {
  		if (sym == "BOND") {
  			// Do something
  		}
  		Inventory.book.updateBuys(sym, buys)
  		Inventory.book.updateSells(sym, sells)
  	}

  	def error(msg: String): Unit = {
  		println(msg)
  	}

  	// Order has been fulfilled
  	def fill(id: Int, sym: String, buy: Boolean, price: Int, size: Int): Unit = {
  		Inventory.fillOrder(id, sym, buy, price, size)
  	}

  	def out(id: Int): Unit = {
  		Inventory.cancelActiveOrder(id)
  	}

  	def trade(sym: String, price: Int, size: Int): Unit = {

  	}
}