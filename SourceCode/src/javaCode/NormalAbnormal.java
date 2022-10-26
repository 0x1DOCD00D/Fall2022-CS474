package javaCode;/*
 *
 *  Copyright (c) 2021. Mark Grechanik and Lone Star Consulting, Inc. All rights reserved.
 *
 *   Unless required by applicable law or agreed to in writing, software distributed under
 *   the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *   either express or implied.  See the License for the specific language governing permissions and limitations under the License.
 *
 */

public class NormalAbnormal {
    private int instanceVar = -1;
    public NormalAbnormal(int p){instanceVar = p;}
    public int m() {
        try {
            if(instanceVar++ > 0)
                throw new Error("0");
            else{
                try{
                    return instanceVar++;
                } catch (Error e){
                    return --instanceVar;
                } finally {
                    try {
                        throw new Exception("10");
                    } catch (Exception e){
                        return instanceVar + Integer.parseInt(e.getMessage());
                    }
                }
            }
        } catch (Exception e){
            return --instanceVar;
        } finally {
            return ++instanceVar;
        }
    }
    public static void main(String[] args) {
        System.out.println(new NormalAbnormal(0).m());
    }
}
