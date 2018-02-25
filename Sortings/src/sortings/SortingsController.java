/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortings;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;

/**
 *
 * @author will
 */
public class SortingsController implements Initializable {
    
    @FXML
    Pane view;
    @FXML
    Label arraySize;
    @FXML
    Slider arraySizeSlider;
    @FXML
    ComboBox algoithm;
    
    public Model _model;
    
    public void SetSortStrategy(){
        
    }
    
    public void sortBtn_Click(){
        
    }
    
    public void arraySizeBar_ValueChanged(){
        //System.out.println("bar changed");
        int size = (int)Math.round(arraySizeSlider.getValue());     //round the value to integer.
        arraySizeSlider.setValue(size);     
        arraySize.setText(Integer.toString(size));
        _model.setSize(size);
        _model.reset(size);
        //>>>>>need to add UI control>>>>>
        
    }
    
    public void resetBtn_Click(){
        _model.reset(_model.getSize());
        //>>>>>need to add UI control>>>>>
        
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        _model=new Model();
        arraySizeSlider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            arraySizeBar_ValueChanged();
        });     //use lambda expression to start a listener.
    }    
    
}
