public class Water {
    private int waterMaxHp;
    private int waterHp;

    public Water (int waterMaxHp) {
        this.waterMaxHp = waterMaxHp;
        this.waterHp = waterMaxHp;
    }

    public void takeEvaporate(int damage) {
        waterHp -= damage;
        if (waterHp < 0) {
            waterHp = 0;
        }
    }
    public int getWater() {
        return waterHp;
    }
}
