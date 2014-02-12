package akka.example

import akka.actor._

case class Work(num: Int)
case class Result(num: Int, result: String)

class Worker extends Actor {
  def receive = {
    case Work(num) =>
      println(s"receiving work with number ${num}")
      sender ! Result(num, "Done")
  }
}


class Master extends Actor {

}

object Master {
  def clusterPorps = Props[Worker]
}
