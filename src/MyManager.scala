object MyManager extends Manager{
	val inventory = new Inventory()

	def hello(cash :Int, syms :Array[(String, Int)]) = {
		inventory.setCash(cash)
		for( i <- 0 until syms.length) {
			inventory.setComodities(syms(i)._1, syms(i)._2)
		}
	}

	def open(l :Array[String]) = {

	}

	def close(l :Array[String]) = {
		
	}

	def ack(id: Int): Unit = {
		
	}

  	def book(sym: String, buys: Array[(Int, Int)], sells: Array[(Int, Int)]): Unit = {
  		if (sym == "BOND") {
  			// Do something
  		}
  		inventory.book.updateBuys(sym, buys)
  		inventory.book.updateSells(sym, sells)
  	}

  	def error(msg: String): Unit = {
  		println(msg)
  	}

  	// Order has been fulfilled
  	def fill(id: Int, sym: String, buy: Boolean, price: Int, size: Int): Unit = {
  		
  	}

  	def out(id: Int): Unit = {
  		
  	}

  	// Order has been rejected
  	def reject(id: Int, msg: String): Unit = {
  		
  	}

  	def trade(sym: String, price: Int, size: Int): Unit = {
  		
  	}
}