package models;

import play.data.validation.*;
import play.db.jpa.*;

import javax.persistence.*;

import java.util.List;

/**
 * *****************************************
 * Creado con IntelliJ IDEA y Play Framework.
 * Autor: Kenneth S. Burgos
 * Fecha: 02/14/13
 * Hora: 02:31 PM
 * *****************************************
 */

@Entity
@Table(name = "clientes")
public class Cliente extends Model {

    @Required
    public String nombre;

    public String rnc;

    public String contacto;

    @Email
    public String email;

    @Phone
    public String telefono;

    public Cliente(String nombre, String rnc, String contacto,
                   String email, String telefono) {
        this.nombre = nombre;
        this.rnc = rnc;
        this.contacto = contacto;
        this.email = email;
        this.telefono = telefono;
    }

    public static Cliente findByNombre(String nombre) {
        return find("byNombre", nombre).first();
    }

    public static String[] allNombresClientes() {
        List<Cliente> clientes = Cliente.findAll();
        String nombres[] = new String[clientes.size()];

        for(int x = 0; x < clientes.size(); x++) {
            nombres[x] = clientes.get(x).nombre;
        }

        return nombres;
    }

    public String toString() {
        return nombre;
    }
}