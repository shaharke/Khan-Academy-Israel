package controllers;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import controllers.CRUD;
import controllers.Secure;
import controllers.CRUD.ObjectType;
import play.data.binding.Binder;
import play.db.Model;
import play.exceptions.TemplateNotFoundException;
import play.i18n.Messages;
import play.mvc.*;

@With(Secure.class)
public class Lessons extends CRUD {
	
	public static void blank() throws Exception {
        ObjectType type = ObjectType.get(getControllerClass());
        notFoundIfNull(type);
        Model object = null;
        if (flash.get("objectId") != null) {
        	Method findModel = type.entityClass.getMethod("findById", Object.class);
        	object = (Model) findModel.invoke(type.entityClass, Long.valueOf(flash.get("objectId")));
        } else {
        	Constructor<?> constructor = type.entityClass.getDeclaredConstructor();
            constructor.setAccessible(true);
        	object = (Model) constructor.newInstance();
        }
        try {
            render(type, object);
        } catch (TemplateNotFoundException e) {
            render("CRUD/blank.html", type, object);
        }
    }
	
	public static void create() throws Exception {
        ObjectType type = ObjectType.get(getControllerClass());
        notFoundIfNull(type);
        Constructor<?> constructor = type.entityClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        Model object = (Model) constructor.newInstance();
        Binder.bind(object, "object", params.all());
        validation.valid(object);
        if (validation.hasErrors()) {
            renderArgs.put("error", Messages.get("crud.hasErrors"));
            try {
                render(request.controller.replace(".", "/") + "/blank.html", type, object);
            } catch (TemplateNotFoundException e) {
                render("CRUD/blank.html", type, object);
            }
        }
        object._save();
        flash.success(Messages.get("crud.created", type.modelName));
        if (params.get("_save") != null) {
            redirect(request.controller + ".list");
        }
        if (params.get("_saveAndAddAnother") != null) {
        	flash("objectId", object._key());
            redirect(request.controller + ".blank");
        }
        redirect(request.controller + ".show", object._key());
    }

}
