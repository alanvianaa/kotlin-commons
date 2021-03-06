package br.com.calculato.commons.time

import java.time.LocalDate

/**
 * Returns the final date of Periodo
 */
fun Int.lastPeriodoDate() = firstPeriodoDate().withLastDayOfMonth()

/**
 * Returns the first date of Periodo
 */
fun Int.firstPeriodoDate() = LocalDate.of(periodoYear(), actualPeriodoMonth(), 1)

/**
 * Returns the month of Periodo not includes 13th
 */
fun Int.actualPeriodoMonth(): Int =
    with(this % 100) { if (this in 1..12) this else error("$this is not an actual periodo month") }

/**
 * Returns the month of Periodo includes 13th
 */
fun Int.periodoMonth(): Int =
    with(this % 100) { if (this in 1..13) this else error("Cannot convert $this to month") }

/**
 * Returns the year of Periodo
 */
fun Int.periodoYear() = div(100)
