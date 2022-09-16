package javaCode;/*
 *
 *  Copyright (c) 2021. Mark Grechanik and Lone Star Consulting, Inc. All rights reserved.
 *
 *   Unless required by applicable law or agreed to in writing, software distributed under
 *   the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *   either express or implied.  See the License for the specific language governing permissions and limitations under the License.
 *
 */
class Parent{
    public int i = 5;
}
public class ChildParent extends Parent {
    public int i = 6;
    public String f() {return "474";}
    public static void main(String[] args) {
        Parent o = new ChildParent();
        System.out.println(((ChildParent)o).f());
    }
}
