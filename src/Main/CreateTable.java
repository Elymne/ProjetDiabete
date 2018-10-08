package Main;

import static JDBC.CreationTable.creationTableBddEvaluation;
import static JDBC.CreationTable.creationTableBddPersonne;

public class CreateTable {

    public static void main(String[] args) {
        
       creationTableBddPersonne();
       creationTableBddEvaluation();
    }

}