package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Data {
	public static  ArrayList<String> firstNames;
	public static ArrayList<String> lastNames;
	public static ArrayList<String> emails;
	public static ArrayList<String> passwords;
	public static ArrayList<String> addresses;
	public static ArrayList<String> cities;
	public static ArrayList<String> zipCodes;
	public static ArrayList<String> phones;
	public static ArrayList<String> country;
	public static ArrayList<String> loginEmails;
	public static ArrayList<String> loginPasswords;
	private static  Random randomGen = new Random();
	private static String csvFIle ="C:\\Users\\juan.gomez\\eclipse-workspace\\Team1-AcademyBugs\\src\\utils\\data.csv";
	private static String loginFile ="C:\\Users\\juan.gomez\\eclipse-workspace\\Team1-AcademyBugs\\src\\utils\\login.csv";
	public static void read(String cvsFile) {
		File file = new File(cvsFile);
		FileReader fr = null;
		try {
			fr = new FileReader(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		};
		
		BufferedReader br = new BufferedReader(fr);
		String line = " ";
		String[] tempArr;
		firstNames = new ArrayList<String>();
		lastNames = new ArrayList<String>();
		emails = new ArrayList<String>();
		passwords = new ArrayList<String>();
		addresses = new ArrayList<String>();
		cities = new ArrayList<String>();
		zipCodes = new ArrayList<String>();
		phones = new ArrayList<String>();
		country =new ArrayList<String>();
		try {
			while((line = br.readLine()) != null) {
				tempArr = line.split(";");
				firstNames.add(tempArr[1]);
				lastNames.add(tempArr[2]);
				emails.add(tempArr[3]);
				passwords.add(tempArr[4]);
				addresses.add(tempArr[5]);
				cities.add(tempArr[6]);
				zipCodes.add(tempArr[7]);
				phones.add(tempArr[8]);
				country.add(tempArr[9]);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void readLogin(String cvsFile) {
		File file = new File(cvsFile);
		FileReader fr = null;
		try {
			fr = new FileReader(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		};
		
		BufferedReader br = new BufferedReader(fr);
		String line = " ";
		String[] tempArr;
		loginEmails = new ArrayList<String>();
		loginPasswords = new ArrayList<String>();
		try {
			while((line = br.readLine()) != null) {
				tempArr = line.split(";");
				loginEmails.add(tempArr[1]);
				loginPasswords.add(tempArr[2]);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String getRandomFirstName() {
		Data.read(csvFIle);
		int index = randomGen.nextInt(firstNames.size());
		return firstNames.get(index);
	}
	public static String getRandomLastName() {
		Data.read(csvFIle);
		int index = randomGen.nextInt(lastNames.size());
		return lastNames.get(index);
	}
	public static String getRandomEmail() {
		Data.read(csvFIle);
		int index = randomGen.nextInt(emails.size());
		return emails.get(index);
	}
	public static String getRandomAddress() {
		Data.read(csvFIle);
		int index = randomGen.nextInt(addresses.size());
		return addresses.get(index);
	}
	public static String getRandomCity() {
		Data.read(csvFIle);
		int index = randomGen.nextInt(cities.size());
		return cities.get(index);
	}
	public static String getRandoZipCode() {
		Data.read(csvFIle);
		int index = randomGen.nextInt(zipCodes.size());
		return zipCodes.get(index);
	}
	public static String getRandomPhone() {
		Data.read(csvFIle);
		int index = randomGen.nextInt(phones.size());
		return phones.get(index);
	}
	public static String getRandomPassword() {
		Data.read(csvFIle);
		int index = randomGen.nextInt(passwords.size());
		return passwords.get(index);
	}
	public static String getRandomCountry() {
		Data.read(csvFIle);
		int index = randomGen.nextInt(country.size());
		return country.get(index);
	}
	public static String getRandomLoginEmail() {
		Data.readLogin(loginFile);
		int index = randomGen.nextInt(loginEmails.size());
		return loginEmails.get(index);
	}
	public static String getRandomLoginPassword() {
		Data.readLogin(loginFile);
		int index = randomGen.nextInt(loginPasswords.size());
		return loginPasswords.get(index);
	}

}
