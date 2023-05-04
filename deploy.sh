#!/bin/bash

# Instance settings
INSTANCE_NAME=project-rsi
INSTANCE_OWNER=siwykot41

# Project settings
PACKAGE=net.wvffle.rsi
SERVICE=CityInformation

# Variables for later use
wsdl_subdomain="wsdl--main--$INSTANCE_NAME--$INSTANCE_OWNER"
package_dir="$(echo $PACKAGE | sed 's/\./\//g')"
service_file="./src/main/java/$package_dir/services/$SERVICE.java"

# Check if service file exists
if [ ! -f "$service_file" ]; then
	echo "Service file '$service_file' not found, check if the service name and the package are correct"
	exit 1
fi

# Generate server war file
if ! ./mvnw clean install war:war exec:exec; then
	echo "Failed to build or deploy war file, check logs for details"
	exit 1
fi

# Wait for server to deploy war file
sleep 0.1

# Fetch WSDL file
wget "https://$wsdl_subdomain.code.wvffle.net/RSI/${SERVICE}Service?wsdl" -O - | sed -E 's#http://'$wsdl_subdomain'.code.wvffle.net:80#https://'$wsdl_subdomain'.code.wvffle.net#g' >src/main/resources/service.wsdl

# Generate client source files
mkdir -p "src/main/java/$package_dir/client/generated"
if ! wsimport -J-Djavax.xml.accessExternalSchema=all src/main/resources/service.wsdl -keep -p $PACKAGE.client.generated -d src/main/java -wsdllocation /service.wsdl; then
	echo "Failed to generate client source files, check logs for details"
	exit 1
fi

# Generate client Jar file
if ! ./mvnw install; then
	echo "Failed to build client jar file, check logs for details"
	exit 1
fi
