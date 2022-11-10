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

object LocalGlobalMap:
  val globalMap: collection.mutable.Map[String, collection.mutable.Map[String, String]] = collection.mutable.Map()
  val localMap: collection.mutable.Map[String, String] = collection.mutable.Map()

  @main def runMap =
    localMap("Car") = "Audi"

    println("local Map  :" + localMap)

    globalMap("A") = localMap.clone()

    println("global Map   :" + globalMap)


    localMap.clear()

    println("local Map  :" + localMap)

    println("global Map   :" + globalMap)