import java.lang._
import java.io.PrintWriter
import java.io.InputStreamReader
import java.io.BufferedReader
import java.net.Socket

object Bot {
  def main(args: Array[String]): Unit = {
    try {
      val skt: Socket = new Socket("APRICOT", 20000)
      val from_exchange = new BufferedReader(new InputStreamReader(skt.getInputStream))
      val to_exchange = new PrintWriter(skt.getOutputStream, true)

      to_exchange.println("HELLO APRICOT")
      var reply = from_exchange.readLine().trim()
      System.err.printf("The exchange replied: %s\n", reply)
    }
  }
}
