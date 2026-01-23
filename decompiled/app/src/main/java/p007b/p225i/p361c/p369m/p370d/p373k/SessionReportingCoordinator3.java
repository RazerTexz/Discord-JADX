package p007b.p225i.p361c.p369m.p370d.p373k;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Environment;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.ActivityChooserModel;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p228b.AutoValue_Event;
import p007b.p225i.p226a.p228b.Priority3;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p361c.p369m.p370d.Logger3;
import p007b.p225i.p361c.p369m.p370d.p374l.LogFileManager;
import p007b.p225i.p361c.p369m.p370d.p375m.AutoValue_CrashlyticsReport_CustomAttribute;
import p007b.p225i.p361c.p369m.p370d.p375m.AutoValue_CrashlyticsReport_Session_Event;
import p007b.p225i.p361c.p369m.p370d.p375m.AutoValue_CrashlyticsReport_Session_Event_Application;
import p007b.p225i.p361c.p369m.p370d.p375m.AutoValue_CrashlyticsReport_Session_Event_Application_Execution;
import p007b.p225i.p361c.p369m.p370d.p375m.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage;
import p007b.p225i.p361c.p369m.p370d.p375m.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal;
import p007b.p225i.p361c.p369m.p370d.p375m.AutoValue_CrashlyticsReport_Session_Event_Device;
import p007b.p225i.p361c.p369m.p370d.p375m.AutoValue_CrashlyticsReport_Session_Event_Log;
import p007b.p225i.p361c.p369m.p370d.p375m.CrashlyticsReport;
import p007b.p225i.p361c.p369m.p370d.p375m.ImmutableList3;
import p007b.p225i.p361c.p369m.p370d.p375m.p376x.CrashlyticsReportJsonTransform8;
import p007b.p225i.p361c.p369m.p370d.p378o.CrashlyticsReportPersistence3;
import p007b.p225i.p361c.p369m.p370d.p378o.CrashlyticsReportPersistence4;
import p007b.p225i.p361c.p369m.p370d.p378o.CrashlyticsReportPersistence7;
import p007b.p225i.p361c.p369m.p370d.p383r.DataTransportCrashlyticsReportSender;
import p007b.p225i.p361c.p369m.p370d.p383r.DataTransportCrashlyticsReportSender3;
import p007b.p225i.p361c.p369m.p370d.p384s.SettingsController;
import p007b.p225i.p361c.p369m.p370d.p387t.TrimmedThrowableData;
import p007b.p225i.p361c.p393p.p395h.JsonDataEncoderBuilder4;

/* JADX INFO: renamed from: b.i.c.m.d.k.d1, reason: use source file name */
/* JADX INFO: compiled from: SessionReportingCoordinator.java */
/* JADX INFO: loaded from: classes3.dex */
public class SessionReportingCoordinator3 {

    /* JADX INFO: renamed from: a */
    public final CrashlyticsReportDataCapture f12278a;

    /* JADX INFO: renamed from: b */
    public final CrashlyticsReportPersistence7 f12279b;

    /* JADX INFO: renamed from: c */
    public final DataTransportCrashlyticsReportSender3 f12280c;

    /* JADX INFO: renamed from: d */
    public final LogFileManager f12281d;

    /* JADX INFO: renamed from: e */
    public final UserMetadata f12282e;

    public SessionReportingCoordinator3(CrashlyticsReportDataCapture crashlyticsReportDataCapture, CrashlyticsReportPersistence7 crashlyticsReportPersistence7, DataTransportCrashlyticsReportSender3 dataTransportCrashlyticsReportSender3, LogFileManager logFileManager, UserMetadata userMetadata) {
        this.f12278a = crashlyticsReportDataCapture;
        this.f12279b = crashlyticsReportPersistence7;
        this.f12280c = dataTransportCrashlyticsReportSender3;
        this.f12281d = logFileManager;
        this.f12282e = userMetadata;
    }

