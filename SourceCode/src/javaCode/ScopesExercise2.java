package javaCode;/*
 *
 *  Copyright (c) 2021. Mark Grechanik and Lone Star Consulting, Inc. All rights reserved.
 *
 *   Unless required by applicable law or agreed to in writing, software distributed under
 *   the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *   either express or implied.  See the License for the specific language governing permissions and limitations under the License.
 *
 */

public class ScopesExercise2 {
    static public int someInt = -1;

    static {
        someInt = 0;
        {
            int someInt = 2;
        }
    }

    public ScopesExercise2(int v){
        someInt += v;
    }

    public int getSomeInt(){
        return someInt;
    }

    public class InnerClass {
        public InnerClass(int v){
            ScopesExercise2.this.someInt += v;
        }
        public int getSomeInt(){
            return someInt;
        }
    }

    public static void main(String[] args) {
        System.out.println(new ScopesExercise2(2).getSomeInt());
        System.out.println(new ScopesExercise2(0).new InnerClass(1).getSomeInt());
        System.out.println(new ScopesExercise2(3).getSomeInt());
    }
}
