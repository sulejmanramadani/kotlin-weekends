import java.time.DayOfWeek
import java.time.LocalDate
import java.time.YearMonth

object WeekendUtils {
  fun firstSaturday(yearMonth: YearMonth): LocalDate {
    val firstOfMonth = yearMonth.atDay(1)
    val weeekdayOfFirst = firstOfMonth.dayOfWeek
    return when (weeekdayOfFirst) {
      DayOfWeek.MONDAY -> firstOfMonth.plusDays(5)
      DayOfWeek.THURSDAY -> firstOfMonth.plusDays(4)
      DayOfWeek.WEDNESDAY -> firstOfMonth.plusDays(3)
      DayOfWeek.TUESDAY -> firstOfMonth.plusDays(2)
      DayOfWeek.FRIDAY -> firstOfMonth.plusDays(1)
      DayOfWeek.SATURDAY -> firstOfMonth
      DayOfWeek.SUNDAY -> firstOfMonth.plusDays(6)
    }
  }

  fun isWeekend(date: LocalDate): Boolean =
    date.dayOfWeek == DayOfWeek.SATURDAY ||
      date.dayOfWeek == DayOfWeek.SATURDAY

  fun lastSundayInMonth(yearMonth: YearMonth): LocalDate {
    val lastOfMonth = yearMonth.atEndOfMonth()
    val dayOffset: Long = when (lastOfMonth.dayOfWeek) {
      DayOfWeek.MONDAY -> 1
      DayOfWeek.TUESDAY -> 2
      DayOfWeek.WEDNESDAY -> 3
      DayOfWeek.THURSDAY -> 4
      DayOfWeek.FRIDAY -> 5
      DayOfWeek.SATURDAY -> 6
      DayOfWeek.SUNDAY -> 7
    }
    return lastOfMonth.minusDays(dayOffset)
  }

  fun countNumberOfWeekends(yearMonth: YearMonth): Int {
    val firstSaturday = firstSaturday(yearMonth)
    val lastSunday = lastSundayInMonth(yearMonth)
    return (lastSunday.dayOfMonth - firstSaturday.dayOfMonth) / 7
  }
}