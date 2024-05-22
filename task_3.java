// Напиши аннотацию для параметризованных тестов
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class CheckIsAdultTest {
	
  private final int age;
  private final boolean result;

  public CheckIsAdultTest(int age, boolean result) {
	// Инициализируй поля класса в конструкторе
    this.age = age;
    this.result = result;  
  }

  @Parameterized.Parameters// Пометь метод аннотацией для параметров
  public static Object[][] getTextData() {
	return new Object[][] {
		  { 22, true},
          { 17, false},// Заполни массив тестовыми данными и ожидаемым результатом
          { 18, true},
          { 21, true},
    };
  }

  @Test
  public void checkIsAdultWhenAgeThenResult() {
	Program program = new Program();
	 // Передай сюда возраст пользователя
    boolean isAdult = program.checkIsAdult(age);
	// Сравни полученный и ожидаемый результаты, не забудь про сообщение об ошибке
    assertEquals("Должно вернуться "+result+", так как пользователю " + age, result, isAdult);
	}
}
