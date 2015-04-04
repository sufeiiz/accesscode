# HW_04-03

### 1. Linear Search on ArrayList 
You are given an ArrayList of unknown size containing integers. Write a class called **LinearSearch** which implements a static method **search** which accepts as input an integer **x**, and returns the first index it sees of **x** in the list. If the integer is not present return in the list return -1

    Eg. if arraylist contains: [3, 45, 1, 2, 99] and x = 1
    Returns : 2

### 2. Sanitizing web pages
Search engines like Google have programs called [web-scapers](http://en.wikipedia.org/wiki/Web_scraping) which visit webpages and scrape the information *displayed* on the webpage. The displayable information is contained in html tags like *p*, *table*, *h2* etc. When we make a GET request for a webpage, the HTML that is returned can also contain tags like **_script_** which often do not correspond to the displayable content on the webpage. Information inside _script_ tags is not used by scapers and they often ignore these tags in the HTML. Write a class called **WebPageSanitizer** which implements a static method called *String sanitize(String html)* which removes all script tags and the information that they encapsulate and returns a *sanitized* version of the HTML string.

### 3. Character Distributions
Create a class to calculate the distribution of characters in the contents of a file. Your class called **DistributionCalculator** should implement a method *calculate(File textFile)* which accepts as input a Text file. It reads the contents of the file and returns an ArrayList which contains the distribution/percentage of characters (a-z) in the text file. Call the *calculate* method from main and print the distribution. You can ignore characters which do not belong in the range(a-z) for doing your calculation. Your program's output should look something like:

    a = 14.44 %
    b = 6.02 %
    ...
    ...
    z = 0.05 %

### 4. Bonus/Challenge : Project Euler 
[Project Euler](https://projecteuler.net/) is a website dedicated to a series of computational problems intended to be solved with computer programs. The project attracts adults and students interested in mathematics and computer programming.  
As an exercise, we are asking you to solve one of Project Euler's problems described [here](https://projecteuler.net/problem=17). Create a class called **LettersInNumbers** which has a method **letterCount** which returns an integer containing the number of letters.
