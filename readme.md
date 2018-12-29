
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


# redis  important info - https://redis.io/topics/data-types-intro
Set daemonize to yes (by default it is set to no).
Set the pidfile to /var/run/redis_6379.pid (modify the port if needed).
Change the port accordingly. In our example it is not needed as the default port is already 6379.
Set your preferred loglevel.
Set the logfile to /var/log/redis_6379.log
Set the dir to /var/redis/6379 (very important step!)
Finally add the new Redis init script to all the default runlevels using the following command:

sudo update-rc.d redis_6379 defaults