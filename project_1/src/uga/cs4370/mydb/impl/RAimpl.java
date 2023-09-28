package uga.cs4370.mydb.impl;

import java.util.List;
import java.util.ArrayList;

import uga.cs4370.mydb.*;

public class RAimpl implements RA {

    /**
     * Performs the select operation on the relation rel
     * by applying the predicate p.
     * 
     * @return The resulting relation after applying the select operation.
     */
    @Override
    public Relation select(Relation rel, Predicate p) {
        RelationBuilder rb = new RelationBuilderImpl();

        Relation relNew = rb.newRelation(rel.getName(), rel.getAttrs(), rel.getTypes());

        for (List<Cell> row : rel.getRows()) {
            if (p.check(row)) {
                relNew.insert(row);
            }
        }
        return relNew;
    }

    /**
     * Performs the project operation on the relation rel
     * given the attributes list attrs.
     * 
     * @return The resulting relation after applying the project operation.
     * 
     * @throws IllegalArgumentException If attributes in attrs are not 
     * present in rel.
     */
    @Override
    public Relation project(Relation rel, List<String> attrs) {
        RelationBuilder rb = new RelationBuilderImpl();
        
        // check if attrs are in rel and get indices
        int colIndex[] = new int[attrs.size()];
        try {
            for (int i = 0; i < attrs.size(); i++) {
                colIndex[i] = rel.getAttrIndex(attrs.get(i)); // check if this gets thrown
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Attribute does not exist in this relation");
        }
        
        // get types of attrs        
        List<Type> types = new ArrayList<Type>();    
        for (int i = 0; i < colIndex.length; i++) {
            types.add(rel.getTypes().get(colIndex[i]));  
        }
        
        Relation relNew = rb.newRelation(rel.getName(), 
                attrs,  
                types);
        
        // add rows
        for (int i = 0; i < rel.getSize(); i++) {
            List<Cell> row = new ArrayList<Cell>();    
            
            for (int j = 0; j < colIndex.length; j++) {
                row.add(rel.getRows().get(i).get(colIndex[j]));
            }
            
            try {
                relNew.insert(row);
            } catch (IllegalArgumentException e) {
                
            }
        }
        
        return relNew;
    }

    /**
     * Performs the union operation on the relations rel1 and rel2.
     * 
     * @return The resulting relation after applying the union operation.
     * 
     * @throws IllegalArgumentException If rel1 and rel2 are not compatible.
     */
    @Override
    public Relation union(Relation rel1, Relation rel2) {
        if (!rel1.getAttrs().equals(rel2.getAttrs()) | !rel1.getTypes().equals(rel2.getTypes())) {
            throw new IllegalArgumentException("The relations are not compatible");
        }
        
        RelationBuilder rb = new RelationBuilderImpl();
        Relation relNew = rb.newRelation(rel1.getName(), 
                rel1.getAttrs(),  
                rel1.getTypes());
        
        // add rows from rel1
        for (int i = 0; i < rel1.getSize(); i++) {
            relNew.insert(rel1.getRows().get(i));
        }
        
        // add rows from re2
        for (int i = 0; i < rel2.getSize(); i++) {
            if (!relNew.getRows().contains(rel2.getRows().get(i))) {
                relNew.insert(rel2.getRows().get(i));
            }
        }
        
        return relNew;
    }

    /**
     * Performs the set difference operation on the relations rel1 and rel2.
     * 
     * @return The resulting relation after applying the set difference operation.
     * 
     * @throws IllegalArgumentException If rel1 and rel2 are not compatible.
     */
    @Override
    public Relation diff(Relation rel1, Relation rel2) {
        if (!rel1.getAttrs().equals(rel2.getAttrs()) | !rel1.getTypes().equals(rel2.getTypes())) {
            throw new IllegalArgumentException("The relations are not compatible");
        }
        
        RelationBuilder rb = new RelationBuilderImpl();
        Relation relNew = rb.newRelation(rel1.getName(), 
                rel1.getAttrs(),  
                rel1.getTypes());
        
        for (int i = 0; i < rel1.getSize(); i++) {
            if (!rel2.getRows().contains(rel1.getRows().get(i))) {
                relNew.insert(rel1.getRows().get(i));
            }
        }
        
        return relNew;
    }

    /**
     * Renames the attributes in origAttr of relation rel to corresponding 
     * names in renamedAttr.
     * 
     * @return The resulting relation after renaming the attributes.
     * 
     * @throws IllegalArgumentException If attributes in origAttr are not present in 
     * rel or origAttr and renamedAttr do not have matching argument counts.
     */
    @Override
    public Relation rename(Relation rel, List<String> origAttr, List<String> renamedAttr) {
        // TODO Auto-generated method stub
        List<String> attrs = rel.getAttrs();
        
        if (origAttr.size() != renamedAttr.size()) {
            throw new IllegalArgumentException("Argument counts do not match");
        }
        
        for (int i = 0; i < origAttr.size(); i++) {
            try {
                attrs.set(attrs.indexOf(origAttr.get(i)), renamedAttr.get(i));
            } catch (Exception e) {
                throw new IllegalArgumentException("Attribute does not exist in this relation");
            }
        }
        
        RelationBuilder rb = new RelationBuilderImpl();
        Relation relNew = rb.newRelation(rel.getName(), 
                attrs,  
                rel.getTypes());
        
        List<List<Cell>> cells = rel.getRows();
        // add rows
        for (int i = 0; i < rel.getSize(); i++) {
            relNew.insert(cells.get(i));
        }
        
        return relNew;
    }

    /**
     * Performs cartisian product on relations rel1 and rel2.
     * 
     * @return The resulting relation after applying cartisian product.
     * 
     * @throws IllegalArgumentException if rel1 and rel2 have common attibutes.
     */
    public Relation cartesianProduct(Relation rel1, Relation rel2) {
        for (int i = 0; i < rel1.getAttrs().size(); i++) {
            if (rel2.hasAttr(rel1.getAttrs().get(i))) {
                throw new IllegalArgumentException("Relations have common attributes");
            }
        }
        
        String name = rel1.getName() + " x " +rel2.getName();
        List<String> attrs = new ArrayList<String>();
        List<Type> types = new ArrayList<Type>();
        attrs.addAll(rel1.getAttrs());
        attrs.addAll(rel2.getAttrs());
        types.addAll(rel1.getTypes());
        types.addAll(rel2.getTypes());
        
        RelationBuilder rb = new RelationBuilderImpl();
        Relation relNew = rb.newRelation(name, 
                attrs,  
                types);
        
        for (int i = 0; i < rel1.getSize(); i++) {
            for (int j = 0; j < rel2.getSize(); j++) {
                List<Cell> row = new ArrayList<Cell>();
                
                row.addAll(rel1.getRows().get(i));
                row.addAll(rel2.getRows().get(j)); 
                
                relNew.insert(row);
            }
        }
        
        return relNew;
    }

    /**
     * Performs natural join on relations rel1 and rel2.
     * 
     * @return The resulting relation after applying natural join.
     */
    @Override
    public Relation join(Relation rel1, Relation rel2) {
        // Get common attrs between rel1 and rel2
        List<String> comAttrs = new ArrayList<String>();
        List<Integer> rel1Index = new ArrayList<Integer>();
        List<Integer> rel2Index = new ArrayList<Integer>();
        for (int i = 0; i < rel1.getAttrs().size(); i++) {
            if (rel2.hasAttr(rel1.getAttrs().get(i))) {
                comAttrs.add(rel1.getAttrs().get(i));
                rel1Index.add(i);
                rel2Index.add(rel2.getAttrIndex(rel1.getAttrs().get(i)));
            }
        }
        
        if (comAttrs.size() == 0) {
            throw new IllegalArgumentException("No common attributes");
        }
        
        List<String> notComAttrs = new ArrayList<String>();
        for (int i = 0; i < rel2.getAttrs().size(); i++) {
            if (!comAttrs.contains(rel2.getAttrs().get(i))) {
                notComAttrs.add(rel2.getAttrs().get(i));
            }
        }

        // Concat attrs and types
        String name = rel1.getName() + " join " +rel2.getName();
        List<String> attrs = new ArrayList<String>(); 
        List<Type> types = new ArrayList<Type>(); 
        attrs.addAll(rel1.getAttrs());
        types.addAll(rel1.getTypes());
        
        for (int i = 0; i < rel2.getAttrs().size(); i++) {
            if (!attrs.contains(rel2.getAttrs().get(i))) {
                attrs.add(rel2.getAttrs().get(i));
                types.add(rel2.getTypes().get(i));
            }
        }
        
        RelationBuilder rb = new RelationBuilderImpl();
        Relation relNew = rb.newRelation(name, attrs, types);
        
        // compare rel2 to rel1
        for (int i = 0; i < rel1.getSize(); i++) {
            for (int j = 0; j < rel2.getSize(); j++) {
                List<Cell> row1 = new ArrayList<Cell>();
                for (int k = 0; k < rel1Index.size(); k++) {
                    row1.add(rel1.getRows().get(i).get(rel1Index.get(k)));
                }
                List<Cell> row2 = new ArrayList<Cell>();
                for (int k = 0; k < rel2Index.size(); k++) {
                    row2.add(rel2.getRows().get(j).get(rel2Index.get(k)));
                }
                
                if (row1.equals(row2)) {
                    List<Cell> row = new ArrayList<Cell>();
                    row.addAll(rel1.getRows().get(i));
                    for (int k = 0; k < rel2.getAttrs().size(); k++) {
                        if (!rel2Index.contains(k)) {
                            row.add(rel2.getRows().get(j).get(k));
                        }
                    }
                    try {
                        relNew.insert(row);
                    } catch (IllegalArgumentException e) {
                        
                    }
                }
            }
        }
            
        // compare rel1 to rel2
        for (int i = 0; i < rel2.getSize(); i++) {
            for (int j = 0; j < rel1.getSize(); j++) {
                List<Cell> row2 = new ArrayList<Cell>();
                for (int k = 0; k < rel2Index.size(); k++) {
                    row2.add(rel2.getRows().get(i).get(rel2Index.get(k)));
                }
                List<Cell> row1 = new ArrayList<Cell>();
                for (int k = 0; k < rel1Index.size(); k++) {
                    row1.add(rel1.getRows().get(j).get(rel1Index.get(k)));
                }
                
                if (row2.equals(row1)) {
                    List<Cell> row = new ArrayList<Cell>();
                    row.addAll(rel1.getRows().get(j));
                    for (int k = 0; k < rel2.getAttrs().size(); k++) {
                        if (!rel2Index.contains(k)) {
                            row.add(rel2.getRows().get(i).get(k));
                        }
                    }
                    
                    try {
                        relNew.insert(row);
                    } catch (IllegalArgumentException e) {
                        
                    }
                }
            }
        }
        
        return relNew;
    }

    /**
     * Performs theta join on relations rel1 and rel2 with predicate p.
     * 
     * @return The resulting relation after applying theta join.
     */
    @Override
    public Relation join(Relation rel1, Relation rel2, Predicate p) {
        // Get common attrs between rel1 and rel2
        List<String> comAttrs = new ArrayList<String>();
        for (int i = 0; i < rel1.getAttrs().size(); i++) {
            if (rel1.hasAttr(rel2.getAttrs().get(i))) {
                comAttrs.add(rel2.getAttrs().get(i));
            }
        }

        if (comAttrs.size() == 0) {
            throw new IllegalArgumentException("No common attributes");
        }

        // Concat attrs and types
        String name = rel1.getName() + " join " + rel2.getName();
        List<String> attrs = new ArrayList<String>();
        List<Type> types = new ArrayList<Type>();
        attrs.addAll(rel1.getAttrs());
        types.addAll(rel1.getTypes());

        for (int i = 0; i < rel2.getAttrs().size(); i++) {
            if (!attrs.contains(rel2.getAttrs().get(i))) {
                attrs.add(rel2.getAttrs().get(i));
                types.add(rel2.getTypes().get(i));
            }
        }

        // Theta join rows based on the predicate
        RelationBuilder rb = new RelationBuilderImpl();
        Relation relNew = rb.newRelation(name, attrs, types);

        for (List<Cell> row1 : rel1.getRows()) {
            for (List<Cell> row2 : rel2.getRows()) {
                // Combine rows from both relations
                List<Cell> combinedRow = row1; // check
                
                combinedRow.addAll(row2);

                // Check if the combined row satisfies the predicate
                if (p.check(combinedRow)) {
                    // If it does, insert it into the joinedRelation
                    relNew.insert(combinedRow);
                }
            }
        }
        return relNew;         
    }
}
