package carrinho;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import produto.Produto;
import produto.ProdutoNaoEncontradoException;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarrinhoTest {
	
	Carrinho carrinho;
	Produto caneta;
	Produto caderno;

	
	@BeforeEach
	public void inicializa() {
		carrinho = new Carrinho();
		caneta = new Produto("Caneta", 2.00);
		caderno = new Produto("Caderno", 20.00);
	}
	
	@DisplayName("Testa a adição de item no carrinho")
	@Test
	public void testAdicionaProduto() {
		carrinho.addItem(caneta);
		assertTrue(carrinho.getQtdeItems() == 1);
	}
	
	@DisplayName("Testa a remoção de item no carrinho")
	@Test
	public void testRemoveProduto() throws ProdutoNaoEncontradoException {
		carrinho.addItem(caneta);
		carrinho.removeItem(caneta);
		assertTrue(carrinho.getQtdeItems() == 0);
	}
	
	@DisplayName("Testa a remoção de item inexistente no carrinho")
	@Test
	public void testRemoveProdutoInexistente() {
		ProdutoNaoEncontradoException thrown = assertThrows(
				ProdutoNaoEncontradoException.class,
	           () -> carrinho.removeItem(caderno)
	    );
		//System.out.println(thrown.getMessage());

	    equals(thrown.getMessage() == null);
	}
	
	@DisplayName("Testa a remoção de item quando o carrinho tem mais de um item")
	@Test
	public void testRemoveProdutoDuplicado() throws ProdutoNaoEncontradoException {
		carrinho.addItem(caneta);
		carrinho.addItem(caneta);
		carrinho.removeItem(caneta);
		assertTrue(carrinho.getQtdeItems() == 1);
	}
	
	/*@Test
	public void testRemoveProdutoInexistente() throws ProdutoNaoEncontradoException {
		try {
			carrinho.addItem(caneta);
			carrinho.removeItem(caderno);
		}catch (ArithmeticException e) {
			assertEquals(null, e.getMessage());
			}
		
		//assertTrue(carrinho.getQtdeItems() == 0);
	} */
	
	@DisplayName("Testa o esvaziamento do carrinho")
	@Test
	public void testEsvaziaCarrinho() {
		carrinho.addItem(caneta);
		carrinho.addItem(caderno);
		carrinho.addItem(caneta);
		assertTrue(carrinho.getQtdeItems() == 3);
		carrinho.esvazia();
		assertTrue(carrinho.getQtdeItems() == 0);
		assertTrue(carrinho.getValorTotal() == 0.00);
	}
	
	@DisplayName("Testa o valor total dos itens do carrinho")
	@Test
	public void testValorTotal() {
		carrinho.addItem(caneta);
		carrinho.addItem(caderno);
		assertTrue(carrinho.getValorTotal() == 22.00);
		
	}
	
	@DisplayName("Testa o valor total dos itens do removendo itens do carrinho")
	@Test
	public void testValorTotalRemovendoProdutos() throws ProdutoNaoEncontradoException {
		carrinho.addItem(caneta);
		carrinho.addItem(caderno);
		assertTrue(carrinho.getValorTotal() == 22.00);
		carrinho.removeItem(caneta);
		assertTrue(carrinho.getValorTotal() == 20.00);
		carrinho.removeItem(caderno);
		assertTrue(carrinho.getValorTotal() == 0.00);
		
	}

}
