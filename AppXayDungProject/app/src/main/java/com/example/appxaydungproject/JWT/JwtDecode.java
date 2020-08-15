package com.example.appxaydungproject.JWT;

import com.auth0.android.jwt.Claim;
import com.auth0.android.jwt.JWT;

public class JwtDecode {
    String token ;

    public void ConvertJWT(){
        JWT jwt = new JWT(token);
        Claim subscriptionMetaData1 = jwt.getClaim("email");
        Claim subscriptionMetaData2 = jwt.getClaim("FullName");
//        String email = subscriptionMetaData.asString();
//        String email = subscriptionMetaData.asString();
    }
}
