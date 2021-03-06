package doller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * 
 * @author ghcjssla
 * 1장
 * 1.테스트 목록을 만들었다.
 * 2.오퍼레이션(메서드)이 외부에서 어떻게 보이길 원하는지 말해주는 이야기를 코드로 표현
 * 3.JUnit에 대한 사항들은 잠시 무시
 * 4. 스텁 구현을 통해 테스트를 컴파일 *스텁 이 메서드가 일단 컴파일되게끔 돌아가게 만들어줌
 * 5. 끔찍한 죄악을 통해 테스트를 통과시킴
 * 6. 돌아가는 코드에서 상수를 변수로 변경하여 점진적으로 일반화
 * 7. 새로운 할일들을 한번에 처리하는 대신 할일 목록에 추가하고 넘어감
 * 
 * 2장
 * 1. 설계상의 결함(Dollar 부작용)을 그 결함으로 인해 실패하는 테스트로 변환
 * 2. 스텁 구현으로 빠르게 컴파일을 통과하도록 만듬
 * 3. 올바르다고 생각하는 코드를 입력하여 테스트를 통과
 * 
 * 3장
 * 1.우리의 디자인 패턴(value object pattern)이 하나의 또 다른 오퍼레이션을 암시한다는 걸 알아챘다.
 * 2.해당 오퍼레이션을 테스트했다.
 * 3.해당 오퍼레이션을 간단히 구현했다.
 * 4.곧장 리팩토링하는 대신 테스트를 조금 더 했다.
 * 5. 두 경우를 모두 수용할 수 있도록 리팩토링했다.
 * 
 * 4장
 * 1.오직 테스트를 향상시키기 위해서만 개발된 기능을 사아ㅛㅇ했다.
 * 2.두 테스트가 동시에 실패하면 망한다는 점을 인식했다.
 * 3.위험 요소가 있음에도 계속 진행했다.
 * 4.테스트와 코드 사이의 결합도를 낮추기 위해, 테스트하는 객체의 새 기능을 사용했다.
 * 
 * 5장
 * 1.큰 테스트를 공략할 수 없다. 그래서 진전을 나타낼 수 있는 자그마한 테스트를 만들었다.
 * 2.뻔뻔스럽게도 중복을 만들고 조금 고쳐서 테스틑를 작성했다.
 * 3.설상가상으로 모델 코드까지 도매금으로 복사하고 수정해서 테스트를 통과했다.
 * 4.중복이 사라지기 전에는 집에 가지 않겠다고 약속했다.
 * 
 * 6장
 * 1.공통된 코드를 첫 번째 클래스(Dollar)에서 상위 클래스(Money)로 단계적으로 옮겼다.
 * 2.두 번째 클래스(Franc)도 Money의 하위클래스로 만들었다.
 * 3.불필요한 구현을 제거하기 전에 두 equals() 구현을 일치시켰다.
 * 
 * 7장
 * 1.우릴 괴롭히던 결함을 끄집어내서 테스트에 담아냈다.
 * 2.완벽하진 않지만 그럭저럭 봐줄만한 방법(getClass())으로 테스트를 통과하게 만들었다.
 * 3.더 많은 동기가 있기 전에는 더 많은 설계를 도입하지 않기로 했다.
 * 
 * 8장
 * 1.동일한 메서드(times)의 두 변이혀 메서드 서명부를 통일시킴으로써 중복 제거를 향해 한 단계 더 전진했다.
 * 2.최소한 메서드 선언부만이라도 공통 상위 클래스(superclass)로 옮겼다.
 * 3.팩토리 메서드를 도입하여 테스트 코드에서 콘크리트 하위 클래스의 존재 사실을 분리해냈다.
 * 4.하위 클래스가 사라지면 몇몇 테스트는 불필요한 여분의 것이 된다는 것을 인식했다. 하지만 일단 그냥 뒀다.
 * 
 * 9장
 * 1. 큰 설계 아이디어를 다루다가 조금 곤경에 빠졌다. 그래서 좀 전에 주목했던 더 작은 작업을 수행했다.
 * 2. 다른 부분들을 호출자(팩토리 메서드)로 옮김으로써 두 생성자를 일치 시켰다.
 * 3. times()가 팩토리 메서드를 사용하도록 만들기 위해 리팩토링을 잠시 중단했다.
 * 4. 비슷한 리팩토링*Franc에 했던 일을 Dollar에도 적용)을 한번의 큰 단계로 처리했다.
 * 5. 동일한 생성자들을 상위 클래스로 올렸다.
 * 
 * 10장
 * 1. 두 times()를 일치시키기 위해 그 메서드들이 호출하는 다른 메서드들을 인라인시킨 후 상수를 변수로 바꿔주었다.
 * 2. 단지 디버깅을 위해 테스트 없이 toString()을 작성했다.
 * 3. Franc 대신 Money를 반환하는 변경을 시도한 뒤 그것이 잘 작동할지를 테스트가 말하도록 했다.
 * 4. 실험해본 걸 뒤로 물리고 또 다른 테스트를 작성했다. 테스트를 작동 했더니 실험도 제대로 작동했다.
 * 
 * 11장
 * 1. 하위 클래스의 속을 들어내는 걸 완료하고, 하위 클래스를 삭제했다.
 * 2. 기존의 소스 구조에서는 필요했지만 새로운 구조에서는 필요 없게 된 테스트를 제거했다.
 * 
 * 12장
 * 1. 큰 테스트를 작은테스트($5+10CHF에서 $5+$5로)로 줄여서 발전을 나타낼 수 있도록 했다.
 * 2. 우리에게 필요한 계산(computation)에 대한 가능한 메타포들을 신중히 생각해봤다.
 * 3. 새 메타포에 기반하여 기존의 테스트를 재작성했다.
 * 4. 테스트를 빠르게 컴파일 했다.
 * 5. 그리고 테스트를 실행했다.
 * 6. 진짜 구현을 만들기 위해 필요한 리팩토링을 약간의 전율과 함께 기대했다. 응??
 * 
 * 13장
 * 1. 모든 중복이 제거되기 전까지는 테스트를 통과한 것으로 치지 않았다.
 * 2. 구현하기 위해 역방향이 아닌 순방향으로 작업했다.
 * 3. 앞으로 필요할 것으로 예상되는 객체(Sum)의 생성을 강요하기 위한 테스트를 작성했다.
 * 4. 빠른 속도로 구현하기 시작했다(Sum)생성자
 * 5.일단 한 곳에 캐스팅을 이용해서 코드를 구현했다가, 테스트가 돌아가자 그 코드를 적당한 자리로 옮겼다.
 * 6. 명시적인 클래스 검사를 제거하기 위해 다형성을 사용했다.
 * 
 * 14장
 * 1. 필요할 거라고 생각한 인자를 빠르게 추가했다.
 * 2. 코드와 테스트 사이에 있는 데이터 중복을 끄집어냈다.
 * 3. 자바의 오퍼레이션에 대한 가정을 검사해보기 위한 테스트(testArrayEquals)를 작성했다.
 * 4. 별도의 테스트 없이 전용(private) 도우미(helper)클래스를 만들었다.
 * 5. 리팩토링하다가 실수를 했고, 그 문제를 분리하기 위해 또 하나의 테스트를 작성하면서 계속 전진해 가기로 선택했다.
 * 
 * 15장
 * 1. 원하는 테스트를 작성하고, 한 단계에 달성할 수 있도록 뒤로 물렀다.
 * 2. 좀더 추상적인 선언을 통해 가지에서 뿌리(애초의 테스트 케이스)로 일반화 했다.
 * 3. 변경 후(Expression fiveBucks), 그 영향을 받은 다른 부분들을 변경하기 위해 컴파일러의 지시를 따랐다(Expression에 plus()를 추가 하기 등등)
 * 
 * 16장
 * 1. 미래에 코드를 읽을 다른 사람들을염두에 둔 테스트를 작성했다.
 * 2. TDD와 여러분의 현재 개발 스타일을 비교해 볼 수 있는 실험 방법을 제시했다.
 * 3. 또 한번 선언부에 대한 수정이 시스템 나머지 부분으로 번져갔고, 문제를 고치기 위해 역시 컴파일러의 조언을 따랐다.
 * 4. 잠시 실험을 시도했는데, 제대로 되지 않아서 버렸다.(반전..........)
 */
