/**
  * Created by Toby Cathcart Burn on 19/11/2016.
  */

trait Manager{
  def hello(cash:Int,syms:List[(Sym,Int)])
  //HELLO CASH SYM:POSN SYM:POSN ...
  //OPEN SYM SYM SYM ...
  def open(List(Sym))
  //CLOSE SYM SYM SYM ...
  def close(List(Sym))
  //ERROR MSG

  //  BOOK SYMBOL BUY PRICE:SIZE PRICE:SIZE ... SELL PRICE:SIZE PRICE:SIZE ...
  //TRADE SYMBOL PRICE SIZE
  //  ACK ID
   // REJECT ID MSG
  //FILL ID SYMBOL DIR PRICE SIZE
  //  OUT ID
}
