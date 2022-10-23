
import com.game.app.servlets.NextServlet;
import org.junit.jupiter.api.Test;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class NextServletTest {
    HttpServletRequest request = mock(HttpServletRequest.class);
    HttpServletResponse response = mock(HttpServletResponse.class);
    NextServlet myServlet = new NextServlet();





    @Test
    public void nextServletExceptionDoGet() {
        when(request.getParameter("page")).thenReturn(null);
        assertThrows(ServletException.class, () -> myServlet.doGet(request, response));
    }


}
