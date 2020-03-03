package PackageManagement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Listener.PackageListenerAdapter;
import Package.Package;

public class PackageManager {
	private List<Package> packages;
	private Map<String, Package> packageMap;

	public PackageManager() {
		this.packages = new ArrayList<Package>();
		this.packageMap = new HashMap<String, Package>();
	}

	private void addPackage(String packageName) {
		Package newPackage = new Package(packageName);
		newPackage.addListener(new PackageListenerAdapter() {
			@Override
			public void packageInstallSuccessfully(String packageName) {
				System.out.println("   " + packageName + " successfully installed");

			}

			@Override
			public void packageUninstallSuccessfully(String pacakgeName) {
				System.out.println("   " + packageName + " successfully removed");

			}

			@Override
			public void packageAlreadyInstalled(String packageName) {
				System.out.println("   " + packageName + " is already intalled");

			}

			@Override
			public void packageStillNeeded(String packageName) {
				System.out.println("   " + packageName + " is still needed");

			}
			
			@Override
			public void packageNolongerNeeded(String packageName)
			{
				System.out.println("   " + packageName + " is no longer needed"); 
			}
			@Override
			public void packageNotInstalled(String packageName) {
				System.out.println("   " + packageName + " is not installed");
				
			}
		});
		this.packages.add(newPackage);
		this.packageMap.put(packageName, newPackage);

	}

	public void addDependent(String packageName, String dependentName) {
		if (!packageMap.containsKey(packageName)) {
			addPackage(packageName);
		}

		if (!packageMap.containsKey(dependentName)) {
			addPackage(dependentName);
		}

		this.packageMap.get(dependentName).getDependents().add(packageMap.get(packageName));

		if (detectCycle(packageMap.get(dependentName))) {
			notifyCycleDetected(dependentName);
			this.packageMap.get(dependentName).getDependents().remove(packageMap.get(packageName));
		}
	}
	
	public List<String> listInstalledPackages()
	{
		List<String> installedPackageNames = new ArrayList<String>();
		for(Package currentPackage : packages)
		{
			if(currentPackage.isInstalled())
			{
				installedPackageNames.add(currentPackage.getPackageName());
			}
		}
		return installedPackageNames;
	}

	public void installPackage(String packageName) {
		if (!packageMap.containsKey(packageName)) {
			addPackage(packageName);
		} else {
			installParents(packageName);

		}
		packageMap.get(packageName).installPackage(false);
	}
	
	public void uninstallPackage(String packageName)
	{
		if(packageMap.containsKey(packageName))
		{
			Package currentPackage = packageMap.get(packageName);
			if(currentPackage.unInstall(false)) {
				uninstallParents(packageName);
			}
		}
	}

	private void uninstallParents(String packageName) {
		Package currentPackage = packageMap.get(packageName);
		for(Package parent : getParents(currentPackage))
		{
			parent.unInstall(true);
		}
		
	}

	private void installParents(String packageName)
	{
		Package childPackage = packageMap.get(packageName);
		for(Package parent : getParents(childPackage))
		{
			parent.installPackage(true);
		}
	}
	
	private List<Package> getParents(Package childPackage) {
		List<Package> parents = new ArrayList<Package>();
		for (Package currentPackage : packages) {
			if (currentPackage != childPackage
					&& currentPackage.getDependents().contains(childPackage)) {
				parents.add(currentPackage);
			}
		}

		return parents;

	}

	private void notifyCycleDetected(String dependentName) {
		System.out.println("    Please double check the dependent " + dependentName + "'s dependency");

	}

	private boolean detectCycle(Package currentPackage) {
		if (currentPackage.getDependents().isEmpty()) {
			return false;
		}

		Set<Package> visited = new HashSet<Package>();
		return DFS(currentPackage, visited);
	}

	private boolean DFS(Package currentPackage, Set<Package> visited) {
		if (visited.contains(currentPackage)) {
			return true;
		}

		visited.add(currentPackage);

		for (Package neighbor : currentPackage.getDependents()) {
			if (!visited.contains(neighbor)) {
				if (DFS(neighbor, visited)) {
					return true;
				}
			}
		}

		return false;
	}
}
