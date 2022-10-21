package javaCode;/*
 *
 *  Copyright (c) 2021. Mark Grechanik and Lone Star Consulting, Inc. All rights reserved.
 *
 *   Unless required by applicable law or agreed to in writing, software distributed under
 *   the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *   either express or implied.  See the License for the specific language governing permissions and limitations under the License.
 *
 */

public class Eksceptional {
    class MyOwnBeauException extends Exception {
        public MyOwnBeauException(){}
        public MyOwnBeauException(String expl){
            super(expl);
        }
    }
    static void blowUp() throws MyOwnBeauException {
        throw new Eksceptional().new MyOwnBeauException("ouch!!!");
//        throw new NullPointerException();
    }

    public static void main(String[] args) throws Exception {
        try{
//            int i = 10;
           new Eksceptional(). blowUp();
//           new Eksceptional();
        }catch (RuntimeException me){
            System.out.println("caught it!");
        } finally {
            System.out.println("leaving this world");
        }
    }
}
