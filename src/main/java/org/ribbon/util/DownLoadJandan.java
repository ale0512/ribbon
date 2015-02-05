package org.ribbon.util;

import jodd.io.NetUtil;
import jodd.jerry.Jerry;
import jodd.jerry.JerryFunction;
import jodd.util.StringUtil;
import jodd.util.SystemUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2014/12/12.
 */
public class DownLoadJandan  implements  Runnable{

    private static String GIRL_URL = "http://jandan.net/ooxx/page-";
    private static String BORED_URL = "http://jandan.net/pic/page-";
    private static String LOFT_URL = "http://sexy.faceks.com/?page=";
    private static String GIRL_FEATURE = ".text img";
    private static String LOFT_FEATUER = ".m-post-img img";
    private static String BORED_FEATURE = "";
    private int startPage = 1;

    public DownLoadJandan(){

    }
    public DownLoadJandan(int startPage){
        this.startPage = startPage;
    }
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
        doc.$(LOFT_FEATUER).each(new JerryFunction() {
            @Override
            public boolean onNode(Jerry $this, int index) {
//                同时下载 jpg 和 gif
              String  url = $this.attr("src");
                if(url.substring(url.lastIndexOf(".")+1).toLowerCase()=="gif"){
                    url = $this.attr("org_src");
                }
                urls.add(url);
//            只下载gif
//                String url = $this.attr("org_src");
//                if(StringUtil.isNotEmpty(url)){
//                    urls.add(url);
//                }
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

        for (int i = 20; i <50 ; i++) {
            Thread thread = new Thread(new DownLoadJandan(i));
            thread.start();
        }

        System.out.println("--------End Download image------------");
    }

    @Override
    public void run() {
        try {
            start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  void start() throws IOException {
        String html  = this.getPage(LOFT_URL + this.startPage);
        List<String> urls = this.getRemoteUri(html);
        this.downloadGirl(urls);
    }
}
