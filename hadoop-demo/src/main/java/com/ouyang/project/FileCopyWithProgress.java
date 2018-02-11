package com.ouyang.project;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.util.Progressable;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;

/**
 * Created by ouyang on 2017/9/25.
 */
public class FileCopyWithProgress {
    public static void main(String[] args) throws Exception {
        String src = "/Users/ouyang/my/resource/hadoop/hadoop-3.0.0-alpha4/WordCount2.java";
        String dest = "hdfs://localhost:9000/user/ouyang/WordCount2.java";
        InputStream in = new BufferedInputStream(new FileInputStream(src));
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(dest), conf);
        OutputStream out = fs.create(new Path(dest), () -> System.out.print("."));
        IOUtils.copyBytes(in, out, 4096, false);
        IOUtils.closeStream(fs);
        IOUtils.closeStream(in);
    }
}
