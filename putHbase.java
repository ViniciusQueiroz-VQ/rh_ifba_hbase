import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;
public class putHbase {
public static void main(String args[]) throws IOException{
//create instance of default hbase configuration object
Configuration config  = HBaseConfiguration.create();
//Get the table instance
HTable table =  new HTable(config, "Acadgild");
//create the put object
Put put = new Put(Bytes.toBytes("row-1"));
//Add the column into the column family Emp_name with qualifier name
put.add(Bytes.toBytes("Emp_name"), Bytes.toBytes("Employee1"),Bytes.toBytes("Kiran"));
//Add the column into the column family sal with qualifier name
put.add(Bytes.toBytes("sal"), Bytes.toBytes("sal_Employee1"), Bytes.toBytes("100000"));
//insert the put instance to table
table.put(put);
System.out.println("Values inserted : ");
table.close();
}
}