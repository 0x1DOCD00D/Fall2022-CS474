package javaCode;/*
 *
 *  Copyright (c) 2021. Mark Grechanik and Lone Star Consulting, Inc. All rights reserved.
 *
 *   Unless required by applicable law or agreed to in writing, software distributed under
 *   the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *   either express or implied.  See the License for the specific language governing permissions and limitations under the License.
 *
 */

public class VarsAndScopes {
    public static int i  = 10;
    public int j = 1000;
     {
        int i = 3;
        if( i == 3) {
            {
                int k = 59;
                i = 20;
                class lc{
                    void f(){
                        System.out.println(j);
                    }
                }
                i = 5;
                new lc().f();
//                j = 2000;
//                System.out.println(j);
            }
        }
    }

    public static void main(String[] args) {
        new VarsAndScopes().i = 100;
        System.out.println(new VarsAndScopes().i);
    }
}
