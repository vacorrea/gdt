
documentation:

1. execute tests with apache benchmark
# ab  -t 60 -n 10000 https:domain:8443     

# create auto signed cert
keytool -genkeypair -alias gdt -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore keystore.p12 -storepass passwd -keypass passwd -dname 'CN=globo' -validity 3650
# list
keytool -list -v
keytool -list -v -storetype pkcs12 -keystore keystore.p12


# ansible playbooks
 $ ansible-playbook -i /etc/ansible/hosts  /home/vcorrea/Desktop/area51/app/gdt/playbook/redis.yaml  --ask-become-pass
