import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/EnrollServlet")
public class EnrollServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String courseId = request.getParameter("courseId");
        HttpSession session = request.getSession();

        List<String> enrolled = (List<String>) session.getAttribute("enrolled");
        if (enrolled == null) enrolled = new ArrayList<>();

        if (!enrolled.contains(courseId)) enrolled.add(courseId);
        session.setAttribute("enrolled", enrolled);

        response.sendRedirect("DashboardServlet");
    }
}
