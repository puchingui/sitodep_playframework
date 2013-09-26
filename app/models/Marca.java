package models;

import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * User: Kenneth S. Burgos
 * Date: 03/12/13
 * Time: 11:17 PM
 */
@Entity
@Table(name = "marcas")
public class Marca extends Model {

    @Required
    public String nombre;

    public Marca() {}

    public String toString() {
        return nombre;
    }
}
