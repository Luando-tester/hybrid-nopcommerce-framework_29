package phuongHoaXuan;


public class LeHoan {
    public static void main(String[] args){
        DinhBoLinh dinhBoLinh = new DinhBoLinh();
//        dinhBoLinh.espresso = "Cfe";
        dinhBoLinh.setEspresso("Cfe");
        System.out.println(dinhBoLinh);
        dinhBoLinh.cappuchino = "Cappuchino Le Hoan";
        System.out.println(dinhBoLinh.getCappuchino());

        dinhBoLinh.cherry = "Capuchino Le Hoan";
        System.out.println(dinhBoLinh.getCherry());

        dinhBoLinh.catimor = "Catimor Le Hoan";
        System.out.println(dinhBoLinh.getCatimor());

        dinhBoLinh.monokai = "ABCD";
        DinhBoLinh.monokai = "ABCD";

    }
}
