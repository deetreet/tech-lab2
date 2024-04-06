import Daos.CatDao;
import Daos.OwnerDao;
import Models.Cat;
import Models.Owner;
import Services.CatService;
import Services.OwnerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ServiceTest {
    @Mock
    private CatDao mockCatDao;
    @Mock
    private OwnerDao mockOwnerDao;
    @InjectMocks
    private CatService catService;
    @InjectMocks
    private OwnerService ownerService;

    private Cat Barsik = new Cat();
    private Owner Leha = new Owner();

    @Test
    public void tryToAddCatAndGetItById_ShouldReturnCat(){
        Mockito.doNothing().when(mockCatDao).saveCat(Barsik);
        when(mockCatDao.getCatById(1)).thenReturn(new Cat());

        catService.addCat(Barsik);
        Cat expectedBarsik = catService.getCatById(1);

        assert(expectedBarsik != null);
        assert(expectedBarsik instanceof Cat);
        Mockito.verify(mockCatDao, Mockito.times(1)).saveCat(Barsik);
        Mockito.verify(mockCatDao, Mockito.times(1)).getCatById(1);
    }

    @Test
    public void tryToChangeCatsName_ShouldChangeCatsName(){
        when(mockCatDao.getCatById(1)).thenReturn(Barsik);
        Mockito.doNothing().when(mockCatDao).updateCat(Barsik);

        catService.changeCatsName(1, "NoBarsik");

        Mockito.verify(mockCatDao, Mockito.times(1)).updateCat(Barsik);
    }

    @Test
    public void tryToDeleteCat_ShouldDeleteCat() {
        when(mockCatDao.getCatById(1)).thenReturn(Barsik);
        Mockito.doNothing().when(mockCatDao).deleteCat(Barsik);

        catService.deleteCat(1);

        Mockito.verify(mockCatDao, Mockito.times(1)).getCatById(1);
        Mockito.verify(mockCatDao, Mockito.times(1)).deleteCat(Barsik);
    }

    @Test
    public void tryToAddOwnerAndGetItById_ShouldReturnOwner(){
        Mockito.doNothing().when(mockOwnerDao).saveOwner(Leha);
        when(mockOwnerDao.getOwnerById(1)).thenReturn(Leha);

        ownerService.addOwner(Leha);
        Owner expectedLeha = ownerService.getOwnerById(1);

        assert(expectedLeha != null);
        assert(expectedLeha instanceof Owner);
        Mockito.verify(mockOwnerDao, Mockito.times(1)).saveOwner(Leha);
        Mockito.verify(mockOwnerDao, Mockito.times(1)).getOwnerById(1);
    }

    @Test
    public void tryToDeleteOwner_ShouldDeleteOwner() {
        when(mockOwnerDao.getOwnerById(1)).thenReturn(Leha);
        Mockito.doNothing().when(mockOwnerDao).deleteOwner(Leha);

        ownerService.deleteOwner(1);

        Mockito.verify(mockOwnerDao, Mockito.times(1)).getOwnerById(1);
    }
}
