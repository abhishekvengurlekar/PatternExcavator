package org.PatternExcavator.AssociationRuleMining.Exceptions.DAOExceptions;

public class ProductAlreadyExistsException extends Exception {

    private String message="Product Name already exists in the dataBase";

    @Override
    public void printStackTrace() {

        System.out.println(message);

        super.printStackTrace();
    }
}
