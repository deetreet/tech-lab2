import Daos.CatDao;
import Daos.OwnerDao;
import Models.Cat;
import Models.Owner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DaoTest {
    @Mock
    private SessionFactory mockSessionFactory;
    @Mock
    private Session mockSession;
    @Mock
    private Transaction mockTransaction;
    @InjectMocks
    private CatDao catDao;
    @InjectMocks
    private OwnerDao ownerDao;

    private Cat Barsik = new Cat();
    private Owner Leha = new Owner();

    @Test
    public void tryToAddCatAndGetItById_ShouldReturnCat(){
        when(mockSessionFactory.openSession()).thenReturn(mockSession);
        when(mockSession.beginTransaction()).thenReturn(mockTransaction);
        when(mockSessionFactory.openSession()).thenReturn(mockSession);
        when(mockSession.beginTransaction()).thenReturn(mockTransaction);
        when(mockSession.beginTransaction()).thenReturn(mockTransaction);
        when(mockSession.get(Cat.class, 1)).thenReturn(new Cat());

        catDao.saveCat(Barsik);
        Cat expectedBarsik = catDao.getCatById(1);

        assert(expectedBarsik != null);
        assertTrue(expectedBarsik instanceof Cat);
        verify(mockSession, Mockito.times(1)).beginTransaction();
        verify(mockSession, Mockito.times(1)).save(Barsik);
        verify(mockTransaction, Mockito.times(1)).commit();
    }

    @Test
    public void tryToUpdateCat_ShouldUpdateCat(){
        when(mockSessionFactory.openSession()).thenReturn(mockSession);
        when(mockSession.beginTransaction()).thenReturn(mockTransaction);
        when(mockSession.beginTransaction()).thenReturn(mockTransaction);

        catDao.updateCat(Barsik);

        verify(mockSession, Mockito.times(1)).beginTransaction();
        verify(mockSession, Mockito.times(1)).update(Barsik);
        verify(mockTransaction, Mockito.times(1)).commit();
    }

    @Test
    public void tryToDeleteCat_ShouldDeleteCat(){
        when(mockSessionFactory.openSession()).thenReturn(mockSession);
        when(mockSession.beginTransaction()).thenReturn(mockTransaction);
        when(mockSession.beginTransaction()).thenReturn(mockTransaction);

        catDao.deleteCat(Barsik);

        verify(mockSession, Mockito.times(1)).beginTransaction();
        verify(mockSession, Mockito.times(1)).delete(Barsik);
        verify(mockTransaction, Mockito.times(1)).commit();
    }

    @Test
    public void tryToAddOwnerAndGetItById_ShouldReturnOwner(){
        when(mockSessionFactory.openSession()).thenReturn(mockSession);
        when(mockSession.beginTransaction()).thenReturn(mockTransaction);
        when(mockSession.beginTransaction()).thenReturn(mockTransaction);
        when(mockSession.get(Owner.class, 1)).thenReturn(new Owner());

        ownerDao.saveOwner(Leha);
        Owner expectedLeha = ownerDao.getOwnerById(1);

        assert(expectedLeha != null);
        assertTrue(expectedLeha instanceof Owner);
        verify(mockSession, Mockito.times(1)).beginTransaction();
        verify(mockSession, Mockito.times(1)).save(Leha);
        verify(mockTransaction, Mockito.times(1)).commit();
    }

    @Test
    public void tryToDeleteOwner_ShouldDeleteOwner(){
        when(mockSessionFactory.openSession()).thenReturn(mockSession);
        when(mockSession.beginTransaction()).thenReturn(mockTransaction);
        when(mockSession.beginTransaction()).thenReturn(mockTransaction);

        ownerDao.deleteOwner(Leha);

        verify(mockSession, Mockito.times(1)).beginTransaction();
        verify(mockSession, Mockito.times(1)).delete(Leha);
        verify(mockTransaction, Mockito.times(1)).commit();
    }
}