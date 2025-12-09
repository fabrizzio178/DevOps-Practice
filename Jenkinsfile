pipeline{
	agent any
	// Este pipeline puede correr en cualquier nodo que Jenkins tenga disponible (agent any)

	stages {
		stage('Descargar código'){
			steps{
				echo 'Descargando código del repositorio'
			}
		}

		stage('Compilar con Maven'){
			agent{ // Aqui el agent es el lugar donde se va a ejecutar este stage
				docker{
					image 'maven:3.9.6-eclipse-temurin-21-alpine'
					// se mapea el caché de mvn para que no baje internet
					args '-v $HOME/.m2:/root/.m2'
					// args son argumentos adicionales que Jenkins le pasa al comando de Docker
					// que usa para crear el contenedor.
				}
			}
			steps{
				echo 'Compilando.'
				sh 'mvn clean package -DskipTests' // sh es shell, ejecutar el comando como si fuera cmd de Linux
			}
		}

		stage('Construir imagen docker'){
			steps{
				echo 'Construyendo imagen'
				sh 'docker build -t calculadora-app:latest .'
			}
		}

		stage('Desplegar'){
			steps{
				echo 'Desplegando contenedor'
				// si existe, lo borramos
				sh 'docker stop calculadora-v1 || true'
				sh 'docker rm calculadora-v1 || true'

				// Corremos la nueva versión en otro puerto para no chocar con jenkins
				sh 'docker run -d -p 8081:8080 --name calculadora-v1 calculadora-app:latest'
			}
		}
	}

}