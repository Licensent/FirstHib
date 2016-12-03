package Servlets;

import Entities.UserPO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by DarthVader on 28.11.2016.
 */
@WebServlet("/result")
public class ServletForResponseUserPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String name = req.getParameter("name");
        String stringId = req.getParameter("id");
        Long id = Long.parseLong(stringId);
        ServiceForWeb web = new ServiceForWeb();
        UserPO userPO = null;
        try {
            userPO = web.getUser(name, id);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        if (userPO != null) {
            req.setAttribute("user", userPO);
        } else {
            req.setAttribute("wrongName", "Wrong Name or Id! Please check the Name or Id.");
        }

        req.getRequestDispatcher("ResponseUserPage.jsp").forward(req, resp);
    }
}
