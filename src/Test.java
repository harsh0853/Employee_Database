import java.util.*;
import java.time.LocalDate;
class Date{
    String hireDate;

    public Date(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getHireDate() {
        return hireDate;
    }

    public int getYear() {
        return Integer.parseInt(hireDate.substring(6,hireDate.length()));
    }

    public int getMonth() {
        return Integer.parseInt(hireDate.substring(3,5));
    }

    public int getDay() {
        return Integer.parseInt(hireDate.substring(0,2));
    }
}

class Address{
    String address;

    public Address(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
class Employee{
    String name;
    int empId;
    double salary;
    Address address;
    Date hireDate;
    String jobPosition;
    String contactNumber;
    public Employee(String name , int empId , double salary , Address address , Date hireDate , String jobPosition , String contactNumber){
        this.name = name;
        this.empId = empId;
        this.salary = salary;
        this.address = address;
        this.hireDate = hireDate;
        this.jobPosition = jobPosition;
        this.contactNumber = contactNumber;
    }

    public String getName() {
        return name;
    }

    public int getEmpId() {
        return empId;
    }

    public double getSalary() {
        return salary;
    }

    public Address getAddress() {
        return address;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public String getContactNumber() {
        return contactNumber;
    }
}
public class Test {

    public static void arrangeEmployeeBySalary(Employee[] employees) {
        Arrays.sort(employees, new Comparator<Employee>() {
            public int compare(Employee e1, Employee e2) {
                return Double.compare(e2.getSalary(), e1.getSalary());
            }
        });
        System.out.println("Employees arranged in descending order by salary:");
        for (Employee e : employees) {
            System.out.println("Name: " + e.getName());
            System.out.println("Employee ID: " + e.getEmpId());
            System.out.println("Salary: " + e.getSalary());
            System.out.println("Hire Date: " + e.getHireDate());
            System.out.println("Job Position: " + e.getJobPosition());
            System.out.println("Contact Number: " + e.getContactNumber());
            System.out.println("Address: " + e.getAddress());
            System.out.println();
        }
    }

    public static void getEmployeesByHireDate(Employee[] employees, Date d1, Date d2) {
        LocalDate date1 = LocalDate.of(d1.getYear(), d1.getMonth(), d1.getDay());
        LocalDate date2 = LocalDate.of(d2.getYear(), d2.getMonth(), d2.getDay());
        for (Employee e : employees) {
            LocalDate hireDate = LocalDate.of(e.getHireDate().getYear(), e.getHireDate().getMonth(), e.getHireDate().getDay());
            if (hireDate.isAfter(date1) && hireDate.isBefore(date2)) {
                System.out.println("Name: " + e.getName());
                System.out.println("Employee ID: " + e.getEmpId());
                System.out.println("Salary: " + e.getSalary());
                System.out.println("Hire Date: " + e.getHireDate());
                System.out.println("Job Position: " + e.getJobPosition());
                System.out.println("Contact Number: " + e.getContactNumber());
                System.out.println("Address: " + e.getAddress());
                System.out.println();
            }
        }
    }

    public static void getEmployeesByJobPosition(Employee[] employees, String jp) {
        for (Employee e : employees) {
            if (e.getJobPosition().equals(jp)) {
                System.out.println("Name: " + e.getName());
                System.out.println("Employee ID: " + e.getEmpId());
                System.out.println("Salary: " + e.getSalary());
                System.out.println("Hire Date: " + e.getHireDate());
                System.out.println("Job Position: " + e.getJobPosition());
                System.out.println("Contact Number: " + e.getContactNumber());
                System.out.println("Address: " + e.getAddress());
                System.out.println();
            }
        }
    }

    public static int foreignEmployeeCount(Employee[] employees) {
        int count = 0;
        for (Employee e : employees) {
            String countryCode = e.getContactNumber().substring(0, 3);
            if (!countryCode.equals("+1")) {
                count++;
            }
        }
        return count;
    }

    public static void getEmployeesBySalary(Employee[] employees, double minSalary, double maxSalary) {
        System.out.println("Employees with salary between " + minSalary + " INR and " + maxSalary + " INR:");
        for (Employee e : employees) {
            double salary = e.getSalary();
            if (salary >= minSalary && salary <= maxSalary) {
                System.out.println(e.getSalary());
            }
        }
    }

        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee[] arr = new Employee[500];
        System.out.println("Enter details of employee : ");
        for(int i = 0 ; i < 500 ; i++){
            System.out.print("Enter name : ");
            String name = sc.next();
            System.out.print("Enter employee id : ");

            int empId = sc.nextInt();
            System.out.print("Enter Salary : ");
            double salary = sc.nextDouble();
            System.out.print("Enter address : ");

            String  address = sc.next();
            Address address1 = new Address(address);
            System.out.print("Enter hireDate : ");
            String hireDate = sc.next();
            Date hireDate1 = new Date(hireDate);
            System.out.print("Enter Job Position : ");
            String jobPosition = sc.next();
            System.out.print("Enter contact number : ");
            String contactNumber = sc.next();
            arr[i]=new Employee(name , empId , salary , address1 , hireDate1 , jobPosition , contactNumber);
        }
            System.out.println("Choose what Operation to perform :   \n");
            System.out.print("Press 1 to Arrange Employee By Salary : \n");
            System.out.print("Press 2 to Get EmployeesBy Job Position : \n");
            System.out.print("Press 3 to Get Employees By HireDate : \n");
            System.out.print("Press 4 to Foreign Employee : \n");
            System.out.print("Press 5 to Get Employees By Salary : \n");
            int q = sc.nextInt();
            if(q==1)
                arrangeEmployeeBySalary(arr);
            else if (q==2){
                String jp = sc.next();
                getEmployeesByJobPosition(arr , jp);
            }
            else if (q==3){
                String hireDate1 = sc.next();
                Date hireDate12 = new Date(hireDate1);
                String hireDate2 = sc.next();
                Date hireDate21 = new Date(hireDate2);
                getEmployeesByHireDate(arr, hireDate12 , hireDate21);
            }
            else if (q==5){
                double s1 = sc.nextDouble();
                double s2 = sc.nextDouble();
                getEmployeesBySalary(arr , s1 , s2);
            }
            else if (q==4){
                foreignEmployeeCount(arr);
            }
            else
                System.out.println("Wrong Input... ");

    }
}
