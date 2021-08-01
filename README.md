# quarkus-resteasy-reactive-multiform-issue

## Upload file POST request hangs
in simple RESTEasy Reactive project with RestForm file upload endpoint AND Reactive Routes failure handler, only in Quarkus 2.1.0.Final.
Without failure handler class file upload proceeds successfully.
The same task works Ok in Quarkus 2.0.3.Final.

## quarkus projects creation
```
mvn io.quarkus:quarkus-maven-plugin:2.1.0.Final:create \
-DprojectGroupId=org.acme \
-DprojectArtifactId=multiform-quarkus-210 \
-DprojectVersion=0.2 \
-Dextensions="resteasy-reactive,resteasy-reactive-jsonb,vertx-web"
```

```
mvn io.quarkus:quarkus-maven-plugin:2.0.3.Final:create \
...
```

## multiform-quarkus-210 upload file hanging
```
% curl -v -F payload=@pom.xml http://127.0.0.1:8080/rest/form
*   Trying 127.0.0.1:8080...
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> POST /rest/form HTTP/1.1
> Host: 127.0.0.1:8080
> User-Agent: curl/7.77.0
> Accept: */*
> Content-Length: 4845
> Content-Type: multipart/form-data; boundary=------------------------ec25671b52288ad7
> 
* We are completely uploaded and fine
^C
```

## multiform-quarkus-203 upload file OK
```
% curl -v -F payload=@pom.xml http://127.0.0.1:8080/rest/form
*   Trying 127.0.0.1:8080...
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> POST /rest/form HTTP/1.1
> Host: 127.0.0.1:8080
> User-Agent: curl/7.77.0
> Accept: */*
> Content-Length: 4845
> Content-Type: multipart/form-data; boundary=------------------------aea3a41b009307dd
> 
* We are completely uploaded and fine
* Mark bundle as not supporting multiuse
< HTTP/1.1 200 OK
< content-length: 151
< Content-Type: text/plain
< 
* Connection #0 to host 127.0.0.1 left intact
file: pom.xml, content type: application/xml, uploaded file: /var/folders/h_/t7f0c9kj02q79yj5nn0k33140000gn/T/uploads/undertow1736355395262476198upload%
```
