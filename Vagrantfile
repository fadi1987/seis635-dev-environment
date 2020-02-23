vagrant_api_version = '2'
machines = {
  seis635: {
    box: 'estenrye/ubuntu-desktop',
    box_version: '1804.20190312.0',
    cpus: 2,
    mem: 4096,
    vmname: 'seis-635',
    network: 'Default Switch',
    script_path: 'config/provision.sh',
  },
}

$script = <<-SCRIPT

SCRIPT

Vagrant.configure(vagrant_api_version) do |config|
  machines.each do |hostname, info|
    config.vm.define hostname do |machine|
      machine.vm.synced_folder "./data", "/opt/data"
      machine.vm.box = info[:box]
      machine.vm.box_version = info[:box_version]
      machine.vm.hostname = hostname
      machine.vm.network 'public_network', bridge: info[:network]
      machine.vm.provision 'file', source: 'config', destination: '/home/vagrant/config' 
      machine.vm.provision 'shell', path: info[:script_path] if info[:script_path]

      machine.vm.provider 'hyperv' do |hv|
        hv.vmname = info[:vmname]
        hv.memory = info[:mem]
        hv.cpus = info[:cpus]
        hv.mac = info[:hv_mac] if info[:hv_mac]
      end
    end
  end
end