from locust import HttpUser, task, between
import random
from datetime import date, datetime, timedelta, timezone

class MyUser(HttpUser):
    host = "http://localhost:8000"
    wait_time = between(1, 2)

    @task
    def registrar_usuario(self):
    

        payload = {
            "idUsuario": random.randint(5, 100),       # Usuario existente
            "idMembresia": random.randint(6, 10),     # Membresía existente
            "valorPagado": round(random.uniform(20.0, 60.0), 2),
            "estado": True
        }

        with self.client.post("/gimnasio/api/historial-membresias", json=payload, catch_response=True) as response:
            if response.status_code not in [200, 201]:
                response.failure(f"Fallo {response.status_code}: {response.text}")
            else:
                response.success()