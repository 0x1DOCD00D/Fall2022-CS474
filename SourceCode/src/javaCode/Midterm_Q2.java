package javaCode;
/*
 *
 *  Copyright (c) 2021. Mark Grechanik and Lone Star Consulting, Inc. All rights reserved.
 *
 *   Unless required by applicable law or agreed to in writing, software distributed under
 *   the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *   either express or implied.  See the License for the specific language governing permissions and limitations under the License.
 *
 */
public class Midterm_Q2 {
    public static int field = 1;
    static {
        field += 2;
    }
    protected static class Inner1 {
        public static int field = 10;
        static {
            field += 90;
        }
        public void update(){ field += 1; }

        public class Inner2 extends Midterm_Q2.Inner1 {
            public Inner2() {
                super.field = field + 100;
            }
            public void update(){ field += 10; }
        }
    }

    public static void main(String[] args) {
        Midterm_Q2.Inner1 o = new Midterm_Q2.Inner1().new Inner2();
        o.update();
        System.out.println(Midterm_Q2.field);
    }}
