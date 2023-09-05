public class Bank {
    public static void main(String[] args) {

        Person person1 = new Person();
        person1.firstName = "Jan";
        person1.lastName = "Kowalski";
        person1.pesel = "898909823";

        Address address1 = new Address();
        address1.city = "Warszawa";
        address1.postalCode = "20-333";
        address1.street = "Złota";
        address1.home = 22;
        address1.flat = 4;
        person1.living = address1;
        person1.register = address1;

        BankAccount account1 = new BankAccount();
        account1.owner = person1;
        account1.balance = 10_000;

        Credit credit1 = new Credit();
        credit1.borrowed = person1;
        credit1.cashBorrowed = 5225.5;
        credit1.casRetuned = 0;
        credit1.interesrRate = 0;
        credit1.termMonths = 12;

//      Druga osoba.

        Person person2 = new Person();
        person2.firstName = "Marta";
        person2.lastName = "Kowalska";
        person2.pesel = "91070645628";
        person2.register = new Address();
        person2.register.city = "Kraków";
        person2.register.postalCode = "30-333";
        person2.register.street = "Mickiewicza";
        person2.register.home = 15;
        person2.register.flat = 8;
        person2.living = address1;
        //drugie konto bankowe
        BankAccount account2 = new BankAccount();
        account2.owner = person2;
        account2.balance = 5_000;

        System.out.println("person 1");
        System.out.println(person1.firstName + " " + person1.lastName + " " + person1.pesel);
        System.out.println("Zamieszkała w miejscowości " +address1.city);
        System.out.println("Posiada konto bankowe z kwotą: " + account1.balance + " " + "zł" );
        System.out.println("oraz kredyt na kwotę: " + credit1.cashBorrowed + " " + "zł");

        System.out.println("Person 2:");
        System.out.println(person1.firstName + " " + person1.lastName);
        System.out.println("mieszka w miejscowości: " + person1.living.city);
        System.out.println("posiada konto bankowe z kwotą: " + account1.balance);

        System.out.println("person 3:");
        System.out.println(person2.firstName + " " + person2.lastName);
        System.out.println("mieszka w miejscowości: " + person2.living.city);
        System.out.println("posiada konto bankowe z kwotą: " + account2.balance);
    }
}
