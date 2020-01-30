package rhifbahbase;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

public class GetHbase {

    public static void main(String args[]) throws IOException {
        
        Configuration config = HBaseConfiguration.create();
        
        HTable table = new HTable(config, "Funcionario");
        
        Get get = new Get(Bytes.toBytes("row-1"));
        
        get.addColumn(Bytes.toBytes("cf"), Bytes.toBytes("cpf"));
        
        Result result = table.get(get);
        
        byte[] nome = result.getValue(Bytes.toBytes("cf"), Bytes.toBytes("nome"));
        System.out.println("Nome: " + Bytes.toString(nome));
        
        byte[] telefone = result.getValue(Bytes.toBytes("cf"), Bytes.toBytes("telefone"));
        System.out.println("Telefone: " + Bytes.toString(telefone));
        
        table.close();
    }
}
