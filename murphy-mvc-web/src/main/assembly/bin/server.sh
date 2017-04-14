#!/bin/sh  
#-------------------------------------------------------------------------------------------------------------      
APP_MAIN=com.dang.reverse_pushToErp_job.shell.Program

APP_HOME=$(cd `dirname $0`; cd .. ; pwd)  
APP_LOG=$APP_HOME/log   
CLASSPATH=$APP_HOME

JAVA_OPTS="-Duser.timezone=GMT+8 -server -Xms512m -Xmx512m -XX:MaxPermSize=256m -Xloggc:$APP_LOG/gc.log"  

for tradePortalJar in "$APP_HOME"/lib/*.jar  
do  
   CLASSPATH="$CLASSPATH":"$tradePortalJar"  
done  

cd $APP_HOME

if [ -d "$APP_LOG" ]; then
  echo "make log dir"
else
  mkdir "$APP_LOG"
fi


 
tradePortalPID=0  
   
getpid(){  
    javaps=`$JAVA_HOME/bin/jps -l | grep $APP_MAIN`  
    if [ -n "$javaps" ]; then  
        tradePortalPID=`echo $javaps | awk '{print $1}'`  
    else  
        tradePortalPID=0  
    fi  
}  
  

start(){  
    getpid  
    echo "======================================================================================"  
    if [ $tradePortalPID -ne 0 ]; then  
        echo "$APP_MAIN already started(PID=$tradePortalPID)"  
        echo "======================================================================================"  
    else  
        echo -n "Starting $APP_MAIN"  
        nohup $JAVA_HOME/bin/java $JAVA_OPTS -classpath $CLASSPATH $APP_MAIN > $APP_LOG/nohup.log &  
        getpid  
        if [ $tradePortalPID -ne 0 ]; then  
            echo "(PID=$tradePortalPID)...[Success]"  
            echo "======================================================================================"  
        else  
            echo "[Failed]"  
            echo "======================================================================================"  
        fi  
    fi  
}  
  

stop(){  
    getpid  
    echo "======================================================================================"  
    if [ $tradePortalPID -ne 0 ]; then  
        echo -n "Stopping $APP_MAIN(PID=$tradePortalPID)..."  
        kill -9 $tradePortalPID  
        if [ $? -eq 0 ]; then  
            echo "[Success]"  
            echo "======================================================================================"  
        else  
            echo "[Failed]"  
            echo "======================================================================================"  
        fi  
        getpid  
        if [ $tradePortalPID -ne 0 ]; then  
            shutdown  
        fi  
    else  
        echo "$APP_MAIN is not running"  
        echo "======================================================================================"  
    fi  
}  
  
#-------------------------------------------------------------------------------------------------------------  
#-------------------------------------------------------------------------------------------------------------  
status(){  
    getpid  
    echo "======================================================================================"  
    if [ $tradePortalPID -ne 0 ]; then  
        echo "$APP_MAIN is running(PID=$tradePortalPID)"  
        echo "======================================================================================"  
    else  
        echo "$APP_MAIN is not running"  
        echo "======================================================================================"  
    fi  
}  


if [ "$1" = "start" ]; then
	start
else
	if [ "$1" = "stop" ]; then
		stop
	else
		if [ "$1" = "status" ]; then
			status
		else
			start
		fi
	fi
fi
