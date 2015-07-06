package kickstarter.model.services;

import kickstarter.entities.Category;
import kickstarter.model.dao.CategoryDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(locations = {"classpath:application-context-test.xml"})
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
})
public class CategoryServiceTest {

    @Mock
    CategoryDAO categoryDAO;

    @InjectMocks
    CategoryService categoryService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testGetAllCategories() throws Exception {
        List<Category> categoriesList = new ArrayList<>();
        categoriesList.add(new Category(1, "name 1"));
        Mockito.when(categoryDAO.getAllCategories()).thenReturn(categoriesList);
        assertEquals(categoriesList, categoryService.getAllCategories());
    }

    @Test
    public void testGetById() throws Exception {
        Category category = new Category(1, "Name 1");
        Mockito.when(categoryDAO.selectById(1)).thenReturn(category);
        assertEquals(category, categoryService.getById(1));
    }
}