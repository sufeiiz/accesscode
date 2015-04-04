# Calendar

In this project, we'll write some code to work with dates, including days of the week and holidays.  

You'll write a program that asks for a date and prints a summary for the date.  The summary will include the day of the week, whether this is a work day, whether it's a holiday (and if so which), whether Daylight Savings Time is in effect, and the zodiac sign for that date.  It will also print a mini calendar of the month containing that date.

Your program should work for all dates between 1980 and 2020.


## Setup

1. Each team should fork the repository.

1. Each team member should clone the forked repository and work there.

1. Open (not import) the project in IntelliJ.

1. Review the code to get a general understanding of the code that's already there. 


## Output

Your program will look like this:

```
date? 2015-07-04

date:              2015-07-04
day of week:       Saturday
work day:          false
national holiday:  Independence Day
is DST:            true
Zodiac sign:       Cancer

July 2015
             1   2   3   4*
 5   6   7   8   9  10  11 
12  13  14  15  16  17  18 
19  20  21  22  23  24  25 
26  27  28  29  30  31  
```


## Tasks

We've provided the skeleton of the program for you, as well as some of the implementation to get you started.

Throughout the code, we use the [`Calendar`](http://docs.oracle.com/javase/7/docs/api/java/util/Calendar.html) class to represent dates.  Review the documentation for this class to remind yourself of how it works and what methods are available.

In several instances, we'll be loading data out of files.  We'll use files that contain the dates of major holidays, the start and end dates for Daylight Savings Time, and dates for zodiac signs.  We've provided these files for you, but you'll need to write code to interpet their contents.  The files are in CSV ([Comma-Separated Values](http://en.wikipedia.org/wiki/Comma-separated_values)) format: each line contains one entry, with multiple values separated by commas.

The code has 8 methods that are missing their implementations, maked by "FIXME" in a comment.  Your team's job is to replace these FIXME's with the necessary code.  When you implement a method, read the method's documentation (the comment right above the method) carefully to understand what the method is supposed to do.

We've provided for you:

- The class `DateTools`, which contains some useful methods for dealing with dates.

  - `DateTools.formatDate` formats a date as a YYYY-MM-DD string. 

  - `DateTools.parseDate` parses a date from a YYYY-MM-DD string.

  - `DateTools.getNextDay` takes a `Calendar` and returns a new `Calendar` representing the following date.

- The class `FileTools`, which contains a method `readLinesFromFile`.  We'll use this for a number of the other methods, to load lines of text from a text file.

- A file [holidays.csv](src/holidays.csv) contains major holidays.  You'll have to interpret the contents of this file and select national holidays.

- A file [dst.csv](src/dst.csv) contains start and end dates for Daylight Savings Time in the United States for each year.

- A file [zodiac.csv](src/zodiac.csv) contains start and end dates for each zodiac period.

- The class `Zodiac` contains a complete implementation of the zodiac sign computation.  You can use this as a reference when working on the other parts, as they share some (but not all) features.


### Good luck!

Don't hesitate to shout out to @alex or the TAs on Slack if you don't understand the project, or get stuck.


