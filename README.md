# FastCards
# Dec 2017
# locke

Design requirements:
[ ] Includes String entry mode: Takes front, back, and priority (high, med, or low) of a flashcard from textfields and buttons and saves it in a Card (satisfies GUI and graphics)
[ ] Includes number entry mode: only ints are allowed on back of cards. Maybe that’s for times tables, etc. (satisfies exception handling)
[ ] Includes recall mode, where cards are displayed using g.drawString() in order of priority, then asks for a new priority setting.
[ ] (Optional) Includes active recall mode, where you have to enter the answer, and you get it wrong, you have to copy the answer exactly. Don’t except the answer until the text matches perfectly.
[ ] (Optional) Cards can be saved between sessions.
[ ] (Optional) Consider implementing concurrency.

Classes:
* FastCards contains main.
    * ArrayList<Card> highPriorityCards, medPriorityCards, lowPriorityCards;
* enum Priority provides string constants for HIGH, MED, LOW
* MainFrame displays the program’s modes.
* EntryPanel takes question and answer from two textfields.
* RecallPanel paints questionSide, paints answerSide, which prompts for priority.
* Card contains the questionSide and answerSide. Aggregation.
* (Optional) ActiveRecallPanel paints questionSide with a textfield for a response, which then prompts for priority.
