package javaCode;/*
 *
 *  Copyright (c) 2021. Mark Grechanik and Lone Star Consulting, Inc. All rights reserved.
 *
 *   Unless required by applicable law or agreed to in writing, software distributed under
 *   the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *   either express or implied.  See the License for the specific language governing permissions and limitations under the License.
 *
 */

class LambdaTest<T extends String> {
    @FunctionalInterface interface CS474Runnable {
        public abstract void run(); }
    public static void main(String[] args) {
        new LambdaTest<String>().runnable("CS474");  }
    CS474Runnable runnable(T s) {
        T var = s;
        return () -> {System.out.println(var); }; }}