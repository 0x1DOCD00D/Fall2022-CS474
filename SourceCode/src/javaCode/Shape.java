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

class RunShape {
    public static void main(String[] args) {
        //read the input
        Shape [] aos = {new Cirle(), new Cirle(), new Oval(), new Rectangle()};
        for (int i = 0; i < 3; i++){
            System.out.println(aos[i].area());
        }

    }
}
