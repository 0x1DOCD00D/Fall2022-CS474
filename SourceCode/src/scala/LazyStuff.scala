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

object LazyStuff:
  val lst = List("Ridhu", "Punit", 123)
  def recFunc(l:List[Any]): Unit =
    l match
      case List() => println("done")
      case hd::tl => println(hd)
          recFunc(tl)

  def createInfiniteList(i:Int): LazyList[Int] =
    i #:: createInfiniteList(i+1)

  @main def runMain_LazyStuff(): Unit =
    println(createInfiniteList(0).take(20).toList)
//    println(recFunc(lst))

