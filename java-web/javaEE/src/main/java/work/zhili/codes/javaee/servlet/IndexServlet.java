package work.zhili.codes.javaee.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * Title : work.zhili.codes.javaee.servlet <br>
 * Company : 北京华宇元典信息服务有限公司 <br>
 * Description :
 *  <p>
 *  <ul> 
 *      <li>
 *  </ul>
 * @author chile
 * @version 1.0
 * @date 2018/3/8 18:11
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get");
        String path = this.getServletContext().getRealPath("/");
        String imagesPath = path + "/images";
        new File(imagesPath);
        resp.getWriter().print(path);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post");

        req.setAttribute("msg", "这是一条信息");

        resp.getWriter().print("It's funny.");

    }
}
