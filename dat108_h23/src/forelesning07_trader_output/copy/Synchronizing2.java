package forelesning07_trader_output.copy;


/* I dette eksempelet bruker vi blokk-synkronisering for å
 * oppnå trådsikkerhet i stedet for metode-synkronisering. 
 * 
 * I dette eksempelet oppretter vi to tråder (thread1 og hread2) 
 * som deler samme Printer-objekt. Inne i printNumbers-metoden 
 * bruker vi synchronized (this) for å sikre at bare én tråd kan 
 * skrive ut tallene samtidig. Som et resultat vil tallene bli 
 * skrevet ut i rekkefølge, selv om to tråder deler samme ressurs.
 * 
 */

public class Synchronizing2 {
    public static void main(String[] args) {
        Printer printer = new Printer();

        Thread thread1 = new Thread(() -> {
            printer.printNumbers();
        });

        Thread thread2 = new Thread(() -> {
            printer.printNumbers();
        });

        thread1.start();
        thread2.start();
    }
}

/*
 * En enkel klasse Printer som skriver ut tall i en 
 * synkronisert blokk.
 * 
 */

class Printer {
    public void printNumbers() {
        synchronized (this) {
            for (int i = 1; i <= 10; i++) {
                System.out.println(i);
            }
        }
    }
}

/* PS:
 * 
 * this-referansen: this refererer til den gjeldende 
 * instansen av objektet. Når du merker en kodeblokk 
 * som "synchronized (this)", betyr det at du bruker 
 * den gjeldende instansen som et låsobjekt. Dette 
 * innebærer at bare én tråd kan få tilgang til denne 
 * koden inne i blokken for denne spesifikke instansen. 
 * Dette er nyttig når du har flere tråder som deler 
 * samme objekt og du vil kontrollere tilgangen til 
 * objektets ressurser.
 * 
 */
