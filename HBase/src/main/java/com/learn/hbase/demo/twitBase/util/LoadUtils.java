package com.learn.hbase.demo.twitBase.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.learn.hbase.HBaseApplication;

public class LoadUtils {

  public static final String WORDS_PATH = "/dict/web2";
  public static final String NAMES_PATH = "/dict/propernames";

  public static List<String> readResource(String path) throws IOException {
    List<String> lines = new ArrayList<String>();
    String line;
    InputStream s = HBaseApplication.class.getResourceAsStream(path);
    BufferedReader reader = new BufferedReader(new InputStreamReader(s));
    while ((line = reader.readLine()) != null) {
      lines.add(line);
    }
    s.close();
    return lines;
  }

  public static int randInt(int max) {
    return (int)Math.floor(Math.random() * max);
  }

  public static String randNth(List<String> words) {
    int val = randInt(words.size());
    return words.get(val);
  }
  
  public static void main(String[] args) throws IOException {
	  System.out.println(LoadUtils.readResource(NAMES_PATH).get(0));
}
}
