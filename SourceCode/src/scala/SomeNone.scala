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

object SomeNone:
  def div(n:Float, m:Float): Option[Float] =
    if m > 0 then Option(n/m)
    else None

  def inc(i: Option[Float]): Option[Float] = i match
    case Some(x) => Option(x+1)
    case None => None

  def incPlain(i:Float): Float = i+1f

  @main def runMain_SomeNone(): Unit =
    val r1 = Option(1f)
    val r2 = r1.map(x=>x.toString)
//    map[A,B]](ds:M[_])(f:A=>B):B
//    flatMap[A,B]](ds:M[_])(f:A=>M[B]):M[B]
    val res = Some(1f).flatMap(x=> Option(incPlain(x)))
    val fn = inc(div(-1,2))
      .flatMap(x=>Option(x*2))
      .filter(_<100)
      .flatMap(c=>Option(c+10))
    println(fn)
