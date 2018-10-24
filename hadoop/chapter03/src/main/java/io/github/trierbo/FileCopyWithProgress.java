package io.github.trierbo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.util.Progressable;

import java.io.*;
import java.net.URI;

public class FileCopyWithProgress {
    public static void main(String[] args) throws IOException {
        InputStream in = new BufferedInputStream(new FileInputStream(args[0]));
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(args[1]), conf);
        OutputStream out = fs.create(new Path(args[1]), new Progressable() {
            public void progress() {
                System.out.print('.');
            }
        });
        IOUtils.copyBytes(in, out, 4096, true);
    }
}
