FROM postgres:16
ENV POSTGRES_PASSWORD=cadmin
ENV POSTGRES_HOST_AUTH_METHOD=trust
ENV POSTGRES_DB=music
ENV POSTGRES_PORT=5432
COPY music.sql /docker-entrypoint-initdb.d/

