package Prac15and16.Items;

public enum DrinkTypeEnum {
    BEER (5),
    WINE (16),
    VODKA (40),
    BRANDY (60),
    CHAMPAGNE (16),
    WHISKEY (50),
    TEQUILA (35),
    RUM (40),
    VERMUTH (18),
    LIQUOR (40),
    JAGERMEISTER (40),
    JUICE (0),
    COFFEE (0),
    GREEN_TEA (0),
    BLACK_TEA (0),
    MILK (0),
    WATER (0),
    SODA (0);

    private final double alcoholVol;

    DrinkTypeEnum(double vol) {
        this.alcoholVol = vol;
    }

    public double getAlcoholVol() {
        return alcoholVol;
    }
}
