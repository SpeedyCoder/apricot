import java.lang._
import java.io.PrintWriter
import java.io.InputStreamReader
import java.io.BufferedReader
import java.net.Socket
import scala.util.parsing.json


object Bot {
  final val skt: Socket = new Socket("test-exch-apricot", 20000)
  def main(args: Array[String]): Unit = {
    val manager: Manager = new MyManager()
    while (true) {
      try {
        val from_exchange = new BufferedReader(new InputStreamReader(skt.getInputStream))
        val to_exchange = new PrintWriter(skt.getOutputStream, true)

        to_exchange.println("HELLO APRICOT")
        var reply = from_exchange.readLine().trim()
        val reply_array: Array[String] = reply.split(" ")
        reply_array(0) match {
          case "HELLO" =>
            manager.hello(reply_array(1).toInt, reply_array.slice(2, reply_array.length).map(colonToSIPair(_)))
          case "OPEN" =>
            manager.open(reply_array.slice(1, reply_array.length))
          case "CLOSE" =>
            manager.close(reply_array.slice(1, reply_array.length))
          case "ERROR" =>
            manager.error(reply_array(1))
          case "BOOK" =>
            val indexOfSELL = reply_array.indexOf("SELL")
            manager.book(reply_array(1), reply_array.slice(3, indexOfSELL).map(colonToIIPair(_)), reply_array.slice(1+indexOfSELL, reply_array.length).map(colonToIIPair(_)))
          case "TRADE" =>
            manager.trade(reply_array(1), reply_array(2).toInt, reply_array(3).toInt)
          case "ACK" =>
            manager.ack(reply_array(1).toInt)
          case "REJECT" =>
            manager.reject(reply_array(1).toInt, reply_array(2))
          case "FILL" =>
            manager.fill(reply_array(1).toInt, reply_array(2), reply_array(3) == "BUY", reply_array(4).toInt, reply_array(5).toInt)
          case "OUT" =>
            manager.out(reply_array(1).toInt)
        }
      }
    }
  }

  // Conver a string "blah:7" to a pair ("blah", 7)
  def colonToSIPair(aCOLONb: String): (String, Int) = {
    val arr = aCOLONb.split(":")
    (arr(0), arr(1).toInt)
  }
  // Conver a string "3:7" to a pair (3, 7)
  def colonToIIPair(aCOLONb: String): (Int, Int) = {
    val arr = aCOLONb.split(":")
    (arr(0).toInt, arr(1).toInt)
  }
}
