package sql;


import sql.entity.Elevi;
import sql.service.ClasaService;
import sql.service.ElevService;

public class Hibernate {

    public static void main(String[] args) {
        ClasaService clasaService = new ClasaService();

        ElevService elevService = new ElevService();

        Elevi elev = elevService.findElevByName("Mircea");
        System.out.println(elev.toString());

    }
}
