package javaCode;/*
 *
 *  Copyright (c) 2021. Mark Grechanik and Lone Star Consulting, Inc. All rights reserved.
 *
 *   Unless required by applicable law or agreed to in writing, software distributed under
 *   the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *   either express or implied.  See the License for the specific language governing permissions and limitations under the License.
 *
 */

interface I1{
    int age = 1;
}

interface I2 extends I1{
    int age1 = 2;
    void f();
}

class C12 implements I1, I2{
    @Override
    public void f() {
        System.out.println("f in c12");
    }
}

class Childof12 extends C12{
    
}
public class ComposeInterfaces {
    public static void main(String[] args) {
        System.out.println(new C12().age);
    }
}
