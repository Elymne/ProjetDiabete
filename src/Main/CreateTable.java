/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import static JDBC.CreationTable.creationTableBddEvaluation;
import static JDBC.CreationTable.creationTableBddPersonne;
/**
 *
 * @author Elymne
 */
public class CreateTable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       creationTableBddPersonne();
       creationTableBddEvaluation();
    }

}