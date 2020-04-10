package com.netdisk.model;
import java.io.*;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;


/**
 * @Classname HelloWorld
 * @Description TODO
 * @Date 2020-3-17 13:48
 * @Created by lishaoteng
 */
public class HelloWorld {
    public static void main(String[] args) throws Exception {
        Configuration configuration = new Configuration();
        FileSystem fs = FileSystem.get(configuration);
        OutputStream out = fs.create(new Path("./input/linuxidc.txt"));
        String str = "Hello World linuxidc";
        out.write(str.getBytes());
        new HelloWorld().listfile();
        new HelloWorld().listFileAndFolder();
        out.flush();
        out.close();
    }
    public void listfile() throws IOException {
        FileSystem fs=conf();
        RemoteIterator<LocatedFileStatus> listFiles = fs.listFiles(new Path("./input/"), true);
        while(listFiles.hasNext()) {
            LocatedFileStatus next = listFiles.next();
            System.out.println(next.getPath().getName());
        }
    }
    public void listFileAndFolder() throws IOException {
        FileSystem fs=conf();
        FileStatus[] listStatus = fs.listStatus(new Path("/"));
        for(FileStatus list:listStatus) {
            System.out.println(list.getPath().getName());
        }
    }
    public FileSystem conf()throws IOException{
        Configuration configuration = new Configuration();
        FileSystem fs = FileSystem.get(configuration);
        return fs;
    }
    public void upload(String[] args){
        try {
            String localStr = args[0];
            String dst = args[1];
            //in对应的是本地文件系统的目录
            InputStream in = new BufferedInputStream(new FileInputStream(localStr));
            Configuration conf = new Configuration();
            //获得hadoop系统的连接
            FileSystem fs = FileSystem.get(URI.create(dst),conf);

            //out对应的是Hadoop文件系统中的目录
            OutputStream out = fs.create(new Path(dst));
            IOUtils.copyBytes(in, out, 4096,true);
                    System.out.println("success");
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }
    public void download(){

    }
}