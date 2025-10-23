### Task Description

Design and implement your chosen system as a set of Kotlin classes and interfaces using OOP.
Your solution must demonstrate full understanding of OOP principles.
You are expected to write code, use correct access modifiers, and explain your design.

#### Project Requirements
1. System Domain
   Describe your system: What is its purpose? What entities (objects) does it have?
   List at least three main classes that represent core entities (e.g., User, Account, Product, Post, etc.).
   Describe relationships between classes (e.g., User owns Account, Post has Comments, User has Friends).
2. Class Hierarchy and Inheritance
   Create an abstract base class for your main domain objects.
   For example, Content for a social network, Account for banking, Product for shopping.
   Make at least two subclasses that inherit from the base class and add specific properties and behavior.
   Example: Post and Message inherit from Content.
   Use open and override keywords to show inheritance and polymorphism.
3. Interfaces
   Define at least two interfaces that specify important actions/services in your system.
   Example: Likeable, Commentable, Searchable, AccountService, etc.
   Implement these interfaces in relevant classes.
   Use interface-based programming for flexibility.
4. Encapsulation and Access Modifiers
   Use private, protected, and public modifiers for fields and functions.
   Show how you protect sensitive data (e.g., passwords, messages, user settings).
5. Polymorphism and Abstract/Virtual Methods
   Use abstract methods in base classes and override them in subclasses.
   Demonstrate polymorphism: Write code that works with base class or interface references, but executes subclass-specific logic.
6. Main User Scenario
   Create at least one user class (e.g., User, Profile, Member).
   Write a scenario in main() where a user interacts with your system:
   Create objects (users, posts, messages, etc.)
   Perform main operations (add/remove friends, post content, like, comment, send messages, etc.)
   Show how the system processes requests using OOP features.
7. Service Classes
   Implement at least one service class that performs business logic using interfaces.
   Example: PostService manages posts, FriendService manages connections, MessageService handles sending messages.
8. Data Management
   Use collections (List, Set, Map) to store entities in your system.
   Show how to add, remove, search, and update data.
   Implement checks (e.g., avoid duplicates, validate user actions).
9. Extra Functionality
   Implement at least three extra features that demonstrate advanced OOP or system logic, such as:
   * Sorting and filtering entities (e.g., sort posts by date, filter by hashtag or user).
   * User reactions (likes, dislikes, emoji), comments on posts/messages.
   * Copying objects using copy() or custom logic.
   * Decomposition (destructuring) of data classes.
   * Printing detailed info about objects.
   * Handling errors (e.g., duplicate friend requests, blocked users).
10. Documentation and Explanation
    For each class and interface, write a short comment explaining its purpose.
    In your main file, write an explanation of your design and how you used OOP concepts.
