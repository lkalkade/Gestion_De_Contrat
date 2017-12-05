package com.app.view;
import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;


public class TablePanel extends JPanel
{
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
public TablePanel( TableModel model )
  {
 
	table = new JTable( model );
    table.setRowHeight(34);
	table.setFont(new Font("Tahoma", Font.BOLD, 12));
	table.setAutoCreateRowSorter(true);
      
    setLayout( new BorderLayout() );
    add( new JScrollPane( table ), BorderLayout.CENTER );
    
  }
  private JTable table;
}