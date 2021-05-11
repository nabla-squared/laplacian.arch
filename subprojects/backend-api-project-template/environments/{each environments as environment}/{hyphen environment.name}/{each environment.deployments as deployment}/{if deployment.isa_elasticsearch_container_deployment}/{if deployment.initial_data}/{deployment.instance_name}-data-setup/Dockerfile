FROM ubuntu:21.04
RUN apt-get update && apt-get install -y curl netcat
RUN mkdir /app
COPY entrypoint.sh /app/entrypoint.sh
COPY data /app/data
COPY mappings /app/mappings
ENTRYPOINT ["/app/entrypoint.sh"]
