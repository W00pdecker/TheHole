import com.game.app.entities.Player;
import com.game.app.servlets.StartServlet;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class StartServletTest {


    HttpServletRequest request = mock(HttpServletRequest.class);
    HttpServletResponse response = mock(HttpServletResponse.class);
    StartServlet myServlet = new StartServlet();
    private HttpSession httpSession = mock(HttpSession.class);



    @Test
    public void startServletDoPostNameNull() throws IOException, ServletException {
        when(request.getParameter("name")).thenReturn(null);
        when(request.getSession()).thenReturn(httpSession);
        myServlet.doPost(request, response);
        verify(response).sendRedirect("/index.jsp");
    }

    @Test
    public void startServletDoPostPlayerIsNull() throws ServletException, IOException {
        when(request.getSession()).thenReturn(httpSession);
        when(request.getParameter("name")).thenReturn("something");
        when(request.getParameter("player")).thenReturn(null);
        try (MockedStatic<Player> player =  Mockito.mockStatic(Player.class)) {
            myServlet.doPost(request, response);
            player.verify(() -> Player.getInstance("something"));
        }
    }
}