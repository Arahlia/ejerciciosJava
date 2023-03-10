import java.util.*;

public class CuerpoCeleste {
    public enum TipoCuerpoCeleste {ESTRELLA, PLANETA, PLANETA_ENANO, LUNA, COMETA, ASTEROIDE};
    private String nombre;
    private  double periodoOrbital;
    private Set<CuerpoCeleste> satelites;
    private TipoCuerpoCeleste tipoCuerpo;

    public CuerpoCeleste(String nombre, double periodoOrbital, TipoCuerpoCeleste tipoCuerpo) {
        this.nombre = nombre;
        this.periodoOrbital = periodoOrbital;
        this.tipoCuerpo = tipoCuerpo;
        this.satelites= new HashSet<CuerpoCeleste>();
    }

    public String getNombre() {
        return nombre;
    }

    public double getPeriodoOrbital() {
        return periodoOrbital;
    }

    public TipoCuerpoCeleste getTipoCuerpo() {
        return tipoCuerpo;
    }

    public HashSet<CuerpoCeleste> getSatelites(){
        return new HashSet<CuerpoCeleste>(satelites);
    }

    @Override
    public String toString() {
        return "CuerpoCeleste{" +
                "nombre='" + nombre + '\'' +
                ", periodoOrbital=" + periodoOrbital +
                ", satelites=" + satelites +
                ", tipoCuerpo=" + tipoCuerpo +
                '}';
    }

    public boolean addSatelite(CuerpoCeleste obj){
        return satelites.add(obj);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CuerpoCeleste that = (CuerpoCeleste) o;
        return Double.compare(that.periodoOrbital, periodoOrbital) == 0 && Objects.equals(nombre, that.nombre) && Objects.equals(satelites, that.satelites) && tipoCuerpo == that.tipoCuerpo;
    }

    @Override
    public int hashCode() {
        Random num = new Random();
        return Objects.hash(nombre, tipoCuerpo) + num.nextInt(100)+1;
    }
}
class Planeta extends CuerpoCeleste {
    public Planeta(String nombre, double periodoOrbital) {
        super(nombre, periodoOrbital, TipoCuerpoCeleste.PLANETA);
    }

    @Override
    public boolean addSatelite(CuerpoCeleste obj) {
        if (obj.getTipoCuerpo() == TipoCuerpoCeleste.LUNA) {
            return super.addSatelite(obj);
        }
        return false;
    }
}
class PlanetaEnano extends CuerpoCeleste {
    public PlanetaEnano(String nombre, double periodoOrbital) {
        super(nombre, periodoOrbital, TipoCuerpoCeleste.PLANETA_ENANO);
    }
}

class Luna extends CuerpoCeleste {
    public Luna(String nombre, double periodoOrbital) {
        super(nombre, periodoOrbital, TipoCuerpoCeleste.LUNA);
    }
}
class Main{
    static Map<String, CuerpoCeleste> sistemaSolar= new HashMap<>();
    static Set<CuerpoCeleste> planetas= new HashSet<>();
    public static void main(String [] args){
    CuerpoCeleste objM= new Planeta("Mercurio",88);
    CuerpoCeleste objV= new Planeta("Venus",225);
    CuerpoCeleste objLT= new Planeta("La Tierra", 365);
    CuerpoCeleste objMA= new Planeta("Marte", 687);
    CuerpoCeleste objJ= new Planeta("Júpiter", 4332);
    CuerpoCeleste objS= new Planeta("Saturno", 10759);
    CuerpoCeleste objU= new Planeta("Urano",30660);
    CuerpoCeleste objN= new Planeta("Neptuno",165);
    CuerpoCeleste objP= new Planeta("Plutón",248);
    planetas.add(objM);
    planetas.add(objV);
    planetas.add(objLT);
    planetas.add(objMA);
    planetas.add(objJ);
    planetas.add(objS);
    planetas.add(objU);
    planetas.add(objN);
    planetas.add(objP);
    sistemaSolar.put("Mercurio", objM);
    sistemaSolar.put("Venus", objV);
    sistemaSolar.put("La Tierra", objLT);
    sistemaSolar.put("Marte", objMA);
    sistemaSolar.put("Júpiter", objJ);
    sistemaSolar.put("Saturno", objS);
    sistemaSolar.put("Urano", objU);
    sistemaSolar.put("Neptuno", objN);
    sistemaSolar.put("Plutón", objP);
    CuerpoCeleste objL= new Luna("Luna",27);
    sistemaSolar.put("Luna", objL);
    objLT.addSatelite(objL);
    CuerpoCeleste objD= new Luna("Deimos", 1.3);
    CuerpoCeleste objPH= new Luna("Phobos", 0.3);
    sistemaSolar.put("Deimos", objD);
    sistemaSolar.put("Phobos", objPH);
    objMA.addSatelite(objD);
    objMA.addSatelite(objPH);
    CuerpoCeleste objI= new Luna("Ío",1.8);
    CuerpoCeleste objE= new Luna("Europa", 3.5);
    CuerpoCeleste objG= new Luna("Ganímedes", 7.1);
    CuerpoCeleste objC= new Luna("Calisto",16.7);
    sistemaSolar.put("Ío", objI);
    sistemaSolar.put("Europa", objE);
    sistemaSolar.put("Ganímedes", objG);
    sistemaSolar.put("Calisto", objC);
    objJ.addSatelite(objI);
    objJ.addSatelite(objE);
    objJ.addSatelite(objG);
    objJ.addSatelite(objC);
    System.out.println("Planetas del Sistema Solar");
    for(CuerpoCeleste c : planetas){
        System.out.println(c.getNombre());
    }
    System.out.println("Satélites de "+sistemaSolar.get("Marte").getNombre()+":");
    for (CuerpoCeleste s : sistemaSolar.get("Marte").getSatelites()){
        System.out.println(s.getNombre());
    }
    Set<CuerpoCeleste> lunas= new HashSet<>();
    for(CuerpoCeleste p : planetas){
        for(CuerpoCeleste s : p.getSatelites()){
            lunas.add(s);
        }
    }
    System.out.println("Todos los satélites: ");
    for(CuerpoCeleste l : lunas){
        System.out.println(l.getNombre());
    }
    CuerpoCeleste objPU= new Planeta("Plutón", 884);
    planetas.add(objPU);
    System.out.println(planetas);
    }
}