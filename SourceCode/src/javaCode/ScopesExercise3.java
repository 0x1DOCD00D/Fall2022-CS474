package javaCode;/*
 *
 *  Copyright (c) 2021. Mark Grechanik and Lone Star Consulting, Inc. All rights reserved.
 *
 *   Unless required by applicable law or agreed to in writing, software distributed under
 *   the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *   either express or implied.  See the License for the specific language governing permissions and limitations under the License.
 *
 */

public class ScopesExercise3 {
    public int someInt = 1;
    public class Inner1 {
        public Inner1(int v){
            ScopesExercise3.this.someInt += v;
        }
        public class Inner2 {
            public Inner2(int v){
                ScopesExercise3.this.someInt -= v;
            }
            public class Inner3 {
                public Inner3(int v){
                    ScopesExercise3.this.someInt *= v;
                }
            }
        }
    }
    public static void main(String[] args) {
        ScopesExercise3 o1 = new ScopesExercise3();
        ScopesExercise3.Inner1 o2 = o1.new Inner1(3);
        ScopesExercise3.Inner1.Inner2 o3 = o2.new Inner2(5);
        ScopesExercise3.Inner1.Inner2.Inner3 o4 = o3.new Inner3(2);
        System.out.println(o1.someInt);
    }
}
