package PackageManagement;
import java.util.Arrays;
import java.util.List;

public class PackageManagement {
	private PackageManager manager;
	
	public PackageManagement()
	{
		this.manager = new PackageManager();
	}
	
	public void addDependencies(String packageName, String[] dependents)
	{
		for(String dependentName : dependents)
		{
			manager.addDependent(packageName, dependentName);
		}
	}
	
	public void removePackage(String packageName)
	{
		manager.uninstallPackage(packageName);
	}
	
	public void installPackage(String packageName)
	{
		manager.installPackage(packageName);
	}
	
	public void listPackages()
	{
		 for(String packageName: manager.listInstalledPackages())
		 {
			 System.out.println("    " + packageName);
		 }
	}
	
	public void translateCommand(String command)
	{
		if(this.manager == null)
		{
			throw new IllegalArgumentException("Invalid command");
		}
		System.out.println(command);
		switch(command)
		{
		case "END":
			this.manager = null;
			return;
		case "LIST":
			listPackages();
		default:
			String[] commandStrings = command.split(" ");
			if(commandStrings[0].contentEquals("INSTALL"))
			{
				installPackage(commandStrings[1]);
			}
			else if(commandStrings[0].contentEquals("DEPEND"))
			{
				addDependencies(commandStrings[1], Arrays.copyOfRange(commandStrings, 2, commandStrings.length));
			}
			else if(commandStrings[0].contentEquals("REMOVE"))
			{
				removePackage(commandStrings[1]);
			}
		}
	}
}
