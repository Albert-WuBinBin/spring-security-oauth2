# spring-security-oauth2

1.Enter this url:http://localhost:8080/SpringSecurityOauth2/oauth/token?grant_type=password&client_id=client1&client_secret=123456&username=admin&password=admin,
you will get this.
{
    "access_token": "a8cfc8da-0769-4f16-9d54-99f60c0c432c",
    "token_type": "bearer",
    "refresh_token": "544caffb-f797-4f0b-bb99-3000267f0442",
    "expires_in": 85887,
    "scope": "read write trust"
}
2.from 1,you can get token ,write it to this url
 http://localhost:8080/SpringSecurityOauth2/hello?access_token=a8cfc8da-0769-4f16-9d54-99f60c0c432c
 you will get this.
 "Hello spring security oauth2"