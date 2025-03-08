public class Carro {
    String modelo;
    double precoDia = 0.0;
    double precoHora = 0.0;
    double precoTotal = 0.0;
    double getPrecoDia() {
        return precoDia;
    }

    void setPrecoDia(double preco) { // Alterado para void e o tipo do parâmetro para double
        this.precoDia = preco;
    }
    double getPrecoHora(){
        return precoHora;
    }
    void setPrecoHora(double precoHora) { // Alterado para void e o tipo do parâmetro para double
        this.precoHora = precoHora;
    }

    double precoTotal(){
        this.precoTotal = this.precoDia + this.precoHora;
        return this.precoTotal;
    }

    String getModelo() {
        return modelo;
    }
    void setModelo(String modelo) {
        this.modelo = modelo;
    }
    enum modeloCarro {
        SEDAN, HATCH, SUV, ESPORTIVO
    }
}
