# Dockerfile
FROM alpine:latest

# netcat 설치
RUN apk add --no-cache netcat-openbsd

EXPOSE 9000

CMD ["nc", "-l", "-p", "9000"]