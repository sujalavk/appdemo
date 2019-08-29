package com.niit.Dao;

import java.util.List;

import com.niit.Model.Category;

public interface CategoryDao {
	// get all categories

		public List<Category>listCategories();

		// create category

		public boolean insertCategory(Category category);

		// update category

		public boolean updateCategory(Category category);

		// delete category by id

		public boolean deleteCategory(String id);

		// delete category by category

		public boolean deleteCategory(Category category);

		// get category by id

		public Category getCategoryByID(String id);

		// get category by name
		public Category getCategoryByName(String name);

	}


