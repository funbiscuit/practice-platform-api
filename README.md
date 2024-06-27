## Build image and publish

```shell
docker build . -t funbiscuit/practice-platform-api
```

```shell
docker push funbiscuit/practice-platform-api
```

## Run REST API:

```shell
docker run --rm --name platform-api -p 8080:8080 -it funbiscuit/practice-platform-api
```
