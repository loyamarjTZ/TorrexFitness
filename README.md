# TEKsystems Capstone Project: Torrex Fitness

## Table of Contents

* [Progress Reports](#Progress-Reports)
* [About this App](#About-this-App)
* [Technical Challenges](#Technical-Challenges)
* [Lessons Learned](#Lessons-Learned)
* [Future Improvements](#Future-Improvements)
* [Technical Architecture](http://)
* [Wire Frame](http://)
* [Schema Diagram](http://)
* [Contact Me](mailto:jose.loyamarquez@outlook.com)

## Progress Reports

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
* updated all models to implement entity relationships according to DB schema
* updated all models to implement entity relationships according to DB schema
* database is now capable of storing relevant persisted data
* revising app UI to a simpler version for ease of testing

### 4/14/22 (55% Done)
* received help from Supamas to correct my DB schema. Changes involved:
    * adding Order_Items table
    * modifying existing tables to account for new field structure
    * modified entity-relationships among tables
    * added DB Schema diagram under resources/static/images/torrex_fitness_db_schema_final.PNG
* revised Product CRUD operations
* converted User model to Customer model since User and Customer should be treated as two different models

### 4/13/22 (50% Done)
* modified the Cart and CartItem models to include @OneToMany and @ManyToOne annotations respectively.
* nearly completed with CRUD operations for Cart; need to refine
* Researching how to add a list of CartItems to a Cart
* Researching how to use @Transient to determine subTotal, tax, and total
* images are causing issues with login; will simplify and exclude images in UI pages to assure functionality.

### 4/12/22 (40% Done)
* improved User and Product Controllers
* finished CRUD operations for User and Products models
* created home page for Admin and SuperAdmin (needs styling)
* received help from Ryan and improved transitions from one page to another using Thymeleaf

### 4/11/22 (30% Done)
* redesigned the models of my app. Still a work in progress.
* rewrote some and still implementing all CRUD functions
* received help from Ryan and Corey regarding security

## About this App

### What is Torrex Fitness?
* Torrex Fitness is a simple Ecommerce application that sells gym equipment.

### User Stories
* Users will be able to:
    * create an account
    * sign in to their account
    * add products to their cart
    * remove products from their cart
    * complete an order


* Admins will be able to:

    * have the same functionality as a User
    * edit a user
    * edit a product
    * add a product


* SuperAdmins will be able to:
    * have the same functionality as an Admin
    * delete a user
    * delete a product
    * edit an order


## Technical Challenges

* Implementing the Torrex Fitness database was the most challenging aspect of this project. I regularly found myself
  modifying models according to what I thought was correct at the time. I modified my tables at least 3 times during the
  life of this project, either because I was not getting my desired outcome or I discovered a simpler implementation. I
  was particularly challenged by determining the Entity Relationships among my tables and implementing them using the
  @ManyToOne, @OneToMany, and @OneToOne annotations.
* Another challenge I encuntered was using Thymeleaf to make my web pages dynamic.

## Lessons Learned

## Future Improvements

  * have the same functionality as a User
  * add a user
  * edit a user
  * add a product
  * modify a product


* SuperAdmins will be able to:
  * have the same functionality as an Admin
  * delete a user
  * delete a product
  * modify an order
  * delete an order
  

## Technical Challenges
* Implementing the Torrex Fitness database was the most challenging aspect of this project. I regularly found myself modifying models according to what I thought was correct at the time. I modified my tables at least 3 times during the life of this project, either because I was not getting my desired outcome or 
I discovered a simpler implementation. I was particularly challenged by determining the Entity Relationships among my tables and implementing them using the @ManyToOne, @OneToMany, and @OneToOne annotations. 
* Another challenge I encountered was using Thymeleaf to make my web pages dynamic.

## Lessons Learned

## Future Improvements
