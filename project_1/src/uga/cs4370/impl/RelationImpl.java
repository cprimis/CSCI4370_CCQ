package uga.cs4370.impl;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import uga.cs4370.mydb.*;


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
		this.relation_attrs_max_word_length = IntStream.of(new int[attrs.size()])
												.boxed()
												.collect(Collectors.toList());
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
			/*
			for (List<Cell> row_i : relation_cells) {
				if(row_i.get(i).equals(cells[i])) {
					throw new IllegalArgumentException("The Cell type does not correspond with the attribute type of the relation");
				} // if
			}// for
			
			*/
			if(cells[i].toString().length() > this.relation_attrs_max_word_length.get(i)) {
				this.relation_attrs_max_word_length.set(i, cells[i].toString().length());
			} // if
			cells_to_list.add(cells[i]);
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
		// TODO Auto-generated method stub
		int index = 0;
		for(Cell cell_i : cells) {
			if( this.relation_type.get(index) == Type.INTEGER) {
				cell_i.getAsInt();
			}
			else if( this.relation_type.get(index) == Type.DOUBLE) {
				cell_i.getAsDouble();
			}
			else if( this.relation_type.get(index) == Type.STRING) {
				cell_i.getAsString();
			}
			if(cell_i.toString().length() > this.relation_attrs_max_word_length.get(index)) {
				this.relation_attrs_max_word_length.set(index, cell_i.toString().length());
			} // if

			index++;
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
		// TODO THIS CURRENTLY PRINTS BUT IT NEEDS TO PRINT LIKE A MYSQL TABLE
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
