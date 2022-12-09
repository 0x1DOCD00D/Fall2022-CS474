package javaCode;/*
 *
 *  Copyright (c) 2021. Mark Grechanik and Lone Star Consulting, Inc. All rights reserved.
 *
 *   Unless required by applicable law or agreed to in writing, software distributed under
 *   the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *   either express or implied.  See the License for the specific language governing permissions and limitations under the License.
 *
 */

public class FinalExam2 {
    interface LivingTissue {
        public default void itchy(){System.out.println("Itches!");}
    }
    interface MetalSkeleton {
    }
    interface Human extends LivingTissue {
        public void luv();
    }
    interface Robot extends MetalSkeleton {
        public void kill();
    }
    class Terminator implements Human,Robot {
        public void kill() { System.out.println("Ouch!"); }
        public void luv() { System.out.println("Nice!"); }
        private void SaveJohnConnor(){System.out.println("Come with me if you want to live!");}
    }
    class A<T extends Human & Robot> {
        public T v = null;
        public A(T p){v = p;}
    }
    public static void main(String... s) {
        A<Terminator> a = new FinalExam2().new A<>(new FinalExam2().new Terminator());
        a.v.itchy();
//        a.v.kill(love());
        a.v.SaveJohnConnor();
    }
}
