
package main;

import model.ModelData;
import view.ViewData;
import controller.ControllerData;

public class Main {

    private static ModelData modelData;
    private static ViewData viewData;
    private static ControllerData controllerData;
    
    public static void main(String[] args) {
        modelData = new ModelData();
        viewData = new ViewData();
        controllerData = new ControllerData(modelData, viewData);
    }
    
}
