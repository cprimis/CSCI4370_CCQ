package uga.cs4370.mydb.impl;

import java.util.Arrays;
import java.util.List;

import uga.cs4370.mydb.*;

public class Main {
    public static void main(String[] args) {      

        RelationBuilder rb = new RelationBuilderImpl();
        RA ra = new RAimpl();
        
        Relation stu1 = rb.newRelation("Student", 
                Arrays.asList("StudentID", "name", "major"), 
                Arrays.asList(Type.INTEGER, Type.STRING, Type.STRING));
        
        Cell c4 = new Cell(1222);
        Cell c5 = new Cell("Jeff Stone");
        Cell c6 = new Cell("Computer Science");
        
        Cell c7 = new Cell(3456);
        Cell c8 = new Cell("Alice Johnson");
        Cell c9 = new Cell("Mathematics");

        Cell c10 = new Cell(7890);
        Cell c11 = new Cell("Bob Smith");
        Cell c12 = new Cell("Physics");

        Cell c13 = new Cell(1234);
        Cell c14 = new Cell("Charlie Brown");
        Cell c15 = new Cell("Chemistry");
        
        List<Cell> t2 = Arrays.asList(c4,c5,c6);
        List<Cell> t3 = Arrays.asList(c7,c8,c9);
        List<Cell> t4 = Arrays.asList(c10,c11,c12);
        List<Cell> t5 = Arrays.asList(c13,c14,c15);
       
        stu1.insert(t2);
        stu1.insert(t3);       
        stu1.insert(t4);
        stu1.insert(t5);    
        
        Relation stu2 = rb.newRelation("Student", 
                Arrays.asList("StudentID", "name", "major"), 
                Arrays.asList(Type.INTEGER, Type.STRING, Type.STRING));

        Cell c16 = new Cell(5678);
        Cell c17 = new Cell("David Williams");
        Cell c18 = new Cell("Biology");
        
        Cell c19 = new Cell(9012);
        Cell c20 = new Cell("Eva Green");
        Cell c21 = new Cell("English Literature");
        
        List<Cell> t6 = Arrays.asList(c16,c17,c18);
        List<Cell> t7 = Arrays.asList(c19,c20,c21);

        stu2.insert(t5);
        stu2.insert(t6);
        stu2.insert(t7);   
        
        Relation cou = rb.newRelation("Courses", 
                Arrays.asList("CourseID", "CName", "Credits"), 
                Arrays.asList(Type.STRING, Type.STRING, Type.INTEGER));
        
        //courses data
        Cell c001 = new Cell("CS01");
        Cell c002 = new Cell("Introduction to Computing");
        Cell c003 = new Cell(3);
        
        Cell c011 = new Cell("CS02");
        Cell c012 = new Cell("Software Development");
        Cell c013 = new Cell(4);
        
        List<Cell> cl00 = Arrays.asList(c001,c002,c003);
        List<Cell> cl01 = Arrays.asList(c011,c012,c013);
        
        cou.insert(cl00);
        cou.insert(cl01);
        
        Relation tea = rb.newRelation("Teaches", 
                Arrays.asList("TeachID", "ProfessorID", "CourseID"), 
                Arrays.asList(Type.INTEGER, Type.INTEGER, Type.STRING));
                                        
        //teaches data
        Cell t001 = new Cell(1301);
        Cell t002 = new Cell(1101);
        Cell t003 = new Cell("CS01");
        
        Cell t011 = new Cell(1302);
        Cell t012 = new Cell(1101);
        Cell t013 = new Cell("CS02");
        
        Cell t021 = new Cell(1303);
        Cell t022 = new Cell(1101);
        Cell t023 = new Cell("CS04");
        
        Cell t031 = new Cell(1304);
        Cell t032 = new Cell(1102);
        Cell t033 = new Cell("CS01");
        
        Cell t041 = new Cell(1305);
        Cell t042 = new Cell(1102);
        Cell t043 = new Cell("CS03");
        
        Cell t051 = new Cell(1306);
        Cell t052 = new Cell(1103);
        Cell t053 = new Cell("CS06");
        
        Cell t061 = new Cell(1307);
        Cell t062 = new Cell(1104);
        Cell t063 = new Cell("CS03");
    
        Cell t071 = new Cell(1308);
        Cell t072 = new Cell(1104);
        Cell t073 = new Cell("CS04");
        
        Cell t081 = new Cell(1309);
        Cell t082 = new Cell(1105);
        Cell t083 = new Cell("MA01");
        
        Cell t091 = new Cell(1310);
        Cell t092 = new Cell(1106);
        Cell t093 = new Cell("MA01");
        
        Cell t101 = new Cell(1311);
        Cell t102 = new Cell(1106);
        Cell t103 = new Cell("MA02");
        
        Cell t111 = new Cell(1312);
        Cell t112 = new Cell(1107);
        Cell t113 = new Cell("MA03");
        
        Cell t121 = new Cell(1313);
        Cell t122 = new Cell(1108);
        Cell t123 = new Cell("PH01");
        
        Cell t131 = new Cell(1314);
        Cell t132 = new Cell(1109);
        Cell t133 = new Cell("PH02");
        
        Cell t141 = new Cell(1315);
        Cell t142 = new Cell(1110);
        Cell t143 = new Cell("BI01");
        
        Cell t151 = new Cell(1316);
        Cell t152 = new Cell(1110);
        Cell t153 = new Cell("BI02");
        
        Cell t161 = new Cell(1317);
        Cell t162 = new Cell(1111);
        Cell t163 = new Cell("BI01");
        
        Cell t171 = new Cell(1318);
        Cell t172 = new Cell(1111);
        Cell t173 = new Cell("BI02");
        
        Cell t181 = new Cell(1319);
        Cell t182 = new Cell(1112);
        Cell t183 = new Cell("BI03");
        
        Cell t191 = new Cell(1320);
        Cell t192 = new Cell(1113);
        Cell t193 = new Cell("BI02");
        
        Cell t201 = new Cell(1321);
        Cell t202 = new Cell(1114);
        Cell t203 = new Cell("MU01");
        
        Cell t211 = new Cell(1322);
        Cell t212 = new Cell(1114);
        Cell t213 = new Cell("MU03");
        
        Cell t221 = new Cell(1323);
        Cell t222 = new Cell(1116);
        Cell t223 = new Cell("ST01");
        
        Cell t231 = new Cell(1324);
        Cell t232 = new Cell(1116);
        Cell t233 = new Cell("ST02");
        
        Cell t241 = new Cell(1325);
        Cell t242 = new Cell(1117);
        Cell t243 = new Cell("ST03");
        
        List<Cell> tl00 = Arrays.asList(t001,t002,t003);
        List<Cell> tl01 = Arrays.asList(t011,t012,t013);
        List<Cell> tl02 = Arrays.asList(t021,t022,t023);
        List<Cell> tl03 = Arrays.asList(t031,t032,t033);
        List<Cell> tl04 = Arrays.asList(t041,t042,t043);
        List<Cell> tl05 = Arrays.asList(t051,t052,t053);
        List<Cell> tl06 = Arrays.asList(t061,t062,t063);
        List<Cell> tl07 = Arrays.asList(t071,t072,t073);
        List<Cell> tl08 = Arrays.asList(t081,t082,t083);
        List<Cell> tl09 = Arrays.asList(t091,t092,t093);
        List<Cell> tl10 = Arrays.asList(t101,t102,t103);
        List<Cell> tl11 = Arrays.asList(t111,t112,t113);
        List<Cell> tl12 = Arrays.asList(t121,t122,t123);
        List<Cell> tl13 = Arrays.asList(t131,t132,t133);
        List<Cell> tl14 = Arrays.asList(t141,t142,t143);
        List<Cell> tl15 = Arrays.asList(t151,t152,t153);
        List<Cell> tl16 = Arrays.asList(t161,t162,t163);
        List<Cell> tl17 = Arrays.asList(t171,t172,t173);
        List<Cell> tl18 = Arrays.asList(t181,t182,t183);
        List<Cell> tl19 = Arrays.asList(t191,t192,t193);
        List<Cell> tl20 = Arrays.asList(t201,t202,t203);
        List<Cell> tl21 = Arrays.asList(t211,t212,t213);
        List<Cell> tl22 = Arrays.asList(t221,t222,t223);
        List<Cell> tl23 = Arrays.asList(t231,t232,t233);
        List<Cell> tl24 = Arrays.asList(t241,t242,t243);
        
        tea.insert(tl00);
        tea.insert(tl01);
        tea.insert(tl02);
        tea.insert(tl03);
        tea.insert(tl04);
        tea.insert(tl05);
        tea.insert(tl06);
        tea.insert(tl07);
        tea.insert(tl08);
        tea.insert(tl09);
        tea.insert(tl10);
        tea.insert(tl11);
        tea.insert(tl12);
        tea.insert(tl13);
        tea.insert(tl14);
        tea.insert(tl15);
        tea.insert(tl16);
        tea.insert(tl17);
        tea.insert(tl18);
        tea.insert(tl19);
        tea.insert(tl20);
        tea.insert(tl21);
        tea.insert(tl22);
        tea.insert(tl23);
        tea.insert(tl24);
  
        stu1.print();
        stu2.print();
        cou.print();
        tea.print();
        
        //------------------------------------------------------------
        System.out.println();
        // getName
        System.out.println("getName");
        System.out.println(cou.getName());
        
        // getSize
        System.out.println("getSize");
        System.out.println(cou.getSize());
        
        // getRows
        System.out.println("getRows");
        System.out.println(cou.getRows());
        
        // getTypes
        System.out.println("getTypes");
        System.out.println(cou.getTypes());
        
        // getAttrs
        System.out.println("getAttrs");
        System.out.println(cou.getAttrs());
        
        // hasAttr
        System.out.println("hasAttr");
        System.out.println("cou has attribute 'test': " + cou.hasAttr("test"));
        
        // getAttrIndex
        System.out.println("getAttrIndex");
        System.out.println("cou has attribute 'Credits' at index " + cou.getAttrIndex("Credits"));
        
        // project
        System.out.println("project");
        Relation projtest = ra.project(stu1, Arrays.asList("StudentID"));
        projtest.print();
        
        // union
        System.out.println("union");
        Relation uniontest = ra.union(stu1, stu2);
        uniontest.print();
        
        // diff
        System.out.println("diff");
        Relation difftest = ra.diff(stu1, stu2);
        difftest.print();
        
        // rename
        System.out.println("rename");
        stu2 = ra.rename(stu2, Arrays.asList("StudentID"), Arrays.asList("ID"));
        stu2.print();
        stu2 = ra.rename(stu2, Arrays.asList("ID"), Arrays.asList("StudentID"));
        
        // cartesianProduct
        System.out.println("cartesianProduct");
        Relation carttest = ra.cartesianProduct(cou, stu2);
        carttest.print();
        
        // natural join
        System.out.println("natural join");
        Relation nattest = ra.join(cou, tea);
        nattest.print();
        
        // theta join
        System.out.println("Theta join");
        Relation thetajoin = ra.join(stu1, stu2, Arrays.asList("StudentID"));
        thetajoin.print();
    }
}
