public class CajeroAutomatico {
    private double saldo;

    public CajeroAutomatico(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void consultarSaldo() {
        System.out.println("🔎 Tu saldo actual es: $" + saldo);
    }

    public void depositar(double monto) {
        if (monto <= 0) {
            System.out.println("⚠️ El monto debe ser mayor a 0.");
            return;
        }
        saldo += monto;
        System.out.println("✅ Depósito realizado. \nSaldo actualizado: $" + saldo);
    }

    public void retirar(double monto) {
        if (monto <= 0) {
            System.out.println("⚠️ El monto debe ser mayor a 0.");
            return;
        }
        if (monto > saldo) {
            System.out.println("❌ Saldo insuficiente. \nTu saldo es: $" + saldo);
        } else {
            saldo -= monto;
            System.out.println("✅ Retiro exitoso. \nSaldo restante: $" + saldo);
        }
    }
}
