import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="ResultServlet", urlPatterns = "/result")
public class ResultServlet extends HttpServlet {

    public ResultServlet(){super();}

    public void doGet(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html");
        try {
            request.setAttribute("year",request.getSession().getAttribute("year"));
            request.setAttribute("sum",request.getSession().getAttribute("sum"));
            request.getRequestDispatcher("result.jsp").forward(request,response);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

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
