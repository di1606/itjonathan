/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.List;
import java.util.Observable;
import java.util.Observer;
import metier.Action;
import metier.ModeleSport;

/**
 *
 * @author Jonathan vouilloz
 */
public class SportObserver implements Observer {
    private List list;

    public SportObserver(List list) {
        this.list = list;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (((Action)arg).getAction() == Action.LOAD) {
            list.removeAll(); 
            for (int i=0; i < ((ModeleSport)o).size(); i++) {
                list.add(((ModeleSport)o).get(i).toString());
            }
        }
    }
}
