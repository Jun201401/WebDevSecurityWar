# /User

## 회원 정보 목록 조회

* Request

  ```
  GET http://localhost:9090/users
  ```

* Response

  ```
 
  ```

## 회원 정보 단건 조회

* Request

  ```
  GET http://localhost:9090/users/{user-id}
  ```

* Response

  ```

  ```

## 회원 정보 생성

* Request

  ```
  POST http://localhost:9090/members
  Content-Type: application/json

  {
    "id" : "user1",
    "password" : "1111",
    "nickname" : "사용자",
    "email" : "user1@gmail.com"
  }
  ```

* Response

  ```
  HTTP/1.1 201 
  Content-Type: application/json;charset=UTF-8
  Transfer-Encoding: chunked
  Date: Fri, 09 Jun 2023 05:55:53 GMT
  Keep-Alive: timeout=60
  Connection: keep-alive

  {
    "id": "user1"
  }
  ```

## 회원 정보 수정

* Request

  ```
  PUT http://localhost:9090/users/{users-id}
  Content-Type: application/json

  {
    "password" : "2222",
    "nickname" : "user2",
    "email" : "user2@naver.com"
  }
  ```

* Response

  ```
  HTTP/1.1 200 
  Content-Type: application/json;charset=UTF-8
  Transfer-Encoding: chunked
  Date: Fri, 09 Jun 2023 05:58:41 GMT
  Keep-Alive: timeout=60
  Connection: keep-alive

  {
    "id": "user2"
  }
  ```

## 회원 정보 삭제

* Request

  ```
  DELETE http://localhost:9090/users/{user-id}
  ```

* Response

  ```
  HTTP/1.1 204 
  Date: Fri, 09 Jun 2023 05:56:55 GMT
  Keep-Alive: timeout=60
  Connection: keep-alive

  <Response body is empty>
  ```