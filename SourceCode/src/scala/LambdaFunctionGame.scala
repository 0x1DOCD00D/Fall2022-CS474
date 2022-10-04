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

object LambdaFunctionGame:
  case class Wrapper(val fun: (Int => Int) => Int)
  @main def runLFG =
    val w = Wrapper((k: Int => Int) => k(k(k(7))))
    println(w)
    println(w.fun(x=>x+1))