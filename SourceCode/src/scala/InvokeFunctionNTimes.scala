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

object InvokeFunctionNTimes:
  val _f: Int=>Int = (i:Int)=>i+1
  val f:Int=>Int = (i:Int)=>_f(i)
//  f(5) => (i:Int)=>((i:Int)=>i+1)(i)=>...
  val ff: Int=>Int = (i:Int)=>f(_f(i))
  val fff: Int=>Int = (i:Int)=>ff(_f(i))
  val ffff: Int=>Int = (i:Int)=>fff(_f(i))

  def infiniteRecAppOfFunc(f:Int=>Int):Int=>Int =
    (i:Int)=>infiniteRecAppOfFunc(f)(f(i))

  def nTimesRecAppOfFunc(f:Int=>Int, n:Int):Int=>Int =
    if n == 0 then (i:Int)=>i
    else
      (i:Int)=>nTimesRecAppOfFunc(f, n-1)(f(i))

  //nTimesRecAppOfFunc((i:Int)=>i+1),2) =>
  //((i:Int)=>nTimesRecAppOfFunc(f, 1)(f(i)))((i:Int)=>i+1)(2) =>
  //((i:Int)=>((i:Int)=>nTimesRecAppOfFunc(f, 0)(f(i)))(f, 1)(f(i)))((i:Int)=>i+1)(2) =>
  //((i:Int)=>((i:Int)=>((i:Int)=>i)(f(i)))(f, 1)(f(i)))((i:Int)=>i+1)(2) =>
  //((i:Int)=>((i:Int)=>((i:Int)=>i)(f(i)))(f, 1)(f(i)))((i:Int)=>i+1)(2)(5)
  //(((i:Int)=>((i:Int)=>i)(f(i)))(f, 1)(f(5)))((i:Int)=>i+1)(2)

  //infiniteRecAppOfFunc(_f) => (i:Int)=>infiniteRecAppOfFunc(_f)(_f(i)) =>
  // (i:Int)=>((i:Int)=>((i:Int)=>((i:Int)=>infiniteRecAppOfFunc(f)(f(i)))(f)(f(i)))(f)(f(i)))(_f)(_f(i))
  @main def runInvokeFunctionNTimes =
    println(_f)
    println(_f(5))
    println(f(5))
    println(ff(5))
    println(fff(5))
    println(infiniteRecAppOfFunc(_f))
//    println(infiniteRecAppOfFunc(_f)(5)) //=> 5 5
    println(nTimesRecAppOfFunc(_f,10)(5))
