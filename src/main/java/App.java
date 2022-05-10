import static spark.Spark.*;
import java.util.HashMap;

import models.Animals;
import models.Endangered;
import models.Location;
import models.Ranger;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.ModelAndView;
import java.util.Map;

import spark.ModelAndView;

public class App {
    public static void main(String[] args) {
      staticFileLocation("/public");

      get("/", (request,respond)->{
          Map<String, Object>model=new HashMap<>();
          return new ModelAndView(model,"index.hbs");
      },  new HandlebarsTemplateEngine());

      //animals
      get("/animals", (request,respond)->{
          Map<Object, Object>model=new HashMap<>();
          model.put("animals", Animals.all());
          return new ModelAndView(model, "animals.hbs");
      },  new HandlebarsTemplateEngine());

      post("/animals/new", (request,respond)->{
          Map<String, Object>model=new HashMap<>();
          String name=request.queryParams("name");
          String category=request.queryParams("category");
          String health=request.queryParams("health");
          String age=request.queryParams("age");

          if(request.queryParams("animals")!=null){
              if(!(name.trim().isEmpty() || category.trim().isEmpty() || health.trim().isEmpty() || age.trim().isEmpty())){
                Endangered endangereds=new Endangered(name,category,health,age);
                  endangereds.save();
              }else{System.out.println("Please fill all fields ");}
          }else
              if(!(name.trim().isEmpty())){
                  Animals animals = new Animals(name,category, health, age);
                  animals.save();
              }else{System.out.println("Please fill all fields ");

              }

          respond.redirect("/animals");
          return null;
      }, new HandlebarsTemplateEngine());

      // get location
        get("/location", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("location", Location.all());
            return new ModelAndView(model, "location.hbs");
        }, new HandlebarsTemplateEngine());

        // post location
        post("/location", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            String locationName = req.queryParams("name");

            if (!(locationName.trim().isEmpty())) {

                Location location = new Location(locationName);
                location.save();
            }
            res.redirect("/location");
            return null;
        },new HandlebarsTemplateEngine());

        //get rangers
        get("/rangers", (request,respond)->{
            Map<String, Object>model=new HashMap<>();
            model.put("ranger",Ranger.all());
            return new ModelAndView(model,"rangers.hbs");
        },  new HandlebarsTemplateEngine());

        //post rangers

        post("/ranger", (request,respond)->{
            Map<String,Object>model=new HashMap<>();
            String ranger_name=request.queryParams("ranger_name");
            String ranger_badge=request.queryParams("ranger_badge");
            String ranger_number=request.queryParams("ranger_number");

            Ranger ranger=new Ranger(ranger_name,ranger_badge,ranger_number);
            ranger.save();

            respond.redirect("/rangers");
            return null;

        }, new HandlebarsTemplateEngine());



    }
}
