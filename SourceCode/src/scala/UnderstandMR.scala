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

object UnderstandMR:
  def payload(i:Int):List[Int] = List(i-1,i,i+1)

  def mymap(data: List[Int])(f: Int => List[Int]): List[List[Int]] =
    data match
      case hd::tl => f(hd) :: mymap(tl)(f)
      case List() => List()

  @main def runMR =
    val cod = List(1,3,5,6,8)//List(List(0,1,2),List(2,3,4),....
    val result = cod.map(payload)

    println(result)