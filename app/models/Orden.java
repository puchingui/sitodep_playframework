package models;

import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.db.jpa.*;

import javax.persistence.*;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;
import java.util.List;

/**
 * *****************************************
 * Creado con IntelliJ IDEA y Play Framework.
 * Autor: Kenneth S. Burgos
 * Fecha: 02/14/13
 * Hora: 02:38 PM
 * *****************************************
 */

@Entity
@Table(name = "ordenes")
public class Orden extends Model {

    @Required
    public Date fecha;

    @Required
    @ManyToOne
    public Cliente cliente;

    @Required
    @ManyToOne
    public Usuario recibidoPor;

    @ManyToOne
    public Usuario responsable;

    @Lob
    @MaxSize(500)
    public String observacion;

    @Enumerated(EnumType.STRING)
    public Estado estado;

    //Equipo
    @Required
    @ManyToOne
    public Tipo tipo;

    @Required
    @ManyToOne
    public Marca marca;

    @Required
    public String modelo;

    @Required
    public String serial;

    public String activo;
    public String falla;
    public Boolean garantia;

    @ManyToOne
    public Usuario creador;

    public static enum Estado {
        Taller,
        Chequeado,
        Irreparable,
        C1,
        C2,
        C3,
        Aprovada,
        Lista,
        Facturar,
        Despachar,
        Cerrada,
        Almacenado
    }

    public Orden() {
        this.fecha = new Date();
        this.estado = Estado.Taller;
    }

    public Orden(Date fecha, Cliente cliente, Usuario recibidoPor,
                 Tipo tipo, Marca marca, String modelo, String serial, Usuario creador) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.recibidoPor = recibidoPor;
        this.estado = Estado.Taller;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.serial = serial;
        this.creador = creador;
    }

    public Orden(Date fecha, Cliente cliente, Usuario recibidoPor, Usuario responsable,
                 String observacion, Tipo tipo, Marca marca,
                 String modelo, String serial, String activo, String falla,
                 Boolean garantia, Usuario creador) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.recibidoPor = recibidoPor;
        this.responsable = responsable;
        this.observacion = observacion;
        this.estado = Estado.Taller;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.serial = serial;
        this.activo = activo;
        this.falla = falla;
        this.garantia = garantia;
        this.creador = creador;
    }

    public Orden anterior() {
        return Orden.find("id < ? order by id desc", id).first();
    }

    public Orden proxima() {
        return Orden.find("id > ? order by id asc", id).first();
    }

    public static List<Orden> lista() {
        return Orden.find("order by id asc").fetch();
    }

    public String toString() {
        return id.toString();
    }

}
