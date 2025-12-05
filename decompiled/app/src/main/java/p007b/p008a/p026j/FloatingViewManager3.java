package p007b.p008a.p026j;

import com.discord.utilities.logging.Logger;
import p658rx.functions.Action1;

/* compiled from: FloatingViewManager.kt */
/* renamed from: b.a.j.e, reason: use source file name */
/* loaded from: classes.dex */
public final class FloatingViewManager3<T> implements Action1<Throwable> {

    /* renamed from: j */
    public final /* synthetic */ FloatingViewManager f1476j;

    public FloatingViewManager3(FloatingViewManager floatingViewManager) {
        this.f1476j = floatingViewManager;
    }

    @Override // p658rx.functions.Action1
    public void call(Throwable th) {
        Logger.e$default(this.f1476j.f1456c, "error while subscribing to componentPausedObservable for hiding floating view", th, null, 4, null);
    }
}
