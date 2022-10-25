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
  trait Xiao:
    def m(i: Int): Int

  def hof1(f: Function1[Int, Int], i:Int): Int = f(i)
  def hof2(f: Int => Int, i:Int): Int = f(i)

  @main def runLambdazz =
    val o = new Xiao:
              override def m(i: Int): Int = i+1
    val f: Int => Int = (i:Int) => i+1

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
