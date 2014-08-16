package com.ibm.bluemix.shifttracking.util;

import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
import java.net.UnknownHostException;

import com.mongodb.*;

public class SimpleMongoDBHelper {
	
	private static String mongoURI = "mongodb://admin:admin@ds033499.mongolab.com:33499/projects";

	private static Mongo mongo;
	private static DB db;
	private SimpleMongoDBHelper() {
	
	}

	public static Mongo getMongoConnection () {
		if (mongo == null) {
			try {
				mongo = new Mongo(new MongoURI(mongoURI));
			} catch (UnknownHostException e) {
				System.out.println("Failed to connect to mongo db");
			}
		}
		return mongo;
	}

	public static void close () {
		
	}
	
	public static DB getDB (String sdb) {
		db = getMongoConnection().getDB(sdb);
		return db;
	}

	public static DB getDB () {
		return getDB("projects");
	}
	
	public static DBCollection getCollection (String n) {
		return getDB().getCollection(n);
	}
}
