import javax.swing.*;
import java.util.List;

public class DeskovkyGUI extends JFrame {
    private JButton nacteniSouboru;
    private JTable dataTabulky;
    private JScrollPane tablePane;
    private JPanel panel;
    private final JFileChooser jFileChooser;
    private Tabulka tabulka;


    public DeskovkyGUI(){
            jFileChooser = new JFileChooser(".");
            dataTabulky = new JTable((tabulka));
            nacteniSouboru.addActionListener(e-> tabulka.loadData(getFileData()).update());
            setVisible(true);
            setContentPane(panel);
            setSize(500, 500);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
    public List<Deskovky> getFileData(){
        int result = jFileChooser.showOpenDialog(this);
        if(result == JFileChooser.CANCEL_OPTION || result == JFileChooser.ERROR_OPTION){
            System.out.println("špatná možnost!");
            return null;
        }

        panel.remove(nacteniSouboru);
        return  DeskovkyScanner.loadData((jFileChooser.getSelectedFile()));
    }

    public static void main(String[] args) {
        new DeskovkyGUI();
    }

    private void createUIComponents(){
        tabulka = new Tabulka().addColumn(0, "hra")
                .addColumn(1, "zakoupeno")
                .addColumn(2, "hodnocení");
        dataTabulky = new JTable(tabulka);
        tablePane = new JScrollPane(dataTabulky);
        add(dataTabulky);

    }
}
