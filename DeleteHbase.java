package rhifbahbase;

import java.io.IOException;
import javax.swing.JOptionPane;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.util.Bytes;

public class DeleteHbase {

    public static void main(String args[]) throws IOException {
        Configuration config = HBaseConfiguration.create();
        HTable table = new HTable(config, "Funcionario");
        Delete del = new Delete(Bytes.toBytes("row-1"));
        del.deleteColumn(Bytes.toBytes("cf"), Bytes.toBytes("cpf"));//exemplo excluir apenas uma coluna
        table.delete(del);//tabela inteira
        JOptionPane.showMessageDialog(null,"Deletado com sucesso");
        table.close();
    }
}
