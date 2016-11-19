import java.io.PrintWriter
import java.net.Socket

/**
  * Created by Sonal on 19/11/2016.
  */
class ConcreteSender extends Sender {

  val skt = Bot.skt
  val to_exchange = new PrintWriter(skt.getOutputStream, true)

  override def hello(teamname: String): Unit = {
//    Parameter is irrelevant because we're team apricot
    to_exchange.println("HELLO APRICOT")
  }

  override def add(id: Int, sym: Sym, buy: Boolean, price: Int, size: Int): Unit = {
    val str = "ADD " + id + " " + sym  + " " + (if (buy) "BUY " else "SELL ") + price + " " + size
    to_exchange.println(str)
  }

  override def convert(id: Int, sym: Sym, buy: Boolean, size: Int): Unit = {
    val str = "CONVERT " + id + " " + sym + (if (buy) " BUY " else " SELL ") + size
    to_exchange.println(str)
  }

  override def cancel(id: Int): Unit = {
    val str = "CANCEL " + id
    to_exchange.println(str)
  }
}
