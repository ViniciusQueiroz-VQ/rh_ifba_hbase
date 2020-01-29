import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Delete;
public class scanHbase {
public static void main(String args[]) throws IOException{
Configuration config = HBaseConfiguration.create();
HTable table = new HTable(config,"Acadgild");
Scan scan = new Scan();
scan.addColumn(Bytes.toBytes("Emp_name"), Bytes.toBytes("Emp_name"));
scan.setStartRow(Bytes.toBytes("row-1"));
//scan.setStartRow(Bytes.toBytes("row-4"));
ResultScanner result = table.getScanner(scan);
for(Result res:result){
byte[] val = res.getValue(Bytes.toBytes("Emp_name"), Bytes.toBytes("Emp_name"));
System.out.println("Row-value:"+Bytes.toString(val));
}
table.close();
}
}