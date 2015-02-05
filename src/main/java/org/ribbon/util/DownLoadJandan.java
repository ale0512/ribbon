package org.ribbon.util;

import jodd.io.NetUtil;
import jodd.jerry.Jerry;
import jodd.jerry.JerryFunction;
import jodd.util.SystemUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2014/12/12.
 */
public class DownLoadJandan {

    private static String GIRL_URL = "http://jandan.net/ooxx/page-";
    private static String BORED_URL = "http://jandan.net/pic/page-";
    private static String GIRL_FEATURE = ".text img";
    private static String BORED_FEATURE = "";

    public  void downloadGirl(List<String> url) throws IOException {
        for (String u:url){
            System.out.println(u);
            File image = new File("F://image",this.getFileNameByUri(u));

            NetUtil.downloadFile(u,image);
        }

    }
    public static void downloadBored(){

    }

    public List<String> getRemoteUri(String html){
        Jerry doc = Jerry.jerry(html);
        final List<String> urls = new ArrayList<String>();
        doc.$(GIRL_FEATURE).each(new JerryFunction() {
            @Override
            public boolean onNode(Jerry $this, int index) {
                urls.add($this.attr("src"));
                return true;
            }
        });
        return urls;
    }

    public String getPage(String url) throws IOException {
        return NetUtil.downloadString(url);
    }

    public String getFileNameByUri(String url){
        return url.substring(url.lastIndexOf("/")+1,url.length());
    }
    public static void main(String[] args) throws IOException {
        System.out.println("---------Start download image----------");
        DownLoadJandan jandan = new DownLoadJandan();
        for (int i = 1211; i >1200 ; i--) {
            String html  = jandan.getPage(GIRL_URL+i);
            List<String> urls = jandan.getRemoteUri(html);
            jandan.downloadGirl(urls);
        }

        System.out.println("--------End Download image------------");
    }
}
