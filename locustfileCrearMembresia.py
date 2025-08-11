from locust import HttpUser, task, between
import random
from datetime import date, datetime, timedelta, timezone

class MyUser(HttpUser):
    host = "http://localhost:8000"
    wait_time = between(1, 2)

    @task
    def registrar_usuario(self):
    

        payload = {
            "descripcion": "Plan en el que puedes acceder a todas las maquinas y a las clases que se preparan por instructores en el gimnasio por 1000 meses",
            "nombreMembresia": "Plan 100 meses",
            "precio": 350.00,
            "vigencia": "12 meses"
        }

        with self.client.post("/gimnasio/api/membresias", json=payload, catch_response=True) as response:
            if response.status_code not in [200, 201]:
                response.failure(f"Fallo {response.status_code}: {response.text}")
            else:
                response.success()