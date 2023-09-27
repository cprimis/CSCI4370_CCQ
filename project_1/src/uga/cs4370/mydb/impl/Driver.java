package uga.cs4370.mydb.impl;

import java.util.Arrays;
import java.util.List;

import uga.cs4370.mydb.*;

public class Driver {
	
	
	
	public static void main(String[] args) {
		


		/**
		RelationBuilder rb = new RelationBuilderImpl();
		Relation r = rb.newRelation("Student", 
				Arrays.asList("ID", "name", "major"), 
				Arrays.asList(Type.INTEGER, Type.STRING, Type.STRING));
		Relation r3 = rb.newRelation("Student", 
				Arrays.asList("ID", "name", "major"), 
				Arrays.asList(Type.INTEGER, Type.STRING, Type.STRING));		
		try {
			Relation r2 = rb.newRelation("Student", 
					Arrays.asList("ID1", "name"), 
					Arrays.asList(Type.INTEGER, Type.STRING, Type.STRING));
			System.out.println(r2.getName());
		} catch(IllegalArgumentException iae) {
//			System.err.println(iae);
		} // try

		Cell c1 = new Cell(1001);
		Cell c2 = new Cell("Chris Primis");
		Cell c3 = new Cell("Data Science");
		
		List<Cell> t1 = Arrays.asList(c1,c2,c3);
		
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

		Cell c16 = new Cell(5678);
		Cell c17 = new Cell("David Williams");
		Cell c18 = new Cell("Biology");
		
		Cell c19 = new Cell(9012);
		Cell c20 = new Cell("Eva Green");
		Cell c21 = new Cell("English Literature");

		Cell c22 = new Cell(3456);
		Cell c23 = new Cell("Frank Miller");
		Cell c24 = new Cell("History");

		Cell c25 = new Cell(7890);
		Cell c26 = new Cell("Grace Lee");
		Cell c27 = new Cell("Geography");

		Cell c28 = new Cell(1234);
		Cell c29 = new Cell("Henry Ford");
		Cell c30 = new Cell("Economics");

		Cell c31 = new Cell(5678);
		Cell c32 = new Cell("Irene Adler");
		Cell c33 = new Cell("Psychology");
		
		Cell c34 = new Cell(5678.10);
		Cell c35 = new Cell(1);
		Cell c36 = new Cell("Psychology");


		List<Cell> t2 = Arrays.asList(c4,c5,c6);
		List<Cell> t3 = Arrays.asList(c7,c8,c9);
		List<Cell> t4 = Arrays.asList(c10,c11,c12);
		List<Cell> t5 = Arrays.asList(c13,c14,c15);
		List<Cell> t6 = Arrays.asList(c16,c17,c18);
		List<Cell> t7 = Arrays.asList(c4,c8,c12);		
		r.insert(t1);
		r.print();
		r.insert(t2);
		r.insert(t3);		
		r.insert(t4);
		r.insert(t5);		
		r.insert(t6);
		r.insert(t7);
		List<List<Cell>> copy_of_r = r.getRows();
		
		r.insert(c19,c20,c21);
		r.insert(c22,c23,c24);
		r.insert(c25,c26,c27);
		r.insert(c28,c29,c30);
		r.insert(c31,c32,c33);
		r.insert(c31,c32,c30);
		try {
			r.insert(c34,c35,c36);
		} catch(Exception e) {
			
		} // try

		r.print();
		System.out.println(copy_of_r.toString());
		for(List<Cell> row_of_r : copy_of_r) {
			r3.insert(row_of_r);
		}
		r3.print();
		System.out.println(r3.getAttrs());
		
//		r3.setAttrs(Arrays.asList("NOT_ID", "NOT_name", "NOT_major"));
		**/
		
		// **************** //
		// Data Tables //

		RelationBuilder rb = new RelationBuilderImpl();
		
		// students datatable
		Relation stu = rb.newRelation("Students", 
				Arrays.asList("StudentID", "FName", "LName", "DoB", "Major"), 
				Arrays.asList(Type.INTEGER, Type.STRING, Type.STRING, Type.STRING, Type.STRING));
		
		//students data
		Cell s01 = new Cell(1234);
		Cell s02 = new Cell("Austin");
		Cell s03 = new Cell("Adams");
		Cell s04 = new Cell("2000-01-01");
		Cell s05 = new Cell("Biology");
		
		Cell s11 = new Cell(1256);
		Cell s12 = new Cell("Bradley");
		Cell s13 = new Cell("Baxter");
		Cell s14 = new Cell("2002-02-02");
		Cell s15 = new Cell("Comp. Sci.");
		
		Cell s21 = new Cell(1278);
		Cell s22 = new Cell("Candace");
		Cell s23 = new Cell("Cooper");
		Cell s24 = new Cell("2001-05-06");
		Cell s25 = new Cell("Physics");
		
		Cell s31 = new Cell(1290);
		Cell s32 = new Cell("Damien");
		Cell s33 = new Cell("Duncan");
		Cell s34 = new Cell("2001-11-20");
		Cell s35 = new Cell("Comp. Sci.");
		
		Cell s41 = new Cell(1212);
		Cell s42 = new Cell("Elena");
		Cell s43 = new Cell("Evans");
		Cell s44 = new Cell("2000-07-25");
		Cell s45 = new Cell("Biology");
	
		Cell s51 = new Cell(1201);
		Cell s52 = new Cell("Florence");
		Cell s53 = new Cell("Fisher");
		Cell s54 = new Cell("2002-04-02");
		Cell s55 = new Cell("Comp. Sci.");
		
		Cell s61 = new Cell(1203);
		Cell s62 = new Cell("Georgia");
		Cell s63 = new Cell("Green");
		Cell s64 = new Cell("2003-08-01");
		Cell s65 = new Cell("Mathematics");
		
		Cell s71 = new Cell(1205);
		Cell s72 = new Cell("Heath");
		Cell s73 = new Cell("Hughes");
		Cell s74 = new Cell("2002-08-17");
		Cell s75 = new Cell("Music");

		Cell s81 = new Cell(1207);
		Cell s82 = new Cell("Issac");
		Cell s83 = new Cell("Irvine");
		Cell s84 = new Cell("2000-06-28");
		Cell s85 = new Cell("Comp. Sci.");
		
		Cell s91 = new Cell(1209);
		Cell s92 = new Cell("Julia");
		Cell s93 = new Cell("Johnson");
		Cell s94 = new Cell("2002-02-13");
		Cell s95 = new Cell("Comp. Sci.");
		
		List<Cell> sl0 = Arrays.asList(s01,s02,s03,s04,s05);
		List<Cell> sl1 = Arrays.asList(s11,s12,s13,s14,s15);
		List<Cell> sl2 = Arrays.asList(s21,s22,s23,s24,s25);
		List<Cell> sl3 = Arrays.asList(s31,s32,s33,s34,s35);
		List<Cell> sl4 = Arrays.asList(s41,s42,s43,s44,s45);
		List<Cell> sl5 = Arrays.asList(s51,s52,s53,s54,s55);
		List<Cell> sl6 = Arrays.asList(s61,s62,s63,s64,s65);
		List<Cell> sl7 = Arrays.asList(s71,s72,s73,s74,s75);
		List<Cell> sl8 = Arrays.asList(s81,s82,s83,s84,s85);
		List<Cell> sl9 = Arrays.asList(s91,s92,s93,s94,s95);
		
		stu.insert(sl0);
		stu.insert(sl1);
		stu.insert(sl2);
		stu.insert(sl3);
		stu.insert(sl4);
		stu.insert(sl5);
		stu.insert(sl6);
		stu.insert(sl7);
		stu.insert(sl8);
		stu.insert(sl9);
		
		stu.print();
		
		
		// courses datatable
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
		
		Cell c021 = new Cell("CS03");
		Cell c022 = new Cell("Java Principles");
		Cell c023 = new Cell(3);
		
		Cell c031 = new Cell("CS04");
		Cell c032 = new Cell("Python Principles");
		Cell c033 = new Cell(3);
		
		Cell c041 = new Cell("CS05");
		Cell c042 = new Cell("Data Security");
		Cell c043 = new Cell(4);
		
		Cell c051 = new Cell("CS06");
		Cell c052 = new Cell("Data Science");
		Cell c053 = new Cell(4);
		
		Cell c061 = new Cell("MA01");
		Cell c062 = new Cell("Calculus I");
		Cell c063 = new Cell(4);
		
		Cell c071 = new Cell("MA02");
		Cell c072 = new Cell("Calculus II");
		Cell c073 = new Cell(4);
		
		Cell c081 = new Cell("MA03");
		Cell c082 = new Cell("Linear Algebra");
		Cell c083 = new Cell(3);
		
		Cell c091 = new Cell("PH01");
		Cell c092 = new Cell("Introduction to Physics");
		Cell c093 = new Cell(3);
		
		Cell c101 = new Cell("PH02");
		Cell c102 = new Cell("Mechanics");
		Cell c103 = new Cell(4);
		
		Cell c111 = new Cell("BI01");
		Cell c112 = new Cell("Introduction to Biology");
		Cell c113 = new Cell(3);
		
		Cell c121 = new Cell("BI02");
		Cell c122 = new Cell("Biological Principles");
		Cell c123 = new Cell(3);
		
		Cell c131 = new Cell("BI03");
		Cell c132 = new Cell("Evolution");
		Cell c133 = new Cell(4);
		
		Cell c141 = new Cell("MU01");
		Cell c142 = new Cell("Music Theory");
		Cell c143 = new Cell(1);
		
		Cell c151 = new Cell("MU02");
		Cell c152 = new Cell("History of Music");
		Cell c153 = new Cell(3);
		
		Cell c161 = new Cell("MU03");
		Cell c162 = new Cell("Music and Film");
		Cell c163 = new Cell(2);
		
		Cell c171 = new Cell("ST01");
		Cell c172 = new Cell("Statistics Principles");
		Cell c173 = new Cell(3);
		
		Cell c181 = new Cell("ST02");
		Cell c182 = new Cell("Probability");
		Cell c183 = new Cell(3);
		
		Cell c191 = new Cell("ST03");
		Cell c192 = new Cell("Research in Statistics");
		Cell c193 = new Cell(1);

		List<Cell> cl00 = Arrays.asList(c001,c002,c003);
		List<Cell> cl01 = Arrays.asList(c011,c012,c013);
		List<Cell> cl02 = Arrays.asList(c021,c022,c023);
		List<Cell> cl03 = Arrays.asList(c031,c032,c033);
		List<Cell> cl04 = Arrays.asList(c041,c042,c043);
		List<Cell> cl05 = Arrays.asList(c051,c052,c053);
		List<Cell> cl06 = Arrays.asList(c061,c062,c063);
		List<Cell> cl07 = Arrays.asList(c071,c072,c073);
		List<Cell> cl08 = Arrays.asList(c081,c082,c083);
		List<Cell> cl09 = Arrays.asList(c091,c092,c093);
		List<Cell> cl10 = Arrays.asList(c101,c102,c103);
		List<Cell> cl11 = Arrays.asList(c111,c112,c113);
		List<Cell> cl12 = Arrays.asList(c121,c122,c123);
		List<Cell> cl13 = Arrays.asList(c131,c132,c133);
		List<Cell> cl14 = Arrays.asList(c141,c142,c143);
		List<Cell> cl15 = Arrays.asList(c151,c152,c153);
		List<Cell> cl16 = Arrays.asList(c161,c162,c163);
		List<Cell> cl17 = Arrays.asList(c171,c172,c173);
		List<Cell> cl18 = Arrays.asList(c181,c182,c183);
		List<Cell> cl19 = Arrays.asList(c191,c192,c193);
		
		cou.insert(cl00);
		cou.insert(cl01);
		cou.insert(cl02);
		cou.insert(cl03);
		cou.insert(cl04);
		cou.insert(cl05);
		cou.insert(cl06);
		cou.insert(cl07);
		cou.insert(cl08);
		cou.insert(cl09);
		cou.insert(cl10);
		cou.insert(cl11);
		cou.insert(cl12);
		cou.insert(cl13);
		cou.insert(cl14);
		cou.insert(cl15);
		cou.insert(cl16);
		cou.insert(cl17);
		cou.insert(cl18);
		cou.insert(cl19);
		cou.print();
		
		
		// enrollment datatable
		Relation enr = rb.newRelation("Enrollment", 
				Arrays.asList("EnrollmentID", "StudentID", "CourseID", "grade"), 
				Arrays.asList(Type.INTEGER, Type.INTEGER, Type.STRING, Type.STRING));
					
		//enrollment data
		Cell e001 = new Cell(1001);
		Cell e002 = new Cell(1234);
		Cell e003 = new Cell("BI01");
		Cell e004 = new Cell("A");
		
		Cell e011 = new Cell(1002);
		Cell e012 = new Cell(1234);
		Cell e013 = new Cell("BI02");
		Cell e014 = new Cell("B");
		
		Cell e021 = new Cell(1003);
		Cell e022 = new Cell(1234);
		Cell e023 = new Cell("BI03");
		Cell e024 = new Cell("A");
		
		Cell e031 = new Cell(1004);
		Cell e032 = new Cell(1234);
		Cell e033 = new Cell("CS01");
		Cell e034 = new Cell("A");
		
		Cell e041 = new Cell(1005);
		Cell e042 = new Cell(1256);
		Cell e043 = new Cell("CS02");
		Cell e044 = new Cell("F");
		
		Cell e051 = new Cell(1006);
		Cell e052 = new Cell(1256);
		Cell e053 = new Cell("CS04");
		Cell e054 = new Cell("B");
		
		Cell e061 = new Cell(1007);
		Cell e062 = new Cell(1256);
		Cell e063 = new Cell("CS06");
		Cell e064 = new Cell("A");
		
		Cell e071 = new Cell(1008);
		Cell e072 = new Cell(1278);
		Cell e073 = new Cell("PH01");
		Cell e074 = new Cell("A");
		
		Cell e081 = new Cell(1009);
		Cell e082 = new Cell(1278);
		Cell e083 = new Cell("PH02");
		Cell e084 = new Cell("B");
		
		Cell e091 = new Cell(1010);
		Cell e092 = new Cell(1278);
		Cell e093 = new Cell("ST01");
		Cell e094 = new Cell("A");
		
		Cell e101 = new Cell(1011);
		Cell e102 = new Cell(1290);
		Cell e103 = new Cell("CS01");
		Cell e104 = new Cell("A");

		Cell e111 = new Cell(1012);
		Cell e112 = new Cell(1212);
		Cell e113 = new Cell("BI01");
		Cell e114 = new Cell("A");
		
		Cell e121 = new Cell(1013);
		Cell e122 = new Cell(1212);
		Cell e123 = new Cell("BI02");
		Cell e124 = new Cell("D");
		
		Cell e131 = new Cell(1014);
		Cell e132 = new Cell(1212);
		Cell e133 = new Cell("BI03");
		Cell e134 = new Cell("F");
		
		Cell e141 = new Cell(1015);
		Cell e142 = new Cell(1203);
		Cell e143 = new Cell("MA01");
		Cell e144 = new Cell("A");
		
		Cell e151 = new Cell(1016);
		Cell e152 = new Cell(1203);
		Cell e153 = new Cell("MA03");
		Cell e154 = new Cell("A");
		
		Cell e161 = new Cell(1017);
		Cell e162 = new Cell(1205);
		Cell e163 = new Cell("MU01");
		Cell e164 = new Cell("B");
		
		Cell e171 = new Cell(1018);
		Cell e172 = new Cell(1205);
		Cell e173 = new Cell("MU03");
		Cell e174 = new Cell("B");
		
		Cell e181 = new Cell(1019);
		Cell e182 = new Cell(1205);
		Cell e183 = new Cell("CS01");
		Cell e184 = new Cell("A");
		
		Cell e191 = new Cell(1020);
		Cell e192 = new Cell(1207);
		Cell e193 = new Cell("CS01");
		Cell e194 = new Cell("A");
		
		Cell e201 = new Cell(1021);
		Cell e202 = new Cell(1207);
		Cell e203 = new Cell("CS02");
		Cell e204 = new Cell("A");
		
		Cell e211 = new Cell(1022);
		Cell e212 = new Cell(1207);
		Cell e213 = new Cell("MA02");
		Cell e214 = new Cell("F");
		
		Cell e221 = new Cell(1023);
		Cell e222 = new Cell(1207);
		Cell e223 = new Cell("ST01");
		Cell e224 = new Cell("A");
		
		Cell e231 = new Cell(1024);
		Cell e232 = new Cell(1209);
		Cell e233 = new Cell("CS03");
		Cell e234 = new Cell("A");
		
		Cell e241 = new Cell(1025);
		Cell e242 = new Cell(1209);
		Cell e243 = new Cell("MA01");
		Cell e244 = new Cell("B");
		
		Cell e251 = new Cell(1026);
		Cell e252 = new Cell(1209);
		Cell e253 = new Cell("PH01");
		Cell e254 = new Cell("C");
		
		Cell e261 = new Cell(1027);
		Cell e262 = new Cell(1209);
		Cell e263 = new Cell("CS06");
		Cell e264 = new Cell("A");
		
		Cell e271 = new Cell(1028);
		Cell e272 = new Cell(1209);
		Cell e273 = new Cell("ST03");
		Cell e274 = new Cell("A");
	
		List<Cell> el00 = Arrays.asList(e001,e002,e003,e004);
		List<Cell> el01 = Arrays.asList(e011,e012,e013,e014);
		List<Cell> el02 = Arrays.asList(e021,e022,e023,e024);
		List<Cell> el03 = Arrays.asList(e031,e032,e033,e034);
		List<Cell> el04 = Arrays.asList(e041,e042,e043,e044);
		List<Cell> el05 = Arrays.asList(e051,e052,e053,e054);
		List<Cell> el06 = Arrays.asList(e061,e062,e063,e064);
		List<Cell> el07 = Arrays.asList(e071,e072,e073,e074);
		List<Cell> el08 = Arrays.asList(e081,e082,e083,e084);
		List<Cell> el09 = Arrays.asList(e091,e092,e093,e094);
		List<Cell> el10 = Arrays.asList(e101,e102,e103,e104);
		List<Cell> el11 = Arrays.asList(e111,e112,e113,e114);
		List<Cell> el12 = Arrays.asList(e121,e122,e123,e124);
		List<Cell> el13 = Arrays.asList(e131,e132,e133,e134);
		List<Cell> el14 = Arrays.asList(e141,e142,e143,e144);
		List<Cell> el15 = Arrays.asList(e151,e152,e153,e154);
		List<Cell> el16 = Arrays.asList(e161,e162,e163,e164);
		List<Cell> el17 = Arrays.asList(e171,e172,e173,e174);
		List<Cell> el18 = Arrays.asList(e181,e182,e183,e184);
		List<Cell> el19 = Arrays.asList(e191,e192,e193,e194);
		List<Cell> el20 = Arrays.asList(e201,e202,e203,e204);
		List<Cell> el21 = Arrays.asList(e211,e212,e213,e214);
		List<Cell> el22 = Arrays.asList(e221,e222,e223,e224);
		List<Cell> el23 = Arrays.asList(e231,e232,e233,e234);
		List<Cell> el24 = Arrays.asList(e241,e242,e243,e244);
		List<Cell> el25 = Arrays.asList(e251,e252,e253,e254);
		List<Cell> el26 = Arrays.asList(e261,e262,e263,e264);
		List<Cell> el27 = Arrays.asList(e271,e272,e273,e274);
		
		enr.insert(el00);
		enr.insert(el01);
		enr.insert(el02);
		enr.insert(el03);
		enr.insert(el04);
		enr.insert(el05);
		enr.insert(el06);
		enr.insert(el07);
		enr.insert(el08);
		enr.insert(el09);
		enr.insert(el10);
		enr.insert(el11);
		enr.insert(el12);
		enr.insert(el13);
		enr.insert(el14);
		enr.insert(el15);
		enr.insert(el16);
		enr.insert(el17);
		enr.insert(el18);
		enr.insert(el19);
		enr.insert(el20);
		enr.insert(el21);
		enr.insert(el22);
		enr.insert(el23);
		enr.insert(el24);
		enr.insert(el25);
		enr.insert(el26);
		enr.insert(el27);
		
		enr.print();
		
		
		// professors datatable
		Relation pro = rb.newRelation("Professors", 
				Arrays.asList("ProfessorID", "FName", "LName", "department"), 
				Arrays.asList(Type.INTEGER, Type.STRING, Type.STRING, Type.STRING));			
						
		//professors data
		Cell p001 = new Cell(1101);
		Cell p002 = new Cell("Omar");
		Cell p003 = new Cell("Diaz");
		Cell p004 = new Cell("Comp. Sci");
		
		Cell p011 = new Cell(1102);
		Cell p012 = new Cell("Alyssa");
		Cell p013 = new Cell("Todd");
		Cell p014 = new Cell("Comp. Sci");
		
		Cell p021 = new Cell(1103);
		Cell p022 = new Cell("Emmanuel");
		Cell p023 = new Cell("Connolly");
		Cell p024 = new Cell("Comp. Sci");
		
		Cell p031 = new Cell(1104);
		Cell p032 = new Cell("Jean");
		Cell p033 = new Cell("Wagner");
		Cell p034 = new Cell("Comp. Sci");
		
		Cell p041 = new Cell(1105);
		Cell p042 = new Cell("Michael");
		Cell p043 = new Cell("Giles");
		Cell p044 = new Cell("Mathematics");
		
		Cell p051 = new Cell(1106);
		Cell p052 = new Cell("Larry");
		Cell p053 = new Cell("Collier");
		Cell p054 = new Cell("Mathematics");
		
		Cell p061 = new Cell(1107);
		Cell p062 = new Cell("Brian");
		Cell p063 = new Cell("Montes");
		Cell p064 = new Cell("Mathematics");
		
		Cell p071 = new Cell(1108);
		Cell p072 = new Cell("Ruth");
		Cell p073 = new Cell("Ferguson");
		Cell p074 = new Cell("Physics");
		
		Cell p081 = new Cell(1109);
		Cell p082 = new Cell("Connor");
		Cell p083 = new Cell("Jackson");
		Cell p084 = new Cell("Physics");
		
		Cell p091 = new Cell(1110);
		Cell p092 = new Cell("Tobias");
		Cell p093 = new Cell("Curry");
		Cell p094 = new Cell("Biology");
		
		Cell p101 = new Cell(1111);
		Cell p102 = new Cell("Jordan");
		Cell p103 = new Cell("Dunlap");
		Cell p104 = new Cell("Biology");
		
		Cell p111 = new Cell(1112);
		Cell p112 = new Cell("Hudson");
		Cell p113 = new Cell("Wallace");
		Cell p114 = new Cell("Biology");
		
		Cell p121 = new Cell(1113);
		Cell p122 = new Cell("Rebecca");
		Cell p123 = new Cell("Peck");
		Cell p124 = new Cell("Biology");
		
		Cell p131 = new Cell(1114);
		Cell p132 = new Cell("Elizabeth");
		Cell p133 = new Cell("Hayes");
		Cell p134 = new Cell("Music");
		
		Cell p141 = new Cell(1115);
		Cell p142 = new Cell("Leonardo");
		Cell p143 = new Cell("Salazar");
		Cell p144 = new Cell("Music");
		
		Cell p151 = new Cell(1116);
		Cell p152 = new Cell("Raymond");
		Cell p153 = new Cell("Aguilar");
		Cell p154 = new Cell("Statistics");
		
		Cell p161 = new Cell(1117);
		Cell p162 = new Cell("Greta");
		Cell p163 = new Cell("Stanton");
		Cell p164 = new Cell("Statistics");
		
		Cell p171 = new Cell(1118);
		Cell p172 = new Cell("Russell");
		Cell p173 = new Cell("Donovan");
		Cell p174 = new Cell("Statistics");

		List<Cell> pl00 = Arrays.asList(p001,p002,p003,p004);
		List<Cell> pl01 = Arrays.asList(p011,p012,p013,p014);
		List<Cell> pl02 = Arrays.asList(p021,p022,p023,p024);
		List<Cell> pl03 = Arrays.asList(p031,p032,p033,p034);
		List<Cell> pl04 = Arrays.asList(p041,p042,p043,p044);
		List<Cell> pl05 = Arrays.asList(p051,p052,p053,p054);
		List<Cell> pl06 = Arrays.asList(p061,p062,p063,p064);
		List<Cell> pl07 = Arrays.asList(p071,p072,p073,p074);
		List<Cell> pl08 = Arrays.asList(p081,p082,p083,p084);
		List<Cell> pl09 = Arrays.asList(p091,p092,p093,p094);
		List<Cell> pl10 = Arrays.asList(p101,p102,p103,p104);
		List<Cell> pl11 = Arrays.asList(p111,p112,p113,p114);
		List<Cell> pl12 = Arrays.asList(p121,p122,p123,p124);
		List<Cell> pl13 = Arrays.asList(p131,p132,p133,p134);
		List<Cell> pl14 = Arrays.asList(p141,p142,p143,p144);
		List<Cell> pl15 = Arrays.asList(p151,p152,p153,p154);
		List<Cell> pl16 = Arrays.asList(p161,p162,p163,p164);
		List<Cell> pl17 = Arrays.asList(p171,p172,p173,p174);
		
		pro.insert(pl00);
		pro.insert(pl01);
		pro.insert(pl02);
		pro.insert(pl03);
		pro.insert(pl04);
		pro.insert(pl05);
		pro.insert(pl06);
		pro.insert(pl07);
		pro.insert(pl08);
		pro.insert(pl09);
		pro.insert(pl10);
		pro.insert(pl11);
		pro.insert(pl12);
		pro.insert(pl13);
		pro.insert(pl14);
		pro.insert(pl15);
		pro.insert(pl16);
		pro.insert(pl17);
		
		pro.print();
		
		
		// teaches datatable
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
		
		tea.print();


		// Questions Implementation
		RA ra = new RAimpl();
		
		//Q1 Select Predicate
		Predicate predex = new Predicate() {
			@Override
			public boolean check(List<Cell> row) {
				int idIndex = enr.getAttrIndex("StudentID");
				Cell idCell = row.get(idIndex);
				int idValue = (Integer) idCell.getAsInt();
				return idValue == 1234;
			}
		};
		
		Relation selecttest1 = ra.select(enr, predex);
		List<String> courseID_attr = Arrays.asList("CourseID");
		Relation finalQ1 = ra.project(selecttest1, courseID_attr);
		System.out.println("Retrieve all course IDs a student with ID 1234 has enrolled in: ");
		finalQ1.print();

		//Q2 Select Predicate
		Predicate predex2 = new Predicate() {
			@Override
			public boolean check(List<Cell> row) {
				int idIndex = stu.getAttrIndex("Major");
				Cell idCell = row.get(idIndex);
				String idValue = idCell.getAsString();
				return idValue == "Comp. Sci.";
			}
		};
		
		Relation selecttest2 = ra.select(stu, predex2);
		//selecttest2.print();
		Relation projecttest2 = ra.project(selecttest2, Arrays.asList("FName","LName","StudentID"));
		System.out.println("All student names and ids who major in computer science: ");
		projecttest2.print();
		
	} // main
} // Driver
