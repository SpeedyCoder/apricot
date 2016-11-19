class SenderHelp(val send:Sender){
  var localId=0
  
  def hello(teamname:String) =send.hello(teamname)
  def add(id:Int,sym:String,buy:Boolean,price:Int,size:Int) = send.add(id,sym,buy,price,size)
  def addNew(sym:String, buy:Boolean, price:Int, size:Int) = {
    localId+=1;
    Inventory.addProposedOrder(buy, localId , sym, price, size)
    send.add(localId,sym,buy,price,size);
  }
  def convert(id:Int,sym:String,buy:Boolean,size:Int) ={
    send.convert(id,sym,buy,size)
  }
  def convertNew(sym:String,buy:Boolean,size:Int)={
    localId+=1;
    send.convert(localId,sym,buy,size)
  }
  def cancel(id:Int) = send.cancel(id)

}