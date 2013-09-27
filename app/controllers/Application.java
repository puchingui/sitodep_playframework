package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

@With(Secure.class)
public class Application extends Controller {

    public static void index() {
        Usuario usuario = Usuario.findByEmail(Security.connected());
        render(usuario);
    }

    public static void usuarios() {
        List<Usuario> usuarios = Usuario.findAll();
        renderJSON(usuarios);
    }

}