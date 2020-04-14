## Spring MVC Security Project
### 2020-04-08

### 개요
* Spring MVC 기반 Security Coding
* Security 기능을 포함한 WebSocket Coding
* React 기반 Front-End 기능 Coding

* JDBC, MyBatis 연동
* MySQL DB 연동
* 회원가입 이메일 인증
* 비밀번호 분실 이메일 인증 후 재설정

### Spring MVC dependency

* spring security 설정
* spring security core
* spring security web
* spring security config
* spring security taglibs

* jasypt
* jasypt-spring31
		
### DB dependency(MySQL, Mybatis 연동)

* mysql-connector-java
 - MySQL과 Java를 연결 해주는 사용하는 DB Driver
* commons-dbcp2
 - jdbc와 Driver 사이에서 DB Connection tool을 만들고,
   Connection, DiConnection을 수행해주는 보조 클래스
* spring-jdbc
 - Spring(Java)와 DB Driver 사이에서 명령어, 
   데이터를 변환시켜주는 보조 Class
* mybatis
 - spring-jdbc와 DB Driver 사이에서 MyBatis Mapper 등으로 작성된 SQL
   변환하고, 데이터를 VO에 쉽게 매핑시키는 용도의 Class
* mybatis-spring
 - spring-jdbc와 mybatis 엔진사이에서 서로 잘 조정하여 버전에 관계없이
   연동이 쉽도록 만들어주는 보조 Class

## Security와 관련 용어

#### 접근 주체(principal)
* 보호된 대상에 접근하는 유저(User)

#### 인증(Authenticate)
* 접근하는 유저가 누구인가 확인(로그인)

#### 인가(Autherize)
* 접근한 유저가 어떤 서비스, 어떤 페이지에 접근할 수 있는 권한이 있는가
  하는 것을 검사

#### 권한(Role)
* 인증(Authenticate)된 주체(User)가 어떤 페이지, 기능, 서비스에 접근할 수 있는 권한이 있단 것을 증명

#### 무결성, 보안
* 무결성 : 인가된 사용자에 의해 손상될 수 있는 것
* 보안 : 인가받지 못한 사용자에 의해 손상될 수 있는 것

## Spring Security
* filter를 사용하여 접근하는 사용자의 인증절차와 인가를 통해 권한이 있는가를 파악하고, 
  적절한 조치(되돌리기, redirect, 사용가능)을 
  비교적 적은 코드 양으로 처리할 수 있도록 만든 framework

* spring security는 세션과 쿠키방식을 병행하여 사용한다

### 유저가 로그인을 시도하면
1. Authentication filter에서부터 users table까지 접근하여 사용자 정보를
   인증하는 절차를 거친다
2. 인증이되면 user table이나 user detail table에서 사용자 정보를 fetch(select)하여 session 저장

3. 일반적인 HttpSession은 서버에 활동 영역 메모리에 session 정보를 저장하는데 비해 
   spring security는 "SecurityContextHolder"라는 메모리에 저장
4. view로 user 정보가 담긴 session을 session Id와 함께 응답으로 전달
* Jsession이라는 쿠키에 sessionID를 담아서 보내고

5. 이후 유저가 접근을 하면 jsessionId에서 쿠키를 추출하여 사용자 인증을 시도한다

6. jsession에서 추출한 sessionID가 유효하면 접근 request에게 authentication을 부착한다  
  
  
### Spring security와 form 데이터
* web browser에서 server로 요청을 하는 것을 request라고 하며 
  요청할 때 사용하는 주소를 url 또는 uri라고 한다
* web browser에서 서버에 request하는 method 방식에는 GET POST PUT DELETE가 있다
* SpringMVC에서는 GET, POST를 주로 사용한다

* GET method는 주소창에 URL을 입력하고 Enter를 누르거나, anchor tag를 마우스로 클릭하거나
  또는 form tag의 method가 없는경우 서버로 요청하는 방식이다
* GET method는 단순히 리스트를 요구하거나 입력 form 화면을 요구하는 용도로 주로 사용된다

* POST method는 입력화면에 값들을 입력한 후 서버로 전송할 때 주로 사용하며,
  입력화면의 form, input 등의 tag에 값을 저장한 후 server로 submit실행하는 경우이다
* POST method는 데이터의 양에 관계없이 server로 전송할 수 있으며, file upload 등도 
  수행할 수 있다
  
* spring security를 적용한 project에서는 get method 방식은 아무런 제약이 없으나 
  POST method 방식은 서버로부터 전달받은 csrf 토큰을 항상 데이터 들과 함게 보내야만
  정상적으로 서버로 보낼 수 있다
* POST 방식의 form 코드에는 다음과 같은 코드를 추가해줘야한다

* <input type="hiden" name="${_csrf.parameterName}" value="${_csrf.token }">

* 매번 form 홤녀구현을 하면서 코드를 추가하다보면, 빠트리는 경우가 발생할도 있고,
  해당 페이지의 데이터를 전송하면 서비스는 수신을 거부하고 403오류를 보낸다
 
 * 오류를 방지하기 위해 Spring form taglibs하면을 작성하면 Spring form taglib라는
   자동으로 토큰을 form 화면 코드에 추가하여 별도의 조치를 취하지 않아도 문제가 
   발생하지 않도록 만들어 준다
   
 

  
  
  
  
  
  
  
  
  