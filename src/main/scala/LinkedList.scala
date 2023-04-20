class LinkedList {
  var head: Node = null

  def addToStart(s: String): Unit = {
    val newNode = new Node(s)
    newNode.next = head
    head = newNode
  }

  def getSize(): Int = {
    def countNodes(node: Node, count: Int): Int = {
      if (node == null) {
        count
      } else {
        countNodes(node.next, count + 1)
      }
    }

    countNodes(head, 0)
  }

  def removeFirstElement(): Unit = {
    if (head != null) {
      head = head.next
    }
  }

  def getLastElement(): Node = {
    def getLast(node: Node): Node = {
      if (node == null || node.next == null) {
        node
      } else {
        getLast(node.next)
      }
    }

    getLast(head)
  }

  def addToEnd(element: String): Unit = {
    val newNode = new Node(element)
    if (head == null) {
      head = newNode
    } else {
      val last = getLastElement()
      last.next = newNode
    }
  }

  def isPresent(e: String): Boolean = {
    def checkNode(node: Node): Boolean = {
      if (node == null) {
        false
      } else if (node.item == e) {
        true
      } else {
        checkNode(node.next)
      }
    }

    checkNode(head)
  }

  def findElement(s: String): Node = {
    def findNode(node: Node): Node = {
      if (node == null) {
        null
      } else if (node.item == s) {
        node
      } else {
        findNode(node.next)
      }
    }

    findNode(head)
  }

  def swapElements(e1: String, e2: String): Unit = {
    var node1 = findElement(e1)
    var node2 = findElement(e2)
    if (node1 != null && node2 != null) {
      val temp = node1.item
      node1.item = node2.item
      node2.item = temp
    }
  }

  def removeLastElement(): Unit = {
    if (head == null) {
      return
    }
    if (head.next == null) {
      head = null
    } else {
      var node = head
      while (node.next.next != null) {
        node = node.next
      }
      node.next = null
    }
  }


  def removeElement(e: String): Unit = {
    if (head == null) {
      return
    }
    if (head.item == e) {
      head = head.next
    } else {
      var node = head
      while (node.next != null && node.next.item != e) {
        node = node.next
      }
      if (node.next != null) {
        node.next = node.next.next
      }
    }
  }

  def insertAfter(before: String, after: String): Unit = {
    val beforeNode = findElement(before)
    if (beforeNode != null) {
      val newNode = new Node(after)
      newNode.next = beforeNode.next
      beforeNode.next = newNode
    }
  }

  override def toString(): String = {
    if (head == null) {
      // Handle the case where the list is empty
      ""
    } else {
      def nodesToString(node: Node): String = {
        if (node == null) {
          // Base case: reached the end of the list
          ""
        } else {
          // Recursive case: concatenate the string representation of the current node
          // and the rest of the list
          node.item + " " + nodesToString(node.next)
        }
      }

      nodesToString(head)
    }
  }


}

object test5 extends App {
  // Tests
  val list = new LinkedList()
  println(list.getSize()) // 0

  list.addToStart("Paris")
  list.addToStart("Bruxelles")
  list.addToStart("Londres")
  println(list) // Londres Bruxelles Paris

  list.removeFirstElement()
  println(list) // Bruxelles Paris

  list.addToEnd("Madrid")
  println(list) // Bruxelles Paris Madrid

  println(list.isPresent("Paris")) // true
  println(list.isPresent("Berlin")) // false

  list.swapElements("Paris", "Madrid")
  println(list) // Bruxelles Madrid Paris

  list.removeLastElement()
  println(list) // Bruxelles Madrid

  list.removeElement("Madrid")
  println(list) // Bruxelles

  list.insertAfter("Bruxelles", "Amsterdam")
  println(list) // Bruxelles Amsterdam

  println(list.getSize()) // 2
}