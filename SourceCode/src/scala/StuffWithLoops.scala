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

object StuffWithLoops:
  def myfor(numOfIter: Int)(block: => Int) : Int =
    if numOfIter > 0 then
      block
      myfor(numOfIter-1)(block)
    else
      block

  @main def runLoops =
    val l = List(1,2,3)
    l.foreach(println)
    myfor(10){
      println("loop")
      1
    }
//    println("loops")