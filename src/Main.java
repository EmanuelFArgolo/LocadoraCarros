import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int horaRetirada;
        int horaDevolucao;
        int diaRetirada;
        int diaDevolucao;
        double precoModelo = 0.0;
        int modelo;
        Carro carro = new Carro();
        Imposto imposto = new Imposto();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o modelo do carro: \n1 - SEDAN\n2 - HATCH\n3 - SUV\n4 - ESPORTIVO\n");
        do {
            modelo = scanner.nextInt();
        } while(modelo < 1 || modelo > 4);
        switch(modelo){
            case 1:
                carro.setModelo("SEDAN");
                carro.setPrecoDia(100.0);
                carro.setPrecoHora(10.0);
                break;
            case 2:
                carro.setModelo("HATCH");
                carro.setPrecoDia(80.0);
                carro.setPrecoHora(8.0);
                break;
            case 3:
                carro.setModelo("SUV");
                carro.setPrecoDia(120.0);
                carro.setPrecoHora(12.0);
                break;
            case 4:
                carro.setModelo("ESPORTIVO");
                carro.setPrecoDia(150.0);
                carro.setPrecoHora(15.0);
                break;
        }

        System.out.println("Informe o dia de retirada do carro: \n");
        diaRetirada = scanner.nextInt();
        System.out.println("Informe a hora de retirada do carro: \n");
        horaRetirada = scanner.nextInt();
        System.out.println("Informe o dia de devolucao do carro: \n");
        diaDevolucao = scanner.nextInt();
        System.out.println("Informe a hora de devolucao do carro: \n");
        horaDevolucao = scanner.nextInt();

        if(diaDevolucao == diaRetirada && horaDevolucao - horaRetirada <= 12){
            System.out.println("Else if dia igual e hora menor que 12");

            carro.setPrecoDia(0.0);
            precoModelo = carro.getPrecoHora() * (horaDevolucao - horaRetirada);
        } else if(diaDevolucao == diaRetirada && horaDevolucao - horaRetirada > 12){
            System.out.println("Else if dia igual e hora maior que 12");
            precoModelo = carro.getPrecoDia();
            System.out.println("Preco modelo: " + precoModelo);
            carro.setPrecoHora(0.0);

        } else if(diaDevolucao != diaRetirada && horaDevolucao <= horaRetirada ){
            System.out.println("Else if dia diferente e hora menor que 12");
            precoModelo = carro.getPrecoDia() * (diaDevolucao - diaRetirada);
            carro.setPrecoHora(0.0);
        } else if (diaDevolucao != diaRetirada && horaDevolucao > horaRetirada){
            System.out.println("Else if dia diferente e hora maior que 12");
            precoModelo = carro.getPrecoDia() * (diaDevolucao - diaRetirada) + carro.getPrecoHora() * (horaDevolucao - horaRetirada);
        }
       double impostoFinal = imposto.CalcTax(carro, precoModelo);

        System.out.println("\nModelo: " + carro.getModelo());

        double precoTotal = precoModelo + impostoFinal;
        System.out.println("\nPreco total: " + precoTotal);
        double TaxaDolares = precoModelo * imposto.getTaxa();
        System.out.println("\nTaxa: " + (imposto.getTaxa()*100) + "%");
        System.out.println("\nPreco total do imposto: " + TaxaDolares);
        scanner.close();
    }
}