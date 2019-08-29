package com.niit.Dao;

import java.util.List;

import com.niit.Model.Supplier;

public interface SupplierDao {

public Supplier getSupplier(String string);
	public List<Supplier> listSupplier();
	public boolean insertSupp(Supplier sup);
	public boolean	updateSupp(Supplier sup);
	public boolean deleteSupp(Supplier sup);
	public Supplier getSupplierByName(String name);
}
