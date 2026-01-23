package p007b.p225i.p361c.p362j.p363a.p364c;

import android.content.Context;
import android.os.Bundle;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p313h.p325l.C3661g;
import p007b.p225i.p361c.DataCollectionDefaultChange;
import p007b.p225i.p361c.FirebaseApp2;
import p007b.p225i.p361c.p362j.p363a.C4550b;
import p007b.p225i.p361c.p362j.p363a.C4557d;
import p007b.p225i.p361c.p362j.p363a.ExecutorC4558e;
import p007b.p225i.p361c.p368l.ComponentContainer;
import p007b.p225i.p361c.p368l.ComponentFactory;
import p007b.p225i.p361c.p396q.Subscriber2;

/* JADX INFO: renamed from: b.i.c.j.a.c.a */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C4551a implements ComponentFactory {

    /* JADX INFO: renamed from: a */
    public static final ComponentFactory f12144a = new C4551a();

    @Override // p007b.p225i.p361c.p368l.ComponentFactory
    /* JADX INFO: renamed from: a */
    public final Object mo6341a(ComponentContainer componentContainer) {
        FirebaseApp2 firebaseApp2 = (FirebaseApp2) componentContainer.mo6346a(FirebaseApp2.class);
        Context context = (Context) componentContainer.mo6346a(Context.class);
        Subscriber2 subscriber2 = (Subscriber2) componentContainer.mo6346a(Subscriber2.class);
        Objects.requireNonNull(firebaseApp2, "null reference");
        Objects.requireNonNull(context, "null reference");
        Objects.requireNonNull(subscriber2, "null reference");
        Objects.requireNonNull(context.getApplicationContext(), "null reference");
        if (C4550b.f12141a == null) {
            synchronized (C4550b.class) {
                if (C4550b.f12141a == null) {
                    Bundle bundle = new Bundle(1);
                    if (firebaseApp2.m6334h()) {
                        subscriber2.mo6360b(DataCollectionDefaultChange.class, ExecutorC4558e.f12161j, C4557d.f12160a);
                        bundle.putBoolean("dataCollectionDefaultEnabled", firebaseApp2.m6333g());
                    }
                    C4550b.f12141a = new C4550b(C3661g.m4882a(context, null, null, null, bundle).f9951f);
                }
            }
        }
        return C4550b.f12141a;
    }
}
