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

public class TransactionProcessor implements ITransactionProcessor {

	public String save() {

		return "Jersey + Spring example";

	}
	
	public List<Backbase> URLReader(String str) {
		List<Backbase> bblist = null;
		BufferedReader in;
		try {
			URL url = new URL(str);
			in = new BufferedReader(new InputStreamReader(url.openStream()));
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				System.out.println(inputLine);
				bblist = readJSON(inputLine);
			}

			// readJSON(inputLine);
			in.close();
			// readJSON(inputLine);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bblist;

	}
	
	/**
	 * @param str
	 * @return
	 */
	public List<Backbase> readJSON(String str) {
		List<Backbase> bbList = new ArrayList();
		try {
			System.out.println(str);
			Object obj = JSONValue.parse(str);
			JSONObject jsonObject = (JSONObject) obj;
			// System.out.println(jsonObject.toJSONString());
			JSONArray transactions = (JSONArray) jsonObject.get("transactions");
			Iterator i = transactions.iterator();
			while (i.hasNext()) {
				Backbase bb = new Backbase();
				JSONObject innerObj = (JSONObject) i.next();
				String id = (String) innerObj.get("id");
				bb.setId(id);
				JSONObject thisaccount = (JSONObject) innerObj.get("this_account");
				JSONObject otheraccount = (JSONObject) innerObj.get("other_account");
				String accountId = (String) thisaccount.get("id");
				String counterpartyAccount = (String) otheraccount.get("number");
				bb.setAccocuntId(accountId);
				bb.setCounterpartyAccount(counterpartyAccount);
				JSONObject holder = (JSONObject) otheraccount.get("holder");
				String counterpartyName = (String) holder.get("name");
				System.out.println("id " + id + " with accountId " + counterpartyName);
				bbList.add(bb);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return bbList;
	}
	

}