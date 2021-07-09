package BankingTransaction;

import java.io.IOException;
import java.util.*;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;

public class TransactionReducer extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable> {
	
//reporter class fetches status
	public void reduce(Text t_key, Iterator<IntWritable> values, OutputCollector<Text,IntWritable> output, Reporter reporter) throws IOException {
		Text key = t_key; //intialise current key
		int transactionByUser = 0;
		while (values.hasNext()) //iteration 
			{
			// replace type of value with the actual type of our value
			IntWritable value = (IntWritable) values.next(); //typecasting to intwritable
			transactionByUser += value.get();
			
		}
		output.collect(key, new IntWritable(transactionByUser)); //total count is returned
	}
}