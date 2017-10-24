#!/bin/bash

export SELENIUM_HUB_PORT=4444 NODES=1 VNC_FROM_PORT=40650 VNC_TO_PORT=40700 VIDEO=false
docker-compose -p grid down