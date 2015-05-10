package cdio3_v1.server;

public class WeightFunctions {
	
	String host = "10.16.172.215"; 
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
		System.out.println(temp);
		if ("T".equals(temp.split(" ")[0]))
		{
			return Double.parseDouble(temp.split("\\s+")[2]);
		}
		else
		{
			System.out.println(">>>");
			return null;
		}
	}
	
	public Double getWeight()
	{
		String temp;
		tcp.send("S\r\n");
		temp = tcp.receive();
		if ("S".equals(temp.split(" ")[0]))
		{
			return Double.parseDouble(temp.split("\\s+")[2]);
		}
		else
		{
			return null;
		}
	}
	
	public boolean sendMessage(String message)
	{
		tcp.send("D " + message + "\r\n");
		return ("D A".equals(tcp.receive())) ? true : false;
	}
	
	public String sendRM20(String message)
	{
		String result;
		int type = 8;
		String request = "RM20 " + type + " \"" + message + "\" \" \" \" \"\r\n";
		tcp.send(request);
		result = tcp.receive();
		System.out.println(result);
		
		if (result.startsWith("RM20 B"))
		{
			return tcp.receive();
		}
		else
		{
			return result;
		}
	}
	
}
