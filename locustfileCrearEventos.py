from locust import HttpUser, task, between
import random
from datetime import date, datetime, timedelta, timezone

class MyUser(HttpUser):
    host = "http://localhost:8000"
    wait_time = between(1, 2)

    @task
    def registrar_usuario(self):
    
        fecha_futura = date.today() + timedelta(days=1)
        payload = {
            "nombreEvento": "Clase de Zumba",
            "descripcion": "Clase intensa de zumba con instructores certificados",
            "cupoMaximo": 20,
            "fecha": "2025-08-09",  # siempre una fecha futura
            "horaInicio": "17:00",
            "horraFin": "18:00"  # corregido el typo
        }

        with self.client.post("/gimnasio/api/eventos", json=payload, catch_response=True) as response:
            if response.status_code not in [200, 201]:
                response.failure(f"Fallo {response.status_code}: {response.text}")
            else:
                response.success()

