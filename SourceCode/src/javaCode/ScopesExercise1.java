package javaCode;/*
 *
 *  Copyright (c) 2021. Mark Grechanik and Lone Star Consulting, Inc. All rights reserved.
 *
 *   Unless required by applicable law or agreed to in writing, software distributed under
 *   the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *   either express or implied.  See the License for the specific language governing permissions and limitations under the License.
 *
 */

public class ScopesExercise1 {
    public int getSomeVar() {
        new ScopesExercise1(10);
        return someVar;
    }

    public void setSomeVar(int someVar) {
        this.someVar = someVar;
    }

    static int someVar;
    public ScopesExercise1(){
        new ScopesExercise1(5);
        int someVar = 1;
        {
            {
                someVar = 2;
                new ScopesExercise1(100);
            }
        }
    }

    public ScopesExercise1(int i){
        someVar = 3;
        {
            someVar = i;
        }
    }

    public static void main(String[] args) {
        System.out.println(new ScopesExercise1().getSomeVar());
    }
}
