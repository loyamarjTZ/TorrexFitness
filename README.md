# TEKsystems Capstone Project: Torrex Fitness
## Table of Contents
* Daily Progress Reports
* About this App

## Progress Reports
### 4/15/22 - Completion Status: 60%
* updated all models to implement entity relationships according to DB schema 
* database is now capable of storing relevant persisted data
* revising app UI to a simpler version for ease of testing

### 4/14/22 - Completion Status: 55%
* received help from Supamas to correct my DB schema. Changes involved:
  * adding Order_Items table
  * modifying existing tables to account for new field structure
  * modified entity-relationships among tables
  * added DB Schema diagram under resources/static/images/torrex_fitness_db_schema_final.PNG
* revised Product CRUD operations
* converted User model to Customer model since User and Customer should be treated as two different models

### 4/13/22 - Completion Status: 50%
* modified the Cart and CartItem models to include @OneToMany and @ManyToOne annotations respectively.
* nearly completed with CRUD operations for Cart; need to refine
* Researching how to add a list of CartItems to a Cart
* Researching how to use @Transient to determine subTotal, tax, and total
* images are causing issues with login; will simplify and exclude images in UI pages to assure functionality.

### 4/12/22 - Completion Status: 40%
* improved User and Product Controllers
* finished CRUD operations for User and Products models
* created home page for Admin and SuperAdmin (needs styling)
* received help from Ryan and improved transitions from one page to another using Thymeleaf

### 4/11/22 - Completion Status: 30%
* redesigned the models of my app. Still a work in progress.
* rewrote some and still implementing all CRUD functions 
* received help from Ryan and Corey regarding security

## About this App
### What is Torrex Fitness?
* Torrex Fitness is a simple Ecommerce application that sells gym equipment.

### What can it do?
* Users will be able to:
  * create an account
  * sign in to their account
  * add products to their cart
  * remove products from their cart
  * complete an order
  

* Admins will be able to:
  * have the same functionality as a User
  * add a user to the user list
  * add a product to the product list


* SuperAdmins will be able to:
  * have the same functionality as an Admin
  * delete users from the user list
  * delete products from the product list

