#!/usr/bin/env bash

echo '>>>>> Me autentico a GAE'
./google-cloud-sdk/bin/gcloud auth activate-service-account --project benita-accesorios --key-file=keyfile.json
echo '>>>>> Ejecuto deploy con mvnw...'
./mvnw -DskipTests appengine:deploy