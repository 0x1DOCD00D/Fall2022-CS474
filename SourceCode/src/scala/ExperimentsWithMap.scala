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

object ExperimentsWithMap:
  enum SomeEnum:
    case zero(env: Map[String, Boolean], num: SomeEnum)
    case one(env: Map[String, Boolean], num: SomeEnum)

    def eval(env: Map[String, Boolean]): Map[String, Boolean] = this match
      case zero(map, num) => num match
        case zero(map1, num) => map ++ (map1 + ("zero" -> true))
        case one(map1, num) => map ++ (map1 + ("zero" -> false))
        case null => map

      case one(map, num) => num match
        case zero(map1, num) => map ++ (map1 + ("one" -> false))
        case one(map1, num) => map ++ (map1 + ("one" -> true))
        case null => map
      case null => Map()

  @main def runMapExeriments: Unit =
    import SomeEnum.*
    val startingMap: Map[String, Boolean] = Map()
    val resultingMap = one(startingMap, zero(Map("zeero" -> false), one(startingMap,null)) )
    println(resultingMap)
    println(resultingMap.eval(startingMap))
