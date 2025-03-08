public class Imposto {
    double taxa = 0.0;

    double CalcTax(Carro carro, double value) {
        if(value >= 100){
            taxa = 0.2;
        } else {
            taxa = 0.15;
        }
        return carro.precoTotal() * taxa;
    }
    double getTaxa(){
        return taxa;
    }
}
