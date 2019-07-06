#!/usr/bin/env bash

echo '>>>>> Instalo Google Cloud SDK'
echo "sudo deb [signed-by=/usr/share/keyrings/cloud.google.gpg] https://packages.cloud.google.com/apt cloud-sdk main" | sudo tee -a /etc/apt/sources.list.d/google-cloud-sdk.list
sudo apt-get install apt-transport-https ca-certificates
echo "sudo deb https://packages.cloud.google.com/apt cloud-sdk main" | sudo tee -a /etc/apt/sources.list.d/google-cloud-sdk.list
curl https://packages.cloud.google.com/apt/doc/apt-key.gpg | sudo apt-key --keyring /usr/share/keyrings/cloud.google.gpg add -
sudo apt-get update && sudo apt-get install google-cloud-sdk -y
sudo apt-get install google-cloud-sdk-app-engine-java -y
echo '>>>>> Me autentico a GAE'
gcloud auth activate-service-account --project benita-accesorios --key-file=keyfile.json
echo '>>>>> Ejecuto deploy con mvnw...'
./mvnw -DskipTests appengine:deploy