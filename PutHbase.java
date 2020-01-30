package rhifbahbase;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;

public class PutHbase {

    public static void main(String args[]) throws IOException {
        Configuration config = HBaseConfiguration.create();
        HTable table = new HTable(config, "Funcionario");
        Put put = new Put(Bytes.toBytes("row-1"));
        put.add(Bytes.toBytes("cf"), Bytes.toBytes("cpf"), Bytes.toBytes("12345678910"));
        put.add(Bytes.toBytes("cf"), Bytes.toBytes("nome"), Bytes.toBytes("Adriano"));
        put.add(Bytes.toBytes("cf"), Bytes.toBytes("telefone"), Bytes.toBytes("77988008800"));
        table.put(put);
        System.out.println("Inserido com Sucesso");
        table.close();
    }
}
