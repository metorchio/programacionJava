#!/usr/bin/env bash

gcloud auth activate-service-account --project benita-accesorios --key-file=keyfile.json
gcloud components install app-engine-java
./mvnw -DskipTests appengine:deploy