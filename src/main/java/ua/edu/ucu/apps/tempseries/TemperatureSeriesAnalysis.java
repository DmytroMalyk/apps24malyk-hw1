package ua.edu.ucu.apps.tempseries;

import java.util.InputMismatchException;

import lombok.Getter;

import java.util.Arrays;

@Getter
public class TemperatureSeriesAnalysis {
    private static final int Minimal = -273;
    private double[] temperatures;
    private int size;
    private int capacity;

    public TemperatureSeriesAnalysis() {
        this.temperatures = new double[0];
        this.size = 0;
        this.capacity = 0;
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        for (double el : temperatureSeries) {
            if (el < Minimal) {
                throw new InputMismatchException();
            }
        }
        this.temperatures = temperatureSeries;
        this.size = temperatureSeries.length;
        this.capacity = temperatureSeries.length;
    }

    public double average() {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        int count = 0;
        double sum = 0;
        for (double el: temperatures) {
            sum += el;
            count += 1;
        }
        return sum/count;
    }

    public double deviation() {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        double numerator = 0;
        double mean = this.average();
        for (double el : temperatures) {
            numerator += (el - mean) * (el - mean);
        }
        return Math.sqrt(numerator/size);
    }

    public double min() {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        double lowest = Double.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            if (temperatures[i] < lowest) {
                lowest = temperatures[i];
            }
        }
        return lowest;
    }

    public double max() {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        double highest = Minimal;
        for (int i = 0; i < size; i++) {
            if (temperatures[i] > highest) {
                highest = temperatures[i];
            }
        }
        return highest;
    }

    public double findTempClosestToZero() {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        double distance_to_zero = Double.MAX_VALUE;
        double temp = 0;
        for (int i = 0; i < size; i++) {
            double el = temperatures[i];
            if (Math.abs(el) < distance_to_zero) {
                distance_to_zero = Math.abs(el);
                temp = el;
            } else if (Double.compare(Math.abs(el), distance_to_zero) == 0) {
                if (el > 0) { temp = el; }
            }
        }
        return temp;
    }

    public double findTempClosestToValue(double tempValue) {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        double distance_to_value = Double.MAX_VALUE;
        double temp = 0;
        for (int i = 0; i < size; i++) {
            double el = temperatures[i];
            if (Math.abs(el - tempValue) < distance_to_value) {
                distance_to_value = Math.abs(el - tempValue);
                temp = el;
            } else if (Double.compare(Math.abs(el - tempValue), distance_to_value) == 0) {
                if (el > 0) { temp = el; }
            }
        }
        return temp;
    }

    public double[] findTempsLessThen(double tempValue) {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        int count = 0;
        for (double el : temperatures) {
            if (el < tempValue) {
                count++;
            }
        }
        double[] result = new double[count];
        int index = 0;
        for (double el : temperatures) {
            if (el < tempValue) {
                result[index++] = el;
            }
        }
        return result;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        int count = 0;
        for (double el : temperatures) {
            if (el > tempValue) {
                count++;
            }
        }
        double[] result = new double[count];
        int index = 0;
        for (double el : temperatures) {
            if (el > tempValue) {
                result[index++] = el;
            }
        }
        return result;
    }

    public double[] findTempsInRange(double lowerBound, double upperBound) {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        int count = 0;
        for (double el : temperatures) {
            if (el > lowerBound && el < upperBound) {
                count++;
            }
        }
        double[] result = new double[count];
        int index = 0;
        for (double el : temperatures) {
            if (el > lowerBound && el < upperBound) {
                result[index++] = el;
            }
        }
        return result;
    }

    public void reset() {
        temperatures = new double[0];
        size = 0;
        capacity = 0;
    }

    public double[] sortTemps() {
        double[] copy = temperatures.clone();
        Arrays.sort(copy);
        return copy;
    }

    public TempSummaryStatistics summaryStatistics() {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        return new TempSummaryStatistics(average(), deviation(), min(), max());
    }

    public int addTemps(double... temps) {
        for (double temp : temps) {
            if (temp < Minimal) {
                throw new InputMismatchException();
            }
        }
        if (temps.length + size > capacity) {
            while (capacity < (temps.length + size)) {
                capacity = (capacity == 0) ? 1 : capacity * 2;
            }
            double[] newTemperatures = new double[capacity];
            for (int i = 0; i < size; i++) {
                newTemperatures[i] = temperatures[i];
            }
            temperatures = newTemperatures;
        }
        for (double temp : temps) {
            temperatures[size++] = temp;
        }
        return size;
    }
}
