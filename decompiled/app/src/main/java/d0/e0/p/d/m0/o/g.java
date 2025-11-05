package d0.e0.p.d.m0.o;

import d0.e0.p.d.m0.c.m;

/* compiled from: ModuleVisibilityHelper.kt */
/* loaded from: classes3.dex */
public interface g {

    /* compiled from: ModuleVisibilityHelper.kt */
    public static final class a implements g {
        public static final a a = new a();

        @Override // d0.e0.p.d.m0.o.g
        public boolean isInFriendModule(m mVar, m mVar2) {
            d0.z.d.m.checkNotNullParameter(mVar, "what");
            d0.z.d.m.checkNotNullParameter(mVar2, "from");
            return true;
        }
    }

    boolean isInFriendModule(m mVar, m mVar2);
}
