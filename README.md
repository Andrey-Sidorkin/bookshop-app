# Bookshop app

This tiny app allows to maintain DB with authors and their books. H2 databased is used. 
The app can receive and return JSON objects and is to be operated via the following endpoints:

#### Authors:

```GET: /authors``` — obtain all available authors<br>
```GET: /authors/{author_id}``` — get author by id<br>
```POST: /authors``` — add author to DB<br>
```PUT: /authors/{author_id}``` — update author<br>
```DELETE: /authors/{author_id}``` — delete author by id<br>

#### Books:

```GET: /books/{isbn}``` — get book by ISBN<br>
```GET: /books/by-genre?name=GENRE_NAME``` — get books by specified genre (case-insensitive)<br>
```GET: /books/by-author?id=AUTHOR_ID``` — get books by author id<br>
```GET: /books/by-keyword?key=KEYWORD``` — find books with title containing specified 
character sequence (case-insensitive)<br>
```POST: /books``` — add book to DB<br>
```PUT: /books/{isbn}``` — update book<br>
```DELETE: /books/{isbn}``` — delete book by ISBN<br>

## Technologies used

* Java
* Hibernate
* Spring
* H2
* SQL
* REST

## How to start

Before start you should replace fields ```YOUR_USERNAME``` 
and ```YOUR_PASSWORD``` in application.properties file with your own.<br>
As an initial data an author Marcel Proust is injected and two books by him: "The Prisoner" and
"In the Shadow of Young Girls in Flower". Enjoy!