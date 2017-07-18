package com.obiecta.utils;

import java.net.URL;
import java.net.URLClassLoader;

public class UrlsOfContextClassLoaderOfCurrentThread
{
    public static void main( String[] args )
    {
        System.out.println( "Urls of ContextClassLoader of CurrentThread");
        for(URL url: ((URLClassLoader) (Thread.currentThread().getContextClassLoader())).getURLs()){
        	System.out.println("  " + url);
        }

        System.out.println("java.library.path=" + System.getProperty("java.library.path"));
    }
}
