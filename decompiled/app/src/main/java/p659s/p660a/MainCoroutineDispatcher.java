package p659s.p660a;

import com.discord.widgets.chat.input.MentionUtils;
import kotlinx.coroutines.CoroutineDispatcher;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p659s.p660a.p661a.MainDispatchers;

/* compiled from: MainCoroutineDispatcher.kt */
/* renamed from: s.a.l1, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class MainCoroutineDispatcher extends CoroutineDispatcher {
    /* renamed from: H */
    public abstract MainCoroutineDispatcher mo11194H();

    /* renamed from: I */
    public final String m11332I() {
        MainCoroutineDispatcher mainCoroutineDispatcherMo11194H;
        CoroutineDispatcher coroutineDispatcher = Dispatchers.f27866a;
        MainCoroutineDispatcher mainCoroutineDispatcher = MainDispatchers.f27700b;
        if (this == mainCoroutineDispatcher) {
            return "Dispatchers.Main";
        }
        try {
            mainCoroutineDispatcherMo11194H = mainCoroutineDispatcher.mo11194H();
        } catch (UnsupportedOperationException unused) {
            mainCoroutineDispatcherMo11194H = null;
        }
        if (this == mainCoroutineDispatcherMo11194H) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        String strM11332I = m11332I();
        if (strM11332I != null) {
            return strM11332I;
        }
        return getClass().getSimpleName() + MentionUtils.MENTIONS_CHAR + C3404f.m4312l0(this);
    }
}
