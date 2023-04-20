
class Node(var item: String, var next: Node) {
  def this(item: String) = this(item, null)
}

object test2 extends App{
  val node1 = new Node("Tokyo")
  val node2 = new Node("Paris")
  val node3 = new Node("Milan")

  node1.next = node2
  node2.next = node3

  println(node3.item)
  println(node2.item)
  println(node1.item)


}



