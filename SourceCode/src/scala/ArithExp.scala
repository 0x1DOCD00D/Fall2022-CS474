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
    case Add(o1: ArithmeticExpression | Int, o2: ArithmeticExpression)
    case Mult(o1: ArithmeticExpression, o2: ArithmeticExpression)
    case Scope(name: String, expressions: List[ArithmeticExpression])

    val EnvironmentTable: Map[String, Int] = Map("Karan" -> 1, "Xiao"->2)

    def eval: Int = this match
      case Variables(name) => EnvironmentTable.getOrElse(name, throw new Exception(name))
      case Value(x) => x
      case Add(o1, o2) => o1 match
        case v: ArithmeticExpression => v.eval
        case v: Int => v
        + o2.eval
      case Mult(o1, o2) => o1.eval * o2.eval

  @main def runArithExp =
    import ArithmeticExpression.*
//    Scope("o1", List(Scope("o2", Scope("o3"), Add(Value(1), Value(2)))))
//    Add(Add(Add(...)))
    println(Add(Add(1, Variables("Karan")), Add(Value(1), Value(2))).eval)