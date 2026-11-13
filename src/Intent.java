class Intent {
    String label;   // shown to the player, e.g. "Bite"
    String type;    // "ATTACK", "HEAL", "CHARGE", ...
    int value;      // damage, heal amount, etc.
    int weight;     // how likely this is, relative to the other options

    Intent(String label, String type, int value, int weight) {
        this.label = label;
        this.type = type;
        this.value = value;
        this.weight = weight;
    }

    String describe() {
        return label + ": " + type + " " + value;
    }
}