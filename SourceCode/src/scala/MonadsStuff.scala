package scala

import scala.annotation.unused
import scala.io.StdIn

/*
 *
 *  Copyright (c) 2021. Mark Grechanik and Lone Star Consulting, Inc. All rights reserved.
 *   
 *   Unless required by applicable law or agreed to in writing, software distributed under
 *   the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *   either express or implied.  See the License for the specific language governing permissions and limitations under the License.
 *  
 */

object MonadsStuff:
  trait Monoid474[T]:
    val zero:T
    def combine(i1:T, i2:T):T

  trait Tree[T]
  case class Leaf[T](v:T) extends Tree[T]
  case class Branch[T](left:Tree[T], right:Tree[T], v:T) extends Tree[T]

  def map[T,S](f: T => S)(t:Tree[T]): Tree[S] = t match
    case Leaf(v)=> Leaf(f(v))
    case Branch(l,r,v) => Branch(map(f)(l), map(f)(r), f(v))

  case class Student(uid:Int, name:String)
  object Monoid4Students extends Monoid474[Student]{
    override val zero: Student = Student(0, "")

    override def combine(i1: Student, i2: Student): Student = Student(i1.uid+i2.uid, i1.name.concat(i2.name))
  }

  trait Functor[F[_]] {	def map[A,B](fa: F[A])(f: A => B): F[B]}
  object TreeFunctor extends Functor[Tree]{
    override def map[A, B](fa: Tree[A])(f: A => B): Tree[B] = fa match
      case Leaf(v) => Leaf(f(v))
      case Branch(l, r, v) => Branch(map(l)(f), map(r)(f), f(v))
  }


  @main def runMain_MonadsStuff$(): Unit =
/*
    case class IOMonad474[T](thunk: ()=>T):
      def map()
      def flatMap
*/

    IOMonad474(()=>{StdIn.readInt()}).flatMap
    val lambda: String => List[Int] = (i:String)=> List(i.length)
    val lambda1: Int => List[Boolean] = (i:Int)=> List(i%2==0)
    val x = List("Koko").flatMap(lambda) == lambda("Koko")
    println(x)
    val y = List("Ridhu").flatMap(e=>List(e)) == List("Ridhu")
    println(y)
    val z = List("Ridhu", "Koko").flatMap(e=>lambda(e)).flatMap(e=>lambda1(e)) ==
      List("Ridhu", "Koko").flatMap(e=>lambda(e).flatMap(e=>lambda1(e)))
    println(z)
/*

//    Tree(Branch(Leaf(1), Branch
    val rv:List[Int] = List(1,2,3).flatMap(e=>List(e*1, e*2,e*3)).flatMap(e1=>List(e1+1)).flatMap(e=>List(e*2))
//List(List(1,2,3),List(2,4,6),List(3,6,9))
    println(rv)

    val abStudent = Student(1, "Abhinav")
    val anathanStudent = Student(2, "Nathan")
    println(Monoid4Students.combine(abStudent,anathanStudent))
    val AbhinavUid:Int = 1
    val AbhinavName:String = "Ab"
    println(MonadsStuff.getClass.getName)
*/