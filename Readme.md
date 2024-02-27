# CarIQ technical challenge

Test over mock Pets API, validating response codes, Json schema and
certain parameters.

## Installation

```sh
git clone https://github.com/Alexisvi14/CarIQChallenge.git
```

## Usage example

First build the gradle dependencies of the project:

```sh
./gradlew dependencies
```

To execute Dockerized WireMock run this command on the root folder of the project:

```sh
docker run -it --rm \
-p 8080:8080 --name wiremock\
 -v $PWD/src/main/resources/stub:/home/wiremock\
  wiremock/wiremock:3.3.1

```

Then to execute the test suite run on the command line:

```sh
./gradlew test
```

## The test suite

This suite is composed of 3 test

- Post test with assertions over the response code and other fields from the body of the response.
- Put test with assertions over the response code and other fields from the body of the response.
- Get test with assertions over the response code and different fields from responses.

