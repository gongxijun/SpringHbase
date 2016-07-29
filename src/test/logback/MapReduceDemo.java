package logback;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Iterator;
import java.util.StringTokenizer;

/**
 * author: 龚细军
 * class-aim:
 */
public class MapReduceDemo {

    private static Logger logger = LoggerFactory.getLogger(MapReduceDemo.class);

    private static class Map extends MapReduceBase implements Mapper<LongWritable, Text, Text,
            IntWritable> {
        private final static IntWritable one = new IntWritable(1);
        private Text words = new Text();

        @Override
        public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
            String line = value.toString();
            //line做解析 相当于Scanner
            StringTokenizer tokenizer = new StringTokenizer(line);
            while (tokenizer.hasMoreTokens()) {
                words.set(tokenizer.nextToken());
                output.collect(words, one);
            }
        }
    }

    private static class Reduce extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable> {
        @Override
        public void reduce(Text key, Iterator<IntWritable> values, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
            int sum = 0;
            while (values.hasNext()) {
                sum += values.next().get();
            }
            output.collect(key, new IntWritable(sum));
        }
    }

    public static void main(String args[]) {

        JobConf conf = new JobConf(MapReduceDemo.class);
        conf.setJobName("MapReduceDemo");
        conf.setOutputKeyClass(Text.class);
        conf.setOutputValueClass(IntWritable.class);
        conf.setMapperClass(Map.class);
        conf.setCombinerClass(Reduce.class);
        conf.setReducerClass(Reduce.class);
        conf.setInputFormat(TextInputFormat.class);
        conf.setOutputFormat(TextOutputFormat.class);

        String inputPath = new String("/gongxijun/HDFS/fileinput");
        String outputPath = new String("/gongxijun/HDFS/fileOutput");

        FileInputFormat.setInputPaths(conf, new Path(inputPath));
        FileOutputFormat.setOutputPath(conf, new Path(outputPath));
        try {
            JobClient.runJob(conf);
        } catch (IOException e) {
            System.out.println(e);

        }
    }
}
