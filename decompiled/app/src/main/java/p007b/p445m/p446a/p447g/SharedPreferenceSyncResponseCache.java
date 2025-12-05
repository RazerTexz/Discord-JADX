package p007b.p445m.p446a.p447g;

import android.content.SharedPreferences;
import p007b.p445m.p446a.SyncResponseCache;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: SharedPreferenceSyncResponseCache.kt */
/* renamed from: b.m.a.g.c, reason: use source file name */
/* loaded from: classes3.dex */
public final class SharedPreferenceSyncResponseCache implements SyncResponseCache {

    /* renamed from: a */
    public final SharedPreferences f13648a;

    public SharedPreferenceSyncResponseCache(SharedPreferences sharedPreferences) {
        Intrinsics3.checkParameterIsNotNull(sharedPreferences, "sharedPreferences");
        this.f13648a = sharedPreferences;
    }

    @Override // p007b.p445m.p446a.SyncResponseCache
    /* renamed from: a */
    public void mo7133a(long j) {
        this.f13648a.edit().putLong("com.lyft.kronos.cached_elapsed_time", j).apply();
    }

    @Override // p007b.p445m.p446a.SyncResponseCache
    /* renamed from: b */
    public void mo7134b(long j) {
        this.f13648a.edit().putLong("com.lyft.kronos.cached_offset", j).apply();
    }

    @Override // p007b.p445m.p446a.SyncResponseCache
    /* renamed from: c */
    public long mo7135c() {
        return this.f13648a.getLong("com.lyft.kronos.cached_elapsed_time", 0L);
    }

    @Override // p007b.p445m.p446a.SyncResponseCache
    public void clear() {
        this.f13648a.edit().clear().apply();
    }

    @Override // p007b.p445m.p446a.SyncResponseCache
    /* renamed from: d */
    public long mo7136d() {
        return this.f13648a.getLong("com.lyft.kronos.cached_offset", 0L);
    }

    @Override // p007b.p445m.p446a.SyncResponseCache
    /* renamed from: e */
    public long mo7137e() {
        return this.f13648a.getLong("com.lyft.kronos.cached_current_time", 0L);
    }

    @Override // p007b.p445m.p446a.SyncResponseCache
    /* renamed from: f */
    public void mo7138f(long j) {
        this.f13648a.edit().putLong("com.lyft.kronos.cached_current_time", j).apply();
    }
}
