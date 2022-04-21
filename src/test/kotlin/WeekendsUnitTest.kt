import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.time.YearMonth

internal class WeekendsUnitTest {
  @Test
  fun `January 2022 has 5 weekends`() {
    assertEquals(5, WeekendUtils.countNumberOfWeekends(YearMonth.of(2022, 1)))
  }

  @Test
  fun `February 2022 has 4 weekends`() {
    assertEquals(4, WeekendUtils.countNumberOfWeekends(YearMonth.of(2022, 2)))
  }

  @Test
  fun `October 2021 has 5 weekends`() {
    assertEquals(5, WeekendUtils.countNumberOfWeekends(YearMonth.of(2021, 10)))
  }

  @Test
  fun `July 2nd is first saturday of July 2022`() {
    assertEquals(LocalDate.of(2022, 7, 2), WeekendUtils.firstSaturday(YearMonth.of(2022, 7)))
  }

  @Test
  fun `July 3rd is first saturday of July 2021`() {
    assertEquals(LocalDate.of(2021, 7, 3), WeekendUtils.firstSaturday(YearMonth.of(2021, 7)))
  }

  @Test
  fun `2022-01-22 is weekend`() {
    assertTrue(WeekendUtils.isWeekend(LocalDate.of(2022, 1, 22)))
  }

  @Test
  fun `2022-01-23 is weekend`() {
    assertTrue(WeekendUtils.isWeekend(LocalDate.of(2022, 1, 23)))
  }

  @Test
  fun `July 25th is last sunday of July 2021`() {
    assertEquals(LocalDate.of(2021, 7, 25), WeekendUtils.firstSaturday(YearMonth.of(2021, 7)))
  }
}