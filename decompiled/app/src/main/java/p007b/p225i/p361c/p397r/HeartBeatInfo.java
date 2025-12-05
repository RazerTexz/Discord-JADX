package p007b.p225i.p361c.p397r;

import androidx.annotation.NonNull;

/* compiled from: HeartBeatInfo.java */
/* renamed from: b.i.c.r.d, reason: use source file name */
/* loaded from: classes3.dex */
public interface HeartBeatInfo {

    /* compiled from: HeartBeatInfo.java */
    /* renamed from: b.i.c.r.d$a */
    public enum a {
        NONE(0),
        SDK(1),
        GLOBAL(2),
        COMBINED(3);

        private final int code;

        a(int i) {
            this.code = i;
        }

        /* renamed from: f */
        public int m6717f() {
            return this.code;
        }
    }

    @NonNull
    /* renamed from: a */
    a mo6716a(@NonNull String str);
}
