#!/bin/bash

# Path to your SQL file
SQL_FILE_PATH=bus_station.sql

# Container name
CONTAINER_NAME=mysql

# Access the MYSQL_ROOT_PASSWORD environment variable from the container
MYSQL_ROOT_PASSWORD=$(docker exec $CONTAINER_NAME printenv MYSQL_ROOT_PASSWORD)

# Execute SQL commands inside the container
docker exec -i $CONTAINER_NAME mysql -u root -p$MYSQL_ROOT_PASSWORD bus_station < $SQL_FILE_PATH