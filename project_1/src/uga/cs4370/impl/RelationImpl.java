package uga.cs4370.impl;
import java.util.List;

import uga.cs4370.mydb.*;


public class RelationImpl implements Relation {
	
	
	String relation_name;
	List<String> relation_attrs;
	List<Type> relation_type;
	List<List<Cell>> relation_cells;
	
	public RelationImpl(String name, List <String> attrs, List<Type> types) {
		this.relation_name = name;
		this.relation_attrs = attrs;
		this.relation_type = types;
	} // RelationImpl

    /**
     * Returns the name of the relation.
     */
	@Override
	public String getName() {
		return this.relation_name;
	} // getName

    /**
     * Returns the row count of the relation.
     */	
	@Override
	public int getSize() {
		return this.relation_attrs.size();
	} // getSize

    /**
     * Get the rows of the relation.
     * Return a deep copy of the rows to avoid 
     * modifications to the rows by the callers of this method.
     */
	@Override
	public List<List<Cell>> getRows() {
		// TODO implement method
		return null;
	} // getRows

    /**
     * Return the type of each column in a list.
     */	
	@Override
	public List<Type> getTypes() {
		return this.relation_type;
	} // getTypes
	
    /**
     * Returns the list of attributes of the relation.
     */
	@Override
	public List<String> getAttrs() {
		return this.relation_attrs;
	} // getAttrs

    /**
     * Returns true only if attr exist in the relation.
     */
	@Override
	public boolean hasAttr(String attr) {
		for (String str : this.relation_attrs) {
			if (str == attr) return true;
		} // for
		return false;
	} // hasAttr

    /**
     * Returns the index of the attr.
     * 
     * @throws IllegalArgumentException if attr does not 
     * exist in the relation.
     */
	@Override
	public int getAttrIndex(String attr) {
		int index = 0;
		for (String str : this.relation_attrs) {
			if (str == attr) return index;
			index++;
		} // for
		throw new IllegalArgumentException("Attribute does not exist in this relation");
	} // getAttrIndex

    /**
     * Inserts a row in the relation.
     * 
     * @throws IllegalArgumentException if the cell types do not correspond 
     * to the attribute types of the relation or if the row already exists.
     */	
	@Override
	public void insert(Cell... cells) {
		// TODO Auto-generated method stub
		
		for(Cell cell_i : cells) {
			
		} // for
	} // insert

    /**
     * Inserts a row in the relation.
     * 
     * @throws IllegalArgumentException if the cell types do not correspond 
     * to the attribute types of the relation or if the row already exists.
     */	
	@Override
	public void insert(List<Cell> cells) {
		// TODO Auto-generated method stub
		int index = 0;
		for(Cell cell_i : cells) {
			if( relation_type.get(index) != cell_i.;
		} // for
	} // insert

    /**
     * Print the relation properly formatted as a table 
     * to the standard output.
     * The result should look similar to MySql table outputs.
     */	
	@Override
	public void print() {
		// TODO Auto-generated method stub
	}

} // RelationImpl
