cd \Fontes\Java\microservice
cd api-gateway-server
mvn clean package -DskipTests

docker build -t gateway:1.0 .

cd..
cd config-server
mvn clean package -DskipTests

docker build -t config:1.0 .

cd..
cd discovery-server
mvn clean package -DskipTests

docker build -t discovery:1.0 .

cd..
cd company
mvn clean package -DskipTests

docker build -t company:1.0 .

cd..
cd employee
mvn clean package -DskipTests

docker build -t employee:1.0 .
