#!/bin/bash

export SELENIUM_HUB_PORT=4444 NODES=1 VNC_FROM_PORT=40650 VNC_TO_PORT=40700 VIDEO=false
docker-compose -p grid up -d

docker-compose -p grid scale chrome=${NODES}

docker exec grid_hub_1 wait_all_done 30s

for ((i=1; i<=${NODES}; i++)); do
  docker-compose -p grid exec -T --index=$i chrome wait_all_done 30s
done