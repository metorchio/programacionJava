#!/usr/bin/env bash

set -x  #Habilito modo verbose.
echo 'Me autentico a GAE'
gcloud auth activate-service-account --project benita-accesorios --key-file=keyfile.json
echo 'Installo el componente app-engine-java'
gcloud components install app-engine-java
echo 'Ejecuto deploy con mvnw...'
./mvnw -DskipTests appengine:deploy