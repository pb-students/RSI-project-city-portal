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
glassfish_log_file="/glassfish5/glassfish/domains/domain1/logs/server.log"

# Check if service file exists
if [ ! -f "$service_file" ]; then
	echo "Service file '$service_file' not found, check if the service name and the package are correct"
	exit 1
fi

# Generate server war file
if ! ./mvnw clean install war:war; then
	echo "Failed to build war file, check logs for details"
	exit 1
fi
            
# Deploy war file
echo "" > $glassfish_log_file
if ! /glassfish5/bin/asadmin deploy --force=true --contextroot=RSI --name=RSI target/RSI-*.war; then
	echo "Failed to deploy war file, check logs for details"
	code-server $glassfish_log_file
	exit 1
fi

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
