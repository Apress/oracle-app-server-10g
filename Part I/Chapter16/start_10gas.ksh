#!/usr/bin/ksh

# Name: start_10gas.ksh
# By: M. Wessler 1/25/2004
# Script to start 10g AS J2EE installation
# Assumes no infrastructure associated with this instance

export DISPLAY=mike.wessler.name:1
export ORACLE_HOME=/u01/app/oracle/product/9.0.4mt1/OraHome1
export PATH=$PATH:$ORACLE_HOME/bin:$ORACLE_HOME/opmn/bin:$ORACLE_HOME/dcm/bin:.

echo "Starting all processes via OPMN"
$ORACLE_HOME/opmn/bin/opmnctl startall

echo "Checking process status"
$ORACLE_HOME/dcm/bin/dcmctl getstate

echo "\nShould see all processes Up and Sync status is True"

