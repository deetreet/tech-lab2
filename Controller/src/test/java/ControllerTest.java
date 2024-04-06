import Controller.CatController;
import Controller.OwnerController;
import Models.Cat;
import Models.Owner;
import Services.CatService;
import Services.OwnerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {
    @Mock
    private CatService mockCatService;
    @Mock
    private OwnerService mockOwnerService;

    @InjectMocks
    private CatController catController;
    @InjectMocks
    private OwnerController ownerController;

    private Cat Barsik = new Cat();
    private Owner Leha = new Owner();

    @Before
    public void setUp() {
        Barsik.setName("Barsik");
        Barsik.setBreed("British");
        Barsik.setOwner(Leha);
        Barsik.setDateOfBirth(new Date());
        List<Cat> cats = new ArrayList<Cat>() {{
            add(Barsik);
        }};

        Leha.setName("Leha");
        Leha.setDateOfBirth(new Date());
        Leha.setCats(cats);
    }

    @Test
    public void tryToAddCatAndGetItById_ShouldReturnCat(){
        Mockito.doNothing().when(mockCatService).addCat(Barsik);
        Mockito.when(mockCatService.getCatById(1)).thenReturn(Barsik);

        catController.addCat(Barsik);
        Cat expectedBarsik = catController.getCatById(1);

        assert(expectedBarsik != null);
        assertTrue(expectedBarsik.getName() == "Barsik"
                && expectedBarsik.getBreed() == "British"
                && expectedBarsik.getOwner() == Leha
                && expectedBarsik.getDateOfBirth() == Barsik.getDateOfBirth());
        Mockito.verify(mockCatService, Mockito.times(1)).addCat(Barsik);
    }

    @Test
    public void tryToChangeCatsName_ShouldChangeCatsName(){
        Mockito.doNothing().when(mockCatService).changeCatsName(1, "NoBarsik");

        catController.changeCatsName(1, "NoBarsik");

        Mockito.verify(mockCatService, Mockito.times(1)).changeCatsName(1, "NoBarsik");
    }

    @Test
    public void tryToDeleteCat_ShouldDeleteCat() {
        Mockito.doNothing().when(mockCatService).deleteCat(1);

        catController.deleteCat(1);

        Mockito.verify(mockCatService, Mockito.times(1)).deleteCat(1);
    }

    @Test
    public void tryToAddOwnerAndGetItById_ShouldReturnOwner() {
        Mockito.doNothing().when(mockOwnerService).addOwner(Leha);
        Mockito.when(mockOwnerService.getOwnerById(1)).thenReturn(Leha);

        ownerController.addOwner(Leha);
        Owner expectedLeha = ownerController.getOwnerById(1);

        assert (expectedLeha != null);
        assertTrue(expectedLeha.getName() == "Leha"
                && expectedLeha.getDateOfBirth() == Leha.getDateOfBirth()
                && expectedLeha.getCats() == Leha.getCats());
        Mockito.verify(mockOwnerService, Mockito.times(1)).addOwner(Leha);
    }

    @Test
    public void tryToDeleteOwner_ShouldDeleteOwner() {
        Mockito.doNothing().when(mockOwnerService).deleteOwner(1);

        ownerController.deleteOwner(1);

        Mockito.verify(mockOwnerService, Mockito.times(1)).deleteOwner(1);
    }
}
