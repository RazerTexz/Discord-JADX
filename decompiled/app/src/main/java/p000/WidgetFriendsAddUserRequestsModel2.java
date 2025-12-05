package p000;

import java.util.Set;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetFriendsAddUserRequestsModel.kt */
/* renamed from: v, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetFriendsAddUserRequestsModel2 extends FunctionReferenceImpl implements Function2<Set<? extends Long>, Set<? extends Long>, WidgetFriendsAddUserRequestsModel> {

    /* renamed from: j */
    public static final WidgetFriendsAddUserRequestsModel2 f27929j = new WidgetFriendsAddUserRequestsModel2();

    public WidgetFriendsAddUserRequestsModel2() {
        super(2, WidgetFriendsAddUserRequestsModel.class, "<init>", "<init>(Ljava/util/Set;Ljava/util/Set;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public WidgetFriendsAddUserRequestsModel invoke(Set<? extends Long> set, Set<? extends Long> set2) {
        Set<? extends Long> set3 = set;
        Set<? extends Long> set4 = set2;
        Intrinsics3.checkNotNullParameter(set3, "p1");
        Intrinsics3.checkNotNullParameter(set4, "p2");
        return new WidgetFriendsAddUserRequestsModel(set3, set4);
    }
}
