package uga.cs4370.mydb.impl;

import java.util.Arrays;
import java.util.List;

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

        Relation ewlNew = rb.newRelation(rel.getName(), rel.getAttrs(), rel.getTypes());

        for (List<Cell> row : rel.getRows()) {
            if (p.test(row)) {
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
        List<Type> types = Arrays.asList();
        for (int i = 0; i < colIndex.length; i++) {
            types.add(rel.getTypes().get(colIndex[i]));
        }
        
        
        Relation relNew = rb.newRelation(rel.getName(), 
                attrs,  
                types);
        
        // add rows
        for (int i = 0; i < rel.getSize(); i++) {
            List<Cell> row = Arrays.asList();
            
            for (int j = 0; j < rel.getAttrs().size(); j++) {
                row.add(rel.getRows().get(i).get(j));
            }
            relNew.insert(row);
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
        if ((rel1.getAttrs() != rel2.getAttrs()) | rel1.getTypes() != rel2.getTypes()) {
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
        if ((rel1.getAttrs() != rel2.getAttrs()) | rel1.getTypes() != rel2.getTypes()) {
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
        List<String> attrs = Arrays.asList(); 
        List<Type> types = Arrays.asList(); 
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
                List<Cell> row = Arrays.asList();
                
                row.addAll(rel1.getRows().get(i));
                row.addAll(rel1.getRows().get(j)); 
                
                relNew.insert(row);
            }
        }
        
        return relNew;
    }

    /**
     * Peforms natural join on relations rel1 and rel2.
     * 
     * @return The resulting relation after applying natural join.
     */
    @Override
    public Relation join(Relation rel1, Relation rel2) {
        // Get common attrs between rel1 and rel2
        List<String> comAttrs = Arrays.asList();
        for (int i = 0; i < rel1.getAttrs().size(); i++) {
            if (rel1.hasAttr(rel2.getAttrs().get(i))) {
                comAttrs.add(rel2.getAttrs().get(i));
            }
        }
        
        if (comAttrs.size() == 0) {
            throw new IllegalArgumentException("No common attributes");
        }

        // Concat attrs and types
        String name = rel1.getName() + " join " +rel2.getName();
        List<String> attrs = Arrays.asList(); 
        List<Type> types = Arrays.asList(); 
        attrs.addAll(rel1.getAttrs());
        types.addAll(rel1.getTypes());
        
        for (int i = 0; i < rel2.getAttrs().size(); i++) {
            if (!attrs.contains(rel2.getAttrs().get(i))) {
                attrs.add(rel2.getAttrs().get(i));
                types.add(rel2.getTypes().get(i));
            }
        }
        
        // Inner join rows
        for (int i = 0; i < comAttrs.size(); i++) {
            
        }
        
        RelationBuilder rb = new RelationBuilderImpl();
        Relation relNew = rb.newRelation(name, attrs, types);
        
        return relNew;
    }

    /**
     * Performs theta join on relations rel1 and rel2 with predicate p.
     * 
     * @return The resulting relation after applying theta join.
     */
    @Override
    public Relation join(Relation rel1, Relation rel2, Predicate p) {
        // TODO Auto-generated method stub
        return null;
    }

}
