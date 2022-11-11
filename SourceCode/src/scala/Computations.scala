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

object Computations:
  trait Student
  trait Professor
  type Vaccinate[T, S] = S => (T, S)
  type Approve[T] = Tuple2[T, Student] => Boolean

//  def returnsMedicalStuff(i: Int): Vaccinate[Student] | Approve = ???

  val performVaxxStd: Vaccinate[String, Student] = (i:Student) => ("Vaccinated!", new Student {})
  val performVaxxProf: Vaccinate[Int, Professor] = (i:Professor) => (10, new Professor {})
  val approval: Approve[String] = (i:(String, Student))=> if i(0).trim == "Vaccinated!" then true else false

  class Cond:
    def IF(block : => Boolean): Cond =
      block
      this

    def THEN(block : => Unit): Cond =
      block
      this

  @main def runCompp =
    val `compare thing my way!! mwaaahaaa!!!` = new Cond
    `compare thing my way!! mwaaahaaa!!!`.IF{
      1 == 1
    } THEN {
      println("the end!")
    }

    println(approval(performVaxxStd(new Student {})))

