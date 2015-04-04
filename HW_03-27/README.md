# HW_03-27

### 1. Recap: Strings and loops 
Write a function **_uniqueCharacters_** which accepts as input a string **S**. Given the string **S** return a string **S2** which contains all the distinct characters in **S**. The input string will only contain lowercase characters. The ordering of characters in the output string does not matter. Eg.

* abbcaabcaa --> abc 
* apple --> aple or aepl
* microsoft --> microsft

### 2. Java Classes  
You are provided with a **Person** class. This class has private fields *name*, *phoneNumber* and *city*, along with their getter and setter methods.

* Write a function called **_checkSameCity_** which accepts as input two Person instances and checks if they live in the same city. The function should return a boolean value
* A *Person* has recently had a child, whose name is 'Abc'. Write a function called **_registerChild_** which accepts as input a Person instance(Parent) and returns a new Person instance for the child, which has the same *phoneNumber* and *city* as the parent.

### 3. Cryptography : Caesar Cipher
The Roman General Julius Caesar used to correspond with his generals using a secret code. He devised a way of *encrypting* his messages using a simple encryption scheme now known as **Caesar Cipher** or **Shift Cipher**. You can read more about it [here](http://en.wikipedia.org/wiki/Caesar_cipher)

* You are given a class called **CaesarCipher** with static methods *encode* and *decode*
* Being amateur codebreakers, we want to know if two distinct looking ciphers correspond to the same input message. Write a function called **_codeBreaker_**, which accepts two cipher strings and returns a boolean value which tells us whether they are actually the same input message encoded using two different offsets. 
* There are multiple ways to do this. Try to come up with as many solutions as you can.

### 4. BONUS : Voting System
You are given 3 classes

* **ElectionManager**
    * Conducts an election. 
    * Controls start of voting 
* **Election**
    * Maintains a list of contenders
* **Contender**
    * Represents details about a contender
        * What is the contender's name? 
        * How many votes has he received?

Write a program to simulate an election. Create a class called **VotingSimulator**. In the main method, you are required to do the following:

1. Create an **Election** object, and given the Election a *name*
2. Create a few **Contender** objects. **_Add_** these to the Election object. Make sure that the contender names are distinct!
3. Create a **ElectionManager** object. Ask it to **_manage_** the Election object created above.
4. Ask the ElectionManager to **_initiatePolling_**
5. Follow the instructions on the console. After each round of polling you will be asked(within the console) whether you want to continue or not.
6. Ask the ElectionManager to **_displayResults_**