public class Tests {
	@Test
	public void testMultiplication() {
		Money dollarfive = Money.dollar(5);
		assertEquals(Money.dollar(10), dollarfive.times(2));
		assertEquals(Money.dollar(15), dollarfive.times(3));

		Money francfive = Money.franc(5);
		assertEquals(Money.franc(10), francfive.times(2));
		assertEquals(Money.franc(15), francfive.times(3));
	}

	@Test
	public void testFrancMultiplication() {
		Money five = Money.franc(5);
		assertEquals(Money.franc(10), five.times(2));
		assertEquals(Money.franc(15), five.times(3));
	}

	@Test
	public void testEqualiity() {
		assertTrue(Money.dollar(5).equals(Money.dollar(5)));
		assertFalse(Money.dollar(5).equals(Money.dollar(6)));
		assertTrue(Money.franc(5).equals(Money.franc(5)));
		assertFalse(Money.franc(5).equals(Money.franc(6)));
		assertFalse(Money.franc(5).equals(Money.dollar(5)));
	}

	@Test
	public void testCurrency() {
		assertEquals("USD", Money.dollar(1).currency());
		assertEquals("CHF", Money.franc(1).currency());
	}

	@Test
	public void testEquality() {
		assertTrue(Money.dollar(5).equals(Money.dollar(5)));
		assertFalse(Money.dollar(5).equals(Money.dollar(6)));
		assertFalse(Money.franc(5).equals(Money.dollar(5)));
	}

