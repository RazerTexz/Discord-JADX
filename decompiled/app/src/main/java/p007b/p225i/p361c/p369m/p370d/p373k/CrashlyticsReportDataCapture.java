package p007b.p225i.p361c.p369m.p370d.p373k;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p361c.p369m.p370d.p375m.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception;
import p007b.p225i.p361c.p369m.p370d.p375m.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread;
import p007b.p225i.p361c.p369m.p370d.p375m.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame;
import p007b.p225i.p361c.p369m.p370d.p375m.CrashlyticsReport;
import p007b.p225i.p361c.p369m.p370d.p375m.ImmutableList3;
import p007b.p225i.p361c.p369m.p370d.p387t.StackTraceTrimmingStrategy;
import p007b.p225i.p361c.p369m.p370d.p387t.TrimmedThrowableData;

/* compiled from: CrashlyticsReportDataCapture.java */
/* renamed from: b.i.c.m.d.k.n0, reason: use source file name */
/* loaded from: classes3.dex */
public class CrashlyticsReportDataCapture {

    /* renamed from: a */
    public static final String f12353a = String.format(Locale.US, "Crashlytics Android SDK/%s", "17.3.0");

    /* renamed from: b */
    public static final Map<String, Integer> f12354b;

    /* renamed from: c */
    public final Context f12355c;

    /* renamed from: d */
    public final IdManager f12356d;

    /* renamed from: e */
    public final AppData f12357e;

    /* renamed from: f */
    public final StackTraceTrimmingStrategy f12358f;

    static {
        HashMap map = new HashMap();
        f12354b = map;
        outline.m858j0(5, map, "armeabi", 6, "armeabi-v7a", 9, "arm64-v8a", 0, "x86");
        map.put("x86_64", 1);
    }

    public CrashlyticsReportDataCapture(Context context, IdManager idManager, AppData appData, StackTraceTrimmingStrategy stackTraceTrimmingStrategy) {
        this.f12355c = context;
        this.f12356d = idManager;
        this.f12357e = appData;
        this.f12358f = stackTraceTrimmingStrategy;
    }

    /* renamed from: a */
    public final CrashlyticsReport.d.AbstractC13233d.a.b.AbstractC13236b m6446a(TrimmedThrowableData trimmedThrowableData, int i, int i2, int i3) {
        String str = trimmedThrowableData.f12778b;
        String str2 = trimmedThrowableData.f12777a;
        StackTraceElement[] stackTraceElementArr = trimmedThrowableData.f12779c;
        int i4 = 0;
        if (stackTraceElementArr == null) {
            stackTraceElementArr = new StackTraceElement[0];
        }
        TrimmedThrowableData trimmedThrowableData2 = trimmedThrowableData.f12780d;
        if (i3 >= i2) {
            TrimmedThrowableData trimmedThrowableData3 = trimmedThrowableData2;
            while (trimmedThrowableData3 != null) {
                trimmedThrowableData3 = trimmedThrowableData3.f12780d;
                i4++;
            }
        }
        CrashlyticsReport.d.AbstractC13233d.a.b.AbstractC13236b abstractC13236bM6446a = null;
        Objects.requireNonNull(str, "Null type");
        ImmutableList3 immutableList3 = new ImmutableList3(m6447b(stackTraceElementArr, i));
        Integer numValueOf = Integer.valueOf(i4);
        if (trimmedThrowableData2 != null && i4 == 0) {
            abstractC13236bM6446a = m6446a(trimmedThrowableData2, i, i2, i3 + 1);
        }
        String str3 = numValueOf == null ? " overflowCount" : "";
        if (str3.isEmpty()) {
            return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception(str, str2, immutableList3, abstractC13236bM6446a, numValueOf.intValue(), null);
        }
        throw new IllegalStateException(outline.m883w("Missing required properties:", str3));
    }

    /* renamed from: b */
    public final ImmutableList3<CrashlyticsReport.d.AbstractC13233d.a.b.AbstractC13237d.AbstractC13238a> m6447b(StackTraceElement[] stackTraceElementArr, int i) {
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame.b bVar = new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame.b();
            bVar.f12628e = Integer.valueOf(i);
            long lineNumber = 0;
            long jMax = stackTraceElement.isNativeMethod() ? Math.max(stackTraceElement.getLineNumber(), 0L) : 0L;
            String str = stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName();
            String fileName = stackTraceElement.getFileName();
            if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
                lineNumber = stackTraceElement.getLineNumber();
            }
            bVar.f12624a = Long.valueOf(jMax);
            Objects.requireNonNull(str, "Null symbol");
            bVar.f12625b = str;
            bVar.f12626c = fileName;
            bVar.f12627d = Long.valueOf(lineNumber);
            arrayList.add(bVar.m6598a());
        }
        return new ImmutableList3<>(arrayList);
    }

    /* renamed from: c */
    public final CrashlyticsReport.d.AbstractC13233d.a.b.AbstractC13237d m6448c(Thread thread, StackTraceElement[] stackTraceElementArr, int i) {
        String name = thread.getName();
        Objects.requireNonNull(name, "Null name");
        Integer numValueOf = Integer.valueOf(i);
        ImmutableList3 immutableList3 = new ImmutableList3(m6447b(stackTraceElementArr, i));
        String str = numValueOf == null ? " importance" : "";
        if (str.isEmpty()) {
            return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread(name, numValueOf.intValue(), immutableList3, null);
        }
        throw new IllegalStateException(outline.m883w("Missing required properties:", str));
    }
}
