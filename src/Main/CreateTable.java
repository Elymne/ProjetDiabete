package Main;

import static JDBC.CreationTable.creationTableBddEvaluation;
import static JDBC.CreationTable.creationTableBddPersonne;

/**
 *
 * @author Djurdjevic Sacha
 */
public class CreateTable {

    public static void main(String[] args) {
        
       creationTableBddPersonne();
       creationTableBddEvaluation();
    }

}