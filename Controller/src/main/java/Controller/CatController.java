package Controller;

import Exceptions.MyException;
import Models.Cat;
import Services.CatService;

import java.util.List;

/**
 * Controller to interact with cats
 */
public class CatController {
    private CatService catService;

    public CatController(CatService catService) {
        this.catService = catService;
    }
    /**
     * Method to add a cat to the database
     * @param cat cat to be added
     */
    public void addCat(Cat cat) {
        if (cat.getName() == null || cat.getName().isEmpty()) {
            throw new MyException("Name cannot be empty");
        } else if (cat.getBreed() == null) {
            throw new MyException("Breed cannot be empty");
        } else if (cat.getOwner() == null) {
            throw new MyException("Owner cannot be empty");
        } else if (cat.getDateOfBirth() == null) {
            throw new MyException("Date of birth cannot be empty");
        }

        try {
            catService.addCat(cat);
        } catch (Exception exception) {
            throw exception;
        }
    }

    /**
     * Method to delete a cat from the database
     * @param catId id of cat to be deleted
     */
    public void deleteCat(Integer catId) {
        try {
            catService.deleteCat(catId);
        } catch (Exception exception) {
            throw exception;
        }
    }

    /**
     * Method to change the name of a cat
     * @param catId id of cat to be changed
     * @param newName new name of the cat
     */
    public void changeCatsName(Integer catId, String newName) {
        try {
            catService.changeCatsName(catId, newName);
        } catch (Exception exception) {
            throw exception;
        }
    }

    /**
     * Method to get a cat by its id
     * @param catId id of cat to be found
     * @return Cat with the given id
     */
    public Cat getCatById(Integer catId) {
        try {
            return catService.getCatById(catId);
        } catch (Exception exception) {
            throw exception;
        }
    }

    /**
     * Method to get the friends of a cat
     * @param catId id of cat to get friends of
     * @return List of friends of the cat
     */
    public List<Cat> getCatsFriends(Integer catId) {
        try {
            return catService.getCatsFriends(catId);
        } catch (Exception exception) {
            throw exception;
        }
    }

    /**
     * Method to make a new friendship between two cats
     * @param firstCatId id of the first cat
     * @param secondCatId id of the second cat
     */
    public void makeNewFriendship(Integer firstCatId, Integer secondCatId) {
        try {
            catService.makeNewFriendship(firstCatId, secondCatId);
        } catch (Exception exception) {
            throw exception;
        }
    }
}
