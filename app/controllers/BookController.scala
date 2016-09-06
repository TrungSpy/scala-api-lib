package controllers

import play.api.libs.json._
import play.api.mvc._
import models.Book._

/**
  * Created by PhanVanTrung on 2016/09/06.
  *
  */

class BookController extends Controller {

  // Show list of books
  def listBooks = Action {
    Ok(Json.toJson(books))
  }
}


