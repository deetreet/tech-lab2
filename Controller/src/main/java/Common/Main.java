package Common;

import Controller.CatController;
import Controller.OwnerController;
import Daos.CatDao;
import Daos.OwnerDao;
import Models.Cat;
import Models.Owner;
import Services.CatService;
import Services.OwnerService;
import Util.HibernateUtil;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Owner Leha = new Owner();
        Owner Sasha = new Owner();

        Cat Barsik = new Cat();
        Cat Murzik = new Cat();
        Cat Belka = new Cat();

        Barsik.setName("Barsik");
        Barsik.setBreed("British");
        Barsik.setOwner(Leha);
        Barsik.setColorId(CatColors.BLACK.ordinal());
        Barsik.setDateOfBirth(new Date());

        Murzik.setName("Murzik");
        Murzik.setBreed("British");
        Murzik.setOwner(Sasha);
        Murzik.setColorId(CatColors.WHITE.ordinal());
        Murzik.setDateOfBirth(new Date());

        Belka.setName("Belka");
        Belka.setBreed("British");
        Belka.setOwner(Sasha);
        Belka.setColorId(CatColors.GREY.ordinal());
        Belka.setDateOfBirth(new Date());

        Leha.setName("Leha");
        Leha.setDateOfBirth(new Date());
        Leha.setCats(new ArrayList<Cat>());
        Leha.getCats().add(Barsik);
        
        Sasha.setName("Sasha");
        Sasha.setDateOfBirth(new Date());
        Sasha.setCats(new ArrayList<Cat>());
        Sasha.getCats().add(Murzik);
        Sasha.getCats().add(Belka);
        
        // -------------------------

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        
        OwnerDao ownerDao = new OwnerDao(sessionFactory);
        OwnerService ownerService = new OwnerService(ownerDao);
        OwnerController ownerController = new OwnerController(ownerService);

        CatDao catDao = new CatDao(sessionFactory);
        CatService catService = new CatService(catDao);
        CatController catController = new CatController(catService);
        
        ownerController.addOwner(Leha);
        ownerController.addOwner(Sasha);
        
        catController.makeNewFriendship(Barsik.getCatId(), Murzik.getCatId());
        catController.makeNewFriendship(Barsik.getCatId(), Belka.getCatId());
        catController.makeNewFriendship(Murzik.getCatId(), Belka.getCatId());

        ownerController.deleteOwner(Leha.getOwnerId());
        ownerController.deleteOwner(Sasha.getOwnerId());
    }
}