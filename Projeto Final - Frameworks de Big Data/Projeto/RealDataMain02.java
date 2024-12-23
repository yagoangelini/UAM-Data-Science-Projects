import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.io.Text;

public class RealDataMain02 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration conf = new Configuration();
        //Salvar como: termo_idDoc_termFrequency_documentFrequency
        conf.set(TextOutputFormat.SEPARATOR, "_");
        Job job = Job.getInstance(conf, "ToyData02");

        job.setJarByClass(RealDataMain02.class);
        job.setMapperClass(RealDataMapper02.class);
        job.setReducerClass(RealDataReducer02.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        // System.exit(job.waitForCompletion(true)? 0:1);
        job.waitForCompletion(true);
    }
}
