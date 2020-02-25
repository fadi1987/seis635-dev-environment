#!/bin/bash
sudo apt-add-repository ppa:ansible/ansible
sudo apt-get update
sudo apt-get install -y ansible
cp /home/vagrant/config/ansible.cfg /home/vagrant/.ansible.cfg
chown vagrant /home/vagrant/.ansible.cfg
chgrp vagrant /home/vagrant/.ansible.cfg
ansible-galaxy install -r /home/vagrant/config/requirements.yml
ZSH='/home/vagrant/.oh-my-zsh' ansible-playbook /home/vagrant/config/java-workstation.yml
echo "vagrant:vagrant" | chpasswd 