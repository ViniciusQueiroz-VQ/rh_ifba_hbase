import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;
public class getHbase{
public static void main(String args[]) throws IOException {
Configuration config = HBaseConfiguration.create();
HTable table = new HTable(config,"Acadgild");
Get get = new Get(Bytes.toBytes("row-1"));
get.addColumn(Bytes.toBytes("Emp_name"), Bytes.toBytes("Emp_name"));
Result result=table.get(get);
byte[] name = result.getValue(Bytes.toBytes("Emp_name"),Bytes.toBytes("Emp_name"));
System.out.println("Name: " +Bytes.toString(name));
table.close();
}
}