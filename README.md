# spring-security-oauth2

1.Enter this url by http post:http://localhost:8080/SpringSecurityOauth2/oauth/token?grant_type=password&client_id=client1&client_secret=123456&username=admin&password=admin,
you will get this.
{
    "access_token": "a8cfc8da-0769-4f16-9d54-99f60c0c432c",
    "token_type": "bearer",
    "refresh_token": "544caffb-f797-4f0b-bb99-3000267f0442",
    "expires_in": 85887,
    "scope": "read write trust"
}
2.from 1,you can get token ,write it to this url by http get 
 http://localhost:8080/SpringSecurityOauth2/hello?access_token=a8cfc8da-0769-4f16-9d54-99f60c0c432c
 you will get this.
 "Hello spring security oauth2"
 
#add aop interceptor
Next,get token again by step 1,but this time you use username=user,password=user this account to get token,and do step 2 by this token,you will find prompt 
"Account does not match",because in AccessControlImpl.java ,i only let account username=admin to access this resoureces 

