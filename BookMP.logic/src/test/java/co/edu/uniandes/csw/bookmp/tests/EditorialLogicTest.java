package co.edu.uniandes.csw.bookmp.tests;

import co.edu.uniandes.csw.bookmp.ejbs.EditorialLogic;
import co.edu.uniandes.csw.bookmp.api.IEditorialLogic;
import co.edu.uniandes.csw.bookmp.converters.EditorialConverter;
import co.edu.uniandes.csw.bookmp.dtos.EditorialDTO;
import co.edu.uniandes.csw.bookmp.entities.EditorialEntity;
import co.edu.uniandes.csw.bookmp.persistence.EditorialPersistence;
import static co.edu.uniandes.csw.bookmp.tests._TestUtil.*;
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
public class EditorialLogicTest {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(EditorialEntity.class.getPackage())
                .addPackage(EditorialDTO.class.getPackage())
                .addPackage(EditorialConverter.class.getPackage())
                .addPackage(EditorialLogic.class.getPackage())
                .addPackage(IEditorialLogic.class.getPackage())
                .addPackage(EditorialPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private IEditorialLogic editorialLogic;

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
        em.createQuery("delete from EditorialEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<EditorialEntity> data = new ArrayList<EditorialEntity>();

    /**
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            EditorialEntity entity = new EditorialEntity();
        	entity.setName(generateRandom(String.class));
        	entity.setEmail(generateRandom(String.class));
        	entity.setPhone(generateRandom(String.class));
        	entity.setUserId(generateRandom(String.class));
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * @generated
     */
    @Test
    public void createEditorialTest() {
        EditorialDTO dto = new EditorialDTO();
        dto.setName(generateRandom(String.class));
        dto.setEmail(generateRandom(String.class));
        dto.setPhone(generateRandom(String.class));
        dto.setUserId(generateRandom(String.class));

        EditorialDTO result = editorialLogic.createEditorial(dto);

        Assert.assertNotNull(result);

        EditorialEntity entity = em.find(EditorialEntity.class, result.getId());

        Assert.assertEquals(dto.getName(), entity.getName());
        Assert.assertEquals(dto.getEmail(), entity.getEmail());
        Assert.assertEquals(dto.getPhone(), entity.getPhone());
        Assert.assertEquals(dto.getUserId(), entity.getUserId());
    }

    /**
     * @generated
     */
    @Test
    public void getEditorialsTest() {
        List<EditorialDTO> list = editorialLogic.getEditorials(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (EditorialDTO dto : list) {
            boolean found = false;
            for (EditorialEntity entity : data) {
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
    public void getEditorialTest() {
        EditorialEntity entity = data.get(0);
        EditorialDTO dto = editorialLogic.getEditorial(entity.getId());
        Assert.assertNotNull(dto);
        Assert.assertEquals(entity.getName(), dto.getName());
        Assert.assertEquals(entity.getEmail(), dto.getEmail());
        Assert.assertEquals(entity.getPhone(), dto.getPhone());
        Assert.assertEquals(entity.getUserId(), dto.getUserId());
    }

    /**
     * @generated
     */
    @Test
    public void deleteEditorialTest() {
        EditorialEntity entity = data.get(0);
        editorialLogic.deleteEditorial(entity.getId());
        EditorialEntity deleted = em.find(EditorialEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updateEditorialTest() {
        EditorialEntity entity = data.get(0);

        EditorialDTO dto = new EditorialDTO();

        dto.setId(entity.getId());
        dto.setName(generateRandom(String.class));
        dto.setEmail(generateRandom(String.class));
        dto.setPhone(generateRandom(String.class));
        dto.setUserId(generateRandom(String.class));

        editorialLogic.updateEditorial(dto);

        EditorialEntity resp = em.find(EditorialEntity.class, entity.getId());

        Assert.assertEquals(dto.getName(), resp.getName());
        Assert.assertEquals(dto.getEmail(), resp.getEmail());
        Assert.assertEquals(dto.getPhone(), resp.getPhone());
        Assert.assertEquals(dto.getUserId(), resp.getUserId());
    }

    /**
     * @generated
     */
    @Test
    public void getEditorialPaginationTest() {
        //Page 1
        List<EditorialDTO> dto1 = editorialLogic.getEditorials(1, 2);
        Assert.assertNotNull(dto1);
        Assert.assertEquals(2, dto1.size());
        //Page 2
        List<EditorialDTO> dto2 = editorialLogic.getEditorials(2, 2);
        Assert.assertNotNull(dto2);
        Assert.assertEquals(1, dto2.size());

        for (EditorialDTO dto : dto1) {
            boolean found = false;
            for (EditorialEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (EditorialDTO dto : dto2) {
            boolean found = false;
            for (EditorialEntity entity : data) {
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
        List<EditorialEntity> cache = new ArrayList<EditorialEntity>();
        List<EditorialDTO> list = editorialLogic.findByName(name);

        for (EditorialEntity entity : data) {
            if (entity.getName().equals(name)) {
                cache.add(entity);
            }
        }
        Assert.assertEquals(cache.size(), list.size());
        for (EditorialDTO dto : list) {
            boolean found = false;
            for (EditorialEntity cacheEntity : cache) {
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
