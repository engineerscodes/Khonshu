# Keycloak Role Based example 
```java
  .requestMatchers(HttpMethod.GET,"*/**").hasAuthority(KS_USER)
  .requestMatchers(HttpMethod.POST,"*/**").hasAuthority(KS_USER)
```  
CASE 1 : DENIED
```java
2023-04-08T13:30:32.244+05:30 DEBUG 6148 --- [nio-9000-exec-1] o.s.security.web.FilterChainProxy        : Securing POST /setup
2023-04-08T13:30:32.246+05:30 TRACE 6148 --- [nio-9000-exec-1] o.s.security.web.FilterChainProxy        : Invoking DisableEncodeUrlFilter (1/13)
2023-04-08T13:30:32.247+05:30 TRACE 6148 --- [nio-9000-exec-1] o.s.security.web.FilterChainProxy        : Invoking WebAsyncManagerIntegrationFilter (2/13)
2023-04-08T13:30:32.249+05:30 TRACE 6148 --- [nio-9000-exec-1] o.s.security.web.FilterChainProxy        : Invoking SecurityContextHolderFilter (3/13)
2023-04-08T13:30:32.251+05:30 TRACE 6148 --- [nio-9000-exec-1] o.s.security.web.FilterChainProxy        : Invoking HeaderWriterFilter (4/13)
2023-04-08T13:30:32.253+05:30 TRACE 6148 --- [nio-9000-exec-1] o.s.security.web.FilterChainProxy        : Invoking CorsFilter (5/13)
2023-04-08T13:30:32.267+05:30 TRACE 6148 --- [nio-9000-exec-1] o.s.security.web.FilterChainProxy        : Invoking LogoutFilter (6/13)
2023-04-08T13:30:32.268+05:30 TRACE 6148 --- [nio-9000-exec-1] o.s.s.w.a.logout.LogoutFilter            : Did not match request to Or [Ant [pattern='/logout', GET], Ant [pattern='/logout', POST], Ant [pattern='/logout', PUT], Ant [pattern='/logout', DELETE]]
2023-04-08T13:30:32.268+05:30 TRACE 6148 --- [nio-9000-exec-1] o.s.security.web.FilterChainProxy        : Invoking BearerTokenAuthenticationFilter (7/13)
2023-04-08T13:30:32.271+05:30 TRACE 6148 --- [nio-9000-exec-1] o.s.s.authentication.ProviderManager     : Authenticating request with JwtAuthenticationProvider (1/2)
2023-04-08T13:30:32.392+05:30 DEBUG 6148 --- [nio-9000-exec-1] o.s.s.o.s.r.a.JwtAuthenticationProvider  : Authenticated token
2023-04-08T13:30:32.393+05:30 DEBUG 6148 --- [nio-9000-exec-1] .s.r.w.a.BearerTokenAuthenticationFilter : Set SecurityContextHolder to JwtAuthenticationToken [Principal=org.springframework.security.oauth2.jwt.Jwt@9e3f92, Credentials=[PROTECTED], Authenticated=true, Details=WebAuthenticationDetails [RemoteIpAddress=0:0:0:0:0:0:0:1, SessionId=null], Granted Authorities=[ks_admin, offline_access, default-roles-khonshu, uma_authorization]]
2023-04-08T13:30:32.393+05:30 TRACE 6148 --- [nio-9000-exec-1] o.s.security.web.FilterChainProxy        : Invoking RequestCacheAwareFilter (8/13)
2023-04-08T13:30:32.394+05:30 TRACE 6148 --- [nio-9000-exec-1] o.s.security.web.FilterChainProxy        : Invoking SecurityContextHolderAwareRequestFilter (9/13)
2023-04-08T13:30:32.395+05:30 TRACE 6148 --- [nio-9000-exec-1] o.s.security.web.FilterChainProxy        : Invoking AnonymousAuthenticationFilter (10/13)
2023-04-08T13:30:32.395+05:30 TRACE 6148 --- [nio-9000-exec-1] o.s.security.web.FilterChainProxy        : Invoking SessionManagementFilter (11/13)
2023-04-08T13:30:32.396+05:30 TRACE 6148 --- [nio-9000-exec-1] o.s.s.w.a.AnonymousAuthenticationFilter  : Did not set SecurityContextHolder since already authenticated JwtAuthenticationToken [Principal=org.springframework.security.oauth2.jwt.Jwt@9e3f92, Credentials=[PROTECTED], Authenticated=true, Details=WebAuthenticationDetails [RemoteIpAddress=0:0:0:0:0:0:0:1, SessionId=null], Granted Authorities=[ks_admin, offline_access, default-roles-khonshu, uma_authorization]]
2023-04-08T13:30:32.396+05:30 TRACE 6148 --- [nio-9000-exec-1] s.CompositeSessionAuthenticationStrategy : Preparing session with ChangeSessionIdAuthenticationStrategy (1/1)
2023-04-08T13:30:32.396+05:30 TRACE 6148 --- [nio-9000-exec-1] o.s.security.web.FilterChainProxy        : Invoking ExceptionTranslationFilter (12/13)
2023-04-08T13:30:32.396+05:30 TRACE 6148 --- [nio-9000-exec-1] o.s.security.web.FilterChainProxy        : Invoking AuthorizationFilter (13/13)
2023-04-08T13:30:32.397+05:30 TRACE 6148 --- [nio-9000-exec-1] estMatcherDelegatingAuthorizationManager : Authorizing SecurityContextHolderAwareRequestWrapper[ org.springframework.security.web.header.HeaderWriterFilter$HeaderWriterRequest@15691123]
2023-04-08T13:30:32.398+05:30 TRACE 6148 --- [nio-9000-exec-1] estMatcherDelegatingAuthorizationManager : Checking authorization on SecurityContextHolderAwareRequestWrapper[ org.springframework.security.web.header.HeaderWriterFilter$HeaderWriterRequest@15691123] using AuthorityAuthorizationManager[authorities=[ks_user]]
2023-04-08T13:30:32.399+05:30 TRACE 6148 --- [nio-9000-exec-1] o.s.s.w.a.ExceptionTranslationFilter     : Sending JwtAuthenticationToken [Principal=org.springframework.security.oauth2.jwt.Jwt@9e3f92, Credentials=[PROTECTED], Authenticated=true, Details=WebAuthenticationDetails [RemoteIpAddress=0:0:0:0:0:0:0:1, SessionId=null], Granted Authorities=[ks_admin, offline_access, default-roles-khonshu, uma_authorization]] to access denied handler since access is denied

```

