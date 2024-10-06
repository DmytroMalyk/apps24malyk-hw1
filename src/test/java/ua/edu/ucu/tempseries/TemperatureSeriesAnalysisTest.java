package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;

import java.util.InputMismatchException;

import org.junit.Test;

import ua.edu.ucu.apps.tempseries.TempSummaryStatistics;
import ua.edu.ucu.apps.tempseries.TemperatureSeriesAnalysis;

public class TemperatureSeriesAnalysisTest {

    @Test
    public void test() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = 
        new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        double actualResult = seriesAnalysis.average();
        assertEquals(expResult, actualResult, 0.00001);
    }

   @Test
   public void testAverageWithOneElementArray() {
       // setup input data and expected result
       double[] temperatureSeries = {-1.0};
       TemperatureSeriesAnalysis seriesAnalysis = 
       new TemperatureSeriesAnalysis(temperatureSeries);
       double expResult = -1.0;

       // call tested method
       double actualResult = seriesAnalysis.average();

       // compare expected result with actual result
       assertEquals(expResult, actualResult, 0.00001);
   }

   @Test(expected = IllegalArgumentException.class)
   public void testAverageWithEmptyArray() {
       double[] temperatureSeries = {};
       TemperatureSeriesAnalysis seriesAnalysis = 
       new TemperatureSeriesAnalysis(temperatureSeries);

       // expect exception here
       seriesAnalysis.average();
   }

   @Test
   public void testAverage() {
       double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
       TemperatureSeriesAnalysis seriesAnalysis = 
       new TemperatureSeriesAnalysis(temperatureSeries);
       double expResult = 1.0;

       double actualResult = seriesAnalysis.average();

       assertEquals(expResult, actualResult, 0.00001);
   }

   @Test
    public void testDeviationSingleElement() {
        double[] temperatureSeries = { 9.0 };
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        double expected = 0.0;
        double actual = seriesAnalysis.deviation();
        assertEquals(expected, actual, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeviationEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.deviation();
    }

    @Test
    public void testDeviationMultipleElements() {
        double[] temperatureSeries = {9.0, -7.0, 1.5, 2.5};
        TemperatureSeriesAnalysis analysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        double average = (9.0 + (-7.0) + 1.5 + 2.5) / temperatureSeries.length;
        double sumOfSquaredDeviations = 0.0;
        for (double temp : temperatureSeries) {
            sumOfSquaredDeviations += Math.pow(temp - average, 2);
        }
        double expectedDeviation =
        Math.sqrt(sumOfSquaredDeviations / temperatureSeries.length);
        double actualDeviation = analysis.deviation();
        assertEquals(expectedDeviation, actualDeviation, 0.00001);
    }

    @Test
    public void testMinSingleElement() {
        double[] temperatureSeries = { -1.5 };
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        double expected = -1.5;
        double actual = seriesAnalysis.min();
        assertEquals(expected, actual, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.min();
    }

@Test
    public void testMinMultipleElements() {
        double[] temperatureSeries = { 9.0, -11.0, -1.5, 2.5 };
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        double expected = -11.0;
        double actual = seriesAnalysis.min();
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testMaxSingleElement() {
        double[] temperatureSeries = { 2.5 };
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        double expected = 2.5;
        double actual = seriesAnalysis.max();
        assertEquals(expected, actual, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaxEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.max();
    }

    @Test
    public void testMaxMultipleElements() {
        double[] temperatureSeries = { 9.0, -11.0, -1.5, 2.5 };
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        double expected = 9.0;
        double actual = seriesAnalysis.max();
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testFindTempClosestToZeroSingleElement() {
        double[] temperatureSeries = { -7.0 };
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        double expected = -7.0;
        double actual = seriesAnalysis.findTempClosestToZero();
        assertEquals(expected, actual, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToZeroEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.findTempClosestToZero();
    }

    @Test
    public void testFindTempClosestToZeroMultipleElements() {
        double[] temperatureSeries = { 9.0, -11.0, -1.5, 2.5 };
        TemperatureSeriesAnalysis seriesAnalysis = new
        TemperatureSeriesAnalysis(temperatureSeries);
        double expected = -1.5;
        double actual = seriesAnalysis.findTempClosestToZero();
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testFindTempClosestToValueSingleElement() {
        double[] temperatureSeries = { 1.5 };
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        double tempValue = 2.0;
        double expected = 1.5;
        double actual = seriesAnalysis.findTempClosestToValue(tempValue);
        assertEquals(expected, actual, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToValueEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.findTempClosestToValue(2.0);
    }

    @Test
    public void testFindTempClosestToValueExactMatch() {
        double[] temperatureSeries = { 9.0, -11.0, 2.5, 1.5 };
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        double tempValue = 2.5;
        double expected = 2.5;
        double actual = seriesAnalysis.findTempClosestToValue(tempValue);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testFindTempClosestToValueNoExactMatch() {
        double[] temperatureSeries = { 9.0, -11.0, 1.5, 2.5 };
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        double tempValue = 2.0;
        double expected = 2.5;
        double actual = seriesAnalysis.findTempClosestToValue(tempValue);
        assertEquals(expected, actual, 0.00001);
    }

@Test
    public void testFindTempsLessThanSingleElement() {
        double[] temperatureSeries = { -1.5 };
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        double tempValue = 0.0;
        double[] expected = { -1.5 };
        double[] actual = seriesAnalysis.findTempsLessThen(tempValue);
        assertArrayEquals(expected, actual, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempsLessThanEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.findTempsLessThen(0.0);
    }

    @Test
    public void testFindTempsLessThanMultipleElements() {
        double[] temperatureSeries = { 9.0, -11.0, -1.5, 2.5 };
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        double tempValue = 2.0;
        double[] expected = { -11.0, -1.5 };
        double[] actual = seriesAnalysis.findTempsLessThen(tempValue);
        assertArrayEquals(expected, actual, 0.00001);
    }

    @Test
    public void testFindTempsLessThanNoMatch() {
        double[] temperatureSeries = { 9.0, 2.5, 1.5 };
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        double tempValue = -12.0;
        double[] expected = {};
        double[] actual = seriesAnalysis.findTempsLessThen(tempValue);
        assertArrayEquals(expected, actual, 0.00001);
    }

    @Test
    public void testFindTempsGreaterThanSingleElement() {
        double[] temperatureSeries = { 2.5 };
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        double tempValue = 1.0;
        double[] expected = { 2.5 };
        double[] actual = seriesAnalysis.findTempsGreaterThen(tempValue);
        assertArrayEquals(expected, actual, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempsGreaterThanEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.findTempsGreaterThen(1.0);
    }

    @Test
    public void testFindTempsGreaterThanMultipleElements() {
        double[] temperatureSeries = { 9.0, -11.0, -1.5, 2.5 };
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        double tempValue = 2.0;
        double[] expected = { 9.0, 2.5 };
        double[] actual = seriesAnalysis.findTempsGreaterThen(tempValue);
        assertArrayEquals(expected, actual, 0.00001);
    }

    @Test
    public void testFindTempsGreaterThanNoMatch() {
        double[] temperatureSeries = { -9.0, -11.0, -1.5 };
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        double tempValue = 0.0;
        double[] expected = {};
        double[] actual = seriesAnalysis.findTempsGreaterThen(tempValue);
        assertArrayEquals(expected, actual, 0.00001);
    }

    @Test
    public void testFindTempsInRangeSingleElementInRange() {
        double[] temperatureSeries = { 1.5 };
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        double lowerBound = -2.0;
        double upperBound = 2.0;
        double[] expected = { 1.5 };
        double[] actual = seriesAnalysis.findTempsInRange(lowerBound, upperBound);
        assertArrayEquals(expected, actual, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempsInRangeEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.findTempsInRange(-5.0, 5.0);
    }

@Test
    public void testFindTempsInRangeMultipleElements() {
        double[] temperatureSeries = { 9.0, -11.0, -1.5, 2.5 };
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        double lowerBound = -2.0;
        double upperBound = 3.0;
        double[] expected = { -1.5, 2.5 };
        double[] actual = seriesAnalysis.findTempsInRange(lowerBound, upperBound);
        assertArrayEquals(expected, actual, 0.00001);
    }

    @Test
    public void testFindTempsInRangeNoMatch() {
        double[] temperatureSeries = { -9.0, -11.0, -1.5 };
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        double lowerBound = 0.0;
        double upperBound = 5.0;
        double[] expected = {};
        double[] actual = seriesAnalysis.findTempsInRange(lowerBound, upperBound);
        assertArrayEquals(expected, actual, 0.00001);
    }

    @Test
    public void testReset() {
        double[] temperatureSeries = { 9.0, -11.0, -1.5, 2.5 };
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        assertEquals(4, seriesAnalysis.getSize());
        seriesAnalysis.reset();
        assertEquals(0, seriesAnalysis.getSize());
    }

    @Test
    public void testResetEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        assertEquals(0, seriesAnalysis.getSize());
        seriesAnalysis.reset();
        assertEquals(0, seriesAnalysis.getSize());
    }

    @Test
    public void testResetAfterAddingTemperatures() {
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis();
        seriesAnalysis.addTemps(9.0, -11.0, -1.5, 2.5);
        assertEquals(4, seriesAnalysis.getSize());
        seriesAnalysis.reset();
        assertEquals(0, seriesAnalysis.getSize());
    }

    @Test
    public void testSortTempsSingleElement() {
        double[] temperatureSeries = { -1.5 };
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        double[] sortedTemps = seriesAnalysis.sortTemps();
        assertArrayEquals(new double[]{ -1.5 }, sortedTemps, 0.00001);
    }

    @Test
    public void testSortTempsEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        double[] sortedTemps = seriesAnalysis.sortTemps();
        assertArrayEquals(new double[]{}, sortedTemps, 0.00001);
    }

    @Test
    public void testSortTempsAlreadySorted() {
        double[] temperatureSeries = { -11.0, -1.5, 2.5, 9.0 };
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        double[] sortedTemps = seriesAnalysis.sortTemps();
        assertArrayEquals(new double[]{ -11.0, -1.5, 2.5, 9.0 }, sortedTemps, 0.00001);
    }

    @Test
    public void testSortTempsUnsorted() {
        double[] temperatureSeries = { 2.5, -11.0, 9.0, -1.5 };
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        double[] sortedTemps = seriesAnalysis.sortTemps();
        assertArrayEquals(new double[]{ -11.0, -1.5, 2.5, 9.0 }, sortedTemps, 0.00001);
    }

    @Test
    public void testSortTempsWithDuplicates() {
        double[] temperatureSeries = { 2.5, -11.0, 2.5, -1.5, 9.0 };
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        double[] sortedTemps = seriesAnalysis.sortTemps();
        assertArrayEquals(new double[]{ -11.0, -1.5, 2.5, 2.5, 9.0 }, sortedTemps, 0.00001);
    }

@Test
    public void testSummaryStatisticsSingleElement() {
        double[] temperatureSeries = { -7.0 };
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        TempSummaryStatistics stats = seriesAnalysis.summaryStatistics();
        assertEquals(-7.0, stats.getAvgTemp(), 0.00001);
        assertEquals(0.0, stats.getDevTemp(), 0.00001);
        assertEquals(-7.0, stats.getMinTemp(), 0.00001);
        assertEquals(-7.0, stats.getMaxTemp(), 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSummaryStatisticsEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.summaryStatistics();
    }

    @Test
    public void testSummaryStatisticsWithMultipleElements() {
        double[] temperatureSeries = { 9.0, -11.0, -1.5, 2.5 };
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        TempSummaryStatistics stats = seriesAnalysis.summaryStatistics();
        assertEquals(-0.25, stats.getAvgTemp(), 0.00001);
        assertEquals(7.25, stats.getDevTemp(), 0.001);
        assertEquals(-11.0, stats.getMinTemp(), 0.00001);
        assertEquals(9.0, stats.getMaxTemp(), 0.00001);
    }

    @Test
    public void testSummaryStatisticsAllEqualValues() {
        double[] temperatureSeries = { 2.5, 2.5, 2.5, 2.5 };
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        TempSummaryStatistics stats = seriesAnalysis.summaryStatistics();
        assertEquals(2.5, stats.getAvgTemp(), 0.00001);
        assertEquals(0.0, stats.getDevTemp(), 0.00001);
        assertEquals(2.5, stats.getMinTemp(), 0.00001);
        assertEquals(2.5, stats.getMaxTemp(), 0.00001);
    }

    @Test
    public void testAddTempsNoNewTemps() {
        double[] temperatureSeries = { 9.0, -11.0 };
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        int result = seriesAnalysis.addTemps();
        assertEquals(2, result);
    }

    @Test
    public void testAddTempsSingleTemp() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        int result = seriesAnalysis.addTemps(1.5);
        assertEquals(1, result);
    }

    @Test(expected = InputMismatchException.class)
    public void testAddTempsWithInvalidTemperature() {
        double[] temperatureSeries = { 9.0 };
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.addTemps(-274.0);
    }

}
