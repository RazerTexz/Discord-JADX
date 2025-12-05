package p007b.p225i.p361c;

import android.content.Context;
import p007b.p225i.p361c.p396q.Publisher;
import p007b.p225i.p361c.p400t.Provider2;
import p007b.p225i.p361c.p405v.DataCollectionConfigStorage;

/* compiled from: FirebaseApp.java */
/* renamed from: b.i.c.b, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class FirebaseApp implements Provider2 {

    /* renamed from: a */
    public final FirebaseApp2 f12113a;

    /* renamed from: b */
    public final Context f12114b;

    public FirebaseApp(FirebaseApp2 firebaseApp2, Context context) {
        this.f12113a = firebaseApp2;
        this.f12114b = context;
    }

    @Override // p007b.p225i.p361c.p400t.Provider2
    public Object get() {
        FirebaseApp2 firebaseApp2 = this.f12113a;
        Context context = this.f12114b;
        Object obj = FirebaseApp2.f12115a;
        return new DataCollectionConfigStorage(context, firebaseApp2.m6331c(), (Publisher) firebaseApp2.f12121g.mo6346a(Publisher.class));
    }
}
