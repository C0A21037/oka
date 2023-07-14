package g04.upload;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.servlet.RequestDispatcher;

//適宜，変更してください．例えば，/gxx/UploadServlet 等．
@WebServlet("/upload/UploadServlet")
// アップロードされたファイルを一時的に保存する場所．gxxを，g20等のグループ番号を指定してください．
// コーディング上は使うこと無いので，xxのところは番号を指定するだけでOKです．
/// /opt/tomcat/apache-tomcat-9.0.45/work/Catalina/localhost から見た相対パス．
// 例えば/gxx だと，/opt/tomcat/apache-tomcat-9.0.45/work/Catalina/localhost/gxx
// 以下に保存されます．
@MultipartConfig(location = "/g04", maxFileSize = 100048576)
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Part part = request.getPart("file");
        String name = this.getFileName(part);
        // 予め，↓で指定したディレクトリを作成しておく必要があります．gxxフォルダを起点とした相対パスです．
        // 下の場合だと，webappsのgxx/WEB-INF/uploadedフォルダにファイルが保存される仕組みです．
        part.write(getServletContext().getRealPath("/WEB-INF/uploaded") + "/" + name);
        // response.sendRedirect("/upload/upload.jsp");
        // 外部ファイルに転送する準備（webapps/gxx/upload/upload.jspに転送する場合が↓．）
        RequestDispatcher dispatcher = request.getRequestDispatcher("/upload/upload.jsp");
        // 外部ファイルに表示処理を任せる
        dispatcher.forward(request, response);
    }

    private String getFileName(Part part) {
        String name = null;
        for (String dispotion : part.getHeader("Content-Disposition").split(";")) {
            if (dispotion.trim().startsWith("filename")) {
                name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
                name = name.substring(name.lastIndexOf("\\") + 1);
                break;
            }
        }
        return name;
    }
}