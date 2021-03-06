package conta;

public abstract class Conta implements Comparable<Conta> {

    protected double saldo;
	protected int numero;
	private String nome;

    public Conta(int numero, String nome) {
    	this.numero = numero;
    	this.nome = nome;
    }

	public String getNome() {
		return nome;
	}

	public int getNumero() {
		return numero;
	}

    public void deposita(double valor) {
    	if (valor < 0) {
    		throw new ValorInvalidoException(valor);
	    } else {
		    this.saldo += valor - 0.10;
	    }
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public abstract void atualiza(double taxa);

    public void saca(double valor) {
        if (valor > saldo) {
            System.out.println("Nao e possivel sacar!");
        } else {
            this.saldo -= valor;
        }
    }

	@Override
	public String toString() {
		return "Conta " + this.getNumero() + ", saldo R$ " + this.saldo;
	}

//	@Override
//	public boolean equals(Object obj) {
//    	Conta outraConta = (Conta) obj;
//		return this.numero == outraConta.numero && this.nome == outraConta.nome;
//	}

	@Override
	public int compareTo(Conta o) {

    	return this.getNome().compareTo(o.getNome());
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void imprimeNome(String nome) {
		String[] nomeSeparado = nome.split(" ");
		for (int i = 0; i < nomeSeparado.length; i++) {
			System.out.print(nomeSeparado[nomeSeparado.length - 1 - i] + " ");
		}
	}

	public int converteString(String string) {
    	int[] n = new int[string.length()];
    	int intConvertido = 0;

    	for (int i = 0; i < string.length(); i++) {
    		n[i] = (int) ((string.charAt(i) - '0')*Math.pow(10, string.length() - 1 - i));
    		System.out.println(n[i]);
	    }

	    for (int i = 0; i < n.length; i++) {
		    intConvertido += n[i];
	    }

	    return intConvertido;
	}

	// Aula 5, Exercício 16
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numero;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (numero != other.numero)
			return false;
		return true;
	}
}