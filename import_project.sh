#!/bin/bash

# Imports project taking as argument from eclipse letting Eclipse project untouched
# Example: ./import_project.sh practica1


ECLIPSE_WORKSPACE=$HOME/eclipse-workspace

import_project(){
	TARGET_PROJECT=$1

	SOURCE_DIRECTORY="${ECLIPSE_WORKSPACE}/${TARGET_PROJECT}"
	DEBUG_DIRECTORY="${TARGET_PROJECT}/Debug"

	echo "Copy ${TARGET_PROJECT} to repository"
	cp -r -v $SOURCE_DIRECTORY .

}

if [ "$#" -ne 1 ]; then
	echo "ERROR: ${0} <project_name>" 1>&2
	exit 1
else 
	import_project $1
fi
