public class LightBulb implements Comparable<LightBulb> {
    private String codigoDeLampara;
    private String TipoDeLampara;
    private int watts;
    private int stock;

    public LightBulb(String codigoDeLampara, String tipoDeLampara, int watts) {
       if (codigoDeLampara.length()!=5){
           throw new RuntimeException("codigo de lampara mal");
       }
        else{
           this.codigoDeLampara = codigoDeLampara;
       }
       if (tipoDeLampara.length()==10){
        TipoDeLampara = tipoDeLampara;
       }
       else{ throw new RuntimeException("mal el tipo de lamapra");
       }
        this.watts = watts;
        this.stock = 1;
    }

    public void ActualizarStock(int cantidad){
        this.stock+=cantidad;
    }

    public String getCodigoDeLampara() {
        return codigoDeLampara;
    }

    public String getTipoDeLampara() {
        return TipoDeLampara;
    }

    public int getWatts() {
        return watts;
    }

    public int getStock() {
        return stock;
    }



    @Override
    public int compareTo(LightBulb o) {

        if (this.codigoDeLampara.compareTo(o.codigoDeLampara)>0){
            return 1;
        }else if (this.codigoDeLampara.compareTo(o.codigoDeLampara)<0){
            return -1;
        }
        return 0;

    }
}
