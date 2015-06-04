#Using APIs

###Resources

[The Java API Spec](http://docs.oracle.com/javase/7/docs/api/)

[JSON.simple](https://code.google.com/p/json-simple/)

###Exercises

####HashSet

A [Set](http://en.wikipedia.org/wiki/Set_%28abstract_data_type%29) is a data structure that stores a collection of unique values. The values are not stored in a particular order. Java has several different implementations of Set. Today we'll use [HashSet](http://docs.oracle.com/javase/6/docs/api/java/util/HashSet.html).

Exercises:
> 1. Import the HashSet and create a HashSet object.
> 2. Use a HashSet to figure out how many unique words are in A Tale of Two Cities and Moby Dick, respectively. Feel free to refer back to the [Verbosity Calculator](https://github.com/accesscode-2-1/VerbosityCalculator) assignment.
> 3. Clean up the code - your HashSet currently thinks "the." and "the" and "The" are all different words! Do some [String](http://docs.oracle.com/javase/7/docs/api/java/lang/String.html) operations to make your word counts more accurate.
> 4. Create a set that is the [intersection](http://en.wikipedia.org/wiki/Intersection_%28set_theory%29) of words between A Tale of Two Cities and Moby Dick. What is the cardinality (size) of this set?
> 5. Create a set that is the [union](http://en.wikipedia.org/wiki/Union_(set_theory)) of words between A Tale of Two Cities and Moby Dick.
> 6. Create an iterator for the union set.
> 7. For fun - try this again but with two books from the same author!

####Stripe API
Play around with the [Stripe](https://stripe.com/) API. Stripe makes it easy to integrate payments into your applications - you may even find this useful for your final projects!

To begin, take a look at Stripe's [Java library project](https://github.com/stripe/stripe-java) on Github. This gives an overview of how to include Stripe in your Java project. As we learn Android, some of the different dependency management solutions like Maven or Gradle might make more sense. However, for this project just download [the latest jar](https://github.com/stripe/stripe-java/releases/tag/v1.27.0) and include this jar in your project.

Now, using [Stripe's Java documentation](https://stripe.com/docs/api?lang=java#intro) and the test API key provided try the following exercises:

> 1. Print out the email addresses of all the customers.
> 2. Print out the number of customers.
> 3. Create a charge, then retrieve the same charge.
> 4. Refund the charge you created in step 3.
> 5. Create, update and then delete a customer.
> 6. Create, update and then delete an invoice.
> 7. Try creating or retreiving data from one more type of object of your choosing.
