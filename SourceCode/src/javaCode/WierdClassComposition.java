package javaCode;/*
 *
 *  Copyright (c) 2021. Mark Grechanik and Lone Star Consulting, Inc. All rights reserved.
 *
 *   Unless required by applicable law or agreed to in writing, software distributed under
 *   the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *   either express or implied.  See the License for the specific language governing permissions and limitations under the License.
 *
 */

public interface WierdClassComposition {
    static public int y = 1;
    default void WierdClassComposition(){  justPrintIt();  }
    void justPrintIt();// {System.out.println("Base: " + String.valueOf(y));}
    public static class Derived implements WierdClassComposition {
        static public int y = 3;
        static {
            y = 5;
        }
        public Derived(){ justPrintIt(); }
        public void justPrintIt() {System.out.println("Derived " + String.valueOf(y));}
    }
    public static void main(String[] args) {
        WierdClassComposition o = new WierdClassComposition.Derived();
        System.out.println(o.y);
    }
}
