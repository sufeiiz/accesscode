### Github and Debugging

#### Objective
Students will learn general software engineering practices and will be able
to navigate Git, have more available debugging tools at their disposal,
and learn the basics of exception handling. 

#### Pre-Work

[Github & Git Foundations](https://www.youtube.com/playlist?list=PLg7s6cbtAD15G8lNyoaYDuKZSKyJrgwB-)

#### Do Now (Morning)

Create a new Java class to do the following string operations:
* Reverse - "Quispe" -> "epsiuQ"
* Uppercase words - "i love java" -> "I Love Java"
* Reverse words - "Java Love I" -> "I Love Java"
* Parse Addition Expression - "3 + (4 + 2)" -> "9". Assume that the only operations are "+" and parentheses.

#### Git and Github

*Git* is a version control system. *Github* is a very popular website for storing git repositories and collaborating.

Some basic git commands:

| Command | Description |
|---------|-------------|
| git init | Creates a new git repository |
| git clone [path] | Creates a local copy of a repository |
| git add | Adds a file or directory to staging |
| git rm | Adds the removal of a file or directory to staging |
| git commit | Commits staged changes to head |
| git push origin [branch] | Push changes to [branch] at remote |
| git status | Lists staged changes and changes that have not get been staged |
| git fetch | Get remote changes |
| git pull | Get remote changes and merge |
| git branch | List branches and indicate current branch |
| git branch [branchname] | Create new branch called [branchname] |
| git checkout [branchname] | Switch to branch called [branchname] |
| git checkout -b [branchname] | Create a new branch called [branchname] and switch to it |
| git blame | Revision and author of a line of the file |
| git log | Show commit logs |
| git diff | Show changes between commits |

Other vocabulary:
* Fork: A copy of a repository.
* Master: The main branch.
* Origin: The remote repository.
* Upstream: The repository that origin copied.
* Branch: A series of changes starting at a particular commit.

## Git log --graph
[git log graph](https://github.com/davisRoman/git_dag/blob/master/intro_to_the_dag.md)

-----

> Exercise: Partner with the other person at your table.

> Part I: Fork and Pull

> 1. Create a repository on Github.

> 1. Clone the repository locally, add the Do Now, and push the change to Github.

> 1. Fork your partner's repository.

> 1. Clone the fork of your partner's repository locally.

> 1. Set the upstream to your partner's repository.

> 1. Create a new branch and make changes to the file in your partner's repository.

> 1. Commit and push this change to Github.

> 1. Open a pull request to your partner's repository master.

> 1. Code review the pull request from your partner.

> 1. Respond to all the changes requested on your pull request (either make the change or push back), and push your changes.

> 1. Accept your partner's pull request.

> Part II: Merge Conflict

> 1. Make your partner a collaborator on your repository.

> 1. Sync your local clone of your repository to origin master.

> 1. Clone your partner's repository locally.

> 1. Make changes to the file in your partner's repository and push.

> 1. Make changes to the file in your own repository and commit.

> 1. Before pushing, sync to origin master.

> 1. Resolve any merge conflicts.

> 1. Push your changes to your repository.

> Part III: Shared repository

> 1. Sync your local clone of your partner's repository to origin master.

> 1. Create a new branch on your partner's repository.

> 1. Push this branch to Github.

> 1. Make changes to the file on this branch and push.

> 1. Open a pull request from this branch to master.

> 1. Code review your partner's pull request on your repository.

> 1. Respond to all comments on your partner's code review on your pull request (either make changes or push back) and push your changes.

> 1. Go back and forth code reviewing and responding to comments until all comments are resolved.

> 1. If comments can't be resolved, ask a third party to weigh in on your pull requst.

> 1. Once all comments are resolved, accept your partner's pull request.

> 1. Sync your local clones of your repositories to origin master, and delete all resolved branches.

#### Do Now (Afternoon)

Find the pull request for your reviewee from this week's code review. Download and run their horoscope app. If there are any problems with the pull request, please work with your reviewee to fix this pull request. 

#### Debugging Basics

##### Variable Scope

A few rules about variable scope:
* Anything declared between {} belongs only to that block. This also goes for the signature of a loop.
* Anything declared in a method only exists for the scope of that method.
* Reference class variables using the `this` keyword.

##### Reading Stack Traces

Stack traces explain the series of method calls that have led to the current state. For example:

```
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 1000000
	at BuggyClass.sum_loop(BuggyClass.java:44)
	at BuggyClass.find_sum(BuggyClass.java:29)
	at BuggyClass.main(BuggyClass.java:19) <5 internal calls>
```

Means that `main` called `find_sum` on line 19, `find_sum` called `sum_loop` on line 29, and `sum_loop` received an `ArrayIndexOutOfBoundsException` on line 44. On the other hand:

```
Exception in thread "main" java.lang.StackOverflowError
	at BuggyClass.sum_recursive(BuggyClass.java:50)
	at BuggyClass.sum_recursive(BuggyClass.java:52)
	at BuggyClass.sum_recursive(BuggyClass.java:52)
	at BuggyClass.sum_recursive(BuggyClass.java:52)
	at BuggyClass.sum_recursive(BuggyClass.java:52)
	at BuggyClass.sum_recursive(BuggyClass.java:52)
	at BuggyClass.sum_recursive(BuggyClass.java:52)
	at BuggyClass.sum_recursive(BuggyClass.java:52)
	at BuggyClass.sum_recursive(BuggyClass.java:52)
	at BuggyClass.sum_recursive(BuggyClass.java:52)
	at BuggyClass.sum_recursive(BuggyClass.java:52)
	.
	.
	.
```

means that `sum_recursive` infinitely calls itself and eventually crashes.

### Example:
- Division by zero

```java
public class Main {

    public static void m1(){
        System.out.println("Method one - m1");
        m2();
    }

    public static void m2(){
        System.out.println("Method two - m2");

        int  x= 10;
        int y = 0;

        double z = x/y;

        System.out.println(z);
    }

    public static void main(String[] args) {
        System.out.println("Starting Main method");
        m1();
        System.out.println("End main method");
    }
}
```
Output:
```
Exception in thread "main" java.lang.ArithmeticException: / by zero
Starting Main method
Method one - m1
Method two - m2
	at com.company.Main.m2(Main.java:16)
	at com.company.Main.m1(Main.java:7)
	at com.company.Main.main(Main.java:25)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at com.intellij.rt.execution.application.AppMain.main(AppMain.java:134)
```

##### Using the Debugger

The debugger allows you to set breakpoints in your code. When you run your code, the execution stops when it reaches a breakpoint. At this point, you can inspect the current state of the program as well as step through the code line by line.

> Exercise: Debug [BuggyClass](../exercises/10_Github-Debugging/src/BuggyClass.java). BuggyClass attemps to compare several different array addition algorithms, but it's fraught with bugs. Remember, bugs are problems with functionality, not just crashing. It may be tricky to infer what someone *meant* to do with the code - in the future you may have to deal with (and fix!) poorly-documented code written by someone who is no longer at the company, or is otherwise not contactable.

#### Exception Handling

Exceptions are errors generated by your program. These errors normally crash your program, but you can write code to `catch` them and recover.

First, let's see how to raise an exception. For example, let's say you had a `myDivide` method. Since dividing by zero isn't defined arithmetically, we should raise an exception.

```
public static double myDivide(int dividend, int divisor) {
    if(divisor == 0){
        throw new IllegalArgumentException("Dividing By Zero");
    }
    // implement division here
    .
    .
    .
}
```

Once an exception is raised, calling code may handle it. For example, let's say you are using the `myDivide` API for a calculator application.

```
public static void myCalculator(String userInput) {
    .
    . // parse userInput
    .
      .
        try {
            myDivide(num1, num2);
        }
        catch (IllegalArgumentException e) {
            alert_user(e.getMessage());
        }
      .
    .
    .
    .
}
```

Here, we use the exception to alert the user as to what went wrong. Exceptions propogate up the call stack, so the method that called `myCalculator` can also handle the exception. If the exception gets to the top of the call stack, then the program crashes.

##### Printing and Logging ( time permitting )

Printing is a very useful debugging method that you've probably already touched. Printing is useful because it can help display intermediate program state. Logging is essentially the same method (i.e. writing state to external output).

#### Bonus

[Project Euler Problem 20](https://projecteuler.net/problem=20)

#### Assessment

What does the first line in the call stack indicate? ([Exit Ticket](https://docs.google.com/forms/d/1a-gfjjsn35N-C6wrQU9y02vHoYLFaEfjUgD7J91n3rM/viewform?usp=send_form))
