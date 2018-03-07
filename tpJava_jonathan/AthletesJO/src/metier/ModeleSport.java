/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import domaine.Sport;
import java.util.ArrayList;

/**
 *
 * @author Jonathan vouilloz
 */
public class ModeleSport extends ListeObjects {
    
    
    public void loadData (){
        aListe = dao.SportDao.getListeSports();
        setChanged(); notifyObservers(new Action(Action.LOAD));
    }
    
    public Object get(){
        return (Sport)super.get();
    }
    
    public Object get(int i) {
        return (Sport)super.get(i);
    }
    

}
