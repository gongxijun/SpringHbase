package com.qunar.mapReduce;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * *********************************************************
 * <p/>
 * Author:     XiJun.Gong
 * Date:       2016-07-29 14:59
 * Version:    default 1.0.0
 * Class description：
 * <p/>
 * *********************************************************
 */
public class MapReduceDemo {

    public static class Map extends Mapper<LongWritable, Text, Text, IntWritable> {

        private final static IntWritable one = new IntWritable(1);
        private Text word = new Text();

        @Override
        public void map(LongWritable key, Text value, Context context)
                throws IOException, InterruptedException {
            String line = value.toString();
            StringTokenizer tokenizer = new StringTokenizer(line);
            while (tokenizer.hasMoreTokens()) {
                word.set(tokenizer.nextToken());
                context.write(word, one);
            }
        }

        public static class Reduce extends Reducer<Text, IntWritable, Text, IntWritable> {

            @Override
            public void reduce(Text key, Iterable<IntWritable> values, Context context)
                    throws IOException, InterruptedException {
                int sum = 0;
                for (IntWritable val : values) {
                    sum += val.get();
                }

                context.write(key, new IntWritable(sum));
            }
        }


        public static void main(String[] args) throws Exception {

            Configuration configuration = new Configuration();
            Job job = new Job(configuration, "wordCount");
            job.setOutputKeyClass(Text.class);
            job.setOutputValueClass(IntWritable.class);
            job.setMapperClass(Map.class);
            job.setReducerClass(Reduce.class);
            job.setInputFormatClass(TextInputFormat.class);
            job.setOutputFormatClass(TextOutputFormat.class);
            Scanner reader = new Scanner(System.in);
            while (reader.hasNext()) {
                FileInputFormat.addInputPath(job, new Path(reader.next()));
                FileOutputFormat.setOutputPath(job, new Path(reader.next()));
                job.waitForCompletion(true);
            }
        }
    }
}
