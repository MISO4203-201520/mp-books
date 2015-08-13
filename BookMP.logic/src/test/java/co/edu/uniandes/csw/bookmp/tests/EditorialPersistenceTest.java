package co.edu.uniandes.csw.bookmp.tests;

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
public class EditorialPersistenceTest {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(EditorialEntity.class.getPackage())
                .addPackage(EditorialPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private EditorialPersistence editorialPersistence;

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
        EditorialEntity newEntity = new EditorialEntity();
        newEntity.setName(generateRandom(String.class));
        newEntity.setEmail(generateRandom(String.class));
        newEntity.setPhone(generateRandom(String.class));
        newEntity.setUserId(generateRandom(String.class));

        EditorialEntity result = editorialPersistence.create(newEntity);

        Assert.assertNotNull(result);

        EditorialEntity entity = em.find(EditorialEntity.class, result.getId());

        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getEmail(), entity.getEmail());
        Assert.assertEquals(newEntity.getPhone(), entity.getPhone());
        Assert.assertEquals(newEntity.getUserId(), entity.getUserId());
    }

    /**
     * @generated
     */
    @Test
    public void getEditorialsTest() {
        List<EditorialEntity> list = editorialPersistence.findAll(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (EditorialEntity ent : list) {
            boolean found = false;
            for (EditorialEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
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
        EditorialEntity newEntity = editorialPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
        Assert.assertEquals(entity.getEmail(), newEntity.getEmail());
        Assert.assertEquals(entity.getPhone(), newEntity.getPhone());
        Assert.assertEquals(entity.getUserId(), newEntity.getUserId());
    }

    /**
     * @generated
     */
    @Test
    public void deleteEditorialTest() {
        EditorialEntity entity = data.get(0);
        editorialPersistence.delete(entity.getId());
        EditorialEntity deleted = em.find(EditorialEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updateEditorialTest() {
        EditorialEntity entity = data.get(0);

        EditorialEntity newEntity = new EditorialEntity();

        newEntity.setId(entity.getId());
        newEntity.setName(generateRandom(String.class));
        newEntity.setEmail(generateRandom(String.class));
        newEntity.setPhone(generateRandom(String.class));
        newEntity.setUserId(generateRandom(String.class));

        editorialPersistence.update(newEntity);

        EditorialEntity resp = em.find(EditorialEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
        Assert.assertEquals(newEntity.getEmail(), resp.getEmail());
        Assert.assertEquals(newEntity.getPhone(), resp.getPhone());
        Assert.assertEquals(newEntity.getUserId(), resp.getUserId());
    }

    /**
     * @generated
     */
    @Test
    public void getEditorialPaginationTest() {
        //Page 1
        List<EditorialEntity> ent1 = editorialPersistence.findAll(1, 2);
        Assert.assertNotNull(ent1);
        Assert.assertEquals(2, ent1.size());
        //Page 2
        List<EditorialEntity> ent2 = editorialPersistence.findAll(2, 2);
        Assert.assertNotNull(ent2);
        Assert.assertEquals(1, ent2.size());

        for (EditorialEntity ent : ent1) {
            boolean found = false;
            for (EditorialEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (EditorialEntity ent : ent2) {
            boolean found = false;
            for (EditorialEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
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
        List<EditorialEntity> list = editorialPersistence.findByName(name);

        for (EditorialEntity entity : data) {
            if (entity.getName().equals(name)) {
                cache.add(entity);
            }
        }
        Assert.assertEquals(list.size(), cache.size());
        for (EditorialEntity ent : list) {
            boolean found = false;
            for (EditorialEntity cacheEntity : cache) {
                if (cacheEntity.getName().equals(ent.getName())) {
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
