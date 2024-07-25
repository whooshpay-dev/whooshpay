package id.whoosh;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import id.whoosh.res.AccessTokenRes;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class Step2_AccessToken extends BaseTest {

    //from step1
    private static final String privateKeyStr = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC4zbHO9QKWikaV7OrFhTqVBFrBoTUa3GZHamWpv6uljciekOesLuPM4AAFCYOknLLLMTZRpLVbcJPvgILYQPVspZsnftM6hoziWk5vmu1xGAAK9FrCb+elcMfHHMoM9hgPTEjOieH/ATohZAnjOsY7LfvMFJsMjzaOvI4LG6RPlrqcbgBreoIG2LLm6sedWqV/Epo4IYbn1gEo3/qBitnuJkrTlRmC97qkcEqTjk6rNAoiFNEoLRlZnxSvzSBXVkFsDoag1LWPJ6smgEeCr/1aScD6KTqk9PN4OyOvoZz4nexRuWDmF8I7j97TWgGVk+bZZQBuMUQoS0+AI5aK0hTdAgMBAAECggEAC5/wx+Z0n7iaARNSn1MmoLoR5W05FHP5wRNJythCOVtGW+cck6GtdbU/exGipMewnYR+eLtGJzbZL28ji+vmJEv0ixL4wY02LoTkuzOBLSSH2CiPzvxQE4GZJ4bBlPgkAk5XpBpbS3mtyOzsjE0lrBJT7P381NjrYyYsPzmhZ9olVbcB7uPq8dK/MAI8FrOwKs/E1/EIg3Hl64rSOoBAl2d6j2T+4d+HF+ZwoPnwgyqeP+3QxicRayb6L1mTQGcE54/dI7w0aa01w0qyG8T6MFtF7CdgIGuT/VRHWzO+2wIlZrU+OC+kxLnlyfTtX7EHPPQGEY3Hk0ddjg787YxL8QKBgQC/6uOU0ePBuj+juUVoZZ+rArdW6ztpT7pFTzeiZTY7Bdvyqp9tfgkuM/47xeUWzwYKnUeLAD3D2KBTK5MF2pQfcqIDNdZUXHJecGGjVLTTrbdlfxhS54uJmti2E6lewpb77ebhFeeB0ATTdZzC35+GWUBrK/JbFyuRRcSRJ7ceWQKBgQD2grKGzioO9nSrRwSX8si9yOWD1qPz5YTvxJ9SuBrs/HfNcL3j+lmDz+NyidB+/K4UuO3k4Y5s3sUbmco6KKkWiw8DDgLfY5paT5EoHAeF3og3z1CZwdbOIM53s4+Ks0d290P9Aff+UxjgN4kP2arLfznplVe17OSyrrWmIE4CJQKBgEf6zQiQACA0vpGld0bEdrIo/qJ27318DZzZLUCXPVO9ytSk8c6bKs5Nadj5TAbV9qoceyzDFmdR5C/NdAMKC+wPjnwtwQk68xpAhB5CMuABk3tZw8G0Xj1p+kWv8iI8UWyDuchJ8t5ZKrY0smrUfHxjFSoc/XT0p76AsEzQ3HlhAoGBAIw6gxYed1x1pJ6+UoWhjcIwYyehVTjsKrg+cKecpWyEnh4W8V6bzoomG2vPq/RhByIwpNub1+pku1ndHWYCNVXmmw6QzN+JCIgxVRCtCTaFBZZB78bXtrshfHIpihFLtO6e8GUf1pQtbyw1S1nh57/FSwtucivCa8KdkiXDoLylAoGBAJZ+FoTQ65uUfdHnQylWfPoNNE3IhcmpU+pheE8EgerVJjoxPFXtaVR5Wh2b9F43lL68dXj+tiQ3O2AEjaJVjOSdQiL2PIRxODE+aUY6iRjsPJfyqaC8XGG68QAQGm/c/+hUNSi9cZyMykjSXzlgoKxjhCckZsBOGffyPHQwfO7V";

    @Test
    public void accessToken() {
        System.out.println("=====> step2 : Create Access Token");

        String timestamp = ZonedDateTime.of(LocalDateTime.now(), WhooshConstant.ZONE_ID).format(WhooshConstant.DF_0);
        System.out.println("timestamp = " + timestamp);
        String clientKey = WhooshConstant.MERCHANT_ID;

        String stringToSign = clientKey + "|" + timestamp;
        System.out.println("stringToSign = " + stringToSign);
        System.out.println("privateKeyStr = " + privateKeyStr);
        String signature = SignatureUtil.createSignature(stringToSign, privateKeyStr);
        System.out.println("signature = " + signature);

        //url
        String url = WhooshConstant.BASE_URL + WhooshConstant.ACCESS_TOKEN_API;

        //body
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("grantType", "client_credentials");
        String jsonBody = jsonObject.toString();

        //post
        String response = RemoteUtil.postJson(url, timestamp, clientKey, signature, jsonBody);
        System.out.println("response = " + response);

        //build res
        Gson gson = new Gson();
        AccessTokenRes res = gson.fromJson(response, AccessTokenRes.class);
        System.out.println("res token = " + res.getAccessToken());

        System.out.println("Please remember the token, use this token for all subsequent api calls.");
    }

}
