/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortings;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

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
    ComboBox algorithm;
    
    final ObservableList<String> strategys = FXCollections.observableArrayList();
    SortingsStrategy sortingsMethod;
    
    Thread sort;                                                                //use Thread sort to prevent interupt.
    
    public Model _model;
    
    public void SetSortStrategy(){
        //System.out.println(algorithm.getValue());
        new Thread (()->{
            if (sort!=null) {                                                   //if the sorting thread is processing, the change will be done after sorting.
                try {
                    sort.join();
                } catch (InterruptedException ex) {
                    
                }
            }

            Platform.runLater(()->{

                String selected=(String)algorithm.getValue();
                if (selected.equals("Selection Sort")){
                    sortingsMethod=new SelectionSort();
                }
                if (selected.equals("Merge Sort")){
                    sortingsMethod=new MergeSort();
                }
            });
        }).start();
    }
    
    public void sortBtn_Click(){
        if (sort!=null&&sort.isAlive()) {                                       //prevent clicking sort btn when the array is being sorted
            return;
        }
        sortingsMethod.Sort(_model.getUnSortedList());
        sort=new Thread(()->{
            while (!_model.isSorted()){                                         //use is alive to know the sorting thread is running or not, if it is not, stop updating GUI
                Platform.runLater(()->{updateUI();});                           //really really really important!!!!!
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                   
                }
            }
            Platform.runLater(()->{updateUI();});                               //note that, every function that involves the GUI need to call within Platform.runLater()!!!!!
        });
        sort.start();

    }
    
    public void arraySizeBar_ValueChanged(){
        //System.out.println("bar changed");
        int size = (int)Math.round(arraySizeSlider.getValue());                 //round the value to integer.
        arraySizeSlider.setValue(size);     
        arraySize.setText(Integer.toString(size));
        _model.setSize(size);
        //_model.reset(size);                                                   setSize will call reset() automatically
        //>>>>>need to add UI control>>>>>
        updateUI();
    }
    
    public void resetBtn_Click(){
        
        //System.out.println("reset");
        _model.reset(_model.getSize());
        //>>>>>need to add UI control>>>>>
        updateUI();
    }
    
    public void exitBtn_Click(){
        Stage s=(Stage) arraySize.getScene().getWindow();
        s.close();
    }
    

    
    public void updateUI(){
//        Rectangle r=new Rectangle(10,100,Color.RED);
//        Rectangle r2=new Rectangle(2,2,Color.BLUE);
//        Rectangle r3=new Rectangle(3,3,Color.GREEN);
//        r.relocate(400, 370);
//        r2.relocate(0, 0);
//        r3.relocate(800, 470);
//        view.getChildren().addAll(r,r2,r3);
        
        view.getChildren().clear();
        
        double w=view.getWidth();
        double h=view.getHeight();
        if (h<=0||w<=0) {
            //use when the program was init.
            h=470;
            w=850;
        }
        
        int[] arr=_model.getUnSortedList();
        double step=w/(arr.length);
        double unitWidth=step-3;                                                // 3 is the gap
        double unitHeight=(h-5)/(arr.length);                    // 5 is the margin between the top
        double location;
        int index;
        for(index=0,location=0;index<arr.length;index++)
        {
            double height=unitHeight*arr[index];
            Rectangle element = new Rectangle(unitWidth,height,Color.PURPLE);
            element.relocate(location,h-height);
            view.getChildren().add(element);
            location+=step;
        }

        //System.out.println("update called");
        
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        _model=new Model();
        strategys.add("Selection Sort");
        strategys.add("Merge Sort");
        algorithm.setItems(strategys);
        algorithm.setValue("Selection Sort");
        sortingsMethod=new SelectionSort();
        arraySizeBar_ValueChanged();
        arraySizeSlider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            arraySizeBar_ValueChanged();
        });     //use lambda expression to start a listener.
    }    
    
}
