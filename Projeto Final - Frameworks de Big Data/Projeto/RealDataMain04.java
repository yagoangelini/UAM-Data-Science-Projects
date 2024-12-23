import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class RealDataMain04 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration conf = new Configuration();
        //Salvar como: idDoc_termo;TFIDF
        conf.set(TextOutputFormat.SEPARATOR, ";");
        Job job = Job.getInstance(conf, "ToyData03");

        job.setMapperClass(RealDataMapper04.class);
        job.setReducerClass(RealDataReducer04.class);
        job.setJarByClass(RealDataMain04.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(DoubleWritable.class);

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        //System.exit(job.waitForCompletion(true)? 0:1);
        job.waitForCompletion(true);
    }
}
