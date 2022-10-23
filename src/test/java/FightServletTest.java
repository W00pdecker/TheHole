import com.game.app.entities.Player;
import com.game.app.servlets.FightServlet;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FightServletTest {
    HttpServletRequest request = mock(HttpServletRequest.class);
    HttpServletResponse response = mock(HttpServletResponse.class);
    FightServlet myServlet = new FightServlet();
    private HttpSession HttpSession = mock(HttpSession.class);

    @Test
    public void actionNullPointerException() {

        when(request.getParameter("action")).thenReturn(null);
        when(request.getParameter("enemy")).thenReturn("goblin");

        assertThrows(NullPointerException.class, () -> myServlet.doPost(request, response));
    }

    @Test
    public void enemyNullPointerException() {
        when(request.getParameter("action")).thenReturn("fight");
        when(request.getParameter("enemy")).thenReturn("null");
        assertThrows(NullPointerException.class, () -> myServlet.doPost(request, response));
    }

    @Test
    public void fightServletException() {
        when(request.getParameter("action")).thenReturn("nonsense");
        when(request.getParameter("enemy")).thenReturn("goblin");
        assertThrows(ServletException.class, () -> myServlet.doPost(request, response));
    }

    @Test
    public void ringTest() throws ServletException, IOException {
        when(request.getParameter("action")).thenReturn("negotiate");
        when(request.getParameter("enemy")).thenReturn("goblin");
        when(request.getSession()).thenReturn(HttpSession);

        try (MockedStatic<Player> player =  Mockito.mockStatic(Player.class)) {
            myServlet.doPost(request, response);
            player.verify(() -> Player.setRing("RingOfNight"));
        }
    }
}
