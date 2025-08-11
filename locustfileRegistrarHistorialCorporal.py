from locust import HttpUser, task, between
import random
from datetime import date, datetime, timedelta, timezone

class MyUser(HttpUser):
    host = "http://localhost:8000"
    wait_time = between(1, 2)


    @task
    def registrar_usuario(self):
              
        payload = {
        "pesoKg": round(random.uniform(40.0, 130.0), 1),  # Peso entre 40 y 130 kg
        "idUsuario": random.randint(1, 800)  # IDs válidos entre 1 y 800
        }

        with self.client.post("/gimnasio/api/historial-corporal", json=payload, catch_response=True) as response:
            if response.status_code not in [200, 201]:
                response.failure(f"Fallo {response.status_code}: {response.text}")
            else:
                response.success()