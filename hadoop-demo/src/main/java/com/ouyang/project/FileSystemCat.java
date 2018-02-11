package com.ouyang.project;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.InputStream;
import java.net.URI;


/**
 * Created by ouyang on 2017/9/25.
 */
public class FileSystemCat {
    public static void main(String[] args) throws Exception {
//        String uri = "hdfs://localhost:9000/user/ouyang/output/part-r-00000";
        String uri = "hdfs://localhost:9000/user/ouyang/WordCount2.java";
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(uri), conf);
        FSDataInputStream in = null;
        in = fs.open(new Path(uri));
        IOUtils.copyBytes(in, System.out, 4096, false);
//        in.seek(0);
//        IOUtils.copyBytes(in, System.out, 4096, false);
        IOUtils.closeStream(in);
        fs.close();
    }
}
