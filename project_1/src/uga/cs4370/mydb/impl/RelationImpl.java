package uga.cs4370.mydb.impl;

import java.util.ArrayList;
import java.util.List;

import uga.cs4370.mydb.Cell;
import uga.cs4370.mydb.Relation;
import uga.cs4370.mydb.Type;


public class RelationImpl implements Relation {
	
	
	String relation_name;
	List<String> relation_attrs;
	List<Integer> relation_attrs_max_word_length;
	List<Type> relation_type;
	List<List<Cell>> relation_cells;
	
	public RelationImpl(String name, List <String> attrs, List<Type> types) {
		this.relation_name = name;
		this.relation_attrs = attrs;
		this.relation_type = types;
		this.relation_cells = new ArrayList<>();
		this.relation_attrs_max_word_length = new ArrayList<>();
		for(int i = 0 ; i < this.relation_attrs.size() ; i++ ) {
			this.relation_attrs_max_word_length.add(attrs.get(i).length());
		} // for

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
		//return this.relation_attrs.size();
		return this.getRows().size();
	} // getSize
	
    /**
     * Get the rows of the relation.
     * Return a deep copy of the rows to avoid 
     * modifications to the rows by the callers of this method.
     */
	@Override
	public List<List<Cell>> getRows() {
		List<List<Cell>> deep_copy = new ArrayList<>();
		for (List<Cell> row_i : this.relation_cells) {
			deep_copy.add(new ArrayList<>(row_i));
		} // for
		return deep_copy;
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
	
	/*
	 * NOTE THIS IS NOT ACCESSIBLE FROM THE RELATIONAL OBJECT, YOU CAN ONLY ACCESS IT HERE OR FROM A RELATIONALIMPL OBJECT
	 */
	public void setAttrs(List<String> new_attrs) {
		if(new_attrs.size() != this.relation_attrs.size()) {
			throw new IllegalArgumentException("attributes must be the same length in order to be replaced");
		}
		this.relation_attrs = new_attrs;
	} // setAttrs

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
	 * Checks if every value in a boolean array are true, if not returns false
	 * 
	 */
	private static boolean allTrue (boolean[] values) {
	    for (boolean value : values) {
	        if (!value)
	            return false;
	    }
	    return true;
	} // allTrue
	
    /**
     * Inserts a row in the relation.
     * 
     * @throws IllegalArgumentException if the cell types do not correspond 
     * to the attribute types of the relation or if the row already exists.
     */	
	@Override
	public void insert(Cell... cells) {
		List<Cell> cells_to_list = new ArrayList<>();
		
		for(int i = 0 ; i < cells.length && i < relation_attrs.size() ; i++) {
			try {
				if(this.relation_type.get(i) == Type.INTEGER) {
					cells[i].getAsInt();
				}
				if(this.relation_type.get(i) == Type.DOUBLE) {
					cells[i].getAsDouble();
				}
				if(this.relation_type.get(i) == Type.STRING) {
					cells[i].getAsString();
				}
			} catch(RuntimeException rte) {
				throw new IllegalArgumentException("The Cell type does not correspond with the attribute type of the relation");
			} // try
			
			if(cells[i].toString().length() > this.relation_attrs_max_word_length.get(i)) {
				this.relation_attrs_max_word_length.set(i, cells[i].toString().length());
			} // if
			cells_to_list.add(cells[i]);
		} // for
		boolean[] matches_another_row = new boolean[cells.length];
		for (List<Cell> row_i : relation_cells) {
			for(int i = 0 ; i < row_i.size() && i < cells.length ; i++) {
				if(row_i.get(i).equals(cells[i])) {
					matches_another_row[i] = true;
				} // if
			} // for
			if(allTrue(matches_another_row)){
				throw new IllegalArgumentException("This row of records matches another row completely. Please rechecks and resubmit.");
			} // if
			matches_another_row = new boolean[cells.length];
		} // for

		
		this.relation_cells.add(cells_to_list);
	} // insert

    /**
     * Inserts a row in the relation.
     * 
     * @throws IllegalArgumentException if the cell types do not correspond 
     * to the attribute types of the relation or if the row already exists.
     */	
	@Override
	public void insert(List<Cell> cells) {
		for(int i = 0 ; i < cells.size() && i < relation_attrs.size() ; i++) {
			try {
				if(this.relation_type.get(i) == Type.INTEGER) {
					cells.get(i).getAsInt();
				}
				if(this.relation_type.get(i) == Type.DOUBLE) {
					cells.get(i).getAsDouble();
				}
				if(this.relation_type.get(i) == Type.STRING) {
					cells.get(i).getAsString();
				}
			} catch(RuntimeException rte) {
				throw new IllegalArgumentException("The Cell type does not correspond with the attribute type of the relation");
			} // try
			if(cells.get(i).toString().length() > this.relation_attrs_max_word_length.get(i)) {
				this.relation_attrs_max_word_length.set(i, cells.get(i).toString().length());
			} // if
		} // for
		boolean[] matches_another_row = new boolean[cells.size()];
		for (List<Cell> row_i : relation_cells) {
			for(int i = 0 ; i < row_i.size() && i < cells.size() ; i++) {
				if(row_i.get(i).equals(cells.get(i))) {
					matches_another_row[i] = true;
				} // if
			} // for
			if(allTrue(matches_another_row)){
				throw new IllegalArgumentException("This row of records matches another row completely. Please rechecks and resubmit.");
			} // if
			matches_another_row = new boolean[cells.size()];
		} // for
		
		this.relation_cells.add(cells);
		
	} // insert

    /**
     * Print the relation properly formatted as a table 
     * to the standard output.
     * The result should look similar to MySql table outputs.
     */	
	@Override
	public void print() {

		System.out.print("+");
		for(Integer print_len : relation_attrs_max_word_length) {
			System.out.print("-".repeat(print_len) + "+");
		} // for
		System.out.print("\n|");
		for(int i = 0; i < relation_attrs_max_word_length.size() && i < relation_attrs.size(); i++) {
			int buffer_needed = relation_attrs_max_word_length.get(i) - relation_attrs.get(i).length();
			System.out.print(relation_attrs.get(i) + " ".repeat(buffer_needed) + "|");
		} // for
		System.out.print("\n+");		
		for(Integer print_len : relation_attrs_max_word_length) {
			System.out.print("-".repeat(print_len) + "+");
		} // for
		
		for (List<Cell> row_i : relation_cells) {
			System.out.print("\n|");
			for(int i = 0; i < row_i.size(); i++) {
				int buffer_needed = relation_attrs_max_word_length.get(i) - row_i.get(i).toString().length();
				System.out.print(row_i.get(i).toString() + " ".repeat(buffer_needed) + "|");
			} // for
		} // for
		System.out.print("\n+");
		for(Integer print_len : relation_attrs_max_word_length) {
			System.out.print("-".repeat(print_len) + "+");
		} // for
		System.out.print("\n");
		
	} // print
	


} // RelationImpl
