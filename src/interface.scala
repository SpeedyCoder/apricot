/**
  * Created by Toby Cathcart Burn on 19/11/2016.
  */


trait Manager{
  type Sym=String
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
  def trade(sym:Sym,price:Int,size:Int)

  //  ACK ID
  def ack(id:Int)
  // REJECT ID MSG
  def reject(id:Int,msg:String)
  //FILL ID SYMBOL DIR PRICE SIZE
  def fill(id:Int,sym:Sym,buy:Boolean,price:Int,size:Int)
  //  OUT ID --not sure what it does
  def out(id:Int)
}

trait Sender{
  type Sym=String
  def hello(teamname:String)
  def add(id:Int,sym:Sym,buy:Boolean,price:Int,size:Int)
  def convert(id:Int,sym:Sym,buy:Boolean,size:Int)
  def cancel(id:Int)

}