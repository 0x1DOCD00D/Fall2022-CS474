package javaCode;/*
 *
 *  Copyright (c) 2021. Mark Grechanik and Lone Star Consulting, Inc. All rights reserved.
 *
 *   Unless required by applicable law or agreed to in writing, software distributed under
 *   the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *   either express or implied.  See the License for the specific language governing permissions and limitations under the License.
 *
 */

public class PlayWithInterfaces {
    interface P {
        default void g(){
            System.out.println("default");
        }
        P f();
    }
    abstract class C implements P {
        @Override
        public void g(){
            System.out.println("C::default");
        }
    }

    class D extends C{
        @Override
        public D f() {
            return new D();
        }
    }
    public static void main(String[] args) {
        new PlayWithInterfaces().new D().f().g();
    }
}
