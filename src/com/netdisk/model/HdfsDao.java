package com.netdisk.model;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.net.URI;

/**
 * @Classname HdfsDao
 * @Description TODO
 * @Date 2020-3-13 16:40
 * @Created by lishaoteng
 */
public class HdfsDao {
    private static final String HDFS="http://one:8020";
    private String hdfsPath;
    private Configuration conf;
    public HdfsDao(Configuration conf){
        this(HDFS,conf);
    }

    public HdfsDao(String hdfs, Configuration conf) {
        this.hdfsPath=hdfs;
        this.conf=conf;
    }
    public static void main(String[] args) throws IOException {
    //JobConf conf = config();
    //HdfsDao hdfs = new HdfsDao(conf);
    //hdfs.ls("http://one:8020");
}

    //加载Hadoop配置文件
  /*  public  static JobConf config(){
        JobConf conf = new JobConf(HdfsDao.class);
        conf.setJobName("HdfsDao");
        conf.addResource("classpath:/conf/core-site.xml");
        conf.addResource("classpath:/conf/hdfs-site.xml");
        conf.addResource("classpath:/conf/mapred-site.xml");
        return conf;
    }*/

    //在根目录下创建文件夹
    public void mkdirs(String folder) throws IOException {
        Path path = new Path(folder);
        FileSystem fs = FileSystem.get(URI.create(hdfsPath), conf);
        if (!fs.exists(path)) {
            fs.mkdirs(path);
            System.out.println("Create: " + folder);
        }
        fs.close();
    }

    //某个文件夹的文件列表
    public FileStatus[] ls(String folder) throws IOException {
        Path path = new Path(folder);
        FileSystem fs = FileSystem.get(URI.create(hdfsPath), conf);
        FileStatus[] list = fs.listStatus(path);
        System.out.println("ls: " + folder);
        System.out.println("======================================================");
        if(list != null)
            for (FileStatus f : list) {
                System.out.printf("%s, folder: %s, 大小: %dK\n", f.getPath().getName(),
                        (f.isDirectory()?"目录":"文件"), f.getLen()/1024);
            }
        System.out.println("======================================================");
        fs.close();

        return  list;
    }


    public void copyFile(String local, String remote) throws IOException{
    FileSystem fs = FileSystem.get(URI.create(hdfsPath), conf);
//remote---/用户/用户下的文件或文件夹
        fs.copyFromLocalFile(new Path(local), new Path(remote));
        System.out.println("copy from: " + local + " to " + remote);
        fs.close();
        }

//删除文件或文件夹
public void rmr(String folder) throws IOException {
        Path path = new Path(folder);
        FileSystem fs = FileSystem.get(URI.create(hdfsPath), conf);
        fs.deleteOnExit(path);
        System.out.println("Delete: " + folder);
        fs.close();
        }


//下载文件到本地系统
public void download(String remote, String local) throws IOException{
        Path path = new Path(remote);
        FileSystem fs = FileSystem.get(URI.create(hdfsPath), conf);
        fs.copyToLocalFile(path, new Path(local));
        System.out.println("download: from" + remote + " to " + local);
        fs.close();
        }


        }
