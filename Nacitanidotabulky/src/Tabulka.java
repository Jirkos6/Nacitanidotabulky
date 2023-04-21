import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tabulka extends AbstractTableModel {
    private final Map<Integer, String> columnMap = new HashMap<>();
    private List<Deskovky> data;
    public Tabulka(){ data = new ArrayList<>();}
    public Tabulka addColumn(int columnIndex, String columnName){
        columnMap.put(columnIndex, columnName);
        return this;
    }
    public void update() {
        fireTableDataChanged();
    }

    public Tabulka loadData(List<Deskovky> data) {
        if(data == null) return this;
        this.data = data;
        return this;
    }

    @Override
    public int getRowCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public String getColumnName(int column) {
        return columnMap.getOrDefault(column, "Error");
    }

    @Override
    public int getColumnCount() {
        return columnMap.keySet().size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (data == null) {
            return "Test1";
        }
    Deskovky deskovky = data.get(rowIndex);
        if(deskovky == null){
            return "TEST";
        }
        return switch (columnIndex){
            case 0 -> deskovky.toString();
            case 1 -> deskovky.getBought() ? "Yes" : "No";
            case 2 -> deskovky.getRating();
            default ->  throw new IllegalStateException("neočekávaná hodnota: " + columnIndex);
        };
    }

}

