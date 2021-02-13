package calculadora;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
	@DisplayName("Testa a soma de dois números")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);		
		Assertions.assertEquals(9, soma);		
	}
	
	@DisplayName("Testa a subtração de dois números")
	@Test
	public void testSubtracaoDoisNumeros() {
		int subtracao = calc.subtracao(9, 6);		
		Assertions.assertEquals(3, subtracao);		
	}
	
	@DisplayName("Testa a divisão de dois números")
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
	}
	
	@DisplayName("Testa a divisão por zero de dois números")
	@Test
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(8, 0);
			fail("Exceção não lançada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
	@DisplayName("Testa divisão por zero")
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}
	
	@DisplayName("Testa a Multiplicação de dois números")
	@Test
	public void testMultiplicacaoDoisNumeros() {
		int multiplicacao = calc.multiplicacao(3, 5);
		assertTrue(multiplicacao == 15);
	}
	
	@DisplayName("Testa a Somatória de n números")
	@Test
	public void testSomatoriaNNumeros() {
		int somatoria = calc.somatoria(4);
		assertTrue(somatoria == 10);
	}
	
	@DisplayName("Testa se o número é positivo")
	@Test
	public void testNumeroPositivo() {
		boolean ehPositivo = calc.ehPositivo(4);
		assertTrue(ehPositivo == true);
	}
	
	@DisplayName("Testa se o número é positivo")
	@Test
	public void testNumeroNegativo() {
		boolean ehPositivo = calc.ehPositivo(-4);
		assertTrue(ehPositivo == false);
	}
	@DisplayName("Testa a Comparação de dois números iguais")
	@Test
	public void compara() {
		int comparaIguais = calc.compara(3,3);
		assertTrue(comparaIguais == 0);
		int comparaPrimeiroMenor = calc.compara(2,3);
		assertTrue(comparaPrimeiroMenor == -1);
		int comparaPrimeiroMaior = calc.compara(4,3);
		assertTrue(comparaPrimeiroMaior == 1);
	}

}
