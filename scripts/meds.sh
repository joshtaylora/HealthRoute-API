#!/bin/bash

curl http://localhost:8080/api/v1/medications -H "Content-Type: application/json" -d '{"day_id": 1,"name": "Prednisone","quantity": 1, "strength": 20,"dosage_unit":"mg"}'
