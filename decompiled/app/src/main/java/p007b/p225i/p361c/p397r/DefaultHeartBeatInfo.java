package p007b.p225i.p361c.p397r;

import android.content.Context;
import p007b.p225i.p361c.p400t.Provider2;

/* JADX INFO: renamed from: b.i.c.r.a, reason: use source file name */
/* JADX INFO: compiled from: DefaultHeartBeatInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class DefaultHeartBeatInfo implements Provider2 {

    /* JADX INFO: renamed from: a */
    public final Context f12833a;

    public DefaultHeartBeatInfo(Context context) {
        this.f12833a = context;
    }

    @Override // p007b.p225i.p361c.p400t.Provider2
    public Object get() {
        HeartBeatInfoStorage heartBeatInfoStorage;
        Context context = this.f12833a;
        synchronized (HeartBeatInfoStorage.class) {
            if (HeartBeatInfoStorage.f12841a == null) {
                HeartBeatInfoStorage.f12841a = new HeartBeatInfoStorage(context);
            }
            heartBeatInfoStorage = HeartBeatInfoStorage.f12841a;
        }
        return heartBeatInfoStorage;
    }
}
