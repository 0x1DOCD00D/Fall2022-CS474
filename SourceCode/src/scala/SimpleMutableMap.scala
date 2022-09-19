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

object SimpleMutableMap:
  private val exampleMap: collection.mutable.Map[String, Int] = collection.mutable.Map()

  def add2Map(k:String, v:Int):Boolean =
    if exampleMap.contains(k) then false
    else
      exampleMap.put(k, v)
      true

  @main def runMutableMapExample =
    add2Map("a", 1)
    add2Map("b", 2)
    println(exampleMap)


