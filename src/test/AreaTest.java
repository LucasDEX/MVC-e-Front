package test;


import static org.junit.Assert.assertEquals;
import model.Area;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import service.AreaService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AreaTest {
	Area area, copia;
	AreaService areaService;
	static int id = 0;

	/*
	 * Antes de rodar este teste, certifique-se que nao ha no banco nenhuma
	 * linha com o id igual ao do escolhido para o to instanciado abaixo. Se
	 * houver, delete. 
	 * Certifique-se também que sobrecarregou o equals na classe
	 * area. 
	 * Certifique-se que a fixture area1 foi criada no banco.
	 * Além disso, a ordem de execução dos testes é importante; por
	 * isso a anotação FixMethodOrder logo acima do nome desta classe
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		area = new Area();
		area.setId(id);
		area.setNome("Estrutura");
		copia = new Area();
		copia.setId(id);
		copia.setNome("Estrutura");
		areaService = new AreaService();
		System.out.println(area);
		System.out.println(copia);
		System.out.println(id);
	}
	
	@Test
	public void test00Carregar() {
		System.out.println("carregar");
		//para funcionar o area 1 deve ter sido carregado no banco por fora
		Area fixture = new Area();
		fixture.setId(2);
		fixture.setNome("Academica");
		AreaService novoService = new AreaService();
		Area novo = novoService.carregar(2);
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test01Criar() {
		System.out.println("criar");
		id = areaService.criar(area);
		System.out.println(id);
		copia.setId(id);
		assertEquals("testa criacao", area, copia);
	}

	@Test
	public void test02Atualizar() {
		System.out.println("atualizar");		
		areaService.atualizar(area);
		area = areaService.carregar(area.getId());
		assertEquals("testa atualizacao", area, copia);
	}

	@Test
	public void test03Excluir() {
		System.out.println("excluir");
		copia.setId(-1);
		copia.setNome(null);
		areaService.excluir(id);
		area = areaService.carregar(id);
		assertEquals("testa exclusao", area, copia);
	}
}