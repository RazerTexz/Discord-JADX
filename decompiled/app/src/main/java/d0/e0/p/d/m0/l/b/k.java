package d0.e0.p.d.m0.l.b;

/* compiled from: DeserializationConfiguration.kt */
/* loaded from: classes3.dex */
public interface k {

    /* compiled from: DeserializationConfiguration.kt */
    public static final class a implements k {
        public static final a a = new a();

        @Override // d0.e0.p.d.m0.l.b.k
        public boolean getAllowUnstableDependencies() {
            return b.getAllowUnstableDependencies(this);
        }

        @Override // d0.e0.p.d.m0.l.b.k
        public boolean getPreserveDeclarationsOrdering() {
            return b.getPreserveDeclarationsOrdering(this);
        }

        @Override // d0.e0.p.d.m0.l.b.k
        public boolean getReleaseCoroutines() {
            return b.getReleaseCoroutines(this);
        }

        @Override // d0.e0.p.d.m0.l.b.k
        public boolean getReportErrorsOnPreReleaseDependencies() {
            return b.getReportErrorsOnPreReleaseDependencies(this);
        }

        @Override // d0.e0.p.d.m0.l.b.k
        public boolean getSkipMetadataVersionCheck() {
            return b.getSkipMetadataVersionCheck(this);
        }

        @Override // d0.e0.p.d.m0.l.b.k
        public boolean getSkipPrereleaseCheck() {
            return b.getSkipPrereleaseCheck(this);
        }

        @Override // d0.e0.p.d.m0.l.b.k
        public boolean getTypeAliasesAllowed() {
            return b.getTypeAliasesAllowed(this);
        }
    }

    /* compiled from: DeserializationConfiguration.kt */
    public static final class b {
        public static boolean getAllowUnstableDependencies(k kVar) {
            d0.z.d.m.checkNotNullParameter(kVar, "this");
            return false;
        }

        public static boolean getPreserveDeclarationsOrdering(k kVar) {
            d0.z.d.m.checkNotNullParameter(kVar, "this");
            return false;
        }

        public static boolean getReleaseCoroutines(k kVar) {
            d0.z.d.m.checkNotNullParameter(kVar, "this");
            return false;
        }

        public static boolean getReportErrorsOnPreReleaseDependencies(k kVar) {
            d0.z.d.m.checkNotNullParameter(kVar, "this");
            return false;
        }

        public static boolean getSkipMetadataVersionCheck(k kVar) {
            d0.z.d.m.checkNotNullParameter(kVar, "this");
            return false;
        }

        public static boolean getSkipPrereleaseCheck(k kVar) {
            d0.z.d.m.checkNotNullParameter(kVar, "this");
            return false;
        }

        public static boolean getTypeAliasesAllowed(k kVar) {
            d0.z.d.m.checkNotNullParameter(kVar, "this");
            return true;
        }
    }

    boolean getAllowUnstableDependencies();

    boolean getPreserveDeclarationsOrdering();

    boolean getReleaseCoroutines();

    boolean getReportErrorsOnPreReleaseDependencies();

    boolean getSkipMetadataVersionCheck();

    boolean getSkipPrereleaseCheck();

    boolean getTypeAliasesAllowed();
}
