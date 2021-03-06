package co.edu.uniandes.csw.marketplace.tests;

import co.edu.uniandes.csw.marketplace.ejbs.BookLogic;
import co.edu.uniandes.csw.marketplace.api.IBookLogic;
import co.edu.uniandes.csw.marketplace.converters.BookConverter;
import co.edu.uniandes.csw.marketplace.dtos.BookDTO;
import co.edu.uniandes.csw.marketplace.entities.BookEntity;
import co.edu.uniandes.csw.marketplace.persistence.BookPersistence;
import static co.edu.uniandes.csw.marketplace.tests._TestUtil.*;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.junit.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class BookLogicTest {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(BookEntity.class.getPackage())
                .addPackage(BookDTO.class.getPackage())
                .addPackage(BookConverter.class.getPackage())
                .addPackage(BookLogic.class.getPackage())
                .addPackage(IBookLogic.class.getPackage())
                .addPackage(BookPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private IBookLogic bookLogic;

    /**
     * @generated
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * @generated
     */
    @Inject
    UserTransaction utx;

    /**
     * @generated
     */
    @Before
    public void configTest() {
        try {
            utx.begin();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * @generated
     */
    private void clearData() {
        em.createQuery("delete from BookEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<BookEntity> data = new ArrayList<BookEntity>();

    /**
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            BookEntity entity = new BookEntity();
        	entity.setName(generateRandom(String.class));
        	entity.setDescription(generateRandom(String.class));
        	entity.setImage(generateRandom(String.class));
        	entity.setIsbn(generateRandom(String.class));
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * @generated
     */
    @Test
    public void createBookTest() {
        BookDTO dto = new BookDTO();
        dto.setName(generateRandom(String.class));
        dto.setDescription(generateRandom(String.class));
        dto.setImage(generateRandom(String.class));
        dto.setIsbn(generateRandom(String.class));

        BookDTO result = bookLogic.createBook(dto);

        Assert.assertNotNull(result);

        BookEntity entity = em.find(BookEntity.class, result.getId());

        Assert.assertEquals(dto.getName(), entity.getName());
        Assert.assertEquals(dto.getDescription(), entity.getDescription());
        Assert.assertEquals(dto.getImage(), entity.getImage());
        Assert.assertEquals(dto.getIsbn(), entity.getIsbn());
    }

    /**
     * @generated
     */
    @Test
    public void getBooksTest() {
        List<BookDTO> list = bookLogic.getBooks(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (BookDTO dto : list) {
            boolean found = false;
            for (BookEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * @generated
     */
    @Test
    public void getBookTest() {
        BookEntity entity = data.get(0);
        BookDTO dto = bookLogic.getBook(entity.getId());
        Assert.assertNotNull(dto);
        Assert.assertEquals(entity.getName(), dto.getName());
        Assert.assertEquals(entity.getDescription(), dto.getDescription());
        Assert.assertEquals(entity.getImage(), dto.getImage());
        Assert.assertEquals(entity.getIsbn(), dto.getIsbn());
    }

    /**
     * @generated
     */
    @Test
    public void deleteBookTest() {
        BookEntity entity = data.get(0);
        bookLogic.deleteBook(entity.getId());
        BookEntity deleted = em.find(BookEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updateBookTest() {
        BookEntity entity = data.get(0);

        BookDTO dto = new BookDTO();

        dto.setId(entity.getId());
        dto.setName(generateRandom(String.class));
        dto.setDescription(generateRandom(String.class));
        dto.setImage(generateRandom(String.class));
        dto.setIsbn(generateRandom(String.class));

        bookLogic.updateBook(dto);

        BookEntity resp = em.find(BookEntity.class, entity.getId());

        Assert.assertEquals(dto.getName(), resp.getName());
        Assert.assertEquals(dto.getDescription(), resp.getDescription());
        Assert.assertEquals(dto.getImage(), resp.getImage());
        Assert.assertEquals(dto.getIsbn(), resp.getIsbn());
    }

    /**
     * @generated
     */
    @Test
    public void getBookPaginationTest() {
        //Page 1
        List<BookDTO> dto1 = bookLogic.getBooks(1, 2);
        Assert.assertNotNull(dto1);
        Assert.assertEquals(2, dto1.size());
        //Page 2
        List<BookDTO> dto2 = bookLogic.getBooks(2, 2);
        Assert.assertNotNull(dto2);
        Assert.assertEquals(1, dto2.size());

        for (BookDTO dto : dto1) {
            boolean found = false;
            for (BookEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (BookDTO dto : dto2) {
            boolean found = false;
            for (BookEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * @generated
     */
    @Test
    public void findByName() {
        String name = data.get(0).getName();
        List<BookEntity> cache = new ArrayList<BookEntity>();
        List<BookDTO> list = bookLogic.findByName(name);

        for (BookEntity entity : data) {
            if (entity.getName().equals(name)) {
                cache.add(entity);
            }
        }
        Assert.assertEquals(cache.size(), list.size());
        for (BookDTO dto : list) {
            boolean found = false;
            for (BookEntity cacheEntity : cache) {
                if (cacheEntity.getName().equals(dto.getName())) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                Assert.fail();
            }
        }
    }
}
