### What is TDD?

Test Driven Development is the practice of development by creating tests. This document explains the basics of this
methodology.

#### Step 1: Write a test

For this example, we're going to try to write a method that returns the primitive `true`. Our first step is
to write the test method. This exercise is useful because it helps us define our API.

https://github.com/accesscode-2-1/unit-0-assessment/blob/master/src/nyc/c4q/Unit0TestsTest.java#L35-L44

Here we can see that we've written two tests. The first test checks to see if the method returns the right type.
The desired type is a boolean. The second test checks to see if it returns the correct boolean, true. For more
complex examples, you may want to write tests for specific cases or different classes of input.

#### Step 2: Run all tests

Run your tests. Your new test should fail. If your code doesn't compile, create the method, but don't actually fill
in the method yet. If you must return something, typically "false" or "null" or "0" types of values should be
your default return values before the method is implemented. You can see the method [here](https://github.com/accesscode-2-1/unit-0-assessment/blob/master/src/nyc/c4q/Unit0Tests.java#L23-L25).

#### Step 3: Write some code

Try to fill in the method with some code with the goal of passing your tests. This was the assessment.

#### Step 4: Run tests

If your tests pass, then continue! If they don't, then continue fixing your code and running your tests until they pass.

#### Step 5: Refactor code

Your code may pass the tests, but it may also be hard to read, or there might be a good reason to move code around.
For example, you may want to split your code into smaller pieces for better code reuse. Refactor your code and run
tests to make sure it still works. If you ever need to refactor your code in the future, then you have tests so you
know you haven't broken anything.

#### Step 6: Repeat

While adding/removing features or otherwise changing code, you can continue to add and rerun tests to ensure your code
works as expected.
