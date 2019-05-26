package sql.controlers;

import sql.entity.Elevi;
import sql.service.ElevService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

// neaparat sa apasa control+O, face magie

@WebServlet(urlPatterns = "/first")
public class my_first_servlet extends HttpServlet {

  private final ElevService elevService;


  public my_first_servlet() {
    elevService = new ElevService();
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    PrintWriter writer = resp.getWriter();

    writer.println("hai noroc");
    List<Elevi> allElevi = elevService.findAllElevi();
    for(Elevi elevi : allElevi){
      writer.println("Elev: " + elevi.toString());
    }
  }
}
