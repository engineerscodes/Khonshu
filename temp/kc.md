# Keycloak Role Based example 
  .requestMatchers(HttpMethod.GET,"*/**").hasAuthority(KS_USER)
  .requestMatchers(HttpMethod.POST,"*/**").hasAuthority(KS_USER)
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
