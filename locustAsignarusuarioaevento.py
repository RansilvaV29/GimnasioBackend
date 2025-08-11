from locust import HttpUser, task, between
import itertools

class MyUser(HttpUser):
    host = "http://localhost:8000"
    wait_time = between(1, 2)

    # ID del evento al que se quiere registrar usuarios
    id_evento = 6
    
    # Rango de IDs de usuarios a usar
    id_usuarios = itertools.cycle(range(3, 101))  # Usuarios con IDs del 1 al 100 en bucle

    @task
    def agregar_usuario_a_evento(self):
        id_usuario = next(self.id_usuarios)
        url = f"/gimnasio/api/eventos/{self.id_evento}/agregar-usuario/{id_usuario}"

        with self.client.post(url, catch_response=True) as response:
            if response.status_code not in [200, 201]:
                response.failure(f"Fallo {response.status_code}: {response.text}")
            else:
                response.success()
