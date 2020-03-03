package PackageManagement;

public class TestPackageMangement {
	public static void main(String[] args)
	{
		PackageManagement management = new PackageManagement();
		
		String[] commands = new String[] 
				{
						"DEPEND TELNET TCPIP NETCARD",
						"DEPEND TCPIP NETCARD",
						"DEPEND DNS TCPIP NETCARD",
						"DEPEND BORWSER TCPIP HTML",
						"INSTALL NETCARD",
						"INSTALL TELNET",
						"INSTALL foo",
						"REMOVE NETCARD",
						"INSTALL BORWSER",
						"INSTALL DNS",
						"LIST", 
						"REMOVE TELNET",
						"REMOVE NETCARD",
						"REMOVE DNS",
						"REMOVE NETCARD",
						"INSTALL NETCARD",
						"REMOVE TCPIP",
						"REMOVE BORWSER",
						"REMOVE TCPIP",
						"LIST",
						"END"
				};
		for(String command : commands)
		{
			management.translateCommand(command);
		}
	}
}
