package com.discord.widgets.bugreports;

import androidx.exifinterface.media.ExifInterface;
import com.discord.api.bugreport.BugReportConfig2;
import java.util.Comparator;
import p507d0.p582u.C12169a;

/* JADX INFO: compiled from: Comparisons.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BugReportViewModel$showFeatureAreas$$inlined$sortedBy$1<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        BugReportConfig2 bugReportConfig2 = (BugReportConfig2) t;
        BugReportConfig2 bugReportConfig22 = (BugReportConfig2) t2;
        return C12169a.compareValues(bugReportConfig2.getSquad() + bugReportConfig2.getName(), bugReportConfig22.getSquad() + bugReportConfig22.getName());
    }
}
