package javaCode;/*
 *
 *  Copyright (c) 2021. Mark Grechanik and Lone Star Consulting, Inc. All rights reserved.
 *
 *   Unless required by applicable law or agreed to in writing, software distributed under
 *   the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *   either express or implied.  See the License for the specific language governing permissions and limitations under the License.
 *
 */

interface ParentWithDefault {
    default void foo(){
        System.out.println("default");
    }
    void abhinav();
}

interface ParentWithDefault1 {
    default void foo(){
        System.out.println("default");
    }
    void abhinav();
}

interface SimpliPimple {
    default void simple(){
        System.out.println("simple");
    }
}

public class DefaultOverride implements ParentWithDefault, ParentWithDefault1, SimpliPimple {
    public DefaultOverride(){

    }

    @Override
    public void foo() {
        System.out.println("child");
//        ParentWithDefault.super.foo();
    }

    @Override
    public void abhinav() {
        super.simple();
        System.out.println("feeling groovy");
    }

    public static void main(String[] args) {
        new DefaultOverride().foo();
        ParentWithDefault1 o = new DefaultOverride();
        o.abhinav();
    }
}
