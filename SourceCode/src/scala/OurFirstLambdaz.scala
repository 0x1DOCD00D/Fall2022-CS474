package scala

/*
 *
 *  Copyright (c) 2021. Mark Grechanik and Lone Star Consulting, Inc. All rights reserved.
 *   
 *   Unless required by applicable law or agreed to in writing, software distributed under
 *   the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *   either express or implied.  See the License for the specific language governing permissions and limitations under the License.
 *  
 */

object OurFirstLambdaz:
  val j = 2
  trait Xiao:
    def m(i: Int): Int

  def appMeth2Itself(f:Int=>Int):Int
  def hof1(f: Function1[Int, Int], i:Int): Int = f(i)
  def hof2(f: Int => Int, i:Int): Int = f(i)
  def retFhof(f1: Int=>Int, f2:Int=>Int): Int=>Int =
    (i:Int) => f2(f1(i))

  def identityM[T](i:T):T = i

  val identityF = (i:Int)=>i

  @main def runLambdazz =
    val fd = (x:Int, y:Int)=>math.sqrt(x*x+y*y)
    val fdf = (x:Int, y:Int, func: Double => Double)=>func(x*x+y*y)
    val o = new Xiao:
              override def m(i: Int): Int = i+1
    val f: Function1[Int, Int] = (i:Int) => i+1

    val fo: Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(v1: Int): Int = v1+1
    }
    val xiao: Xiao = (i:Int) => i+1

    println(o.m(3))
    println(f(3))
    println(fo.apply(3))
    println(xiao.m(3))
    println(((i:Int) => i+1)(3))
    println(hof1((i:Int) => i+1,2)==hof2((i:Int) => i+1,2))
    println(retFhof((i:Int)=>i+j, (i:Int)=>i-1)(6))
    println(((x:Int, y:Int)=>math.sqrt(x*x+y*y))(3,4))
    val peo = ((x:Int)=>(y:Int)=>math.sqrt(x*x+y*y))(3)
    println(peo)
    println(peo(4))
    println(fdf(3,4, math.sqrt))
    println(fdf(3,4, math.abs))


