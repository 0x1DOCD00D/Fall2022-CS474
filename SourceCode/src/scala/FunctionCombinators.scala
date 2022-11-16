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

object FunctionCombinators:
  def andThen4Abhinav(f1:Int=>Int)(f2:Int=>String):Int=>String = (i:Int)=>f2(f1(i))
  def andThen4AbhinavGeneral[T,S,R](f1:T=>S)(f2:S=>R):T=>R = (i:T)=>f2(f1(i))

  def unit[T](p:T):WrapperUnit[T] = WrapperUnit(p)

  case class WrapperUnit[T](p1:T):
    def map[S](f:T=>S):WrapperUnit[S] = WrapperUnit(f(p1))

//  case class WrapperUnit[T,S](p1:T, p2:S)
  println(WrapperUnit("Punit_Unit"))
  println(unit("Mark").map((i:String)=>i.length))

// f: T=>S and g: S=>R
  val finc: Int=>Int = (p:Int)=> p+1
  val fvar: Int=>String = (p:Int)=> p.toString.concat("_cs474")
//  Int=>Int compose with Int=>String : Int =>String
  val fcomp = finc andThen(fvar)
  val fcomp1 = (i:Int)=>fvar(finc(i))
  def basicMethod(p: Int): String = p.toString

  def mymap1stAttempt(pf: Int=>Int): Int=>Int =
    (i:Int)=>pf(pf(pf(i)))

  def mapp[T,S](d:List[T])(f:T=>S)  : List[S] =
    for {
      elem <- d
    } yield f(elem)

  @main def runFuncComb =
    println(basicMethod(3))
    println(
      ((p: Int)=> p.toString)(5)
    )
    println(fvar(7))
    println(mymap1stAttempt((p:Int)=>p+1))
    println(mymap1stAttempt((p:Int)=>p+1)(5))
    println(fcomp(5))
    println(fcomp1(5))
    println(andThen4Abhinav((p:Int)=> p+1)((p: Int)=> p.toString+"__cs474")(9))
    //Float => Int =. String
    println(andThen4AbhinavGeneral((i:Float)=>i.toInt+3)((i:Int)=>i.toString+"___cs474")(70))
    println(
      mapp(List(1,2,3))((i:Int)=>List(i-1,i,i+1))
    )