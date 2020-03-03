package Listener;

public interface IPackageListener {
	void packageInstallSuccessfully(String packageName);
	void packageUninstallSuccessfully(String pacakgeName);
	void packageAlreadyInstalled(String packageName);
	void packageStillNeeded(String packageName);
	void packageNolongerNeeded(String packageName);
	void packageNotInstalled(String packageName);
}
