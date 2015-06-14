### Android UI Basics

#### Objective

Students will learn about the properties of widgets and containers and be more comfortable editing widget properties in the XML.

#### Code Review

Code Review a lucky developer's app!

#### Lesson (Morning)

Widgets are UI components meant to serve a particular interaction with the user. Containers determine the structure of how widgets are arranged. Here are a few key things to know about widgets:
* Parent/Child: If a widget A is structured within another widget or container B, then A is a child of B, and B is a parent of A.
* Padding vs. Margin: Padding is internal spacing, margin is external spacing.
* match_parent: Fills the space of the parent element. 
* wrap_content: Takes up the minimum amount of space needed for the content.
* Structure vs Function: XML displays the structure of the user interface. Function should be definied in Java. When structure needs to be defined in Java, it should be disconnected from function as much as possible.
* Structure vs Style: Structure defines the hierchy in which elements are laid out, while style dictates things such as font color and size. Although both can be defined in XML, these different pieces should also be separated from each other when possible.
* Callbacks: A callback is a piece of code passed to another piece of code, which controls the execution. We will start to see code that asynchronously executes some action. This may be different from the "linear" programs you may have been writing before. Reasoning about synchronous/asynchronous items will become important in the future.


> Exercise: Without using the designer, do the following:

> 1. Create an Android app with a blank Activity.

> 1. In the main layout, add a button.

> 1. Add another button positioned underneath the first button.

> 1. Add another button positioned undernead the second button.

> 1. Have your buttons display the text 1, 2, and 3 based on their position.

> 1. Add a button to the right of each button displaying R1, R2, and R3 respectively.

> 1. Add a TextView under each button.

> 1. Create an OnClickListener in a new class.

> 1. Implement a method that increments a class variable OnClick i.e. this variable should count the number of times something has been clicked.

> 1. Add a constructor to the OnClickListener that takes in a TextView and change OnClick such that it updates the TextView with the # of times the button has been clicked.

> 1. For each button, add an instance of the OnClickListener and pass in the corresponding TextView.

> 1. Create a new TextView that displays all the times all of the Buttons have been clicked in total.

> 1. Exchange code review with the person at your table and resolve all comments.

#### Do Now (Afternoon)

Add TODOs into your horoscope app based on what we learned this morning.

#### Github

Work on yesterdays' [Github exercises](10_Github-Debugging.md)

#### Group Project 

Spend the rest of the day working on your group project with your team.

#### Assessment

[Exit Ticket](https://docs.google.com/forms/d/1a-gfjjsn35N-C6wrQU9y02vHoYLFaEfjUgD7J91n3rM/viewform?usp=send_form)

#### Resources
* Textbook: The Theory of Widgets, The Android User Interface, Basic Widgets
