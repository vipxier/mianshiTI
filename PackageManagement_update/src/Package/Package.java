package Package;

import java.util.HashSet;
import java.util.Set;

import Listener.IPackageListener;

public class Package {
	private String packageName;
	private Set<Package> dependents;
	private boolean installed;
	private IPackageListener packageListener;

	public Package(String packageName) {
		this.packageName = packageName;
		dependents = new HashSet<Package>();
	}

	public void addListener(IPackageListener listener) {
		this.packageListener = listener;
	}

	public boolean isInstalled() {
		return this.installed;
	}

	public String getPackageName() {
		return this.packageName;
	}

	public Set<Package> getDependents() {
		return this.dependents;
	}

	public void installPackage(boolean asParent) {
		if (isInstalled()) {
			if (!asParent) {
				notifyPackageAlreadyInstalled();
			}
			return;
		}
		this.installed = true;
		notifyPackageSuccessfullyInstall();
	}

	private void notifyPackageSuccessfullyInstall() {
		// TODO Auto-generated method stub
		packageListener.packageInstallSuccessfully(packageName);
	}

	private void notifyPackageAlreadyInstalled() {
		this.packageListener.packageAlreadyInstalled(packageName);

	}

	public boolean unInstall(boolean asParent) {
		if (!isInstalled()) {
			if(!asParent) {
				notifyPackageNotInstalled();
			}
			return false;
		}

		if (!canbeUninstalled()) {
			if (!asParent) {
				notifyPackageStillNeeded();
			}
			return false;
			
		}

		if (asParent) {
			notifyPackageNolongerNeeded();
		}
		this.installed = false;
		notifyPackageSccessfullyUninstall();
		return true;
	}

	private void notifyPackageNotInstalled() {
		// TODO Auto-generated method stub
		packageListener.packageNotInstalled(packageName);
	}

	private boolean canbeUninstalled() {
		for (Package dependent : dependents) {
			if (dependent.isInstalled()) {
				return false;
			}
		}
		return true;
	}

	private void notifyPackageNolongerNeeded() {
		// TODO Auto-generated method stub
		packageListener.packageNolongerNeeded(packageName);
	}

	private void notifyPackageSccessfullyUninstall() {
		// TODO Auto-generated method stub
		packageListener.packageUninstallSuccessfully(packageName);
	}

	private void notifyPackageStillNeeded() {
		packageListener.packageStillNeeded(packageName);

	}
}
