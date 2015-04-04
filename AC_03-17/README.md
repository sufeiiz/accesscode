# Hangman

* Player gets 7 tries to guess the correct word. 
* Random word library was created ggundersen.
* New words can be added into SecretWord.java

# In-class assignment

Use two custom classes, [`SecretWord`](https://github.com/accesscode-2-1/unit-0/blob/master/in-class%20exercise%20solutions/Hangman/SecretWord.java) and [`Drawing`](https://github.com/accesscode-2-1/unit-0/blob/master/in-class%20exercise%20solutions/Hangman/Drawing.java) to implement the game [Hangman](http://en.wikipedia.org/wiki/Hangman_%28game%29). Hint: you need to write your own class in `Hangman.java` and then use then other two classes to build your program! Some things to consider:

- Users can miss 5 times, after which they lose.
- User input should be uppercase letters.

You can choose how to precisely to implement hangman yourself, but here is an example game:

```
Let's play Hangman!

Word  : _ _ _ 
  |
Misses: 0
Guess : E
Word  : _ _ _ 
  |
 \
Misses: 1
Guess : G
Word  : G _ _ 
  |
 \
Misses: 1
Guess : I
Word  : G _ _ 
  |
 \0
Misses: 2
Guess : L
Word  : G _ _ 
  |
 \0/
Misses: 3
Guess : M
Word  : G _ M 
  |
 \0/
Misses: 3
Guess : U
Word  : G _ M 
  |
 \0/
  |
Misses: 4
Guess : T
Word  : G _ M 
  |
 \0/
  |
 /
Misses: 5
Guess : Y

You won!
The word was: G Y M 
```

You can look at the `.java` files directly to see what methods are available to you but in summary:

`SecretWord`

| Type | Method | Description |
|---|---|---|
| `boolean` | `isLetter(char letter)` | Returns `true` if `letter` is in the secret word, `false` otherwise. |
| `void` | `set(char letter)` | Sets `letter` as correctly guessed but throws an error if `letter` is not in the secret word. |
| `String` | `toString()` | Returns a `String` of the secret word with underscores for un-guessed letters. |
| `String` | `reveal()` | Returns a full `String` of the secret word. |
| `boolean` | `isGuessed()` | Returns `true` if the secret word has been guessed, `false` otherwise. |

`Drawing`

| Type | Method | Description |
|---|---|---|
| `String` | `get(int misses)` | Returns the drawing as a `String`, dependent on the number of `misses`. |

##### Bonus questions:

Have you already finished the assignment? Here are a few other things to try:
- `SecretWord` expects uppercase letters, but the user can input anything they'd like. Check user input and gracefully report back to the user ("Please only use uppercase letters") rather passing the input on to `SecretWord`.
- If the user guesses the same letter twice, we don't care. Can you instead report a specific message, for example, "You've already guessed that letter"? You can do this without any new tools, i.e. without arrays.
- So long as you do not effect the misses-to-output relationship of `Drawing`, the object can return whatever you'd like. Change how the stick figure is drawn.
