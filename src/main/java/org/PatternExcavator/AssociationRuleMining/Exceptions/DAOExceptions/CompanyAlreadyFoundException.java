package org.PatternExcavator.AssociationRuleMining.Exceptions.DAOExceptions;


public class CompanyAlreadyFoundException extends Exception{

   private String message="Company Name already exists in the Database";

   @Override
   public void printStackTrace() {

      System.out.println(message);

      super.printStackTrace();
   }
}
