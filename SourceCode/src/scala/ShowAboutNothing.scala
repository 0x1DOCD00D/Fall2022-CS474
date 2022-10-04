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

object ShowAboutNothing:
  lazy val v: Any = throw new Exception("arrrgh!!!")
  def divide(p1: Int, p2: Int): Float =
    if p2 != 0 then p1/p2
    else throw new Exception("")

  @main def runNothing =
    println(v)