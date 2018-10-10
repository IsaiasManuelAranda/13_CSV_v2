
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.ModelData;
import view.ViewData;

public class ControllerData implements ActionListener {
    private final ModelData modelData;
    private final ViewData viewData;

    public ControllerData(ModelData modelData, ViewData viewData) {
        this.modelData = modelData;
        this.viewData = viewData;
        actionListener();
        initComponents();
        modelData.read();
        goHead();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewData.jb_guardar){
            makeCSV();
        }
        else if (e.getSource() == viewData.jb_limpiar){
            clean();
        }
        else if (e.getSource() == viewData.jb_head){
            goHead();
        }
        else if (e.getSource() == viewData.jb_last){
            goLast();
        }
        else if (e.getSource() == viewData.jb_next){
            goNext();
        }
        else if (e.getSource() == viewData.jb_tail){
            goTail();
        }
    }
    
    private void makeCSV() {
        modelData.setName(viewData.jtf_nombre.getText());
        modelData.setEmail(viewData.jtf_email.getText());
        JOptionPane.showMessageDialog(null, "Tu nombre y tu email se han almacenado correctamente. ");
        modelData.resultCSV();
        modelData.setMessage(modelData.resultCSV());
        modelData.read();
        goHead();
        modelData.writeFile(modelData.getPath(), modelData.getMessage());
    }
    private void clean(){
        viewData.jtf_nombre.setText(null);
        viewData.jtf_email.setText(null);
    }
    
    private void initComponents() {
        viewData.setVisible(true);
        viewData.setLocationRelativeTo(null);
        viewData.setTitle("Base de Datos");
        
    }

    private void goHead() {
        modelData.moveHead();
        viewData.jtf_nombre.setText(modelData.getName());
        viewData.jtf_email.setText(modelData.getEmail());
        
    }

    private void goTail() {
        modelData.moveTail();
        viewData.jtf_nombre.setText(modelData.getName());
        viewData.jtf_email.setText(modelData.getEmail());
    }

    private void goNext() {
        modelData.moveNext();
        viewData.jtf_nombre.setText(modelData.getName());
        viewData.jtf_email.setText(modelData.getEmail());
    }

    private void goLast() {
        modelData.movePrevious();
        viewData.jtf_nombre.setText(modelData.getName());
        viewData.jtf_email.setText(modelData.getEmail());
    }
    
    private void actionListener(){
        viewData.jb_guardar.addActionListener(this);
        viewData.jb_limpiar.addActionListener(this);
        viewData.jb_head.addActionListener(this);
        viewData.jb_last.addActionListener(this);
        viewData.jb_next.addActionListener(this);
        viewData.jb_tail.addActionListener(this);
    }
    

}
