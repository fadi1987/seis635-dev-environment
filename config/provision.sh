sudo apt-add-repository ppa:ansible/ansible
sudo apt-get update
sudo apt-get install -y ansible
echo "vagrant:vagrant" | chpasswd 
cp /home/vagrant/config/ansible.cfg /home/vagrant/.ansible.cfg 
ansible-playbook /home/vagrant/config/java-workstation.yml