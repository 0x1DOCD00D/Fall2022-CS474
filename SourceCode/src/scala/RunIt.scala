package scala

object RunIt:
  val block1 = {
    val hrishi = "cs474"
    2
    //hrishi
  }

  val name: String = "farbod"
  val name1:Int = 2
  def f(v:Integer):Int =
    v+1

  def perforatedloop(cntr: Int, block: => Int): Int =
    if cntr % 2 == 0 then
      println(cntr)
      block
    if cntr >= 0 then
      perforatedloop(cntr -1, block)
    else 0

  @main def doesitwork(): Unit =
    perforatedloop(10, {
      val x = 3
      x
    })
    val param = new Integer(3)
    f(param)
    val v = new Integer(2);
    println(block1)