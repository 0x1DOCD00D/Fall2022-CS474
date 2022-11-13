# Homework 5
### Description: using a language for designers of the boolean logic that you created in the previous homeworks implement partial evaluation and optimization of the expressions written in that language.
### Grade: 10%

## Preliminaries
In the previous homework assignments you gained experience with creating and managing your Git repository and implementing your first *domain-specific language (DSL)* using Scala for writing and evaluating expressions for designers of boolean logic devices using variables and scopes. You learned how to create [Scalatest](https://www.scalatest.org/) tests to test your implementation and to create build scripts using [SBT to build and run scripts](https://www.scala-sbt.org/) for your DSL project.

In this homework you will gain experience with using [partial evaluation](https://www.cs.utexas.edu/~wcook/tutorial/PEnotes.pdf) and optimization of the expressions written in your DSL. First things first, if you haven't done so, you must create your account at [Github](https://github.com), a Git repo management system. Then invite me, your course instructor and your TA as your collaborators. Please avoid using emails from your other accounts like funnybunny2000@gmail.com and use the corresponding channels on Teams instead. You will always receive a response within 12 hours at most and in reality the response time is within 30 minutes on average.

Next, if you haven't done so, you will install [IntelliJ](https://www.jetbrains.com/student/) with your academic license, the JDK, the Scala runtime and the IntelliJ Scala plugin and the [Simple Build Toolkit (SBT)](https://www.scala-sbt.org/1.x/docs/index.html) and make sure that you can create, compile, and run Java and Scala programs. Please make sure that you can run [various Java tools from your chosen JDK between versions 8 and 17](https://docs.oracle.com/en/java/javase/index.html). It is highly recommended that you use Scala version 3.1.1.

Many students found the following book that I recommended very useful: [the fifth edition of the book on Programming in Scala by Martin Odersky and Lex Spoon et al](https://www.artima.com/shop/programming_in_scala_5ed). There are many other books and resources available on the Internet to learn Scala. Those who know more about functional programming can use the book on Functional Programming in Scala published on Sep 14, 2014 by Paul Chiusano and Runar Bjarnason and it is available using your academic subscription on [SafariBooksOnline](https://learning.oreilly.com/home/).

## Overview
In the previous homeworks, you created a DSL for binary logic designers where you added expressions for storing results of some computations in variables and using them in different scopes and you introduced classes and their inheritance composition mechanism and your implemented branching constructs and exception handling. Also, you added abstract classes and interfaces with inheritance and interface implementation composition mechanisms. Your abstract classes contain fields and methods with private, public and protected accesses to its members, similarly to your implementation of concrete classes. You created an evaluator that iterates through the expressions in a program written in your DSL and this evaluator uses the environment table to assign values to variables and reduce the program to a single value of the type **Boolean**.

The goal of his homework is to learn how to use partial evaluation to [allow undefined variables during evaluation by preserving syntactical phrases if they cannot be evaluated completely](https://www.cs.utexas.edu/~wcook/tutorial/PEnotes.pdf) in your DSL. Consider an example of the following **IF** expression for an arithmetic DSL.
```scala
IF(Variable("x") GreaterThan Variable("y")) {
  Add(Variable("x"), Value(2))
} {
  Multiply(Variable("y"), Variable("x"))
}
end IF
```
Whereas the evaluation of the branch **true** depends on the value of the variable **x** the result of the branch **false** is always the value of the variable **y**. If the values for both variables are provided in the environment table then the evaluation of this expression is trivial and it can be accomplished with the implementation of your language in the previous homeworks. However, specifying only one variable mapping to a value results in an error in the current DSL implementation. In this final homework your goal is to issue a partially evaluated expressions without throwing an exception, i.e., the return type of the evaluator is the union, **Expression | Boolean** where Expression is the supertype of the expression in your DSL.

For example, consider the result below of the partial evaluation of the expression above where the value of the variable **x** is one. This expression is obtained by replacing the references to the variable **x** with value one. Of course, it may be argued that this evaluation is not complete, since the expression **Add** can be reduced to value three. Moreover, in the branch **false** we can reduce the expression **Multiply** to **Variable("y")**. We call this step an optimization step, since it rewrites the program by transforming it into a simpler program.
```scala
IF(Value(1) GreaterThan Variable("y")) {
  Add(Value(1), Value(2))
} {
  Multiply(Variable("y"), Value(1))
}
end IF
```

The simpler program shown below is a result of the combined evaluation and optimization steps and achieving it is a goal of your final homework. The first step is to modify your DSL so that it can return either a partially evaluated program or a value if the environment table is incomplete. At one extreme, if the environment table is completely missing then the result of the partial evaluation will be the original program whereas at another extreme the result of the evaluation is a value of the type **Boolean**, something that you have already implemented in your previous homeworks. In this homework your job is to fill the gap in the middle between these two extremes.
```scala
IF(Value(1) GreaterThan Variable("y")) {
  Value(3)
} {
  Variable("y")
}
end IF
```

Next, you will implement the monadic function **map** for the type Expression that represents your core data type for boolean logic operations. Consider a program in your DSL as a container of expressions. The function **map** is applied to a container of the DSL expressions and they take functions as their parameters. The parameter functions are optimization transformers that rewrite the program into a simpler programs by applying specific transformations. For example, an example of a simple transformation is rewriting expression **Multiply(Variable("y"), Value(1))** into a simpler expression **Variable("y")**. That is, each optimizing transformer function is similar to the method **eval** that your have already implemented, except it is designed for a specific transformation. This way it is possible to create programs that will apply optimizing transformers to programs written in your DSL by creating more sophisticated transformers without changing the implementation of your DSL.

The signatures of the the monadic function **map** is the same that we studied in the class. The function **map** takes a function that is applied to each element in the container, i.e., each expression in your program to produce a resulting expression:
```scala
trait BoolLogicExpression:
  def map(f: BoolLogicExpression => BoolLogicExpression): BoolLogicExpression
```
Of course, this implementation can be generalized by using the parametric polymorphism, but it is not required for this homework. Please note that it is an example and not a strict guide to your implementation. You are free to experiment to choose signatures of the data types that you like as long as you explain your rationale in your documentation.

This homework script is written using a retroscripting technique, in which the homework outlines are generally and loosely drawn, and the individual students improvise to create the implementation that fits their refined objectives. In doing so, students are expected to stay within the basic core requirements of the homework (e.g., to implement various optimizing transformers) and they are free to experiments. Asking questions is important, so please ask away on the corresponding Teams channels!
//declare some exception class

## Functionality
Your homework can be divided roughly into five steps. First, you design the data types that represent partially evaluated expressions and you modify the method **eval** to allow it to return a partially evaluated program. Second, you design the monadic function, **map** to take optimizing transformer functions and apply them to partially evaluated programs. As in the previous homework you will add the logic for combining procedural and data abstractions into your class implementation with methods. Next, you will implement some examples of the optimizing transformers. Fourth, you will create an algorithm for partially evaluating programs in your DSL and optimizing them. Finally, you will create Scalatest tests to verify the correctness of your implementation. You will write a report to explain your implementation and the semantics of your language.

## Baseline
To be considered for grading, your project should include the support for partial evaluation, the monadic function, **map**, at least three optimizing transformation functions and all required operations and your project should be buildable using the SBT, and your documentation must specify how you create and evaluate expressions with branching and exception handling implementation in your language.

## Teams collaboration
You can post questions and replies, statements, comments, discussion, etc. on Teams. For this homework, feel free to share your ideas, mistakes, code fragments, commands from scripts, and some of your technical solutions with the rest of the class, and you can ask and advise others using Teams on language design issues, resolving error messages and dependencies and configuration issues. When posting question and answers on Teams, please select the appropriate folder, i.e., **hw5** to ensure that all discussion threads can be easily located. Active participants and problem solvers will receive bonuses from the big brother :-) who is watching your exchanges on Teams (i.e., your class instructor). However, *you must not post the source code of your program or specific details on how your implemented your design ideas!*

## Git logistics
**This is an individual homework.** You can reuse your repo from the previous homework or you can create a separate private repository for each of your homeworks and for the course project. Inviting other students to join your repo for an individual homework will result in losing your grade. For grading, only the latest push timed before the deadline will be considered. **If you push after the deadline, your grade for the homework will be zero**. For more information about using the Git please use this [link as the starting point](https://confluence.atlassian.com/bitbucket/bitbucket-cloud-documentation-home-221448814.html). For those of you who struggle with the Git, I recommend a book by Ryan Hodson on Ry's Git Tutorial. The other book called Pro Git is written by Scott Chacon and Ben Straub and published by Apress and it is [freely available](https://git-scm.com/book/en/v2/). There are multiple videos on youtube that go into details of the Git organization and use.

I repeat, make sure that you will give the course instructor and your TA the read/write access to *your repository* so that we can leave the file feedback.txt with the explanation of the grade assigned to your homework.

## Discussions and submission
As it is mentioned above, you can post questions and replies, statements, comments, discussion, etc. on Teams. Remember that you cannot share your code and your solutions privately, but you can ask and advise others using Teams and StackOverflow or some other developer networks where resources and sample programs can be found on the Internet, how to resolve dependencies and configuration issues. Yet, your implementation should be your own and you cannot share it. Alternatively, you cannot copy and paste someone else's implementation and put your name on it. Your submissions will be checked for plagiarism. **Copying code from your classmates or from some sites on the Internet will result in severe academic penalties up to the termination of your enrollment in the University**. When posting question and answers on Teams, please select the appropriate folder to ensure that all discussion threads can be easily located.


## Submission deadline and logistics
The submission deadline is Sunday, November 27 at 10PM CST. **THERE WILL BE NO SUBMISSION DEADLINE EXTENSION!** You will turn in your submission using the corresponding Assignments entry in Teams where you submit the link to your Github repository. Your repo will include the code, your documentation with instructions and detailed explanations on how to assemble and deploy your program along with the tests and a document that explains the semantics of your language, and what the limitations of your implementation are. Again, do not forget, please make sure that you will give your instructor/TA the write access to your repository. Your name should be shown in your README.md file and other documents. Your code should compile and run from the command line using the commands **sbt clean compile test** and **sbt clean compile run**. Also, you project should be IntelliJ friendly, i.e., your graders should be able to import your code into IntelliJ and run from there. Use .gitignore to exlude files that should not be pushed into the repo.

## Evaluation criteria
- the maximum grade for this homework is 10%. Points are subtracted from this maximum grade: for example, saying that 2% is lost if some requirement is not completed means that the resulting grade will be 10%-2% => 8%; if the core homework functionality does not work, no bonus points will be given;
- only some basic expression language is implemented without partial evaluation and the optimizing transformations: up to 10% lost;
- less than three optimizing transformer functions are provided and their usage is not shown: up to 8% lost;
- you should document how you implemented your solution to the questions in the section functionality and provide tests that result in error messages for prohibited uses of the implementation of the partial evaluation and optimization. Failure to do so results in losing up to 10% of your grade.
- as before, for each use of **var** instead of **val** 0.2% will be substracted from the maximum grade unless the use is justified by using vars only in local scopes for optimization purposes;
- not specifying .gitignore that excludes irrelevant files from the repo: up to 2% lost;
- for each non-spelling-related problem reported by the IntelliJ code analysis and inspection tool 0.2% will be substracted from the maximum grade;
- having less than five unit and/or integration tests that show how your implemented features work: up to 5% lost;
- missing comments and explanations from the program: up to 5% lost;
- no instructions in your README.md on how to install and run your program: up to 5% lost;
- the program crashes without completing the core functionality or it is incorrect: up to 10% lost;
- the documentation exists but it is insufficient to understand how you assembled and deployed all language components: up to 8% lost;
- the minimum grade for this homework cannot be less than zero.

That's it, folks!
