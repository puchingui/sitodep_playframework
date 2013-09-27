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
    @Email
    public String email;

    @Required
    @Password
    public String clave;

    public String nombre;

    @Enumerated(EnumType.STRING)
    public Rol rol;

    /***
     * Constructor
     * @param email
     * @param clave
     * @param nombre
     * @param rol
     */
    public Usuario(String email, String clave, String nombre, Rol rol) {
        this.email = email;
        this.clave = clave;
        this.nombre = nombre;
        this.rol = rol;
    }

    public static Usuario findByEmail(String email) {
        return find("byEmail", email).first();
    }

    public static Usuario verifica(String email, String clave) {
        return find("byEmailAndClave", email, clave).first();
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
        return this.nombre;
    }
}