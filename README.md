# TextProcessingTool Documentation

## Table of Contents
1. [Overview](#overview)
2. [Package Structure](#package-structure)
3. [Class Descriptions](#class-descriptions)
    - [DataManager](#dataManager)
    - [RegexHelper](#regexHelper)
    - [SavedEntry](#savedEntry)
    - [TextEntry](#textEntry)
    - [TextProcessor](#textProcessor)

## Overview
The `TextProcessingTool` is a Java-based application designed to manage and process text data. It provides functionality for storing, retrieving, and manipulating text entries, as well as performing various text processing operations.

## Package Structure
All classes are located in the `textprocessingtool.model` package.
Runnable .jar file in dist directory

## Class Descriptions

### 1. DataManager
**Purpose:** Manages different data structures for storing text-related information.

**Key Features:**
- Maintains a `List`, `Set`, and `Map` for storing different types of text data
- Provides methods for adding, removing, and retrieving items from each data structure
- Ensures data encapsulation by returning copies of internal collections

**Methods:**
- `addToList(String item)`: Adds an item to the List
- `removeFromList(String item)`: Removes an item from the List
- `getSimpleList()`: Returns a copy of the List
- `addToSet(String item)`: Adds an item to the Set
- `removeFromSet(String item)`: Removes an item from the Set
- `getUniqueSet()`: Returns a copy of the Set
- `addTextEntry(TextEntry entry)`: Adds a `TextEntry` to the Map
- `getTextEntry(String id)`: Retrieves a `TextEntry` from the Map by ID
- `updateTextEntry(String id, String newContent)`: Updates the content of a `TextEntry`
- `removeTextEntry(String id)`: Removes a `TextEntry` from the Map
- `getAllTextEntries()`: Returns a copy of the Map containing all `TextEntries`

### 2. RegexHelper
**Purpose:** Provides utility methods for working with regular expressions.

**Key Features:**
- Pattern matching and replacement operations
- Finding all occurrences of a pattern in text

**Methods:**
- `containsPattern(String text, String pattern)`: Checks if the text contains the given pattern
- `findAllMatches(String text, String pattern)`: Finds all occurrences of the pattern in the text
- `replaceAll(String text, String pattern, String replacement)`: Replaces all occurrences of the pattern with the replacement string

### 3. SavedEntry
**Purpose:** Represents a collection of entries from different data structures.

**Properties:**
- `arrayListEntry`: String representing an entry from ArrayList
- `setEntry`: String representing an entry from Set
- `mapEntry`: String representing an entry from Map

**Methods:**
- `getArrayListEntry()`: Returns the ArrayList entry
- `getSetEntry()`: Returns the Set entry
- `getMapEntry()`: Returns the Map entry

### 4. TextEntry
**Purpose:** Represents a text entry with an ID and content.

**Properties:**
- `id`: String identifier for the entry
- `content`: String content of the entry

**Methods:**
- `getId()`: Returns the ID of the entry
- `getContent()`: Returns the content of the entry
- `setContent(String content)`: Sets new content for the entry

### 5. TextProcessor
**Purpose:** Provides various text processing operations.

**Key Features:**
- Word counting and occurrence tracking
- Text capitalization and word reversal

**Methods:**
- `wordCount(String text)`: Counts the number of words in the text
- `wordOccurrenceCount(String text, String word)`: Counts occurrences of a specific word in the text
- `capitalizeWord(String text)`: Capitalizes the first letter of each word in the text
- `reverseWords(String text)`: Reverses the order of words in the text

## Examples
### DataManager Usage
```java
DataManager dataManager = new DataManager();
dataManager.addToList("Hello");
dataManager.addToSet("World");
TextEntry entry = new TextEntry("1", "Sample text");
dataManager.addTextEntry(entry);
System.out.println(dataManager.getSimpleList()); // [Hello]
System.out.println(dataManager.getUniqueSet());  // [World]
System.out.println(dataManager.getTextEntry("1").getContent()); // Sample text
