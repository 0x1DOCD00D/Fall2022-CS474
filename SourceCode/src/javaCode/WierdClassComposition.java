package javaCode;/*
 *
 *  Copyright (c) 2021. Mark Grechanik and Lone Star Consulting, Inc. All rights reserved.
 *
 *   Unless required by applicable law or agreed to in writing, software distributed under
 *   the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *   either express or implied.  See the License for the specific language governing permissions and limitations under the License.
 *
 */

public class WierdClassComposition {
    static public int y = 1;
    public WierdClassComposition(){  y = 3;  justPrintIt();  }
    void justPrintIt() {System.out.println("Base: " + String.valueOf(y));}
    static {
        y = 2;
    }
    public static class Derived extends WierdClassComposition {
        int y = 3;
        {
            y = 4;
        }
        public Derived(){ justPrintIt(); }
        void justPrintIt() {System.out.println("Derived " + String.valueOf(y));}
    }
    public static void main(String[] args) {
        WierdClassComposition.Derived o = new WierdClassComposition.Derived();
        System.out.println(o.y);
    }
}
