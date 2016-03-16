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
 */
public class Tests {
	@Test
	public void testMultiplication(){
		Dollar five = new Dollar(5);
		five.times(2);
		assertEquals(10, five.amount);
	}
}
