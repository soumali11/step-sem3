// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
public class QUES3 {
   public QUES3() {
   }

   public static void main(String[] var0) {
      Employee var1 = new Employee("E-101", "Divya", (double)65000.0F);
      Employee var2 = new Employee("E-102", "Arjun");
      var1.printProfile();
      var2.printProfile();
   }

   static class Employee {
      String empId;
      String empName;
      double salary;
      boolean isIntern;

      public Employee(String var1, String var2, double var3) {
         this.empId = var1;
         this.empName = var2;
         this.salary = var3;
         this.isIntern = false;
      }

      public Employee(String var1, String var2) {
         this(var1, var2, (double)0.0F);
         this.isIntern = true;
      }

      public void printProfile() {
         System.out.println(this.empId + " | " + this.empName + " | Rs " + this.salary + " | Intern: " + this.isIntern);
      }
   }
}
