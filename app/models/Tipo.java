package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * User: Kenneth S. Burgos
 * Date: 03/12/13
 * Time: 11:06 PM
 */
@Entity
@Table(name = "tipos")
public class Tipo extends Model {

    public String descripcion;

    public Tipo() {}

    public String toString() {
        return descripcion;
    }
}
