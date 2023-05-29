package javaCode;/*
 *
 *  Copyright (c) 2021. Mark Grechanik and Lone Star Consulting, Inc. All rights reserved.
 *
 *   Unless required by applicable law or agreed to in writing, software distributed under
 *   the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *   either express or implied.  See the License for the specific language governing permissions and limitations under the License.
 *
 */

import scala.SuperThisScala;

public class SuperThis {
    public static int field = 10;
    static {
        field = 30;
    }
    class Subclass extends SuperThis{
        static {
            field = 100;
        }

        public static int field = 20;
        public SuperThis isThatIt = super.isThatIt;
    }
    public SuperThis isThatIt = this;
    public static void main(String[] args) {
        System.out.println(new SuperThis().isThatIt.field);
        System.out.println(new SuperThis().new Subclass().isThatIt.field);
    }
}
