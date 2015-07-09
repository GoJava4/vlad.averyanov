package kickstarter.model.services;

import kickstarter.entities.Category;
import kickstarter.model.dao.CategoryDAO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.LinkedList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class CategoryServiceTest {


    @Mock
    private CategoryDAO categoryDAO;

    @InjectMocks
    private CategoryService categoryService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllCategories() throws Exception {
        when(categoryDAO.getAllCategories()).thenReturn(new LinkedList<Category>());
        Assert.assertTrue(categoryService.getAllCategories().size() == 0);
    }

    @Test
    public void testGetById() throws Exception {
        Category category = new Category();
        when(categoryDAO.getById(1)).thenReturn(category);
        Assert.assertEquals(category, categoryService.getById(1));
    }
}