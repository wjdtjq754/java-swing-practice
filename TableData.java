import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.table.AbstractTableModel;

public class TableData extends AbstractTableModel{
	private List<Transaction> list;
	private String[] headers = {"Name","Type","Amount","Note"};
	public TableData() {
		updateList();
	}
	
	public String getColumnName(int cell) {
		return headers[cell];
	}
	
	public void updateList() {
		list = new ArrayList<>();
		try {
			Scanner sc = new Scanner(new File("./data.csv"));
			for(int i=0; sc.hasNextLine();i++) {
				String[] data = sc.nextLine().split(",");
				if(i!=0) {
				Transaction t = new Transaction();
				TransactionBuilder tb = new TransactionBuilder(t);
				t= tb
					.name(data[0])
					.type(data[1])
					.amount(Double.parseDouble(data[2]))
					.note(data[3])
					.transaction();
				list.add(t);
				}
			}
			sc.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int getRowCount() {
		
		return list.size();
	}

	@Override
	public int getColumnCount() {
		
		return 4;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex) {
		case 0:
			return list.get(rowIndex).getName();
		case 1:
			return list.get(rowIndex).getType();
		case 2:
			return list.get(rowIndex).getAmount();
		case 3:
			return list.get(rowIndex).getNote();
		}
		return null;
	}


	public static void main(String[] args) {
		

	}

	public void refresh() {
		updateList();
		super.fireTableDataChanged(); 	//테이블 업데이트
	}
}
