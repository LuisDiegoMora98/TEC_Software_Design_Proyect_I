/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author lalem
 */
public class ControllerViewer {

    private static ControllerViewer controllerViewer;
    
    private ControllerViewer() {
        
    }
    
    public ControllerViewer getInstance(){
        if(controllerViewer == null){
            controllerViewer = new ControllerViewer();
        }
        return controllerViewer;
    }    
    
    public void refresh(){
    
    }
}
