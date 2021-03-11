package com.zipcodewilmington.phonebook;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook =map;
    }

    public PhoneBook() {
        phonebook=new HashMap<String, List<String>>(); {
        };
    }


    public void add(String name, String phoneNumber) {
        List<String> tempList = phonebook.get(name);
        if(tempList == null) {
            tempList = new ArrayList<>();
            phonebook.put(name, tempList);
        }
        tempList.add(phoneNumber);
    }

    public void addAll(String name, String... phoneNumbers) {
        List<String> tempList = phonebook.get(name);
        List<String> numList= Arrays.asList(phoneNumbers);
        if(tempList == null) {
            tempList = new ArrayList<>();
            phonebook.put(name, tempList);
        }
        for(String i:phoneNumbers){tempList.add(i);}

    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        List<String> tempList = phonebook.get(name);
        if (tempList==null){
            return false;
        }return true;
    }

    public Boolean hasEntry(String name, String number) {
        List<String> tempList = phonebook.get(name);
        if (tempList==null){
            return false;
        }return true;
    }

    public List<String> lookup(String name) {

        if(hasEntry(name)){
            return phonebook.get(name);
        }
        return null;
    }

    public String reverseLookup(String phoneNumber)  {
        List<String> nameList=getAllContactNames();
        List<String> temp=getAllContactNames();
        for (String i:nameList){
            temp=phonebook.get(i);
            for(String j:temp){ if(j==phoneNumber){ return i;}}
        }
        return null;
    }

    public List<String> getAllContactNames() {
        List<String>nameList=new ArrayList<String>();
        for (String i: phonebook.keySet()){
            nameList.add(i);
        }
        Collections.sort(nameList);
        Collections.reverse(nameList);
        return nameList;

    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
