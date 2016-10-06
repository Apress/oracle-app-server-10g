#!/usr/bin/ksh

# Name: stop_10gas.ksh
# By: M. Wessler 1/25/2004
# Script to stop 10g AS J2EE installation
# Assumes no infrastructure associated with this instance

export DISPLAY=mike.wessler.name:1
export ORACLE_HOME=/u01/app/oracle/product/9.0.4mt1/OraHome1
export PATH=$PATH:$ORACLE_HOME/bin:$ORACLE_HOME/opmn/bin:$ORACLE_HOME/dcm/bin:.

echo "Stopping all processes via OPMN"
$ORACLE_HOME/opmn/bin/opmnctl stopall

sleep 5
echo "\nShould not see any running application server processes\n"
ps -ef | grep -i oracle | grep -v ksh | grep -v grep | grep -v ps
