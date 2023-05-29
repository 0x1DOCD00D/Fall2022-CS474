package javaCode;/*
 *
 *  Copyright (c) 2021. Mark Grechanik and Lone Star Consulting, Inc. All rights reserved.
 *
 *   Unless required by applicable law or agreed to in writing, software distributed under
 *   the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *   either express or implied.  See the License for the specific language governing permissions and limitations under the License.
 *
 */

class P{}
class C1 extends P{}
class C2 extends P{}

class StrangeBehavior<T extends P>{
    public P m(P o){
        return (T)o;
    }
}
public class ExpectedBehavior {
    public P m(P o){
        return (C1)o;
    }

    public static void main(String[] args) {
        P o = new StrangeBehavior<C1>().m(new C2());

//        P o = new ExpectedBehavior().m(new C2());
//        P o = new ExpectedBehavior().m(new C1());
        System.out.println(o.getClass().getName());
    }
}
