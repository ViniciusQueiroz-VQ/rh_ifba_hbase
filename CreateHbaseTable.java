package rhifbahbase;

import java.io.IOException;
import javax.swing.JOptionPane;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.util.Bytes;

public class CreateHbaseTable {

    Configuration config = HBaseConfiguration.create();

    public void createtable(String name, String[] colfamily) throws MasterNotRunningException,
            ZooKeeperConnectionException, IOException {
        HBaseAdmin admin = new HBaseAdmin(config);
        HTableDescriptor des = new HTableDescriptor(Bytes.toBytes(name));
        for (String colfamilies : colfamily) {
            des.addFamily(new HColumnDescriptor(colfamilies));
        }
        if (admin.tableExists(name)) {
            JOptionPane.showMessageDialog(null, "Tabela já existe");
        } else {
            admin.createTable(des);
           JOptionPane.showMessageDialog(null,"Tabela: " + name + " criada com sucesso");
        }
    }

    public static void main(String args[]) throws MasterNotRunningException,
            ZooKeeperConnectionException, IOException {
        CreateHbaseTable op = new CreateHbaseTable();
        String tablename = "Funcionario";
        String[] familys = {"cpf", "nome", "telefone"};
        op.createtable(tablename, familys);
    }
}
