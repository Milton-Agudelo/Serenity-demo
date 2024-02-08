Feature: User can see elements counting (Characters, words and sentences) and get more repeated words of a entered text

  @countCharacters
  Scenario: Characters counting
    Given Miguel wants to know the number of elements of a text
    When he enters the text to analyze
    Then he should see the number of characters

  @countWords
  Scenario: Words counting
    Given Miguel wants to know the number of elements of a text
    When he enters the text to analyze
    Then he should see the number of words

  @countSentences
  Scenario: Sentences counting
    Given Miguel wants to know the number of elements of a text
    When he enters the text to analyze
    Then he should see the number of sentences

  @getMostRepeatedWords
  Scenario: Most repeated words getting
    Given Miguel wants to know the number of elements of a text
    When he enters the text to analyze
    Then he should see the 7 most repeated words
