package com.discord.utilities.collections;

import a0.a.a.a;
import a0.a.a.b;
import androidx.annotation.VisibleForTesting;
import b.d.b.a.outline;
import d0.t.Collections2;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Histogram.kt */
/* loaded from: classes2.dex */
public final class Histogram {
    private final int bucketLimit;
    private long count;
    private final int halfPrecision;
    private final TreeMap<Long, Long> histogram;
    private Long max;
    private Long min;
    private final int precision;
    private long total;

    /* compiled from: Histogram.kt */
    public static final /* data */ class Report {
        private final double average;
        private final int bucketCount;
        private final long count;
        private final long max;
        private final long min;
        private final long percentile25;
        private final long percentile50;
        private final long percentile75;
        private final long percentile90;
        private final long percentile95;

        public Report(long j, long j2, double d, long j3, int i, long j4, long j5, long j6, long j7, long j8) {
            this.min = j;
            this.max = j2;
            this.average = d;
            this.count = j3;
            this.bucketCount = i;
            this.percentile25 = j4;
            this.percentile50 = j5;
            this.percentile75 = j6;
            this.percentile90 = j7;
            this.percentile95 = j8;
        }

        public static /* synthetic */ Report copy$default(Report report, long j, long j2, double d, long j3, int i, long j4, long j5, long j6, long j7, long j8, int i2, Object obj) {
            return report.copy((i2 & 1) != 0 ? report.min : j, (i2 & 2) != 0 ? report.max : j2, (i2 & 4) != 0 ? report.average : d, (i2 & 8) != 0 ? report.count : j3, (i2 & 16) != 0 ? report.bucketCount : i, (i2 & 32) != 0 ? report.percentile25 : j4, (i2 & 64) != 0 ? report.percentile50 : j5, (i2 & 128) != 0 ? report.percentile75 : j6, (i2 & 256) != 0 ? report.percentile90 : j7, (i2 & 512) != 0 ? report.percentile95 : j8);
        }

        /* renamed from: component1, reason: from getter */
        public final long getMin() {
            return this.min;
        }

        /* renamed from: component10, reason: from getter */
        public final long getPercentile95() {
            return this.percentile95;
        }

        /* renamed from: component2, reason: from getter */
        public final long getMax() {
            return this.max;
        }

        /* renamed from: component3, reason: from getter */
        public final double getAverage() {
            return this.average;
        }

        /* renamed from: component4, reason: from getter */
        public final long getCount() {
            return this.count;
        }

        /* renamed from: component5, reason: from getter */
        public final int getBucketCount() {
            return this.bucketCount;
        }

        /* renamed from: component6, reason: from getter */
        public final long getPercentile25() {
            return this.percentile25;
        }

        /* renamed from: component7, reason: from getter */
        public final long getPercentile50() {
            return this.percentile50;
        }

        /* renamed from: component8, reason: from getter */
        public final long getPercentile75() {
            return this.percentile75;
        }

        /* renamed from: component9, reason: from getter */
        public final long getPercentile90() {
            return this.percentile90;
        }

        public final Report copy(long min, long max, double average, long count, int bucketCount, long percentile25, long percentile50, long percentile75, long percentile90, long percentile95) {
            return new Report(min, max, average, count, bucketCount, percentile25, percentile50, percentile75, percentile90, percentile95);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Report)) {
                return false;
            }
            Report report = (Report) other;
            return this.min == report.min && this.max == report.max && Double.compare(this.average, report.average) == 0 && this.count == report.count && this.bucketCount == report.bucketCount && this.percentile25 == report.percentile25 && this.percentile50 == report.percentile50 && this.percentile75 == report.percentile75 && this.percentile90 == report.percentile90 && this.percentile95 == report.percentile95;
        }

        public final double getAverage() {
            return this.average;
        }

        public final int getBucketCount() {
            return this.bucketCount;
        }

        public final long getCount() {
            return this.count;
        }

        public final long getMax() {
            return this.max;
        }

        public final long getMin() {
            return this.min;
        }

        public final long getPercentile25() {
            return this.percentile25;
        }

        public final long getPercentile50() {
            return this.percentile50;
        }

        public final long getPercentile75() {
            return this.percentile75;
        }

        public final long getPercentile90() {
            return this.percentile90;
        }

        public final long getPercentile95() {
            return this.percentile95;
        }

        public int hashCode() {
            return b.a(this.percentile95) + ((b.a(this.percentile90) + ((b.a(this.percentile75) + ((b.a(this.percentile50) + ((b.a(this.percentile25) + ((((b.a(this.count) + ((a.a(this.average) + ((b.a(this.max) + (b.a(this.min) * 31)) * 31)) * 31)) * 31) + this.bucketCount) * 31)) * 31)) * 31)) * 31)) * 31);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Report(min=");
            sbU.append(this.min);
            sbU.append(", max=");
            sbU.append(this.max);
            sbU.append(", average=");
            sbU.append(this.average);
            sbU.append(", count=");
            sbU.append(this.count);
            sbU.append(", bucketCount=");
            sbU.append(this.bucketCount);
            sbU.append(", percentile25=");
            sbU.append(this.percentile25);
            sbU.append(", percentile50=");
            sbU.append(this.percentile50);
            sbU.append(", percentile75=");
            sbU.append(this.percentile75);
            sbU.append(", percentile90=");
            sbU.append(this.percentile90);
            sbU.append(", percentile95=");
            return outline.C(sbU, this.percentile95, ")");
        }
    }

    public Histogram(int i, int i2) {
        this.precision = i;
        this.bucketLimit = i2;
        this.histogram = new TreeMap<>();
        this.halfPrecision = i / 2;
    }

    public final void addSample(long value) {
        this.count++;
        this.total += value;
        Long l = this.min;
        Long l2 = this.max;
        if (l == null || l.longValue() > value) {
            this.min = Long.valueOf(value);
        }
        if (l2 == null || l2.longValue() < value) {
            this.max = Long.valueOf(value);
        }
        long jRoundValue$utils_release = roundValue$utils_release(value);
        Long l3 = this.histogram.get(Long.valueOf(jRoundValue$utils_release));
        if (l3 != null || this.histogram.size() <= this.bucketLimit) {
            this.histogram.put(Long.valueOf(jRoundValue$utils_release), Long.valueOf((l3 != null ? l3.longValue() : 0L) + 1));
        }
    }

    public final Report getReport() {
        Integer num;
        long jLongValue;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Integer num2 = 50;
        ArrayDeque arrayDeque = new ArrayDeque(Collections2.listOf((Object[]) new Integer[]{25, num2, 75, 90, 95}));
        long j = 0;
        for (Map.Entry<Long, Long> entry : this.histogram.entrySet()) {
            long jLongValue2 = entry.getKey().longValue();
            long jLongValue3 = entry.getValue().longValue();
            if (arrayDeque.isEmpty()) {
                break;
            }
            j += jLongValue3;
            Integer num3 = num2;
            double d = (j / this.count) * 100;
            while ((!arrayDeque.isEmpty()) && ((Number) arrayDeque.get(0)).doubleValue() <= d) {
                linkedHashMap.put(Integer.valueOf(((Number) arrayDeque.removeFirst()).intValue()), Long.valueOf(jLongValue2));
            }
            num2 = num3;
        }
        Integer num4 = num2;
        Long l = this.min;
        long jLongValue4 = l != null ? l.longValue() : 0L;
        Long l2 = this.max;
        long jLongValue5 = l2 != null ? l2.longValue() : 0L;
        long j2 = this.count;
        double d2 = j2 == 0 ? 0.0d : this.total / j2;
        int size = this.histogram.size();
        Long l3 = (Long) linkedHashMap.get(25);
        if (l3 != null) {
            jLongValue = l3.longValue();
            num = num4;
        } else {
            num = num4;
            jLongValue = 0;
        }
        Long l4 = (Long) linkedHashMap.get(num);
        long jLongValue6 = l4 != null ? l4.longValue() : 0L;
        Long l5 = (Long) linkedHashMap.get(75);
        long jLongValue7 = l5 != null ? l5.longValue() : 0L;
        Long l6 = (Long) linkedHashMap.get(90);
        long jLongValue8 = l6 != null ? l6.longValue() : 0L;
        Long l7 = (Long) linkedHashMap.get(95);
        return new Report(jLongValue4, jLongValue5, d2, j2, size, jLongValue, jLongValue6, jLongValue7, jLongValue8, l7 != null ? l7.longValue() : 0L);
    }

    @VisibleForTesting
    public final long roundValue$utils_release(long value) {
        int i = this.precision;
        long j = value % i;
        long j2 = value - j;
        return j <= ((long) this.halfPrecision) ? j2 : j2 + i;
    }

    public /* synthetic */ Histogram(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i3 & 2) != 0 ? 1000 : i2);
    }
}
