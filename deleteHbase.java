import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.hbase.client.Result;
public class deleteHbase{
public static void main(String args[])throws IOException{
Configuration config = HBaseConfiguration.create();
HTable table=new HTable(config, "Acadgild");
Delete del=new Delete(Bytes.toBytes("row-1"));
del.deleteColumn(Bytes.toBytes("Emp_name"),Bytes.toBytes("Emp_name") );
table.delete(del);
System.out.println("value-delted");
table.close();
}
}