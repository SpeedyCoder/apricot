
class ManagePrint(val manager:Manager) extends Manager{
  //HELLO CASH SYM:POSN SYM:POSN ...
  def hello(cash:Int,syms:Array[(Sym,Int)]){
    manager.hello(cash,syms)
  }
  //OPEN SYM SYM SYM ...
  def open(syms:Array[Sym]){
    println("OPEN "+syms.toString)
    manager.open(syms)
  }
  //CLOSE SYM SYM SYM ...
  def close(syms:Array[Sym]){
    println("OPEN "+syms.toString)}
  //ERROR MSG
  def error(msg:String){
    manager.error(msg)
  }

  //  BOOK SYMBOL BUY PRICE:SIZE PRICE:SIZE ... SELL PRICE:SIZE PRICE:SIZE ...
  def book(sym :Sym,buys:Array[(Int,Int)],sells:Array[(Int,Int)]){
    manager.book(sym,buys,sells)
  }
  //TRADE SYMBOL PRICE SIZE
  def trade(sym:Sym,price:Int,size:Int){
    if(sym=="BOND"){
    println("trade "+sym)
    println("Price "+price.toString)}
    manager.trade(sym,price,size)
  }

  //  ACK ID
  def ack(id:Int) = {
    println("ack")
  manager.ack(id)}
  // REJECT ID MSG
  def reject(id:Int,msg:String) = {
    println("rejected!")
    manager.reject(id,msg)
  }
  //FILL ID SYMBOL DIR PRICE SIZE
  def fill(id:Int,sym:Sym,buy:Boolean,price:Int,size:Int) = {
    println("FILL")
    manager.fill(id,sym,buy,price,size)
  }
  //  OUT ID --not sure what it does
  def out(id:Int) ={
    println("out")
    manager.out(id)
  }
}