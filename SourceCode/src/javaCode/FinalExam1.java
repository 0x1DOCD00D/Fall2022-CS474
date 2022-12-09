package javaCode;/*
 *
 *  Copyright (c) 2021. Mark Grechanik and Lone Star Consulting, Inc. All rights reserved.
 *
 *   Unless required by applicable law or agreed to in writing, software distributed under
 *   the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *   either express or implied.  See the License for the specific language governing permissions and limitations under the License.
 *
 */

public class FinalExam1<T extends Number> {
    protected T y;
    public FinalExam1(T x){  y = x;  f();  }
    void f () {System.out.println("Super = " + String.valueOf(y));}
    static class B extends FinalExam1<Integer> {
        protected String y = "I loove Scala!";
        public B(Integer x){ super(x); y = x.toString(); f();}
        void f () {System.out.println("Derived = " + y);}
    }
    public static void main(String[] args) {
        FinalExam1<Integer> o = new FinalExam1.B (3_141);
    }
}