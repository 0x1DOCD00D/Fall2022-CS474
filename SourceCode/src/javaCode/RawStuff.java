package javaCode;/*
 *
 *  Copyright (c) 2021. Mark Grechanik and Lone Star Consulting, Inc. All rights reserved.
 *
 *   Unless required by applicable law or agreed to in writing, software distributed under
 *   the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *   either express or implied.  See the License for the specific language governing permissions and limitations under the License.
 *
 */


interface In1 {
    void f();
}
interface In2 {
    void g();
}

class CC implements In2 {
    @Override
    public void g() {
        System.out.println("g is called");
    }
}
public class RawStuff<T extends Number & In1 & In2> implements I2 {
    T field;
    public RawStuff(T f){field = f;}

    @Override
    public void f() {field.g();}

    public static void main(String[] args) {
        (new RawStuff<CC>(new CC())).f();
    }
}
