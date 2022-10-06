package javaCode;/*
 *
 *  Copyright (c) 2021. Mark Grechanik and Lone Star Consulting, Inc. All rights reserved.
 *
 *   Unless required by applicable law or agreed to in writing, software distributed under
 *   the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *   either express or implied.  See the License for the specific language governing permissions and limitations under the License.
 *
 */

/*public interface Shape {
    int area();
}*/

import java.util.Scanner;

abstract class Shape {
    public abstract int area();
}

class Cirle extends Shape {
    @Override
    public int area() {
        return 1;
    }
}

class Rectangle extends Shape {
    @Override
    public int area() {
        return 2;
    }
}

class Oval extends Shape {
    @Override
    public int area() {
        return 3;
    }
}
class Square extends Rectangle{}

class RunShape {
    public static void main(String[] args) {
        Shape [] aos = new Shape[10];
        Scanner inpValue = new Scanner(System.in);
        int index = 0;
        int input = 1;
        int count = 0;
        do{
            System.out.println("enter the value [1-Circle, 2- Rectangle, 3 - Oval, 4 - Square]: ");
            input = inpValue.nextInt();
            System.out.println("enter the value of the 0 <= index <= 4 into which to put a shape: ");
            switch (input){
                case 1: index = inpValue.nextInt();
                        aos[index] = new Cirle();
                        break;
                case 2: index = inpValue.nextInt();
                    aos[index] = new Rectangle();
                    break;
                case 3: index = inpValue.nextInt();
                    aos[index] = new Oval();
                    break;
                case 4: index = inpValue.nextInt();
                    aos[index] = new Square();
                    break;
                default: break;
            }
        }while(++count < 5);
        //read the input
//        Shape [] aos = {new Cirle(), new Cirle(), new Oval(), new Rectangle(), new Square()};
        for (int i = 0; i < 5; i++){
            System.out.println(aos[i].area());
        }

    }
}
