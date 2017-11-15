package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public interface ITransactionProcessor {

	public String save();
	
	public List<Backbase> URLReader(String str) ;
	
	public List<Backbase> readJSON(String str) ;
	

}