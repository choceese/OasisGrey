public class Water {
    private int waterMaxHp;
    private int waterHp = waterMaxHp;

    public Water (int waterMaxHp) {
        this.waterMaxHp = waterMaxHp;
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
