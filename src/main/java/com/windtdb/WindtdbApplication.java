package com.windtdb;

import cn.com.wind.td.tdb.OPEN_SETTINGS;
import cn.com.wind.td.tdb.ResLogin;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.StringTokenizer;

@SpringBootApplication
public class WindtdbApplication{
//	public void addDll() {
//		ClassLoader classLoader = getClass().getClassLoader();
//        URL url = classLoader.getResource("");
//        assert url != null;
//        String baseDir = url.getPath();
//        String jniDll = baseDir + "BOOT-INF/classes/tdbapi_jni.dll";
//        String tdbDll = baseDir + "BOOT-INF/classes/TDBAPI.dll";
//        System.load(jniDll);
//        System.load(tdbDll);
//        System.out.println(jniDll);
//	}


	public static void main(String[] args) {
//		String property = System.getProperty("java.library.path");
//		StringTokenizer parser = new StringTokenizer(property, ";");
//		while (parser.hasMoreTokens()) {
//			System.err.println(parser.nextToken());
//		}
		//System.load("src/main/java/tdbapi_jni.dll");
		//System.load("src/main/java/TDBAPI.dll");
		//System.load("D:/intellij/windtdb/lib/tdbapi_jni.dll");
		//System.load("D:/intellij/windtdb/lib/TDBAPI.dll");
		//System.loadLibrary("tdbapi_jni.dll");
		//System.loadLibrary("TDBAPI.dll");
//		WindtdbApplication wa = new WindtdbApplication();
//		wa.addDll();
		SpringApplication.run(WindtdbApplication.class, args);
	}
}
