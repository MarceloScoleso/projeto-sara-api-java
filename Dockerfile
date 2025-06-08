# Etapa 1: Build da aplicação com Maven
FROM maven:3.9.6-eclipse-temurin-21 AS builder
WORKDIR /build
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: Imagem de execução com usuário não-root
FROM eclipse-temurin:21-jdk

# Criar um usuário não-root
RUN useradd -ms /bin/bash sarauser
USER sarauser

# Definir diretório de trabalho
WORKDIR /home/sarauser/app

# Copiar o JAR do estágio anterior
COPY --from=builder /build/target/*.jar app.jar

# Definir variável de ambiente (exemplo: porta padrão)
ENV SERVER_PORT=8080

# Expor a porta
EXPOSE 8080

# Rodar o JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
