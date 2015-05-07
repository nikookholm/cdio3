package cdio3_v1.server;

public class WeightFunctions {
	
	String host = "localhost"; 
	int    port = 4567;
	
	TCPConnector tcp;
	
	public WeightFunctions() throws Exception
	{
		tcp = new TCPConnector(host, port);
		tcp.connect();
	}

	public Double tara()
	{
		String temp;
		tcp.send("T\r\n");
		temp = tcp.receive();
		if (temp.split(" ")[0] == "T")
		{
			return Double.parseDouble(temp.split(" ")[1]);
		}
		else
		{
			return null;
		}
	}
	
	public Double getWeight()
	{
		String temp;
		tcp.send("S\r\n");
		temp = tcp.receive();
		if (temp.split(" ")[0] == "S")
		{
			return Double.parseDouble(temp.split(" ")[1]);
		}
		else
		{
			return null;
		}
	}
	
	public boolean sendMessage(String message)
	{
		tcp.send(message + "\r\n");
		return (tcp.receive()=="D\r\n")? true : false;
	}
	
	public String sendRM20(String message)
	{
		String result;
		tcp.send(message);
		if ((result = tcp.receive()).indexOf("RM20 B") >= -1)
		{
			return tcp.receive();
		}
		else
		{
			return result;
		}
	}
	
}
