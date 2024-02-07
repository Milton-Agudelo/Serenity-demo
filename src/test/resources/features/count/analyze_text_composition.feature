Feature: Count elements (Characters, words and sentences) and get more repeated words of a text

  @countCharacters
  Scenario: Characters count
    Given Miguel wants to know the features of a text
    When he enters the text to analyze
    Then he should see the number of characters

  @countWords
  Scenario: Words count
    Given Miguel wants to know the features of a text
    When he enters the text to analyze
    Then he should see the number of words

  @countSentences
  Scenario: Sentences count
    Given Miguel wants to know the features of a text
    When he enters the text to analyze
    Then he should see the number of sentences

  @getMostRepeatedWords
  Scenario: Most repeated words
    Given Miguel wants to know the features of a text
    When he enters the text to analyze
    Then he should see the 7 most repeated words
