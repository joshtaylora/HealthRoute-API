#!/bin/bash

curl -d '{"timestamp":"2022-07-05T06:12:40Z"}' -H "Content-Type: application/json" http://localhost:8080/api/v1/meals
curl -d '{"timestamp":"2022-07-05T09:12:40Z"}' -H "Content-Type: application/json" http://localhost:8080/api/v1/meals
curl -d '{"timestamp":"2022-07-05T12:12:40Z"}' -H "Content-Type: application/json" http://localhost:8080/api/v1/meals
curl -d '{"timestamp":"2022-07-05T15:12:40Z"}' -H "Content-Type: application/json" http://localhost:8080/api/v1/meals
curl -d '{"timestamp":"2022-07-05T18:12:40Z"}' -H "Content-Type: application/json" http://localhost:8080/api/v1/meals

