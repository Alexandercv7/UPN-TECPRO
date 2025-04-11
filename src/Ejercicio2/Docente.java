package Ejercicio2;

import java.text.DecimalFormat;

public class Docente {
   
    //Atributos
    private String nombre;
    private String codigo;
    private String categoria;
    private String estudios;
    private int horas;
    static final double PORSEG = 0.03;
    private static int contador = 0;

    public static int getContador() {        return contador;    }
    public static void setContador(int aContador) {        contador = aContador;    }
    public String getNombre() {        return nombre;    }
    public void setNombre(String nombre) {        this.nombre = nombre;    }
    public String getCodigo() {        return codigo;    }
    public void setCodigo(String codigo) {        this.codigo = codigo;    }
    public String getCategoria() {        return categoria;    }
    public void setCategoria(String categoria) {        this.categoria = categoria;    }
    public String getEstudios() {        return estudios;    }
    public void setEstudios(String estudios) {        this.estudios = estudios;    }
    public int getHoras() {        return horas;    }
    public void setHoras(int horas) {        this.horas = horas;    }
    
    //constructor
    //generar el codigo autogenerado
    
    public Docente(){
        contador++; //Incrementando contador
        //Creando formato para el DecimalFormat
        DecimalFormat df = new DecimalFormat("DOC0000");
        //Le damos el formato al contador y se almacena en la variable codigo
        codigo = df.format(contador);
    }
    
    public double pagHora(){
        if(categoria.equals("Principal")) return 25.00;
        else if (categoria.equals("Asociado")) return 18.00;
        else return 15.00;
    }
    
    double pagParcial(){
        return horas*pagHora();
    }
    
    public double bonificacion(){
        if(categoria.equals("Principal")&& estudios.equals("Doctorado"))
            return (pagParcial()*0.20);
        if(categoria.equals("Principal")&& estudios.equals("Maestria"))
            return (pagParcial()*0.17);
        if(categoria.equals("Asociado")&& estudios.equals("Doctorado"))
            return (pagParcial()*0.15);
        if(categoria.equals("Asociado")&& estudios.equals("Maestria"))
            return (pagParcial()*0.10);
        if(categoria.equals("Auxiliar")&& estudios.equals("Doctorado"))
            return (pagParcial()*0.12);
        if(categoria.equals("Auxiliar")&& estudios.equals("Maestria"))
            return (pagParcial()*0.08);
        return 0;
    }
    
    public double descuento(){
        return (pagParcial()*PORSEG);
    }
    
    public double sueldoFinal(){
        return (pagParcial()+bonificacion())-descuento();
    }
    
    public String mostrarDatos(){
        
        DecimalFormat df = new DecimalFormat("#.##");
        String texto = "\n Codigo: " + codigo+
               " || Nombre: " + nombre+
               " || Categoria: " + categoria+
               " || Estudios Postgrado: " + estudios+
               " || Horas Clase: " + horas+
               " || Pago Parcial: S/." + df.format(pagParcial())+
               " || Bonificación: S/." + df.format(bonificacion())+
               " || Descuento: S/." + df.format(descuento())+
               " || Sueldo final: S/." + df.format(sueldoFinal());
        
        return texto;
    }
}
