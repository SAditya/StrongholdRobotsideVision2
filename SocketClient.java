package vision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient
{

	Socket imgSocket;
	PrintWriter out;
	BufferedReader in;
	BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

	public SocketClient()
	{
		String hostname = "127.0.0.1";
		int port = 82;

		try
		{
			imgSocket = new Socket(hostname, port);
			out = new PrintWriter(imgSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(
					imgSocket.getInputStream()));
			stdIn = new BufferedReader(new InputStreamReader(System.in));
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String testSocket()
	{
		String returnValue = "Error";
		try
		{
			returnValue = stdIn.readLine();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return returnValue;
	}
}
