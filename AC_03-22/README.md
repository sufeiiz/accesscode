# URLs and HTTP

Goals:

1. understand these terms:
  - network
  - encoding
  - protocol
1. create and manipulate URLs
1. retrieve data via HTTP

[Click here for slides.](https://docs.google.com/a/c4q.nyc/presentation/d/12S0rxujSdbRiYtdWjB2wdC4aRHfsuIqidgykSlw0s2g)

**Important:** Please **fork** this repo and then clone your fork.

## Encoding

In Java, you can _encode_ a `char` as an `int` simply by casting it.

```java
int encoded = (int) 'x';
```

Likewise, to decode a character, simply cast it back.

```java
char decoded = (char) 120;
```

Note: Java uses a text encoding named _Unicode_, which is a superset of ASCII.  It encoded values are the same for English letters, digits, and punctuation, but characters from other languages have encodings too.

> **Exercises:**
> 
> 1. Write a method that determines whether a character is an uppercase letter.
> 
>  ```java
> public static boolean isUppercaseLetter(char c) {
>    // Write me.
> }
> ```
> 
> 1. Write a method that determines whether a character is a lowercase letter.
>
> 1. _Rot-13_ is a (very simple) _cryptographic cipher_: a code for transferring text or other information in such a way that the contents are understandable only to intended recipient.  It works by rotating each letter 13 positions forward in the alphabet.
> 
>  For example, A becomes N, B becomes O, C becomes P, _etc._  The alphabet wraps around from Z to A, so, for example, X becomes K.  Lower letters work similarly.  All other characters are unchanged.
> 
>  Write a method that encodes a string in rot-13. 
> 
>  ```java
>  public static String rot13Encode(String string) {
>    // Write me.
>  }
>  ```
>
> 1. Write `rot13Decode()`, which decodes the cipher.
> 
> 1. Generalize your methods to rotate any number of positions through the alphabet, not just 13.


## URLs

Use the `HTTP.stringToUrl(string)` method to convert a string to a `java.net.URL` object.  We've provided you this "factory method" because it's a bit easier to use than the standard constructors for the `URL` class.

See: http://docs.oracle.com/javase/7/docs/api/java/net/URL.html

> **Exercises:**
> 
> 1. Write a method that constructs an HTTP URL from the host name, port number, and path.  Include the port number only if it is _not_ 80.
> 
>  ```java
>  public static URL makeHttpUrl(String host, int port, String path) {
>    // Write me.
>  }
>  ```
> 
> 2. Using overloaded methods, write a similar method that doesn't take a port number, and assumes the port number is 80.
> 
> 3. Write a method that **neatly** prints out the parts of a URL, in the correct order.


## HTTP

We've provided a method `HTTP.get(url)` method to connect to a web server, request the correct path, and return you the data.  The argument is a `URL` object and the return value is a `String`.  You don't have to worry about the protocol at all.  Just pass it a URL object, and it will return to you a string (unless somethign went wrong).

> **Exercises:**
> 
> 1. Write a program that asks for a URL from the user.  Retrieve the document via HTTP and print them out.  If the URL is invalid, print an error message stating that.
> 
> 1. Write a program that asks for a URL and retrieves the document.  Guess whether the document is HTML by checking whether it begins with the string `<!doctype html>` (case-insensitive).  Print out whether the document is HTML.
> 
>  Test your program on,
>  - http://www.google.com/
>  - http://espn.go.com/
>  - http://canitbesaturdaynow.com/images/fpics/355/04_06_09__-(89).jpg
>  - http://www.gutenberg.org/cache/epub/1251/pg1251.txt
> 
> 1. Write a program that asks for a URL and a word.  The program retrieves the document and counts the number of times the word occurs in that document.
> 
>  For example, you could use it to retrieve _Alice in Wonderland_ from [Project Gutenberg](http://www.gutenberg.org/) and count how many times the word "Alice" appears.
> 
>  ```
>  enter URL: http://www.gutenberg.org/cache/epub/11/pg11.txt
>  enter word: Alice
>  That word occurs 403 times in the document.
>  ```

Project Gutenberg is a web site that provides thousands of free public domain ebooks.  They are available in a variety of formats, including "plain text", which is easy for computers to process.


