package ru.kpfu.itis.solopov.net.util;

import com.cloudinary.Cloudinary;

import java.util.HashMap;
import java.util.Map;

public class CloudinaryUtil {

    private static Cloudinary cloudinary;

    public static Cloudinary getInstance() {
        if (cloudinary == null) {
            Map<String, String> configMap = new HashMap<>();
            configMap.put("cloud_name", "dx8hpdxxt");
            configMap.put("api_key", "751597726339143");
            configMap.put("api_secret", "fxUUrlm7dPYoFPgPWgnx9ixeC3Y");
            cloudinary = new Cloudinary(configMap);
        }
        return cloudinary;
    }
}