public class App {
    public static void main(String[] args) throws Exception {
        ControleRemoto c = new ControleRemoto();
        c.ligar();
        c.maisVolume();
        c.play();
        c.abrirMenu();
        c.fecharMenu();
    }
}
// este é apenas um código teste!

---------------------------------

public class ControleRemoto implements Controlador {
    //Atributos
    private int volume;
    private boolean ligado;
    private boolean tocando;

    //Métodos Especiais

    //Construtor
    public ControleRemoto(){
        this.volume = 50;
        this.ligado = false;
        this.tocando = false;
    }

    //Getters e Setters
    private int getVolume(){
        return volume;
    }
    
    private void setVolume(int volume){
        this.volume = volume;
    }

    private boolean getLigado(){
        return ligado;
    }
    
    private void setLigado(boolean ligado){
        this.ligado = ligado;
    }

    private boolean getTocando(){
        return tocando;
    }

    private void setTocando(boolean tocando){
        this.tocando = tocando;
    }

    //Métodos Abstratos

    @Override
    public void ligar(){
        this.setLigado(true);
    }

    @Override
    public void desligar(){
        this.setLigado(false);
    }

    @Override
    public void abrirMenu(){
        if(this.getLigado()){
            System.out.println("----MENU----");
            System.out.println("Está Ligado? " + this.getLigado());
            System.out.println("Está Tocando? " + this.getTocando());
            System.out.println("Qual Volume? " + this.getVolume());
            for(int i = 0; i <= this.getVolume(); i+= 10){
                System.out.print("[]");
                System.out.println();
            }
        }else{
            System.out.println("Para abrir o Menu, ligue o aparelho!");
        }
    }

    @Override
    public void fecharMenu(){
        if(this.getLigado()){
            System.out.println("Fechando Menu...");
        }else{
            System.out.println("Para fechar o Menu, ligue o aparelho!");
        }
    }

    @Override
    public void maisVolume(){
        if (this.getLigado()) {
            this.setVolume(this.getVolume() + 5);
        }else{
            System.out.println("Para aumentar o volume, ligue o aparelho!");
        }
    }

    @Override
    public void menosVolume(){
        if (this.getLigado()) {
            this.setVolume(this.getVolume() - 5);
        }else{
            System.out.println("Para diminuir o volume, ligue o aparelho!");
        }
    }

    @Override
    public void ligarMudo(){
        if (this.getLigado() && this.getVolume() > 0) {
            this.setVolume(0);
        }else{
            System.out.println("Para ativar o mudo, ligue o aparelho!");
        }
    }

    @Override
    public void desligarMudo(){
        if (this.getLigado() && this.getVolume() == 0) {
            this.setVolume(50);
        }else{
            System.out.println("Para desativar o mudo, ligue o aparelho!");
        }
    }

    @Override
    public void play(){
        if (this.getLigado() && !(this.getTocando())) {
            this.setTocando(true);
        }else{
            System.out.println("Para dar play, ligue o aparelho!");
        }
    }

    @Override
    public void pause(){
        if (this.getLigado() && this.getTocando()) {
            this.setTocando(false);
        }else{
            System.out.println("Para dar pause, ligue o aparelho!");
        }
    }
}

---------------------------------

public interface Controlador {
    //Métodos Abstratos
    public abstract void ligar();
    public abstract void desligar();
    public abstract void abrirMenu();
    public abstract void fecharMenu();
    public abstract void maisVolume();
    public abstract void menosVolume();
    public abstract void ligarMudo();
    public abstract void desligarMudo();
    public abstract void play();
    public abstract void pause();
}
