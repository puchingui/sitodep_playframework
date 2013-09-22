package models;

import javax.persistence.*;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;

import play.data.validation.*;
import play.db.jpa.*;

import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario extends Model {

    @Required
    public String nombre;

    @Required
    @Password
    public String clave;

    @Email
    public String email;

    public String fullname;

    @Enumerated(EnumType.STRING)
    public Rol rol;

    /***
     * Constructor
     * @param nombre
     * @param clave
     * @param fullname
     * @param rol
     */
    public Usuario(String nombre, String clave, String email, String fullname, Rol rol) {
        this.nombre = nombre;
        this.clave = clave;
        this.email = email;
        this.fullname = fullname;
        this.rol = rol;
    }

    public static Usuario findByNombre(String nombre) {
        return find("byNombre", nombre).first();
    }

    public static Usuario verifica(String nombre, String clave) {
        return find("byNombreAndClave", nombre, clave).first();
    }

    public static String[] allNombresUsuarios() {
        List<Usuario> usuarios = Usuario.findAll();
        String nombres[] = new String[usuarios.size()];

        for(int x = 0; x < usuarios.size(); x++) {
            nombres[x] = usuarios.get(x).nombre;
        }

        return nombres;
    }

    public String getProfile() {
        return rol.toString();
    }

    public String toString() {
        return nombre;
    }
}