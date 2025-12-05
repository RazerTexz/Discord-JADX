package kotlin.text;

import java.util.List;
import kotlin.ranges.Ranges2;
import p507d0.p579g0.MatchResult2;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: MatchResult.kt */
/* loaded from: classes3.dex */
public interface MatchResult {

    /* compiled from: MatchResult.kt */
    /* renamed from: kotlin.text.MatchResult$a */
    public static final class C12797a {
        public static C12798b getDestructured(MatchResult matchResult) {
            return new C12798b(matchResult);
        }
    }

    /* compiled from: MatchResult.kt */
    /* renamed from: kotlin.text.MatchResult$b */
    public static final class C12798b {

        /* renamed from: a */
        public final MatchResult f27452a;

        public C12798b(MatchResult matchResult) {
            Intrinsics3.checkNotNullParameter(matchResult, "match");
            this.f27452a = matchResult;
        }

        public final MatchResult getMatch() {
            return this.f27452a;
        }
    }

    C12798b getDestructured();

    List<String> getGroupValues();

    MatchResult2 getGroups();

    Ranges2 getRange();

    String getValue();

    MatchResult next();
}
