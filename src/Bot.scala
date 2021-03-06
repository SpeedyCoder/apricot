import java.lang._
import java.io.PrintWriter
import java.io.InputStreamReader
import java.io.BufferedReader
import java.net.Socket


object Bot {
  var server: String = "production"
  var port = 20000
  var skt: Socket = new Socket(server, port)
  def main(args: Array[String]): Unit = {
    // Usage scala Bot [-s servername] [-p port]
    if (args.length > 0) {
      var i = 0
      while (i < args.length) {
        if (args(i) == "-s") {
          server = args(i+1)
          i += 2
        } else if (args(i) == "-p") {
          port = args(i+1).toInt
          i += 2
        }
      }
    }
    while(true){
        try {
          skt = new Socket(server, port)
          val manager: Manager = new ManagePrint(MyManager)
          val from_exchange = new BufferedReader(new InputStreamReader(skt.getInputStream))
          val to_exchange = new PrintWriter(skt.getOutputStream, true)

          to_exchange.println("HELLO APRICOT")
          var r = true
          while (r) {
            val lastLine = from_exchange.readLine()
            if (lastLine == null) {
              print("resetting");r=false
            } else {
              val reply = lastLine.trim()
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
                  manager.book(reply_array(1), reply_array.slice(3, indexOfSELL).map(colonToIIPair(_)), reply_array.slice(1 + indexOfSELL, reply_array.length).map(colonToIIPair(_)))
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
        } catch {
          case npe: NullPointerException => print("NPE caught:\n" + npe.getMessage)
          case e: Exception => print("Some other exception caught:\n" + e.getMessage)
        } finally {
          skt.close()
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
