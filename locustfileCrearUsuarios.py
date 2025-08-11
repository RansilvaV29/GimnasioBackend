from locust import HttpUser, task, between
import random
from datetime import datetime, timezone

class MyUser(HttpUser):
    host = "http://localhost:8000"
    wait_time = between(1, 3)

    @task
    def registrar_usuario(self):
        payload = {
            "rol": {
                "idRol": 1
            },
            "cedula": str(random.randint(1000000000, 9999999999)),
            "nombres": "Usuario" + str(random.randint(1, 1000)),
            "apellidos": "TestLocust",
            "fechaNacimiento": "2000-01-01",
            "correo": f"usuario{random.randint(1000, 9999)}@mail.com",
            "telefono": f"09{random.randint(10000000, 99999999)}",
            "contrasena": "admin"
        }

        with self.client.post("/gimnasio/api/auth/register", json=payload, catch_response=True) as response:
            if response.status_code not in [200, 201]:
                response.failure(f"Fallo {response.status_code}: {response.text}")
            else:
                response.success()
