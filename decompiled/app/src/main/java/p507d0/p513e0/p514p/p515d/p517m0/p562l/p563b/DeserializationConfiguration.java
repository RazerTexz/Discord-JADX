package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b;

import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.k, reason: use source file name */
/* JADX INFO: compiled from: DeserializationConfiguration.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface DeserializationConfiguration {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.k$a */
    /* JADX INFO: compiled from: DeserializationConfiguration.kt */
    public static final class a implements DeserializationConfiguration {

        /* JADX INFO: renamed from: a */
        public static final a f24658a = new a();

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.DeserializationConfiguration
        public boolean getAllowUnstableDependencies() {
            return b.getAllowUnstableDependencies(this);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.DeserializationConfiguration
        public boolean getPreserveDeclarationsOrdering() {
            return b.getPreserveDeclarationsOrdering(this);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.DeserializationConfiguration
        public boolean getReleaseCoroutines() {
            return b.getReleaseCoroutines(this);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.DeserializationConfiguration
        public boolean getReportErrorsOnPreReleaseDependencies() {
            return b.getReportErrorsOnPreReleaseDependencies(this);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.DeserializationConfiguration
        public boolean getSkipMetadataVersionCheck() {
            return b.getSkipMetadataVersionCheck(this);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.DeserializationConfiguration
        public boolean getSkipPrereleaseCheck() {
            return b.getSkipPrereleaseCheck(this);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.DeserializationConfiguration
        public boolean getTypeAliasesAllowed() {
            return b.getTypeAliasesAllowed(this);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.k$b */
    /* JADX INFO: compiled from: DeserializationConfiguration.kt */
    public static final class b {
        public static boolean getAllowUnstableDependencies(DeserializationConfiguration deserializationConfiguration) {
            Intrinsics3.checkNotNullParameter(deserializationConfiguration, "this");
            return false;
        }

        public static boolean getPreserveDeclarationsOrdering(DeserializationConfiguration deserializationConfiguration) {
            Intrinsics3.checkNotNullParameter(deserializationConfiguration, "this");
            return false;
        }

        public static boolean getReleaseCoroutines(DeserializationConfiguration deserializationConfiguration) {
            Intrinsics3.checkNotNullParameter(deserializationConfiguration, "this");
            return false;
        }

        public static boolean getReportErrorsOnPreReleaseDependencies(DeserializationConfiguration deserializationConfiguration) {
            Intrinsics3.checkNotNullParameter(deserializationConfiguration, "this");
            return false;
        }

        public static boolean getSkipMetadataVersionCheck(DeserializationConfiguration deserializationConfiguration) {
            Intrinsics3.checkNotNullParameter(deserializationConfiguration, "this");
            return false;
        }

        public static boolean getSkipPrereleaseCheck(DeserializationConfiguration deserializationConfiguration) {
            Intrinsics3.checkNotNullParameter(deserializationConfiguration, "this");
            return false;
        }

        public static boolean getTypeAliasesAllowed(DeserializationConfiguration deserializationConfiguration) {
            Intrinsics3.checkNotNullParameter(deserializationConfiguration, "this");
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
