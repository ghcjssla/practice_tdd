package doller;
import static org.junit.Assert.*;

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
 */
public class Tests {
	@Test
	public void testMultiplication(){
		Dollar five = new Dollar(5);
		assertEquals(new Dollar(10), five.times(2));
		assertEquals(new Dollar(15), five.times(3));
	}
	
	@Test
	public void testEqualiity(){
		assertTrue(new Dollar(5).equals(new Dollar(5)));
		assertFalse(new Dollar(5).equals(new Dollar(6)));
	}
}
