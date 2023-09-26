package uga.cs4370.mydb.impl;

import java.util.List;
import java.lang.IllegalArgumentException;
import uga.cs4370.mydb.*;
public class RelationBuilderImpl implements RelationBuilder{

    /**
     * Creates an empty relation with attribute names attrs and
     * attribute types types.
     * 
     * @throws IllegalArgumentException if attrs and types have different counts
     * or attrs have empty or non-alphanumeric attribute names.
     */	
	@Override
	public Relation newRelation(String name, List<String> attrs, List<Type> types)  {

		for (String str : attrs) {
			if (str.isEmpty() || !str.matches("[a-zA-Z0-9 ]*")) {
				throw new IllegalArgumentException("Invalid string detected in List: " + str);

			} // if
		} // for

		if(attrs.size() !=  types.size()) {
			throw new IllegalArgumentException("Attribute List must be the same length as Types List");
		} // if

		return new RelationImpl(name,attrs,types);
	} // newRelation

}
