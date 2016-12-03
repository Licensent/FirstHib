package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by DarthVader on 28.11.2016.
 */
@WebServlet("/enterdata")
public class ServletForRequestUserPage extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
        req.setAttribute("name", "Nigga");
        req.getRequestDispatcher("RequestUserPage.jsp").forward(req, resp);

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("name", "Nigga");
        req.getRequestDispatcher("RequestUserPage.jsp").forward(req, resp);

    }

}
