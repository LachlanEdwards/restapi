package com.metlease.Entity.Helpers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

public class MultimediaSingleton {

    private static MultimediaSingleton instance = null;
    private static final String CLOUD_NAME = "metlease";
    private static final String API_KEY = "728113461321164";
    private static final String API_SECRET = "d8KyV7w65WNryfN-6BrNBYJzHgo";

    private static Cloudinary cloudinary;

    private MultimediaSingleton() {
        cloudinary = new Cloudinary("cloudinary://728113461321164:d8KyV7w65WNryfN-6BrNBYJzHgo@metlease");
    }

    public static MultimediaSingleton getInstance() {
        if (instance == null) {
            instance = new MultimediaSingleton();
        }

        return instance;
    }

    public static Map upload(File file) throws Exception {
        try {
            return cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        } catch (Exception e) {
            throw e;
        }
    }
}
