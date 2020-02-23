# SEIS635 Dev Environment:

This is a virtualized Java Development Virtual Machine.

Installed features:

- OpenJDK 1.8
- Eclipse
- Git
- Guake Terminal  ==> Press F12 to get a terminal to drop down.
- ZSH
- Ansible

The Vagrant file is configured to automatically mount the data folder to /opt/data.
Files saved to /opt/data will be preserved on the host machine.

## Configuring Hyper-V

```powershell
Enable-WindowsOptionalFeature -Online -FeatureName Microsoft-Hyper-V-All
[System.Environment]::SetEnvironmentVariable('VAGRANT_DEFAULT_PROVIDER', 'hyperv', 'user')
$env:VAGRANT_DEFAULT_PROVIDER = 'hyperv'
```

## How to run

Prerequisites:
  - Hyper-V
  - [Vagrant](https://www.vagrantup.com/downloads.html)

```powershell
vagrant up
```

## How to shutdown

```powershell
vagrant halt
```

## How to delete the VM

```powershell
vagrant destroy
```