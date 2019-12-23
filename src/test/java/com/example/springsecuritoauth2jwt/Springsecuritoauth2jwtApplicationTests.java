package com.example.springsecuritoauth2jwt;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaSigner;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Springsecuritoauth2jwtApplicationTests {
    @Test
    public void contextLoads() {
        //密钥库名称
        String storeName = "xc.keystore";
        //密钥库密码
        String storePassword = "xuechengkeystore";
        //密钥别名
        String alias = "xckey";
        //密钥密码
        String key = "xuecheng";

        //密钥库路径
        ClassPathResource classPathResource = new ClassPathResource(storeName);

        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(classPathResource, storePassword.toCharArray());
        KeyPair keyPair = keyStoreKeyFactory.getKeyPair(alias, key.toCharArray());
        RSAPrivateKey aPrivate = (RSAPrivateKey) keyPair.getPrivate();

        Map<String,String> map = new HashMap<>();
        map.put("name","houyong");
        String string = JSON.toJSONString(map);
        Jwt encode = JwtHelper.encode(string, new RsaSigner(aPrivate));
        String claims = encode.getClaims();
        String encoded = encode.getEncoded();
        System.out.println(encoded);
    }


    @Test
    public void match(){
        String jwt = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1NzcxMTEyODAsInVzZXJfbmFtZSI6ImNlc2hpMiIsImF1dGhvcml0aWVzIjpbImNvdXJzZV9maW5kX2xpc3QiLCJjb3Vyc2VwaWNfZmluZF9saXN0Il0sImp0aSI6IjQ1OWM0ZjkwLTRjMjMtNGZlNi05NTQ1LWZhZTA3NzYwMWZkMiIsImNsaWVudF9pZCI6ImFwcCIsInNjb3BlIjpbImFwcCJdfQ.FRTmV6sGB6zkPaBZF1-oB9CfXFX3FVtJdVECTDAyWkfwD1UxWlV-V3NHsdePt8ZwAwE7y09jF4epzuIUGxQQWOERlHkHRcJ8IGyx2kLhZdSF1m9FN4spVGWMCUWt0ntXYkvwcpYdPeEM36Dping5UCUjdq0hwDUebjIP8FyiUj6Ce6pIrCqvsZ1SHPlX68VrB9xXTlLBVyEaqlQFej0nq13h8bsQDUaAAvDEYsZ2KDHES1ebgROO0MPW7rzAnHO9gaWEA93P5j051nuKk_Zv-HmucXNKI2AaYb7oEX7jXUxHkVMLDF-_mb6DSffpur3Kw8FA9OzZq2Gf-aPhwq5e4A";
        String publickey = "-----BEGIN PUBLIC KEY-----MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAk2quEWHqiijm+x/7uBIKhuQpfsgMHPhaD3YHlx9aKe7IfELX+Oh9mrwG234ZirsfymU2zpda2s3cH1jhYWm+CkP7zQAUX219+k7xuJFxXnUX/Hyb5wm9wsvCtp5Dl/L57mqiikPst2qKqezfP9bg61GmfH8OTKZFo9QxTGsJDeYnpxt7WA6jilohmlB2vPGoAN9KANWlxJadTVhlNZNE+OqWXWTRdeTSmBTnFrisyTgB3S1GQCaYPLJQ+1FLDqZJl8k79QJ3DOqZN7bsqoURSmSgegUE9pfgbIXstfjntoIsOPFDtCCajenPXOmExvDltl4DpwzuJkrFgG8V3kPojQIDAQAB-----END PUBLIC KEY-----";

        //校验jwt令牌
        Jwt jwt1 = JwtHelper.decodeAndVerify(jwt, new RsaVerifier(publickey));
        System.out.println(jwt1);
    }
}