CASE 2 : GOT ACCESS

```JAVA
2023-04-08T13:36:17.344+05:30  INFO 1804 --- [nio-9000-exec-2] o.s.web.servlet.DispatcherServlet        : Completed initialization in 1 ms
2023-04-08T13:36:17.353+05:30 TRACE 1804 --- [nio-9000-exec-2] o.s.security.web.FilterChainProxy        : Trying to match request against DefaultSecurityFilterChain [RequestMatcher=any request, Filters=[org.springframework.security.web.session.DisableEncodeUrlFilter@8d52313, org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter@64f49b3, org.springframework.security.web.context.SecurityContextHolderFilter@61d527ac, org.springframework.security.web.header.HeaderWriterFilter@2dd4a7a9, org.springframework.web.filter.CorsFilter@23e3a27f, org.springframework.security.web.authentication.logout.LogoutFilter@5d32f5db, org.springframework.security.oauth2.server.resource.web.authentication.BearerTokenAuthenticationFilter@775a5a67, org.springframework.security.web.savedrequest.RequestCacheAwareFilter@380e3122, org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter@3777fc44, org.springframework.security.web.authentication.AnonymousAuthenticationFilter@70869678, org.springframework.security.web.session.SessionManagementFilter@6d38a81d, org.springframework.security.web.access.ExceptionTranslationFilter@311453ab, org.springframework.security.web.access.intercept.AuthorizationFilter@73dd3a46]] (1/1)
2023-04-08T13:36:17.354+05:30 DEBUG 1804 --- [nio-9000-exec-2] o.s.security.web.FilterChainProxy        : Securing POST /setup
2023-04-08T13:36:17.355+05:30 TRACE 1804 --- [nio-9000-exec-2] o.s.security.web.FilterChainProxy        : Invoking DisableEncodeUrlFilter (1/13)
2023-04-08T13:36:17.356+05:30 TRACE 1804 --- [nio-9000-exec-2] o.s.security.web.FilterChainProxy        : Invoking WebAsyncManagerIntegrationFilter (2/13)
2023-04-08T13:36:17.357+05:30 TRACE 1804 --- [nio-9000-exec-2] o.s.security.web.FilterChainProxy        : Invoking SecurityContextHolderFilter (3/13)
2023-04-08T13:36:17.358+05:30 TRACE 1804 --- [nio-9000-exec-2] o.s.security.web.FilterChainProxy        : Invoking HeaderWriterFilter (4/13)
2023-04-08T13:36:17.361+05:30 TRACE 1804 --- [nio-9000-exec-2] o.s.security.web.FilterChainProxy        : Invoking CorsFilter (5/13)
2023-04-08T13:36:17.372+05:30 TRACE 1804 --- [nio-9000-exec-2] o.s.security.web.FilterChainProxy        : Invoking LogoutFilter (6/13)
2023-04-08T13:36:17.373+05:30 TRACE 1804 --- [nio-9000-exec-2] o.s.s.w.a.logout.LogoutFilter            : Did not match request to Or [Ant [pattern='/logout', GET], Ant [pattern='/logout', POST], Ant [pattern='/logout', PUT], Ant [pattern='/logout', DELETE]]
2023-04-08T13:36:17.373+05:30 TRACE 1804 --- [nio-9000-exec-2] o.s.security.web.FilterChainProxy        : Invoking BearerTokenAuthenticationFilter (7/13)
2023-04-08T13:36:17.377+05:30 TRACE 1804 --- [nio-9000-exec-2] o.s.s.authentication.ProviderManager     : Authenticating request with JwtAuthenticationProvider (1/2)
2023-04-08T13:36:17.502+05:30 DEBUG 1804 --- [nio-9000-exec-2] o.s.s.o.s.r.a.JwtAuthenticationProvider  : Authenticated token
2023-04-08T13:36:17.503+05:30 DEBUG 1804 --- [nio-9000-exec-2] .s.r.w.a.BearerTokenAuthenticationFilter : Set SecurityContextHolder to JwtAuthenticationToken [Principal=org.springframework.security.oauth2.jwt.Jwt@e3c8e312, Credentials=[PROTECTED], Authenticated=true, Details=WebAuthenticationDetails [RemoteIpAddress=0:0:0:0:0:0:0:1, SessionId=null], Granted Authorities=[offline_access, default-roles-khonshu, uma_authorization, ks_user]]
2023-04-08T13:36:17.504+05:30 TRACE 1804 --- [nio-9000-exec-2] o.s.security.web.FilterChainProxy        : Invoking RequestCacheAwareFilter (8/13)
2023-04-08T13:36:17.504+05:30 TRACE 1804 --- [nio-9000-exec-2] o.s.security.web.FilterChainProxy        : Invoking SecurityContextHolderAwareRequestFilter (9/13)
2023-04-08T13:36:17.505+05:30 TRACE 1804 --- [nio-9000-exec-2] o.s.security.web.FilterChainProxy        : Invoking AnonymousAuthenticationFilter (10/13)
2023-04-08T13:36:17.505+05:30 TRACE 1804 --- [nio-9000-exec-2] o.s.security.web.FilterChainProxy        : Invoking SessionManagementFilter (11/13)
2023-04-08T13:36:17.506+05:30 TRACE 1804 --- [nio-9000-exec-2] o.s.s.w.a.AnonymousAuthenticationFilter  : Did not set SecurityContextHolder since already authenticated JwtAuthenticationToken [Principal=org.springframework.security.oauth2.jwt.Jwt@e3c8e312, Credentials=[PROTECTED], Authenticated=true, Details=WebAuthenticationDetails [RemoteIpAddress=0:0:0:0:0:0:0:1, SessionId=null], Granted Authorities=[offline_access, default-roles-khonshu, uma_authorization, ks_user]]
2023-04-08T13:36:17.506+05:30 TRACE 1804 --- [nio-9000-exec-2] s.CompositeSessionAuthenticationStrategy : Preparing session with ChangeSessionIdAuthenticationStrategy (1/1)
2023-04-08T13:36:17.506+05:30 TRACE 1804 --- [nio-9000-exec-2] o.s.security.web.FilterChainProxy        : Invoking ExceptionTranslationFilter (12/13)
2023-04-08T13:36:17.506+05:30 TRACE 1804 --- [nio-9000-exec-2] o.s.security.web.FilterChainProxy        : Invoking AuthorizationFilter (13/13)
2023-04-08T13:36:17.507+05:30 TRACE 1804 --- [nio-9000-exec-2] estMatcherDelegatingAuthorizationManager : Authorizing SecurityContextHolderAwareRequestWrapper[ org.springframework.security.web.header.HeaderWriterFilter$HeaderWriterRequest@2acdc8ce]
2023-04-08T13:36:17.508+05:30 TRACE 1804 --- [nio-9000-exec-2] estMatcherDelegatingAuthorizationManager : Checking authorization on SecurityContextHolderAwareRequestWrapper[ org.springframework.security.web.header.HeaderWriterFilter$HeaderWriterRequest@2acdc8ce] using AuthorityAuthorizationManager[authorities=[ks_user]]
2023-04-08T13:36:17.508+05:30 DEBUG 1804 --- [nio-9000-exec-2] o.s.security.web.FilterChainProxy        : Secured POST /setup
org.keycloak.representations.AccessToken@d014132
```
