package com.adp.service;

import java.io.FileNotFoundException;

import org.kie.api.io.ResourceType;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.KnowledgeBaseFactory;
import org.kie.internal.builder.DecisionTableConfiguration;
import org.kie.internal.builder.DecisionTableInputType;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;

public class VehicleDecisionTableRulesSerivce {

	
	
	
	/**
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	public static KnowledgeBase createKnowledgeBaseFromSpreadsheet(String ruleFile) throws FileNotFoundException{
		DecisionTableConfiguration dtconf = KnowledgeBuilderFactory
				.newDecisionTableConfiguration();
		dtconf.setInputType(DecisionTableInputType.XLS);
  
		KnowledgeBuilder knowledgeBuilder = KnowledgeBuilderFactory
				.newKnowledgeBuilder();
		try {
			knowledgeBuilder.add(ResourceFactory.newClassPathResource(ruleFile),ResourceType.DTABLE, dtconf);
		} catch (Exception e) {
			throw new FileNotFoundException();
		}

		if (knowledgeBuilder.hasErrors()) {
			throw new RuntimeException(knowledgeBuilder.getErrors().toString());
		}		

		KnowledgeBase knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();
		knowledgeBase.addKnowledgePackages(knowledgeBuilder
				.getKnowledgePackages());
		return knowledgeBase;
	}
}
