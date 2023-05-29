package scala

/*
 *
 *  Copyright (c) 2021. Mark Grechanik and Lone Star Consulting, Inc. All rights reserved.
 *   
 *   Unless required by applicable law or agreed to in writing, software distributed under
 *   the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *   either express or implied.  See the License for the specific language governing permissions and limitations under the License.
 *  
 */
object Continuation:
  class Shift[+A, -B, +C](val fun: (A => B) => C) {
    def map[A1](f: (A => A1)): Shift[A1, B, C] = {
      new Shift((k: A1 => B) => fun { (x: A) => k(f(x)) })
    }

    def flatMap[A1, B1, C1<:B](f: A => Shift[A1, B1, C1]): Shift[A1, B1, C] = {
      new Shift((k: A1 => B1) =>
        fun { (x: A) => f(x).fun(k) })
    }
  }

  def reset[A, C](c: Shift[A, A, C]) = c.fun((x: A) => x)

  @main def runContinuation =
    // create a shift, and maping.
    val ctx = for {
      x <- new Shift((k: Int => Int) => k(k(k(7))))
    } yield x + 1

    println(reset(ctx)) // => 10
    println(reset(ctx)) // => 10