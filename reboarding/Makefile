office = microservices/office/target/office-0.0.1-SNAPSHOT.war
queue = microservices/queue/target/queue-0.0.1-SNAPSHOT.war
api = reboarding-api/target/reboarding-api-0.0.1-SNAPSHOT.war

all: ${office} ${queue} ${api}
	docker build -t reboardingapi -f docker/api/Dockerfile .
	docker build -t office -f docker/office/Dockerfile .
	docker build -t queue -f docker/queue/Dockerfile .

.PHONY: microservices
microservices:
	cd microservices && mvn clean install

${office} : microservices
	cd microservices/office && mvn clean install

${queue} : microservices
	cd microservices/queue && mvn clean install

${api} :
	cd reboarding-api &&  mvn clean install