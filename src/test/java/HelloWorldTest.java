import org.junit.ClassRule;
import org.junit.Test;
import org.testcontainers.containers.GenericContainer;

import java.io.IOException;
import java.net.Socket;

public class HelloWorldTest {
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

    System.out.println("hello world");
  }
}

class Fixture {
  public static GenericContainer simpleWebServer
    = new GenericContainer("alpine:3.2")
    .withExposedPorts(1550)
    .withCommand("/bin/sh", "-c", "while true; do echo "
      + "\"HTTP/1.1 200 OK\n\nHello World!\" | nc -l -p 1550; done");

  static {
    simpleWebServer.start();
  }
}
