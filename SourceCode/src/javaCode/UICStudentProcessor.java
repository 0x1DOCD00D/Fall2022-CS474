package javaCode;/*
 *
 *  Copyright (c) 2021. Mark Grechanik and Lone Star Consulting, Inc. All rights reserved.
 *
 *   Unless required by applicable law or agreed to in writing, software distributed under
 *   the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *   either express or implied.  See the License for the specific language governing permissions and limitations under the License.
 *
 */

public class UICStudentProcessor {
    public static float process(UICStudent s) {
        return s.gpa() + s.highestGrade();
    }

    public static void main(String[] args) {
        System.out.println(UICStudentProcessor.process(new Undergrad()));
    }
}

class Undergrad implements UICStudent {
    @Override
    public float gpa() {
        return 0;
    }

    @Override
    public float highestGrade() {
        return 0;
    }
}