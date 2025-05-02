import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Course;

@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Course> courses = List.of(
            new Course("101", "Web Programming", "Dr. Smith"),
            new Course("102", "Data Structures", "Prof. John")
        );

        HttpSession session = request.getSession(false);
        List<String> enrolled = (List<String>) session.getAttribute("enrolled");
        if (enrolled == null) enrolled = new ArrayList<>();

        request.setAttribute("courses", courses);
        request.setAttribute("enrolled", enrolled);
        request.setAttribute("username", session.getAttribute("username"));

        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
    }
}
