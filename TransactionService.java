package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@Path("/test")
@Produces({ MediaType.APPLICATION_JSON })
public class TransactionService {

	@Autowired
	ITransactionProcessor transactionProcessor;

	@GET
	@Path("/transactionlist")
	public List<Backbase> transactionsList() {

		String url = "https://apisandbox.openbankproject.com/obp/v1.2.1/banks/rbs/accounts/savings-kids-john/public/transactions";
		List<Backbase> bblist = transactionProcessor.URLReader(url);
		String result1 = "rrrrr";
		return bblist;
		//return Response.status(200).entity(bblist).build();

	}
	
	

}