public class SwimmingArea {
    private String areaName;
    private int occupants;
    private boolean[] lights;
    
    public SwimmingArea() {
        this.areaName = "Swimming Pool Area";
        this.occupants = 0;
        this.lights = new boolean[3];
    }
    
    public void addOccupants(int n) {
        if (n > 0) {
            occupants += n;
        }
    }
    
    public void removeOccupants(int n) {
        if (n > 0) {
            occupants = Math.max(0, occupants - n);
        }
    }
    
    public void switchOnLight(int lightNumber) {
        if (lightNumber >= 1 && lightNumber <= 3) {
            lights[lightNumber - 1] = true;
        }
    }
    
    public void switchOffLight(int lightNumber) {
        if (lightNumber >= 1 && lightNumber <= 3) {
            lights[lightNumber - 1] = false;
        }
    }
    
    public void reportStatus() {
        System.out.println("\n--- " + areaName + " Status ---");
        System.out.println("Occupants: " + occupants);
        System.out.print("Lights: ");
        for (int i = 0; i < lights.length; i++) {
            System.out.print("Light " + (i + 1) + ": " + (lights[i] ? "ON" : "OFF"));
            if (i < lights.length - 1) System.out.print(", ");
        }
        System.out.println("\n-----------------------------");
    }
    
    // Getters
    public String getAreaName() { return areaName; }
    public int getOccupants() { return occupants; }
    public boolean[] getLights() { return lights; }
}
