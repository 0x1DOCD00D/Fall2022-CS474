package javaCode;/*
 *
 *  Copyright (c) 2021. Mark Grechanik and Lone Star Consulting, Inc. All rights reserved.
 *
 *   Unless required by applicable law or agreed to in writing, software distributed under
 *   the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *   either express or implied.  See the License for the specific language governing permissions and limitations under the License.
 *
 */

class Energy{
    public Energy(int i){}
}

class Sustenance{}
class Food extends Sustenance {}
class Drink extends Sustenance {}

public abstract class Human {
    public int height = 0;
    public static boolean mammal;
    static {
        System.out.println("mammmaaaaal!!!");
        mammal = true;
    }
    public abstract Energy eat(Sustenance yam);
//    public abstract Energy eat(Food yam);
//    public abstract Energy eat(Drink yam);
    public Human(){
        height = 180;
    }
}

class Student extends Human {
//    @Override
    public Energy eat(Food yam) {
        System.out.println("food");
        return new Energy(yam.toString().length());
    }

//    @Override
    public Energy eat(Sustenance yam) {
        System.out.println("generic sustenance");
        return new Energy(yam.hashCode());
    }

//    @Override
/*    public Energy eat(Drink yam) {
        System.out.println("drink");
        return new Energy(yam.hashCode());
    }*/

    public static void main(String[] args) {
        System.out.println(new Student().eat(new Drink()));
        System.out.println(new Student().eat(new Drink()));
    }
}


