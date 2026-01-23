package p007b.p225i.p361c.p397r;

import android.content.Context;
import androidx.annotation.NonNull;
import p007b.p225i.p361c.p368l.Lazy2;
import p007b.p225i.p361c.p397r.HeartBeatInfo;
import p007b.p225i.p361c.p400t.Provider2;

/* JADX INFO: renamed from: b.i.c.r.c, reason: use source file name */
/* JADX INFO: compiled from: DefaultHeartBeatInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public class DefaultHeartBeatInfo3 implements HeartBeatInfo {

    /* JADX INFO: renamed from: a */
    public Provider2<HeartBeatInfoStorage> f12835a;

    public DefaultHeartBeatInfo3(Context context) {
        this.f12835a = new Lazy2(new DefaultHeartBeatInfo(context));
    }

    @Override // p007b.p225i.p361c.p397r.HeartBeatInfo
    @NonNull
    /* JADX INFO: renamed from: a */
    public HeartBeatInfo.a mo6716a(@NonNull String str) {
        boolean zM6718a;
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean zM6718a2 = this.f12835a.get().m6718a(str, jCurrentTimeMillis);
        HeartBeatInfoStorage heartBeatInfoStorage = this.f12835a.get();
        synchronized (heartBeatInfoStorage) {
            zM6718a = heartBeatInfoStorage.m6718a("fire-global", jCurrentTimeMillis);
        }
        return (zM6718a2 && zM6718a) ? HeartBeatInfo.a.COMBINED : zM6718a ? HeartBeatInfo.a.GLOBAL : zM6718a2 ? HeartBeatInfo.a.SDK : HeartBeatInfo.a.NONE;
    }
}
