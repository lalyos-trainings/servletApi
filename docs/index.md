# Servlet Api Training

## Day 1

The servlet specification defines the directory structure for a web application:

```
├── WEB-INF
│   ├── classes
│   │   └── com
│   │       └── acme
│   │           └── servlet
│   │               └── HelloServlet.class
│   └── lib
│       ├── logback-classic.jar
│       ├── logback-core.jar
│       └── slf4j.jar
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