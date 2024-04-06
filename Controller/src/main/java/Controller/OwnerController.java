package Controller;

import Models.Owner;
import Services.OwnerService;


/*
Has methods:
- AddOwner
- DeleteOwner
- GetOwnerById
*/


/**
 * Controller to interact with owners
 */
public class OwnerController {
    private OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    /**
     * Method to add an owner to the database
     * @param owner owner to be added
     */
    public void addOwner(Owner owner) {
        try {
            ownerService.addOwner(owner);
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
            ownerService.deleteOwner(ownerId);
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
            return ownerService.getOwnerById(ownerId);
        } catch (Exception exception) {
            throw exception;
        }
    }
}
