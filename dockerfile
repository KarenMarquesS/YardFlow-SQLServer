# Etapa 1: Build da aplicação
FROM maven:3.9.6-eclipse-temurin-17 AS builder

# Diretório de trabalho
WORKDIR /app

# Criação do usuário para segurança
RUN adduser -h /home/devforge -s /bin/bash -D devforge

# Copia os arquivos do projeto Maven
COPY pom.xml .
COPY src ./src

# Compila o projeto sem rodar testes (mais rápido para produção)
RUN mvn clean package -DskipTests

# Etapa 2: Imagem leve apenas com JDK para execução
FROM eclipse-temurin:17-jdk-alpine

# Diretório onde o app será executado
WORKDIR /app

# Copia o JAR da etapa de build
COPY --from=builder /app/target/YarkFlow-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta padrão do Spring Boot
EXPOSE 8080

# Variável de ambiente para mudar a porta se necessário
ENV SERVER_PORT=8080

# Comando de inicialização
ENTRYPOINT ["java", "-jar", "app.jar"]