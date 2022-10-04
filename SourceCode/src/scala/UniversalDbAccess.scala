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

object UniversalDbAccess:
  trait UniversalDb:
    def connect(cs: String): Boolean

  def getData(db: UniversalDb): String =
    if db.connect("") then
      "success"
    else throw new Exception("cannot open the db")

/*  def getDatafromsqlServer(conn: String): String =
    conn

  def getDatafromOracle(connFromOracle: String): String =
    connFromOracle*/

  def main(args: Array[String]): Unit = {
    println(getData(new KaranSqlServerDb))
  }
