@echo off & setlocal enabledelayedexpansion

set LIB_JARS=""
cd .\lib
for %%i in (*) do set LIB_JARS=!LIB_JARS!;.\lib\%%i

cd ..\

echo %LIB_JARS%

java -Xms1024m -Xmx1024m -XX:MaxPermSize=256M -classpath .\config;%LIB_JARS% -jar ./lib/murphy-shell-1.0.0.jar

@pause