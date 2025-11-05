package d0.e0.p.d.m0.e.a.i0;

/* compiled from: context.kt */
/* loaded from: classes3.dex */
public interface c {

    /* compiled from: context.kt */
    public static final class a implements c {
        public static final a a = new a();

        @Override // d0.e0.p.d.m0.e.a.i0.c
        public boolean getCorrectNullabilityForNotNullTypeParameter() {
            return false;
        }

        @Override // d0.e0.p.d.m0.e.a.i0.c
        public boolean getTypeEnhancementImprovements() {
            return false;
        }

        @Override // d0.e0.p.d.m0.e.a.i0.c
        public boolean isReleaseCoroutines() {
            return false;
        }
    }

    boolean getCorrectNullabilityForNotNullTypeParameter();

    boolean getTypeEnhancementImprovements();

    boolean isReleaseCoroutines();
}
