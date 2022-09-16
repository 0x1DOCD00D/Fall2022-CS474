package javaCode;/*
 *
 *  Copyright (c) 2021. Mark Grechanik and Lone Star Consulting, Inc. All rights reserved.
 *
 *   Unless required by applicable law or agreed to in writing, software distributed under
 *   the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *   either express or implied.  See the License for the specific language governing permissions and limitations under the License.
 *
 */

public class StaticInnerClasses {
    class X{
        public int i = 5;
    }

    static class S {
        public int i = 6;
        static class S1{
            public int i = 7;
            static class S2{
                public int i = 8;
                class Y {
                    public int i = 9;
                }

            }

        }
    }
    public static void main(String[] args) {
        new StaticInnerClasses();
        StaticInnerClasses.X o1 = new StaticInnerClasses().new X();
        System.out.println(o1.i);
        S o2 = new StaticInnerClasses.S();
        System.out.println(o2.i);
        S.S1 o3 = new StaticInnerClasses.S.S1();
        System.out.println(o3.i);
        StaticInnerClasses.S.S1.S2 o4 = new StaticInnerClasses.S.S1.S2();
        System.out.println(o4.i);
        S.S1.S2.Y o5 = new StaticInnerClasses.S.S1.S2().new Y();
        System.out.println(o5.i);
    }
}
