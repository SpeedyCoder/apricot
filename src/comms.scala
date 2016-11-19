/**
  * Created by Toby Cathcart Burn on 19/11/2016.
  */
import java.lang._
import java.io.PrintWriter
import java.io.InputStreamReader
import java.io.BufferedReader
import java.net.Socket
import scala.util.parsing.json

object status{
  var from_exchange:BufferedReader
  var to_exchange:PrintWriter
  def setup()={
    val skt: Socket = new Socket("test-exch-apricot", 20000)
    from_exchange = new BufferedReader(new InputStreamReader(skt.getInputStream))
    to_exchange = new PrintWriter(skt.getOutputStream, true)
  }
  def send(s:string) = to_exchange.println
}

def send()
