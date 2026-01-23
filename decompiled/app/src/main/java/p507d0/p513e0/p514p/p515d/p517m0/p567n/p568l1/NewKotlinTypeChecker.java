package p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1;

import p507d0.p513e0.p514p.p515d.p517m0.p552k.OverridingUtil;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeRefiner;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.l, reason: use source file name */
/* JADX INFO: compiled from: NewKotlinTypeChecker.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface NewKotlinTypeChecker extends KotlinTypeChecker {

    /* JADX INFO: renamed from: b */
    public static final a f24820b = a.f24821a;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.l$a */
    /* JADX INFO: compiled from: NewKotlinTypeChecker.kt */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public static final /* synthetic */ a f24821a = new a();

        /* JADX INFO: renamed from: b */
        public static final NewKotlinTypeChecker2 f24822b = new NewKotlinTypeChecker2(KotlinTypeRefiner.a.f24807a);

        public final NewKotlinTypeChecker2 getDefault() {
            return f24822b;
        }
    }

    KotlinTypeRefiner getKotlinTypeRefiner();

    OverridingUtil getOverridingUtil();
}
