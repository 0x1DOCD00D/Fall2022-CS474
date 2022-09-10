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

object ScopesInScala:
  def f(input:  Double): Unit = ()
    //println(input)

/*  val v = {
    val x: Int = 3
    val y = x*2.5
    println("block invoked")
    y
  }*/
  @main def runScopesBlabla =
/*    f {
      val x: Int = 3
      val y = x * 2.5
      println("block invoked")
      y
    }
    f {
      val x: Int = 3
      val y = x * 2.5
      println("block invoked")
      y
    }*/
    f {
      val x: Int = 3
      val y = x * 2.5
      println("block invoked")
      y
    }
