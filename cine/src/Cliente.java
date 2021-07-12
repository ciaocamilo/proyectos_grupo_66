public class Cliente extends Persona implements Tiquete{

    private int id;

    @Override
    public float calcularCosto(float costoBase) {
        float costoReal = costoBase - 1000;
        return costoReal;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Cedula = " + this.cedula
                        + " Nombre = " + this.nombre
                        + " ID = " + this.id);
    }

}
