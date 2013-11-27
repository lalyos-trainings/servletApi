# Servlet Api Training

## webapp

The servlet specification defines the directory structure for a web application:

```
├── WEB-INF
│   ├── classes
│   │   └── com
│   │       └── acme
│   │           └── servlet
│   │               └── HelloServlet.class
│   ├── lib
│   │   ├── logback-classic.jar
│   │   ├── logback-core.jar
│   │   └── slf4j.jar
│   └── web.xml
└── index.html
```

As a minimum you need a `WEB-INF/web.xml` with a content of a few lines:

```
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
  xmlns="http://java.sun.com/xml/ns/javaee" 
  xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd" 
  id="WebApp_ID" version="2.5">
  
  <display-name>sampleWebApp</display-name>
</web-app>
```

## javax.servlet.Servlet

- init(ServletConfig)
- service(ServletRequest, ServletResponse)
- destroy()

```
ServletConfig.getInitParameter()
```
## HttpServlet

service() methos delegates to:

- doGet
- doPost
- doPut
- doDelete

## url pattern

- path : `/something/*`
- extension: `*.extension`
- exact: anything else
- default: `/` - if nothing matches `default` servlet should serve. (static resources)

## generating html:

```
resp.getWriter().println("<h1>Hello</h1>");
resp.getWriter().println("<div class=\"msg\">");
resp.getWriter().println("some message");
resp.getWriter().println("</div>");
```

### http

- url: `http://host:port/context/path?query`

Request response based message protocol where both have the same structure:

- start-line (request-line / status-line)
- headers: Host, Content-type, Accept-Encoding, Accept-Language, Cookie, ...
- body: in reguest optional (only for POSTed forms), in response: html

status codes:
- 1xx: Informational 
- 2xx: Successful: 
  - 200: Ok
  - 201: Created
- 3xx: Redirection 
  - 301: Moved Permanently
  - 302: Found
  - 304: Not Modified
- 4xx:Client Error 
  - 401: Unauthorized
  - 403: Forbidden
  - 404: Not Found
- 5xx: Server Error 
  - 500: Internal Server Error
  - 501: Not Implemented
  - 503: Service Unavailable
  
## Forms

sample html form:
```
<form action="breaktime" method="post">
  <input type="text" name="name" />
  <input type="text" name="age" />
  <input type="submit" value="add">
</form>
```

java code that handles form submission:

```
String name = request.getParameter("name");
String age = request.getParameter("age");
```

## Scopes

Scopes help to store information with `get/setAttribute()` methods.

- request: request.getAttribute()
- session: request.getSession().getAttribute()
- application: getServletContext().getAttribute()

Note: be carefull with session scope! Think about 1 million user ...

## include/forward/redirect
There are several ways, how 2 servlet can communicate with eachother:

- include: get the content reproduced by an other servlet an include it in the output of the current one. (footer,header)
- forward: let an other servlet create the `complete` output html. (error handling)
- redirect: send an 304 response, browser sends a `new request`. (bookmark)

### forward/include
```
RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/path");

dispatcher.forward(request, response);
...
dispatcher.include(request, response);

```

```
```