package p630i0;

import p630i0.DefaultCallAdapterFactory;

/* compiled from: lambda */
/* renamed from: i0.a */
/* loaded from: classes3.dex */
public final /* synthetic */ class RunnableC12498a implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ DefaultCallAdapterFactory.b.a f26476j;

    /* renamed from: k */
    public final /* synthetic */ Callback3 f26477k;

    /* renamed from: l */
    public final /* synthetic */ Throwable f26478l;

    public /* synthetic */ RunnableC12498a(DefaultCallAdapterFactory.b.a aVar, Callback3 callback3, Throwable th) {
        this.f26476j = aVar;
        this.f26477k = callback3;
        this.f26478l = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DefaultCallAdapterFactory.b.a aVar = this.f26476j;
        this.f26477k.mo10708a(DefaultCallAdapterFactory.b.this, this.f26478l);
    }
}