    /* JADX INFO: renamed from: a */
    public final void m6399a(@NonNull Throwable th, @NonNull Thread thread, @NonNull String str, @NonNull String str2, long j, boolean z2) {
        AutoValue_CrashlyticsReport_Session_Event_Log autoValue_CrashlyticsReport_Session_Event_Log;
        boolean zEquals = str2.equals("crash");
        CrashlyticsReportDataCapture crashlyticsReportDataCapture = this.f12278a;
        int i = crashlyticsReportDataCapture.f12355c.getResources().getConfiguration().orientation;
        TrimmedThrowableData trimmedThrowableData = new TrimmedThrowableData(th, crashlyticsReportDataCapture.f12358f);
        Long lValueOf = Long.valueOf(j);
        ActivityManager.RunningAppProcessInfo runningAppProcessInfoM6415i = CommonUtils.m6415i(crashlyticsReportDataCapture.f12357e.f12262d, crashlyticsReportDataCapture.f12355c);
        Boolean boolValueOf = runningAppProcessInfoM6415i != null ? Boolean.valueOf(runningAppProcessInfoM6415i.importance != 100) : null;
        Integer numValueOf = Integer.valueOf(i);
        ArrayList arrayList = new ArrayList();
        arrayList.add(crashlyticsReportDataCapture.m6448c(thread, trimmedThrowableData.f12779c, 4));
        if (z2) {
            for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
                Thread key = entry.getKey();
                if (!key.equals(thread)) {
                    arrayList.add(crashlyticsReportDataCapture.m6448c(key, crashlyticsReportDataCapture.f12358f.mo6696a(entry.getValue()), 0));
                }
            }
        }
        ImmutableList3 immutableList3 = new ImmutableList3(arrayList);
        CrashlyticsReport.d.AbstractC13233d.a.b.AbstractC13236b abstractC13236bM6446a = crashlyticsReportDataCapture.m6446a(trimmedThrowableData, 4, 8, 0);
        Long l = 0L;
        String str3 = l == null ? " address" : "";
        if (!str3.isEmpty()) {
            throw new IllegalStateException(outline.m883w("Missing required properties:", str3));
        }
        AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal autoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal = new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal("0", "0", l.longValue(), null);
        CrashlyticsReport.d.AbstractC13233d.a.b.AbstractC13235a[] abstractC13235aArr = new CrashlyticsReport.d.AbstractC13233d.a.b.AbstractC13235a[1];
        Long l2 = 0L;
        Long l3 = 0L;
        String str4 = crashlyticsReportDataCapture.f12357e.f12262d;
        Objects.requireNonNull(str4, "Null name");
        String str5 = crashlyticsReportDataCapture.f12357e.f12260b;
        String strM883w = l2 == null ? " baseAddress" : "";
        if (l3 == null) {
            strM883w = outline.m883w(strM883w, " size");
        }
        if (!strM883w.isEmpty()) {
            throw new IllegalStateException(outline.m883w("Missing required properties:", strM883w));
        }
        abstractC13235aArr[0] = new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage(l2.longValue(), l3.longValue(), str4, str5, null);
        AutoValue_CrashlyticsReport_Session_Event_Application_Execution autoValue_CrashlyticsReport_Session_Event_Application_Execution = new AutoValue_CrashlyticsReport_Session_Event_Application_Execution(immutableList3, abstractC13236bM6446a, autoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal, new ImmutableList3(Arrays.asList(abstractC13235aArr)), null);
        String str6 = numValueOf == null ? " uiOrientation" : "";
        if (!str6.isEmpty()) {
            throw new IllegalStateException(outline.m883w("Missing required properties:", str6));
        }
        AutoValue_CrashlyticsReport_Session_Event_Application autoValue_CrashlyticsReport_Session_Event_Application = new AutoValue_CrashlyticsReport_Session_Event_Application(autoValue_CrashlyticsReport_Session_Event_Application_Execution, null, boolValueOf, numValueOf.intValue(), null);
        BatteryState batteryStateM6401a = BatteryState.m6401a(crashlyticsReportDataCapture.f12355c);
        Float f = batteryStateM6401a.f12283a;
        Double dValueOf = f != null ? Double.valueOf(f.doubleValue()) : null;
        int iM6402b = batteryStateM6401a.m6402b();
        boolean zM6419m = CommonUtils.m6419m(crashlyticsReportDataCapture.f12355c);
        long jM6422p = CommonUtils.m6422p();
        Context context = crashlyticsReportDataCapture.f12355c;
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY)).getMemoryInfo(memoryInfo);
        long j2 = jM6422p - memoryInfo.availMem;
        long jM6407a = CommonUtils.m6407a(Environment.getDataDirectory().getPath());
        AutoValue_CrashlyticsReport_Session_Event_Device.b bVar = new AutoValue_CrashlyticsReport_Session_Event_Device.b();
        bVar.f12635a = dValueOf;
        bVar.f12636b = Integer.valueOf(iM6402b);
        bVar.f12637c = Boolean.valueOf(zM6419m);
        bVar.f12638d = Integer.valueOf(i);
        bVar.f12639e = Long.valueOf(j2);
        bVar.f12640f = Long.valueOf(jM6407a);
        CrashlyticsReport.d.AbstractC13233d.b bVarM6605a = bVar.m6605a();
        String str7 = lValueOf == null ? " timestamp" : "";
        if (!str7.isEmpty()) {
            throw new IllegalStateException(outline.m883w("Missing required properties:", str7));
        }
        Long lValueOf2 = Long.valueOf(lValueOf.longValue());
        String strMo6492b = this.f12281d.f12473d.mo6492b();
        if (strMo6492b != null) {
            autoValue_CrashlyticsReport_Session_Event_Log = new AutoValue_CrashlyticsReport_Session_Event_Log(strMo6492b, null);
        } else {
            Logger3.f12227a.m6371b("No log data to include with this event.");
            autoValue_CrashlyticsReport_Session_Event_Log = null;
        }
        Map<String, String> mapM6404a = this.f12282e.m6404a();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.ensureCapacity(mapM6404a.size());
        for (Map.Entry<String, String> entry2 : mapM6404a.entrySet()) {
            String key2 = entry2.getKey();
            Objects.requireNonNull(key2, "Null key");
            String value = entry2.getValue();
            Objects.requireNonNull(value, "Null value");
            arrayList2.add(new AutoValue_CrashlyticsReport_CustomAttribute(key2, value, null));
        }
        Collections.sort(arrayList2, SessionReportingCoordinator2.f12272j);
        CrashlyticsReport.d.AbstractC13233d.a aVarM6573a = autoValue_CrashlyticsReport_Session_Event_Application;
        if (!arrayList2.isEmpty()) {
            AutoValue_CrashlyticsReport_Session_Event_Application.b bVar2 = (AutoValue_CrashlyticsReport_Session_Event_Application.b) autoValue_CrashlyticsReport_Session_Event_Application.m6572e();
            bVar2.f12597b = new ImmutableList3<>(arrayList2);
            aVarM6573a = bVar2.m6573a();
        }
        CrashlyticsReport.d.AbstractC13233d.a aVar = aVarM6573a;
        CrashlyticsReportPersistence7 crashlyticsReportPersistence7 = this.f12279b;
        String str8 = lValueOf2 != null ? "" : " timestamp";
        if (!str8.isEmpty()) {
            throw new IllegalStateException(outline.m883w("Missing required properties:", str8));
        }
        AutoValue_CrashlyticsReport_Session_Event autoValue_CrashlyticsReport_Session_Event = new AutoValue_CrashlyticsReport_Session_Event(lValueOf2.longValue(), str2, aVar, bVarM6605a, autoValue_CrashlyticsReport_Session_Event_Log, null);
        int i2 = ((SettingsController) crashlyticsReportPersistence7.f12682k).m6685c().mo6690b().f12758a;
        File fileM6635h = crashlyticsReportPersistence7.m6635h(str);
        Objects.requireNonNull(CrashlyticsReportPersistence7.f12674c);
        try {
            CrashlyticsReportPersistence7.m6631l(new File(fileM6635h, outline.m886y("event", String.format(Locale.US, "%010d", Integer.valueOf(crashlyticsReportPersistence7.f12677f.getAndIncrement())), zEquals ? "_" : "")), ((JsonDataEncoderBuilder4) CrashlyticsReportJsonTransform8.f12656a).m6711a(autoValue_CrashlyticsReport_Session_Event));
        } catch (IOException e) {
            Logger3.f12227a.m6372c("Could not persist event for session " + str, e);
        }
        List<File> listM6627g = CrashlyticsReportPersistence7.m6627g(fileM6635h, CrashlyticsReportPersistence3.f12668a);
        Collections.sort(listM6627g, CrashlyticsReportPersistence4.f12669j);
        int size = listM6627g.size();
        for (File file : listM6627g) {
            if (size <= i2) {
                return;
            }
            CrashlyticsReportPersistence7.m6630k(file);
            size--;
        }
    }

    /* JADX WARN: Incorrect types in method signature: (Ljava/util/concurrent/Executor;Ljava/lang/Object;)Lcom/google/android/gms/tasks/Task<Ljava/lang/Void;>; */
    /* JADX INFO: renamed from: b */
    public Task m6400b(@NonNull Executor executor, @NonNull int i) {
        if (i == 1) {
            Logger3.f12227a.m6371b("Send via DataTransport disabled. Removing DataTransport reports.");
            this.f12279b.m6632b();
            return C3404f.m4264Z(null);
        }
        CrashlyticsReportPersistence7 crashlyticsReportPersistence7 = this.f12279b;
        List<File> listM6634e = crashlyticsReportPersistence7.m6634e();
        ArrayList<CrashlyticsReportWithSessionId> arrayList = new ArrayList();
        arrayList.ensureCapacity(((ArrayList) listM6634e).size());
        for (File file : (ArrayList) crashlyticsReportPersistence7.m6634e()) {
            try {
                arrayList.add(new AutoValue_CrashlyticsReportWithSessionId(CrashlyticsReportPersistence7.f12674c.m6619f(CrashlyticsReportPersistence7.m6629j(file)), file.getName()));
            } catch (IOException e) {
                Logger3.f12227a.m6372c("Could not load report file " + file + "; deleting", e);
                file.delete();
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (CrashlyticsReportWithSessionId crashlyticsReportWithSessionId : arrayList) {
            CrashlyticsReport crashlyticsReportMo6396a = crashlyticsReportWithSessionId.mo6396a();
            if ((crashlyticsReportMo6396a.mo6522h() != null ? (char) 2 : crashlyticsReportMo6396a.mo6519e() != null ? (char) 3 : (char) 1) != 3 || i == 3) {
                DataTransportCrashlyticsReportSender3 dataTransportCrashlyticsReportSender3 = this.f12280c;
                Objects.requireNonNull(dataTransportCrashlyticsReportSender3);
                CrashlyticsReport crashlyticsReportMo6396a2 = crashlyticsReportWithSessionId.mo6396a();
                TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                dataTransportCrashlyticsReportSender3.f12727e.mo2290b(new AutoValue_Event(null, crashlyticsReportMo6396a2, Priority3.HIGHEST), new DataTransportCrashlyticsReportSender(taskCompletionSource, crashlyticsReportWithSessionId));
                arrayList2.add(taskCompletionSource.f20845a.mo6014i(executor, new SessionReportingCoordinator(this)));
            } else {
                Logger3.f12227a.m6371b("Send native reports via DataTransport disabled. Removing DataTransport reports.");
                this.f12279b.m6633c(crashlyticsReportWithSessionId.mo6397b());
            }
        }
        return C3404f.m4194B1(arrayList2);
    }
}
