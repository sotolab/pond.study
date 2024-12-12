# Dockerfile
FROM alpine:latest

# netcat 설치
RUN apk add --no-cache netcat-openbsd

EXPOSE 9000

# 기본적으로 서버 모드로 시작
CMD ["nc", "-l", "-p", "9000"]