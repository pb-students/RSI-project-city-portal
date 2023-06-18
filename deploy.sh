#!/bin/bash

# Generate server war file
./mvnw clean install war:war exec:exec
if [ $? -ne 0 ]; then
	echo "Failed to build or deploy war file"
	exit 1
fi
