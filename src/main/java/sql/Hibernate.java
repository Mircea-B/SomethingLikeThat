package sql;


import sql.entity.Elevi;
import sql.service.ClasaService;
import sql.service.ElevService;

public class Hibernate {

    public static void main(String[] args) {
        ClasaService clasaService = new ClasaService();

        ElevService elevService = new ElevService();

        Elevi elev = elevService.findElevByName("Catalina");
        System.out.println(elev);
    }
}
