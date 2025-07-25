@echo off
echo Starting Log Models Application with Maven...
mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Dfile.encoding=UTF-8"
pause 