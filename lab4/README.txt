Class: MyLinkedList
=======================================
  1:    5000 words in     305 milliseconds
  2:   10000 words in     514 milliseconds
  3:   15000 words in     674 milliseconds
  4:   20000 words in     842 milliseconds
  5:   25000 words in     982 milliseconds

Wordlist: small-wordlist.txt  Document: pride-and-prejudice.txt
words: 5000  increment: 5000  steps: 5  reps: 5
Class: MRUList
=======================================
  1:    5000 words in     221 milliseconds
  2:   10000 words in     366 milliseconds
  3:   15000 words in     521 milliseconds
  4:   20000 words in    1135 milliseconds
  5:   25000 words in    1280 milliseconds

Question 2: The linked list does increase linearly but the MRU list doesn't - instead it takes more time the more words.  This is because for this wordlist, the cost of shifting the list around takes more time than the benefit of using the MRUList 

words: 5000  increment: 5000  steps: 5  reps: 5
Class: MyLinkedList
=======================================
  1:    5000 words in    3456 milliseconds
  2:   10000 words in    5566 milliseconds
  3:   15000 words in    8671 milliseconds
  4:   20000 words in   12194 milliseconds
  5:   25000 words in   14873 milliseconds

Wordlist: medium-wordlist.txt  Document: pride-and-prejudice.txt
words: 5000  increment: 5000  steps: 5  reps: 5
Class: MRUList
=======================================
  1:    5000 words in     981 milliseconds
  2:   10000 words in    1663 milliseconds
  3:   15000 words in    2386 milliseconds
  4:   20000 words in    3140 milliseconds
  5:   25000 words in    3882 milliseconds

For a larger list I w\
ould expect it to be faster since MRUList assumes that words that show up earlier in the ext appear more often later, and this is proba\
bly more true for a larger wordlist.
I affirm that I have adhered to the Honor Code on this assignment. 
