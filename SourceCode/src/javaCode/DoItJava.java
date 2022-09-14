package javaCode;/*
 *
 *  Copyright (c) 2021. Mark Grechanik and Lone Star Consulting, Inc. All rights reserved.
 *
 *   Unless required by applicable law or agreed to in writing, software distributed under
 *   the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *   either express or implied.  See the License for the specific language governing permissions and limitations under the License.
 *
 */

public class DoItJava {
    class Car{
        class Engine{}
        class Breaks {}
        Engine e;
        Breaks b;
    }

    public static void main(String[] args) {
        new DoItJava().new Car();
        int i = 3;
        class myclass{
            private int i = 5;
            public int f(){
                return i;
            }
        }
//        void f(){}
        System.out.println(new myclass().f());
    }
}
