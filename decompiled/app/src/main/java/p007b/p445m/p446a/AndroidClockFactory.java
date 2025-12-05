package p007b.p445m.p446a;

import android.content.Context;
import android.content.SharedPreferences;
import com.lyft.kronos.Clock8;
import java.util.List;
import p007b.p445m.p446a.p447g.AndroidSystemClock;
import p007b.p445m.p446a.p447g.KronosClockImpl;
import p007b.p445m.p446a.p447g.SharedPreferenceSyncResponseCache;
import p007b.p445m.p446a.p447g.p448d.DatagramFactory2;
import p007b.p445m.p446a.p447g.p448d.DnsResolver2;
import p007b.p445m.p446a.p447g.p448d.SntpClient;
import p007b.p445m.p446a.p447g.p448d.SntpResponseCache2;
import p007b.p445m.p446a.p447g.p448d.SntpService2;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: AndroidClockFactory.kt */
/* renamed from: b.m.a.a, reason: use source file name */
/* loaded from: classes3.dex */
public final class AndroidClockFactory {
    /* renamed from: a */
    public static Clock8 m7127a(Context context, SyncListener syncListener, List list, long j, long j2, long j3, int i) {
        List<String> list2;
        long j4;
        long j5;
        long j6;
        int i2 = i & 2;
        if ((i & 4) != 0) {
            DefaultParam defaultParam = DefaultParam.f13643e;
            list2 = DefaultParam.f13639a;
        } else {
            list2 = null;
        }
        List<String> list3 = list2;
        if ((i & 8) != 0) {
            DefaultParam defaultParam2 = DefaultParam.f13643e;
            j4 = DefaultParam.f13642d;
        } else {
            j4 = j;
        }
        if ((i & 16) != 0) {
            DefaultParam defaultParam3 = DefaultParam.f13643e;
            j5 = DefaultParam.f13641c;
        } else {
            j5 = j2;
        }
        if ((i & 32) != 0) {
            DefaultParam defaultParam4 = DefaultParam.f13643e;
            j6 = DefaultParam.f13640b;
        } else {
            j6 = j3;
        }
        Intrinsics3.checkParameterIsNotNull(context, "context");
        Intrinsics3.checkParameterIsNotNull(list3, "ntpHosts");
        AndroidSystemClock androidSystemClock = new AndroidSystemClock();
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.lyft.kronos.shared_preferences", 0);
        Intrinsics3.checkExpressionValueIsNotNull(sharedPreferences, "context.getSharedPrefere…ME, Context.MODE_PRIVATE)");
        SharedPreferenceSyncResponseCache sharedPreferenceSyncResponseCache = new SharedPreferenceSyncResponseCache(sharedPreferences);
        Intrinsics3.checkParameterIsNotNull(androidSystemClock, "localClock");
        Intrinsics3.checkParameterIsNotNull(sharedPreferenceSyncResponseCache, "syncResponseCache");
        Intrinsics3.checkParameterIsNotNull(list3, "ntpHosts");
        if (androidSystemClock instanceof Clock8) {
            throw new IllegalArgumentException("Local clock should implement Clock instead of KronosClock");
        }
        return new KronosClockImpl(new SntpService2(new SntpClient(androidSystemClock, new DnsResolver2(), new DatagramFactory2()), androidSystemClock, new SntpResponseCache2(sharedPreferenceSyncResponseCache, androidSystemClock), null, list3, j4, j5, j6), androidSystemClock);
    }
}
