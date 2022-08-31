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

object ArithExp:
  enum ArithmeticExpression:
    case Value(v:Int)
    case Variables(name:String)
    case Add(o1: ArithmeticExpression, o2: ArithmeticExpression)
    case Mult(o1: ArithmeticExpression, o2: ArithmeticExpression)

    val EnvironmentTable: Map[String, Int] = Map("Tam" -> 1, "Xiao"->2)

    def eval: Int = this match
      case Variables(name) => EnvironmentTable.getOrElse(name, throw new Exception(name))
      case Value(x) => x
      case Add(o1, o2) => o1.eval + o2.eval
      case Mult(o1, o2) => o1.eval * o2.eval

  @main def runArithExp =
    import ArithmeticExpression.*
//    Add(Add(Add(...)))
    println(Add(Add(Value(1), Variables("Tam")), Add(Value(1), Value(2))))