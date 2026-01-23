package p507d0.p513e0.p514p.p515d.p517m0.p518b;

import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.LockBasedStorageManager;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.e, reason: use source file name */
/* JADX INFO: compiled from: DefaultBuiltIns.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DefaultBuiltIns extends KotlinBuiltIns {

    /* JADX INFO: renamed from: f */
    public static final a f22457f = new a(null);

    /* JADX INFO: renamed from: g */
    public static final DefaultBuiltIns f22458g = new DefaultBuiltIns(false, 1, null);

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.e$a */
    /* JADX INFO: compiled from: DefaultBuiltIns.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final DefaultBuiltIns getInstance() {
            return DefaultBuiltIns.access$getInstance$cp();
        }
    }

    public DefaultBuiltIns(boolean z2) {
        super(new LockBasedStorageManager("DefaultBuiltIns"));
        if (z2) {
            m9361d(false);
        }
    }

    public static final /* synthetic */ DefaultBuiltIns access$getInstance$cp() {
        return f22458g;
    }

    public static final DefaultBuiltIns getInstance() {
        return f22457f.getInstance();
    }

    public /* synthetic */ DefaultBuiltIns(boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z2);
    }
}
