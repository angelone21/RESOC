
package edu.cecar.controladores;

import edu.cecar.modelos.*;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 * Clase: ControladorRenderizarCelda
 * 
 * @version: 0.1
 *  
 * @since: 19/09/2019
 * 
 * Fecha de Modificación:
 * 
 * @author: Vincenzo Angelone
 * 
 * Copyrigth: CECAR
 */
public class ControladorRenderizarCelda implements TableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel imagen = new JLabel();
        imagen.setIcon((ImageIcon)value);
        return imagen;
    }   
    

}
