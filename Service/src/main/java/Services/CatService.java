package Services;

import Daos.CatDao;
import Exceptions.MyException;
import Models.Cat;

import java.util.List;

/**
 * Class realizing the service to interact with cat entities
 */
public class CatService {
    private CatDao catDao;
    
    public CatService(CatDao catDao) {
        if (catDao == null) {
            throw new MyException("CatDao cannot be null");
        }
        
        this.catDao = catDao;
    }
    /**
     * Method to add a cat to the database
     * @param cat cat to be added
     */
    public void addCat(Cat cat) {
        try{
            catDao.saveCat(cat);
        } catch (Exception exception) {
            throw exception;
        }
    }

    /**
     * Method to delete a cat from the database
     * @param catId id of cat to be deleted
     */
    public void deleteCat(Integer catId) {
        try{
            Cat cat = catDao.getCatById(catId);
            catDao.deleteCat(cat);
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
        try{
            if (newName == null || newName.isEmpty()) {
                throw new MyException("New name cannot be empty");
            }
            Cat cat = catDao.getCatById(catId);
            cat.setName(newName);
            catDao.updateCat(cat);
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
        try{
            return catDao.getCatById(catId);
        } catch (Exception exception) {
            throw exception;
        }
    }

    /**
     * Method to get all friends of a cat
     * @param catId id of cat whose friends are to be found
     * @return List of friends of the cat
     */
    public List<Cat> getCatsFriends(Integer catId) {
        try {
            List<Cat> cats = catDao.getCatsFriends(catId);
            return cats;
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
            catDao.makeNewFriendship(firstCatId, secondCatId);
        } catch (Exception exception) {
            throw exception;
        }
    }
}
