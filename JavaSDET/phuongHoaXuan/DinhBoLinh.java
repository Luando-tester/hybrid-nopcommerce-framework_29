package phuongHoaXuan;

public class DinhBoLinh {
    private String espresso;
    public void setEspresso(String espresso){
        this.espresso= espresso;
    }
    private String getEspresso(){
        return espresso;
    }

    protected String catimor;

    protected String getCatimor(){
        return catimor;
    }

    protected String cappuchino;

    protected String getCappuchino(){
        return cappuchino;
    }

    protected String cherry;

    protected String getCherry(){
        return cherry;
    }
    public static String monokai;

    public static String getMonokai(){
        return monokai;
    }

    public static void main(String[] args){
        DinhBoLinh dinhBoLinh = new DinhBoLinh();
        dinhBoLinh.espresso = "Espresso";
        System.out.println(dinhBoLinh.getEspresso());

        dinhBoLinh.cappuchino = "Cappuchino";
        System.out.println(dinhBoLinh.getCappuchino());

        dinhBoLinh.cherry = "Cherry";
        System.out.println(dinhBoLinh.getCherry());

        dinhBoLinh.catimor = "Catimor";
        System.out.println(dinhBoLinh.getCatimor());

        //catimor = "AZCafe";

        monokai = "";

        getMonokai();
    }
}
