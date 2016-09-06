package models

import play.api.libs.json.Json


/**
  * @author Phan Van Trung
  */
object  Book {

  case class Book(name: String, author: String)

  implicit  val bookWrites = Json.writes[Book]
  implicit  val bookReads = Json.reads[Book]


  var books = List(Book("Chi Dau", " Vu Trong Phung"), Book("Nhat ki Dang Thuy Tram", "Thuy Tram"))

  def addBook(b : Book) = books = books ::: List(b)
}