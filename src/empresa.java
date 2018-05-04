import java.util.List;

public class empresa {

    private LightBulb bombita;
    private BinarySearchTree<LightBulb> arbolDeBombitas = new BinarySearchTree<>();

    public empresa(List<LightBulb> f ) {    //esto lo pongo adentro del constictor de empresa  porque el enunciado da a entender que lo primero que hace la empresa es pasar la lista que tenian a un arbol
        for (LightBulb e : f) {             // pero no se si esta bien asi
            arbolDeBombitas.insert(e);
        }
    }


    public void PasarDeListaArbol(List<LightBulb> f ) {
        for (LightBulb e : f) {
            arbolDeBombitas.insert(e);
        }
    } //este es por si despues me quieren pasar otra lista mas y que tambien lo agregue al arbol, pero no se si va porque supuestamente es una sola lista

    public LightBulb buscarPorCodigoDeBombitaParaModificarStock(String e, int cantidad){
      return   buscarPorCodigoDeBombita(e,arbolDeBombitas,cantidad);
    }

private LightBulb buscarPorCodigoDeBombita(String codigo, BinarySearchTree<LightBulb> arbolConLasBombitas, int cantidad){
    String obtenerCodigo=arbolConLasBombitas.getRoot().getCodigoDeLampara();

    if (codigo.equals(obtenerCodigo)){
        ModificarStockDeUnaBombita(arbolConLasBombitas.getRoot(),cantidad);
        return arbolConLasBombitas.getRoot();
    }
    if (codigo.compareTo(obtenerCodigo) < 0 && !arbolConLasBombitas.getLeft().isLeaf()) { //no se si esto anda pero quiero que se vaya guiando por el codigo de la bombita, fijate vos
        return buscarPorCodigoDeBombita(codigo, arbolConLasBombitas.getLeft(), cantidad);// aca es toodo sin test asique seguro rompe en algun lado
    } else if (!arbolConLasBombitas.getRight().isLeaf()){
        return buscarPorCodigoDeBombita(codigo,arbolConLasBombitas.getRight(),cantidad);
    }else {
        throw new RuntimeException("no ta");
    }
}

    public void ModificarStockDeUnaBombita(LightBulb e, int cantidad){
        if(cantidad>0){
            e.ActualizarStock(cantidad);
        }else{
            if(e.getStock()>-cantidad){
                e.ActualizarStock(cantidad);
            }throw new RuntimeException("No hay tantas bombitas");
        }
    } //esto lo hago para que me reste o sume del stock y lo saco afuera asi no me queda tan largo el de buscar por codigo

    public void AgregarXCantidadDeUnaBombitaQueNoEsta(LightBulb e, int cantidad) {
        if (cantidad <= 0) throw new RuntimeException("No se puede ingresar una cantidad negativa o nula");
        if (arbolDeBombitas.exists(e)) {
            e.ActualizarStock(cantidad);
        } else {
            arbolDeBombitas.insert(e);
            e.ActualizarStock(cantidad-1);
        }
    }

    public void RemoverLaBombitaDelInvetario(String codigoDeBombitaAEliminar) {
        try {
            arbolDeBombitas.eliminate(buscarPorCodigoDeBombitaParaModificarStock(codigoDeBombitaAEliminar,0));
        }catch (Exception e){
            e.getMessage();
        }
    }

    //todo, falta el  imprimir el informe
}
