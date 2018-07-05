import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="StartServlet", urlPatterns = "")
public class StartServlet extends HttpServlet {

    public StartServlet(){super();}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        try{
            request.getSession().setAttribute("year",request.getParameter("year"));
            request.getSession().setAttribute("sum",request.getParameter("sum"));
            response.sendRedirect("result");
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req,res);
        System.out.println("service");
    }

    public void destroy(){
        super.destroy();
        System.out.println("destroy");
    }

    @Override
    public void init(ServletConfig config) throws ServletException{
        super.init(config);
        System.out.println("init");
    }
}
