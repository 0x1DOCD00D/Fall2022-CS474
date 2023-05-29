package javaCode;/*
 *
 *  Copyright (c) 2021. Mark Grechanik and Lone Star Consulting, Inc. All rights reserved.
 *
 *   Unless required by applicable law or agreed to in writing, software distributed under
 *   the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *   either express or implied.  See the License for the specific language governing permissions and limitations under the License.
 *
 */

public class SquareFunction {
    interface ComputeSquareOfSomeInteger {
        int square(int x);
    }

    public static void main(String[] args) {
        int square = new ComputeSquareOfSomeInteger(){
            @Override
            public int square(int x) {
                return x*x;
            }
        }.square(6);
        System.out.println(square);

        ComputeSquareOfSomeInteger sqFunction = (int x)->x*x;
        System.out.println(sqFunction.square(6));
    }
}
