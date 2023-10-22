import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class PR450Producte {
    private int id;
    private String nom;
    private PropertyChangeSupport llistaObservers = new PropertyChangeSupport(this);


    PR450Producte(int id, String nom){
        this.id = id;
        this.nom = nom;
    }


    public int getId() {
        return id;
    }
    
    public void setId(int new_id) {
        int old_id = this.id;
        this.id = new_id;
        if (old_id != this.id){
            llistaObservers.firePropertyChange("id", old_id, new_id);
        }
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String new_nom) {
        String old_nom = this.nom;
        this.nom = new_nom;
        if (old_nom != this.nom){
            llistaObservers.firePropertyChange("nom", old_nom, new_nom);
        }
    }

    public void addPropertyChangeListener(String name, PropertyChangeListener listener) {
        llistaObservers.addPropertyChangeListener(name, listener);
    }

    public void removePropertyChangeListener(String name, PropertyChangeListener listener) {
        llistaObservers.removePropertyChangeListener(name, listener);
    }

    @Override
    public String toString() {
        return  Integer.toString(id);
    }
}