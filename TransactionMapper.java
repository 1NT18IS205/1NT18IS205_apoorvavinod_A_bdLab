package BankingTransaction;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable; // int wrapper class
import org.apache.hadoop.io.LongWritable; // long wrapper class
import org.apache.hadoop.io.Text; // string class
import org.apache.hadoop.mapred.*; // mapper class

//inherits mapreduce base class 
public class TransactionMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {
	private final static IntWritable one = new IntWritable(1); //intialization
	
//overrides map
	public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {

		String valueString = value.toString(); // type casting
		String[] Transaction = valueString.split(","); // split based on , (, is the delimiter)
		output.collect(new Text(Transaction[2]), one);
	}                          // interested in only occurence of names
}
