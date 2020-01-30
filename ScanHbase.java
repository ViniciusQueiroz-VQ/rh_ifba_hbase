package rhifbahbase;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.hbase.client.Result;

public class ScanHbase {

    public static void main(String args[]) throws IOException {
        Configuration config = HBaseConfiguration.create();
        HTable table = new HTable(config, "Funcionario");
        Scan scan = new Scan();
        scan.addColumn(Bytes.toBytes("cf"), Bytes.toBytes("cpf"));
        scan.setStartRow(Bytes.toBytes("row-1"));
        ResultScanner result = table.getScanner(scan);
        for (Result res : result) {
            byte[] val = res.getValue(Bytes.toBytes("cf"), Bytes.toBytes("cpf"));
            System.out.println("Row-value:" + Bytes.toString(val));
        }
        table.close();
    }
}
