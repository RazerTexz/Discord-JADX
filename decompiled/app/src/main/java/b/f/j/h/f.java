package b.f.j.h;

import b.f.j.j.h;
import b.f.j.j.i;
import java.util.Collections;
import java.util.List;

/* compiled from: SimpleProgressiveJpegConfig.java */
/* loaded from: classes.dex */
public class f implements d {
    public final c a = new b(null);

    /* compiled from: SimpleProgressiveJpegConfig.java */
    public static class b implements c {
        public b(a aVar) {
        }

        @Override // b.f.j.h.f.c
        public List<Integer> a() {
            return Collections.EMPTY_LIST;
        }

        @Override // b.f.j.h.f.c
        public int b() {
            return 0;
        }
    }

    /* compiled from: SimpleProgressiveJpegConfig.java */
    public interface c {
        List<Integer> a();

        int b();
    }

    @Override // b.f.j.h.d
    public i a(int i) {
        return new h(i, i >= this.a.b(), false);
    }

    @Override // b.f.j.h.d
    public int b(int i) {
        List<Integer> listA = this.a.a();
        if (listA == null || listA.isEmpty()) {
            return i + 1;
        }
        for (int i2 = 0; i2 < listA.size(); i2++) {
            if (listA.get(i2).intValue() > i) {
                return listA.get(i2).intValue();
            }
        }
        return Integer.MAX_VALUE;
    }
}
