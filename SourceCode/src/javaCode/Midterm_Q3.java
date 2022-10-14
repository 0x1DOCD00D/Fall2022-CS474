package javaCode;/*
 *
 *  Copyright (c) 2021. Mark Grechanik and Lone Star Consulting, Inc. All rights reserved.
 *
 *   Unless required by applicable law or agreed to in writing, software distributed under
 *   the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *   either express or implied.  See the License for the specific language governing permissions and limitations under the License.
 *
 */

interface MCall {
    default int f() {
        return 2;
    }
}
public class Midterm_Q3 implements MCall {
    int fvar = 0;
    public int f() {
        return fvar = 1;
    }
    interface MCall {
        default int f() {
            return 10;
        }
    }
    public static class Nested extends Midterm_Q3 implements MCall {
        int fvar = 3;

        public int f() {
            return fvar;
        }
    }
    public static void main(String[] args) {
        Midterm_Q3.MCall call1 = new Midterm_Q3.Nested();    //line 1
        Midterm_Q3 call2 = new Midterm_Q3();                 //line 2
//        MCall call0 = new Midterm_Q3();                      //line 3
        Midterm_Q3.Nested call3 = new Midterm_Q3.Nested();   //line 4
//        call3 = new Midterm_Q3();                            //line 5
        System.out.println((call1 = call3).f());             //line 6
        System.out.println(call2.f());                       //line 7
        System.out.println(call3.f());                        //line 8
    } }
