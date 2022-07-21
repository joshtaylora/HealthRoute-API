#!/bin/bash

curl http://localhost:8080/api/v1/days -H "Content-Type: application/json" -d '{"date": "2022-07-02"}' 
curl http://localhost:8080/api/v1/days -H "Content-Type: application/json" -d '{"date": "2022-07-03"}'
curl http://localhost:8080/api/v1/days -H "Content-Type: application/json" -d '{"date": "2022-07-04"}'
curl http://localhost:8080/api/v1/days -H "Content-Type: application/json" -d '{"date": "2022-07-05"}'

curl -X PATCH http://localhost:8080/api/v1/meals/1/day -H "Content-Type: application/json" -d '{"id": 1, "date": "2022-07-02"}'
curl -X PATCH http://localhost:8080/api/v1/meals/2/day -H "Content-Type: application/json" -d '{"id": 2}'
curl -X PATCH http://localhost:8080/api/v1/meals/3/day -H "Content-Type: application/json" -d '{"id": 3}'
curl -X PATCH http://localhost:8080/api/v1/meals/4/day -H "Content-Type: application/json" -d '{"id": 4}'
