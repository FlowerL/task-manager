# task-manager

If any problem, plz email to vxlang78@163.com.

This is a java project to manager user's task. The features of this project are as follows:

(1) Backend and frontend separated

The whole project is a classical frontend and backend separation project. The project what you see is just about the backend side 
to handle request and transfer data back to the frontend side. The backend and frontend use and only use json to transfer data. 
When deploying, plz configure nginx between the backend and frontend to solve the cross-origin problem (you can also use com.jxshen.task.manager.configuration.CorsConfig to solve the problme but it is not recommended).

For the frontend side project, plz refer to https://github.com/Renee007/todo.git or git@github.com:Renee007/todo.git, which use 
webpack(npm) to manager project with technology stack of jquery, vue2.0, bootstrap.

(2) Springboot

The backend project uses springboot to quickly build the framework. Springboot embeds tomcat but in this project you can either run it as java application or deploy it as war to run with outside tomcat. plz refer to Application.java & the dependencies configuration of spring-boot-starter-web and org.apache.tomcat.embed.

Because springboot defaultly use OrderedHiddenHttpMethod to read request.getParamter("method") which consumes the request body when the method type is "post" and there is none key-value pairs as "method=" in request url. I used a HttpWrapper cooperating with a filter ordered in the first to cache the request body in byte[]. Then the request content can be repeatedly read in the server.

(3) Maven

The backend project uses maven to manager package dependency. In pom it uses java 1.8 as default to cooperate with tomcat 8.5 (for the embedded tomcat you can change version with tomcat-embed-jasper) and web dynamic module 3.0 (you can change it in the war module -- task-manager-api folder, .settings/org.eclipse.wst.common.project.facet.core.xml with <installed facet="jst.web" version="3.0"/>, then refresh your project or refresh Deployment Descriptor in eclipse). For other versions, plz make sure they can cooperate each other, otherwise springboot app can't be bootstrapped successfully. If you are in trouble in using the project as war, just start it as java application in Application.java to avoid troubles.

(4) MVC

The backend project uses both traditional springMVC (task-manager-api) and Restful MVC (task-manager-sdk) to handle request. In restful MVC, it also contains a trial to use https.

The descriptions of the five modules of the project are as follows:

(i)task-manager-api: war project with springMVC style to receive http request and return response. The controllers only handle json but they don't rely on the content-type: application/json because the controllers analyze the stream from request body themselves and transfer the content to json. This layer will dao service layer.

(ii)task-manager-service: transaction and business logic are all in here. The service layer will also transfer VO to entity for database and vice versa.This layer will call dao layer.

(iii)task-manager-dao: orm layer using mybatis.

(iv)task-manager-common: some utility class used by all layer.

(v)tass-manager-sdk: independent sdk for other developer use and manve deployment. It uses restful style for client and server with https (not oauth2.0). It is just in experiment.
