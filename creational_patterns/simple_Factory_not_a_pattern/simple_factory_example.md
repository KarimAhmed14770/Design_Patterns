# 📰 Challenge: The Dynamic Content Ingestion Factory

## 📝 The Problem
You are building the core content engine for a modern publishing platform. The system handles three distinct types of content submissions:
1. **Blog Post:** Standard articles that require an author's name.
2. **News Post:** Time-sensitive reporting that requires a specific journalistic source or wire agency name.
3. **Product Post:** Commercial showcase entries that require a product price.

All three content variants share core common attributes: a `title` and the main body `content`. 

Currently, the front-end submission controllers are forced to use raw `if-else` or `switch` blocks to figure out which specific post type to create using the `new` keyword. This scatters object-creation logic across our application layers. 

Your task is to centralize this instantiation logic into a single dedicated helper class using the **Simple Factory** approach.

---

## 📋 The Requirements

### 1. The Parent Class (`Post.java`)
* This is the base class (or abstract class) that all specific post types will inherit from.
* It must contain the common fields: `title` (String) and `content` (String).
* Provide a constructor to set these fields and a method to print out or display the post data.

### 2. The Specific Content Subclasses
Create three separate classes that extend your base `Post` class and add their own custom attributes:
* **`BlogPost.java`** -> Adds an `author` (String) field.
* **`NewsPost.java`** -> Adds a `source` (String) field.
* **`ProductPost.java`** -> Adds a `price` (double or BigDecimal) field.

### 3. The Central Creator Class (`PostFactory.java`)
* This class is your Simple Factory. It should **not** inherit from anything.
* Create a single method: `public static Post createPost(String type, String title, String content, String extraAttribute)`
* Inside this method, use a standard conditional statement (`switch` or `if-else`) to evaluate the `type` string. 
* Based on that type, map the parameters, instantiate the correct subclass using `new`, and return it as the generic base `Post` type.
* If an unsupported type string is passed in, throw a clear `IllegalArgumentException`.

### 4. The Test Layer (`Main.java`)
* Write a main file that acts as the client application.
* Simulate receiving three different submission requests from a user.
* Call `PostFactory.type(...)` for each submission, capture the results in a generic `Post` variable, and print them out to verify that the factory successfully isolated the object creation.