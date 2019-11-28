import org.junit.Test;

import javax.net.SocketFactory;
import java.io.IOException;
import java.net.Socket;

public class AnotherTest
{
  @Test
  public void name()
  {
    try
    {
      Socket socket = new Socket(Fixture.simpleWebServer.getContainerIpAddress(), Fixture.simpleWebServer.getMappedPort(1550));
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }

    System.out.println("another test");

  }

}
