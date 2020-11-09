public class Inventory {
    public int safeKey;
    public int gateKey;
    public int houseKey;

    public Inventory() {
        gateKey = 0;
        safeKey = 0;
        houseKey =0;
    }

    public void addGateKey() { gateKey++; }
    public void addSafeKey() { safeKey++; }
    public void addHouseKey() { houseKey++; }

   // public int getHousekey() { return(houseKey); }

    public void readInventory() {
        System.out.println("Your inventory is:");
        String out;
        if (safeKey >= 1) {
            System.out.println("- 1 safeKey");
        }
        if (gateKey >= 1) {
            System.out.println("- 1 gateKey");
        }
        if (houseKey >= 1) {
            System.out.println("- 1 houseKey");
        }
    }
}
