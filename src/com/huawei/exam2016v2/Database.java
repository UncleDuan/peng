package com.huawei.exam2016v2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by ionolab-DP on 2019/1/5.
 */
public class Database {
    private int amountsOfStudents;
    private int amountsOfOperation;
    private int[] grade;

    public Map<Character, Handler> getDatabaseHandler() {
        return databaseHandler;
    }

    public void setDatabaseHandler(Map<Character, Handler> databaseHandler) {
        this.databaseHandler = databaseHandler;
    }

    private Map<Character,Handler> databaseHandler=new HashMap<Character, Handler>();

    public Database(int amountsOfStudents, int amountsOfOperation, int[] grade) {
        this.amountsOfStudents = amountsOfStudents;
        this.amountsOfOperation = amountsOfOperation;
        this.grade = grade;
        this.databaseHandler.put('Q',new HandlerQuery(this));
        this.databaseHandler.put('U',new HandlerUpdate(this));
    }

    public int getAmountsOfStudents() {
        return amountsOfStudents;
    }

    public void setAmountsOfStudents(int amountsOfStudents) {
        this.amountsOfStudents = amountsOfStudents;
    }

    public int getAmountsOfOperation() {
        return amountsOfOperation;
    }

    public void setAmountsOfOperation(int amountsOfOperation) {
        this.amountsOfOperation = amountsOfOperation;
    }

    public int[] getGrade() {
        return grade;
    }

    public void setGrade(int[] grade) {
        this.grade = grade;
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()) {
            int amountsOfStudents=sc.nextInt();
            int amountsOfOperation=sc.nextInt();
            int[] grade=new int[amountsOfStudents];
            for (int i=0;i<amountsOfStudents;i++){
                grade[i]=sc.nextInt();
            }
            Database mydatabase = new Database(amountsOfStudents, amountsOfOperation, grade);
            for (int i=0;i<amountsOfOperation;i++) {
                String command=sc.next();
                int param1=sc.nextInt();
                int param2=sc.nextInt();
                Handler myHandler = mydatabase.getDatabaseHandler().get(command.charAt(0));
                myHandler.doCmd(param1, param2);
            }
        }
    }
}

interface Handler{
    public int doCmd(int param1,int param2);
}

class HandlerQuery implements Handler{

    protected Database database;

    public HandlerQuery(Database database) {
        this.database = database;
    }

    @Override
    public int doCmd(int param1, int param2) {
        int max=0;
        for (int i=param1-1;i<param2;i++){
            if (database.getGrade()[i]>max){
                max=database.getGrade()[i];
            }
        }
        System.out.println(max);
        return max;
    }
}

class HandlerUpdate implements Handler{
    protected Database database;

    public HandlerUpdate(Database database) {
        this.database = database;
    }

    @Override
    public int doCmd(int param1, int param2) {
        database.getGrade()[param1-1]=param2;
        return 0;
    }
}