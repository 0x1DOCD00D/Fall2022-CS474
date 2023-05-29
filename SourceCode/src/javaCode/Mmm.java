package javaCode;/*
 *
 *  Copyright (c) 2021. Mark Grechanik and Lone Star Consulting, Inc. All rights reserved.
 *
 *   Unless required by applicable law or agreed to in writing, software distributed under
 *   the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *   either express or implied.  See the License for the specific language governing permissions and limitations under the License.
 *
 */

import java.sql.SQLException;

public class Mmm {
    private void throwIt( final Exception t ) throws SQLException {
        throw (SQLException)t;
    }

    public static void main(String[] args) {
        try {
//            RuntimeException ex = (RuntimeException)(new SQLException());
            new Mmm().throwIt(new SQLException());
        } catch(final SQLException ex){

            ex.printStackTrace();        }
    }
}