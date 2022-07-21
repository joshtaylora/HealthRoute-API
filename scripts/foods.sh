#!/bin/bash

curl -d '{"name": "peanut butter","calories": 250,"carbs": 15,"protein": 18,"fat": 9}' -H "Content-Type: application/json" http://localhost:8080/api/v1/foods
curl -d '{"name": "chocolate whey protein","calories": 300,"carbs": 15,"protein": 50,"fat": 4}' -H "Content-Type: application/json" http://localhost:8080/api/v1/foods
curl -d '{"name": "protein pancakes","calories": 500,"carbs": 40,"protein": 30,"fat": 16}' -H "Content-Type: application/json" http://localhost:8080/api/v1/foods
curl -d '{"name": "hamburger bun","calories": 120,"carbs": 30,"protein": 5,"fat": 3}' -H "Content-Type: application/json" http://localhost:8080/api/v1/foods
curl -d '{"name": "bubba burger","calories": 200,"carbs": 3,"protein": 25,"fat": 12}' -H "Content-Type: application/json" http://localhost:8080/api/v1/foods
curl -d '{"name": "pasta","calories": 250,"carbs": 15,"protein": 18,"fat": 9}' -H "Content-Type: application/json" http://localhost:8080/api/v1/foods
curl -d '{"name": "meatballs","calories": 250,"carbs": 15,"protein": 18,"fat": 9}' -H "Content-Type: application/json" http://localhost:8080/api/v1/foods

curl -X PATCH http://localhost:8080/api/v1/foods/1/1 
curl -X PATCH http://localhost:8080/api/v1/foods/2/1 
curl -X PATCH http://localhost:8080/api/v1/foods/3/2 
curl -X PATCH http://localhost:8080/api/v1/foods/4/2
curl -X PATCH http://localhost:8080/api/v1/foods/5/3
curl -X PATCH http://localhost:8080/api/v1/foods/6/3
curl -X PATCH http://localhost:8080/api/v1/foods/7/4
