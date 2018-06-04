# cinemahh

- required PostgreSQL Database
- make changes to hibernate.cfg.xml according to your db props
- run db-table-creation.sql script

run
-
mvn tomcat7:run

debug:
-
IntelliJ:
 - Maven -> Plugins -> tomcat7 -> tomcat7:run debug mode

Eclipse: 
- run with jvm settings: -Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=-SET DEBUG PORT HERE-
