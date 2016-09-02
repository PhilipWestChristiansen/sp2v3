import client.EchoClient;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import server.EchoServer;

public class ClientServerIntegrationTest {

    public ClientServerIntegrationTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String[] args = new String[2];
                args[0] = "localhost";
                args[1] = "7777";
                EchoServer.main(args);
            }
        }).start();
    }

    @AfterClass
    public static void tearDownClass() {
        EchoServer.stopServer();
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void send() throws IOException {
        EchoClient client = new EchoClient();
        client.connect("localhost", 7777);
        client.send("Hello");
        assertEquals("HELLO", client.receive());
        client.stop();
    }
    
    public void isStopped() {
        EchoClient ec = new EchoClient();
        assertTrue(ec.isStopped());
    }

}
