package p007b.p225i.p361c.p397r;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: HeartBeatInfoStorage.java */
/* renamed from: b.i.c.r.e, reason: use source file name */
/* loaded from: classes3.dex */
public class HeartBeatInfoStorage {

    /* renamed from: a */
    public static HeartBeatInfoStorage f12841a;

    /* renamed from: b */
    public final SharedPreferences f12842b;

    public HeartBeatInfoStorage(Context context) {
        this.f12842b = context.getSharedPreferences("FirebaseAppHeartBeat", 0);
    }

    /* renamed from: a */
    public synchronized boolean m6718a(String str, long j) {
        if (!this.f12842b.contains(str)) {
            this.f12842b.edit().putLong(str, j).apply();
            return true;
        }
        if (j - this.f12842b.getLong(str, -1L) < 86400000) {
            return false;
        }
        this.f12842b.edit().putLong(str, j).apply();
        return true;
    }
}
