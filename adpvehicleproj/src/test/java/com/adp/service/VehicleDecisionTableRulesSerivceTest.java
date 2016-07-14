package com.adp.service;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.drools.definition.KnowledgePackage;
import org.drools.definition.rule.Rule;
import org.junit.Test;
import org.kie.api.definition.KiePackage;
import org.kie.api.io.ResourceType;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.KnowledgeBaseFactory;
import org.kie.internal.builder.DecisionTableConfiguration;
import org.kie.internal.builder.DecisionTableInputType;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;

public class VehicleDecisionTableRulesSerivceTest {

	
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void createKnowledgeBaseFromSpreadsheetTest(){
		KnowledgeBase knowledgeBase = null;
		List list = new ArrayList();
		boolean thrown = false;
		try {
			knowledgeBase = VehicleDecisionTableRulesSerivce.createKnowledgeBaseFromSpreadsheet("VehicleDecisionTable.xls");
			Collection<KiePackage> packages = knowledgeBase.getKiePackages();
			
			for( KiePackage kPackage: packages ){
			    for( org.kie.api.definition.rule.Rule rule: kPackage.getRules()){
			    	list.add(rule);
			    }
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			thrown = true;
		}
		assertFalse(list.isEmpty());
		assertFalse(thrown);
	}

	@Test
	public void createKnowledgeBaseFromSpreadsheetInvalidFileTest(){
		KnowledgeBase knowledgeBase = null;
		List list = new ArrayList();
		boolean thrown = false;
		try {
			knowledgeBase = VehicleDecisionTableRulesSerivce.createKnowledgeBaseFromSpreadsheet("abc.xls");
			Collection<KiePackage> packages = knowledgeBase.getKiePackages();
			for( KiePackage kPackage: packages ){
			    for( org.kie.api.definition.rule.Rule rule: kPackage.getRules()){
			    	list.add(rule);
			    }
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			thrown = true;
		}
		assertTrue(list.isEmpty());
		assertTrue(thrown);
	}
	
}
