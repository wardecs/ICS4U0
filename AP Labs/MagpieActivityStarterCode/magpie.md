### Activity 1
1. Can you identify keywords to which your chatbot responds?

My chatbot would often respond with "Interesting" after saying no, until after some time it tried to change the topic.

2. Think of several keywords and the responses they might cause. 

| **Keyword**            | **Response**              |
| ---------------------- | ------------------------- |
| Hello                  | Hello                     |
| How are you?           | Doing Good!               |
| Tell me about yourself | Beep boop, I'm a computer |
| Goodbye                | See you soon!             |



### Activity 2

| Keyword | Response                                                     |
| ------- | ------------------------------------------------------------ |
| Money   | Do you happen to have your credit card information with you? |
| why?    | I'm stuck in Uganda, and need help.                          |
| Uganda  | Yeah, that's where I'm at right now!                         |

**What happens when a keyword is included in another word? Consider statements like “I know
all the state capitals” and “I like vegetables smothered in cheese.” Explain the problem with the
responses to these statements.**

The current system only checks whether the entire sentence contains a certain set of characters, it doesn't care that these characters are contained within another word, so long as they simply exist within the entire message.



### Activity 3:

`findKeyword("She's my sister", "sister", 0);`

| Iteration            | psn  | before | after |
| -------------------- | ---- | ------ | ----- |
| 1 | 9    | " "    | " "   |

`findKeyword("Brother Tom is helpful", "brother", 0);`

| Iteration            | psn  | before | after |
| -------------------- | ---- | ------ | ----- |
| 1    | 0    | " "  | " "  |

`findKeyword("I can't catch wild cats.", "cat", 0);`

| Iteration            | psn  | before | after |
| -------------------- | ---- | ------ | ----- |
| 1    | 8   | " "  | "c" |
| 2 | 19 | " " | "s" |

`findKeyword("I know nothing about snow plows.", "no", 0);`

| Iteration            | psn  | before | after |
| -------------------- | ---- | ------ | ----- |
| 1    | 3   | "k" | "w" |
| 2 | 7 | " " | "t" |
| 3 | 22 | "s" | "w" |

### Activity 4:
**Find an example of when this structure does not work well. How can you improve it?**

When saying something like "I think you are nice", the structure replies with "Why do you think me?" It would be possible to fix this by adding more conditions that check whether the user is using keywords like "think" within "I *something* you."

 