	@Test
	public void testSimpleAdddition() {
		Money five = Money.dollar(5);
		Expression sum = five.plus(five);
		Bank bank = new Bank();
		Money reduced = bank.reduce(sum, "USD");
		assertEquals(Money.dollar(10), reduced);
	}

	@Test
	public void testPlusReturnsSum() {
		Money five = Money.dollar(5);
		Expression result = five.plus(five);
		Sum sum = (Sum) result;
		;
		assertEquals(five, sum.augend);
		assertEquals(five, sum.addend);
	}

	@Test
	public void testReduceSum() {
		Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
		Bank bank = new Bank();
		Money result = bank.reduce(sum, "USD");
		assertEquals(Money.dollar(7), result);
	}

	@Test
	public void testReduceMoney() {
		Bank bank = new Bank();
		Money result = bank.reduce(Money.dollar(1), "USD");
		assertEquals(Money.dollar(1), result);
	}

	@Test
	public void testIdentityRate() {
		assertEquals(1, new Bank().rate("USD", "USD"));
	}

	@Test
	public void testReduceMoneyDifferentCurrency() {
		Bank bank = new Bank();
		bank.addRate("CHF", "USD", 2);
		Money result = bank.reduce(Money.franc(2), "USD");
		assertEquals(Money.dollar(1), result);
	}

	@Test
	public void testArrayEquals() {
		assertEquals(new Object[] { "abc" }, new Object[] { "abc" });
	}

	@Test
	public void testMixedAddition() {
		Expression fiveBucks = Money.dollar(5);
		Expression tenFrancs = Money.franc(10);
		Bank bank = new Bank();
		bank.addRate("CHF", "USD", 2);
		Money result = bank.reduce(fiveBucks.plus(tenFrancs), "USD");
		assertEquals(Money.dollar(10), result);
	}

	@Test
	public void testSumPlusMoney() {
		Expression fiveBucks = Money.dollar(5);
		Expression tenFrancs = Money.franc(10);
		Bank bank = new Bank();
		bank.addRate("CHF", "USD", 2);
		Expression sum = new Sum(fiveBucks, tenFrancs).plus(fiveBucks);
		Money result = bank.reduce(sum, "USD");
		assertEquals(Money.dollar(15), result);
	}

	@Test
	public void testSumTimes() {
		Expression fiveBucks = Money.dollar(5);
		Expression tenFrancs = Money.franc(10);
		Bank bank = new Bank();
		bank.addRate("CHF", "USD", 2);
		Expression sum = new Sum(fiveBucks, tenFrancs).times(2);
		Money result = bank.reduce(sum, "USD");
		assertEquals(Money.dollar(20), result);
	}
	
//	@Test
//	public void testPlusSameCurrencyReturnsMoney(){
//		Expression sum = Money.dollar(1).plus(Money.dollar(1));
//		assertTrue(sum instanceof Money);
//	}

}