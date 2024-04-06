package Services;

import Daos.OwnerDao;
import Exceptions.MyException;
import Models.Owner;

/**
 * Class realizing the service to interact with owner entities
 */
public class OwnerService {
    private OwnerDao ownerDao;

    public OwnerService(OwnerDao ownerDao) {
        if (ownerDao == null) {
            throw new MyException("OwnerDao cannot be null");
        }

        this.ownerDao = ownerDao;
    }

    /**
     * Method to add an owner to the database
     * @param owner owner to be added
     */
    public void addOwner(Owner owner) {
        try {
            ownerDao.saveOwner(owner);
        } catch (Exception exception) {
            throw exception;
        }
    }

    /**
     * Method to delete an owner from the database
     * @param ownerId id of owner to be deleted
     */
    public void deleteOwner(Integer ownerId) {
        try {
            Owner owner = ownerDao.getOwnerById(ownerId);
            ownerDao.deleteOwner(owner);
        } catch (Exception exception) {
            throw exception;
        }
    }

    /**
     * Method to get an owner by its id
     * @param ownerId id of owner to be found
     * @return Owner with the given id
     */
    public Owner getOwnerById(Integer ownerId) {
        try {
            return ownerDao.getOwnerById(ownerId);
        } catch (Exception exception) {
            throw exception;
        }
    }
}
