import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;
public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567;
    }

    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        staticFileLocation("/public");

        //home/index page
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //animals routing
        post("/animals/new", (request, response) -> {

            Map<String, Object> model = new HashMap<>();

            String name = request.queryParams("name");
            String type = "common";
            Animal newAnimal = new Animal(name, type);
            newAnimal.save();

            model.put("animals", newAnimal);


            return new ModelAndView(model, "animals-form.hbs");
        }, new HandlebarsTemplateEngine());
        post("endangered/new", (request, response) -> {

            Map<String, Object> model = new HashMap<>();

            String name = request.queryParams("name");
            String type = "endangered";
            String health = request.queryParams("health");
            String age = request.queryParams("age");

            EndangeredAnimal newEndageredAnimal = new EndangeredAnimal(name, type, health, age);
            newEndageredAnimal.save();
            model.put("animals", newEndageredAnimal);

            return new ModelAndView(model, "endangered-form.hbs");
        }, new HandlebarsTemplateEngine());
//        B)READ
        //ANIMAL
        get("animals/form", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("animals", Animal.all());

            return new ModelAndView(model, "animals-form.hbs");

        }, new HandlebarsTemplateEngine());

        get("/animals/view", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
//            model.put("animals",EndangeredAnimal.getAllEndangered());
            model.put("animals", Animal.all());
            return new ModelAndView(model, "animals-view.hbs");
        }, new HandlebarsTemplateEngine());

        get("/endangered/form", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            List<String> age = new ArrayList<String>();
            age.add(EndangeredAnimal.ADULT_AGE);
            age.add(EndangeredAnimal.NEWBORN_AGE);
            age.add(EndangeredAnimal.YOUNG_AGE);

            List<String> health = new ArrayList<String>();
            health.add(EndangeredAnimal.ILL_HEALTH);
            health.add(EndangeredAnimal.OKAY_HEALTH);
            health.add(EndangeredAnimal.HEALTHY_HEALTH);

            model.put("health", health);
            model.put("age", age);

            return new ModelAndView(model, "endangered-form.hbs");

        }, new HandlebarsTemplateEngine());
        get("/animals/:id/delete", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int animalId = Integer.parseInt(request.params(":id"));
            Animal foundAnimal = Animal.find(animalId);

            foundAnimal.deleteById(animalId);
            model.put("animals", Animal.all());
            return new ModelAndView(model, "animals-view.hbs");
        }, new HandlebarsTemplateEngine());

        get("/animals/delete", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Animal.deleteAll();
            model.put("animals", Animal.all());
            return new ModelAndView(model, "animals-view.hbs");

        }, new HandlebarsTemplateEngine());

        //rangers routes
        post("/rangers/new", (request, response) -> {

            Map<String, Object> model = new HashMap<>();

            String name = request.queryParams("name");
            String badge_number=request.queryParams("badge_number");
            String phone_number=request.queryParams("phone_number");
            String email=request.queryParams("email");


            Ranger newRanger = new Ranger(name,badge_number,phone_number,email);
            newRanger.save();

            model.put("rangers", newRanger);
            return new ModelAndView(model, "rangers-form.hbs");
        }, new HandlebarsTemplateEngine());


//        2.READ

        get("/rangers/form",(request, response) -> {
            Map<String,Object> model=new HashMap<String, Object>();
            return new ModelAndView(model,"rangers-form.hbs");
        },new HandlebarsTemplateEngine());

        get("/rangers/view",(request, response) -> {
            Map<String,Object> model=new HashMap<String, Object>();
            model.put("rangers",Ranger.all());
            return new ModelAndView(model,"rangers-view.hbs");
        },new HandlebarsTemplateEngine());


        get("/rangers/sighting/:id",(request, response) -> {
            Map<String,Object> model=new HashMap<String, Object>();
            int rangerId=Integer.parseInt(request.params(":id"));

            model.put("rangerId",rangerId);
            model.put("sightings",Sighting.findRangerSighting(rangerId));
            return new ModelAndView(model,"rangerSightingView.hbs");
        },new HandlebarsTemplateEngine());


//        3.UPDATE
//        4.DELETE

        get("/rangers/:id/delete",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int rangerId=Integer.parseInt(request.params(":id"));
            Ranger foundRanger = Ranger.find(rangerId);

            foundRanger.deleteById(rangerId);
            model.put("rangers", Ranger.all());
            return new ModelAndView(model,"rangers-view.hbs");

        },new HandlebarsTemplateEngine());
        get("/rangers/delete",(request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Ranger.deleteAll();
            model.put("rangers",Ranger.all());
            return new ModelAndView(model,"rangers-view.hbs");

        },new HandlebarsTemplateEngine());

        //sighting views
        get("/sighting/:id/delete",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int sightingId=Integer.parseInt(request.params(":id"));
            Sighting foundSighting = Sighting.find(sightingId);

            foundSighting.deleteById(sightingId);
            model.put("sightings", Sighting.all());
            return new ModelAndView(model,"sighting-view.hbs");

        },new HandlebarsTemplateEngine());

        get("/sightings/delete",(request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Sighting.deleteAll();
            model.put("sightings",Sighting.all());
            return new ModelAndView(model,"sightings-view.hbs");

        },new HandlebarsTemplateEngine());
        post("/sighting/new", (request, response) -> {

            Map<String, Object> model = new HashMap<>();
            String animal_name= request.queryParams("name");
            String location_id= request.queryParams("location");
            int ranger_id= Integer.parseInt(request.queryParams("ranger"));


            Sighting newSighting = new Sighting(animal_name,location_id,ranger_id);
            newSighting.save();

            model.put("sighting", newSighting);
            return new ModelAndView(model, "sighting-form.hbs");
        }, new HandlebarsTemplateEngine());


//        2.READ

        get("sighting/form",(request, response) -> {
            Map<String,Object> model=new HashMap<String, Object>();
            model.put("ranger",Ranger.all());
            model.put("animal",Animal.all());
            return new ModelAndView(model,"sighting-form.hbs");
        },new HandlebarsTemplateEngine());


        get("sighting/view",(request, response) -> {
            Map<String,Object> model=new HashMap<String, Object>();

            model.put("sightings",Sighting.all());
            return new ModelAndView(model,"sighting-view.hbs");
        },new HandlebarsTemplateEngine());
        get("sighting/view/desc",(request, response) -> {
            Map<String,Object> model=new HashMap<String, Object>();

            model.put("sightings",Sighting.allDescOrder());
            return new ModelAndView(model,"sighting-view.hbs");
        },new HandlebarsTemplateEngine());


    }

}