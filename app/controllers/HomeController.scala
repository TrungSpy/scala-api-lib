package controllers

import play.api.mvc.{Action, Controller}

import scala.reflect.io.Path


/**
 * A very small controller that renders a home page.
  * @author Phan Van Trung
 */
class HomeController extends Controller {

  def index = Action { implicit request =>
    Ok(views.html.index())
  }
}
