/**
  * Created by Toby Cathcart Burn on 19/11/2016.
  */


type Sym=String

trait Manager{
  //HELLO CASH SYM:POSN SYM:POSN ...
  def hello(cash:Int,syms:Array[(Sym,Int)])
  //OPEN SYM SYM SYM ...
  def open(syms:Array[Sym])
  //CLOSE SYM SYM SYM ...
  def close(syms:Array[Sym])
  //ERROR MSG
  def error(msg:String)

  //  BOOK SYMBOL BUY PRICE:SIZE PRICE:SIZE ... SELL PRICE:SIZE PRICE:SIZE ...
  def book(sym :Sym,buys:Array[(Int,Int)],sells:Array[(Int,Int)])
  //TRADE SYMBOL PRICE SIZE
  def trade(Sym,Array[(Int,Int)],Array[(Int,Int)])

  //  ACK ID
  def error(Sym,Array[(Int,Int)],Array[(Int,Int)])
   // REJECT ID MSG
   def reject(Int,String)
  //FILL ID SYMBOL DIR PRICE SIZE
  def fill(id:Int,)
  //  OUT ID --not sure what it does
  def out(Int)
}
