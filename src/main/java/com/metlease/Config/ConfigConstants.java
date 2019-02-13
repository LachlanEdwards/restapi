package com.metlease.Config;

public class ConfigConstants {
    public static final String SECRET = "2870BE1ECFC31EAE379BA1A1A0314786871BB9AFCE31394199E44F5024678FC8";
    public static final long EXPIRATION_TIME = 604_800_000;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/secure/create";
    public static final String LOGIN_URL = "/secure/use";
    public static final String LOGOUT_URL = "/secure/exit";
    public static final String ERROR_URL = "/secure/error";
    public static final String AUTH_URL = "/secure";
}
