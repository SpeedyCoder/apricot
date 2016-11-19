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
		Inventory.reset()
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
  			if (buys.length > 0 && buys(0)._1 > 1001) {
  				sender.addNew("BOND", false, buys(0)._1, buys(0)._2)
  			}
  			if (sells.length > 0 && sells(0)._1 < 999) {
  				sender.addNew("BOND", true, sells(0)._1, sells(0)._2)
  			}
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