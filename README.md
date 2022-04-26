# TEKsystems Capstone Project: Torrex Fitness

## Table of Contents

* [Progress Reports](#Progress-Reports)
* [How to Use this App](#How-to-Use-this-App)
* [Technical Challenges](#Technical-Challenges)
* [Lessons Learned](#Lessons-Learned)
* [Future Improvements](#Future-Improvements)
* [Technical Architecture](https://github.com/loyamarjTZ/TorrexFitness/blob/main/torrex_fitness_tech_stack.PNG)
* [Application Wireframe](https://github.com/loyamarjTZ/TorrexFitness/blob/main/Torrex%20Fitness%20Wireframes.pdf)
* [Database Schema Diagram](https://github.com/loyamarjTZ/TorrexFitness/blob/main/torrex_fitness_db_schema.PNG)
* [Contact Me](mailto:jose.loyamarquez@outlook.com)

## Progress Reports

### 4/26/22 (100% Done)

* Deleted unnecessary web pages and comments
* Added CustomerRestController
* Formatted and refactored source code
* Added "How to use this App" section
* Project is ready for submission!

### 4/25/22 (95% Done)

* Received help from Ryan, Corey, and Sang to add Service and Repository JUnit testing
* Received help from Jonathan and Dan updating application.properties to create the torrex_fitness database if it
  doesn't exist
* Project is nearly complete, just need to satisfy a few more requirements and refactor source code for submission

### 4/24/22 (90% Done)

* Uploaded the following documents:
    * Database schema diagram
    * Technology stack diagram
    * Application Wireframe
* Formatted the values of subtotal, tax, and total
* Omitted, but not deleted, the Order and OrderItems models; will have to be implemented as a future feature.
* Added image carousel to the Product Gallery web page
* All that remains is to complete JUnit testing and refactor redundant source code

### 4/22/22 (80% Done)

* Completion status of project up this point has been based on the completeness of MVP functionality, however, today, it
  has been clarified that project completion should be determined by the completion of the Technical Requirements and
  Grading Rubric provided at the beginning of training.
* With this in mind, and after today's progress, project is 80% complete.
* Regarding today's progress: display of subtotal, tax, and total in the user_shopping_cart page is complete
* I am happy to share that MVP functionality is now complete! All that remains is the following:
    * Complete all remaining requirements from the Technical Requirements and Grading Rubric documents
    * Review and refactor all source code to remove redundant statements
    * Upload missing documents such as wireframes, database schema diagram, tech stack diagram, etc. to the project
      repository
* 100% completion expected by 4/25/22

### 4/21/22 (85% Done)

* Received help from Anthony, Ryan, Corey, and Eric in completing "Add to Cart" functionality
* Received help from Sang in implementing "Delete Item from Cart" functionality
* Work in progress: display the Subtotal, Tax, and Total of all items in the Cart

### 4/20/22 (80% Done)

* Implemented CartItemService, CartItemServiceImpl, and CartItemRepository
* Created web page for displaying cart items, subtotal, tax, and total
* Created new and modified existing handler methods to persist CartItems and update related tables as necessary

### 4/19/22 (75% Done)

* Users that register for an account are now simultaneously added to the Customer table
* Received help from Supamas and Ryan in persisting a Cart to the database
* Began implementing "Add to Cart" functionality

### 4/18/22 (70% Done)

* Simplified registration page.
* Received help from Supamas and Ryan to implement account registration feature. Users, Admins, and SuperAdmins can now
  register an account which grants them their respective ROLE privileges.

### 4/17/22 (65% Done)

* Admin Home, Customers, and Products pages have been simplified
* Added "quantity" field to Product model
* Created user_product_gallery page for customer to browse products
* Began implementing "Add to Cart" functionality

### 4/15/22 (60% Done)

* Updated all models to implement entity relationships according to DB schema
* Updated all models to implement entity relationships according to DB schema
* Database is now capable of storing relevant persisted data
* Revising app UI to a simpler version for ease of testing

### 4/14/22 (55% Done)

* Received help from Supamas to correct my DB schema. Changes involved:
    * Adding Order_Items table
    * Modifying existing tables to account for new field structure
    * Modified entity-relationships among tables
    * Added DB Schema diagram under resources/static/images/torrex_fitness_db_schema_final.PNG
* Revised Product CRUD operations
* Converted User model to Customer model since User and Customer should be treated as two different models

### 4/13/22 (50% Done)

* Modified the Cart and CartItem models to include @OneToMany and @ManyToOne annotations respectively.
* Nearly completed with CRUD operations for Cart; need to refine
* Researching how to add a list of CartItems to a Cart
* Researching how to use @Transient to determine subTotal, tax, and total
* Images are causing issues with login; will simplify and exclude images in UI pages to assure functionality.

### 4/12/22 (40% Done)

* Improved User and Product Controllers
* Finished CRUD operations for User and Products models
* Created home page for Admin and SuperAdmin (needs styling)
* Received help from Ryan and improved transitions from one page to another using Thymeleaf

### 4/11/22 (30% Done)

* Redesigned the models of my app. Still a work in progress.
* Rewrote some and still implementing all CRUD functions
* Received help from Ryan and Corey regarding security

## How to Use this App

1. Download/clone this project
2. Find the **application.properties** file under the **resources** directory and modify the following fields:
    * spring.datasource.username= **<your_mariadb_username>**
    * spring.datasource.password= **<your_mariadb_password>**
3. After updating the default username and password with your own, run the
   **TorrexFitnessApplication** class under the **com.joseloya.torrexfitness** directory. You may need to wait a couple
   of seconds for the TomCat server to start running.
4. Once the TomCat server is up and running, open a private browser window and type **localhost:8080/** in the address
   bar.
5. The application Sign In page should appear, and you may begin interacting with the application.

### User Stories

* Users will be able to:
    * create an account
    * sign in to their account
    * add products to their cart
    * remove products from their cart
    * complete an order (tbd)


* Admins will be able to:

    * have the same functionality as a User
    * edit a user
    * edit a product
    * add a product


* SuperAdmins will be able to:
    * have the same functionality as an Admin
    * delete a user
    * delete a product
    * edit an order (tbd)

## Technical Challenges

* Implementing the Torrex Fitness database was the most challenging aspect of this project. I regularly found myself
  modifying models according to what I thought was correct at the time. I modified my tables at least 3 times during the
  life of this project, either because I was not getting my desired outcome or I discovered a simpler implementation. I
  was particularly challenged by determining the entity relationships among my tables and implementing them using the
  @ManyToOne, @OneToMany, and @OneToOne annotations.


* Another challenge I encountered was using Thymeleaf to display data on my web pages.

## Lessons Learned

* **Prioritization is a skill.** I "bit off more than I could chew" when first declaring the features of my application,
  and I spent the last two weeks of training prioritizing only the features that contribute towards my MVP. As with any
  skill, I expect to improve my prioritization skills with more practice and experience.


* **Seek help often.** I received help from both my instructor and my peers on several occasions, to whom I owe a huge
  thanks for saving me time and sparing me headaches. Communicating our impediments during daily stand up often led to
  group discussions, which would lead to proposing solutions.


* **Create a sustainable work routine by taking regular breaks.** Although the pace of the bootcamp subjected me to the
  occasional burnout, I would recover faster by dedicating an entire day, usually Saturdays, to unwind. I would return
  from these breaks with a new approach on how to resolve my bugs and resolved them faster than if I had attempted to
  "truck" through them.

## Future Improvements

* Implement My Orders, All Orders, and multiple CartItems functionality.

## Potential Applications

* Doctors need a convenient way to request supplies for their patients, such as crutches, TENS units, slings, leg
  braces, etc. and my application could serve as a starting point for an in-house, supply-ordering service.