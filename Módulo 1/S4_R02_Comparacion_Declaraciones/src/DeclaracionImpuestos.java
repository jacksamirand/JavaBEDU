public record DeclaracionImpuestos(String rfcContibuyente, double montoDeclarado) {
    @Override
    public String toString(){
        return "📄 Declaración enviada por RFC: " + rfcContibuyente + " por $" + montoDeclarado;
    }

}
