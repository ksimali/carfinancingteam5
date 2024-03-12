# Utilisation d'une image officielle PostgreSQL
FROM postgres:latest

# Définition des variables d'environnement pour la configuration par défaut
ENV POSTGRES_DB=carfinancingteam5
ENV POSTGRES_USER=root
ENV POSTGRES_PASSWORD=carfinance

# Exposition du port PostgreSQL
EXPOSE 5432