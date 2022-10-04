package javaCode;/*
 *
 *  Copyright (c) 2021. Mark Grechanik and Lone Star Consulting, Inc. All rights reserved.
 *
 *   Unless required by applicable law or agreed to in writing, software distributed under
 *   the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *   either express or implied.  See the License for the specific language governing permissions and limitations under the License.
 *
 */

class Dad {
    int age = 50;
    public void genom(){
        System.out.println("Dad: " + age);
    }
}
class Daughter extends Dad {
    int age = 20;
    public void genom(){
        System.out.println("Girl: " + age);
    }
}

public class SubtypePoly {
    public static void main(String[] args) {
        Dad o = new Daughter();
        o.genom(); //what is the output of this call. Please explain.




        System.out.println(o.age); //what is printed to the console. Explain.





        System.out.println(((Daughter)o).age); //what is printed to the console. Explain.






        new Dad().genom(); //what is the output of this call. Please explain.





        new Daughter().genom(); //what is the output of this call. Please explain.



    }
}
