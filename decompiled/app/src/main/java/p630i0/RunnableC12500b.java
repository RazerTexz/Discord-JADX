package p630i0;

import java.io.IOException;
import p630i0.DefaultCallAdapterFactory;
import retrofit2.Response;

/* JADX INFO: renamed from: i0.b */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC12500b implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ DefaultCallAdapterFactory.b.a f26479j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ Callback3 f26480k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ Response f26481l;

    public /* synthetic */ RunnableC12500b(DefaultCallAdapterFactory.b.a aVar, Callback3 callback3, Response response) {
        this.f26479j = aVar;
        this.f26480k = callback3;
        this.f26481l = response;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DefaultCallAdapterFactory.b.a aVar = this.f26479j;
        Callback3 callback3 = this.f26480k;
        Response response = this.f26481l;
        if (DefaultCallAdapterFactory.b.this.f26538k.mo10700d()) {
            callback3.mo10708a(DefaultCallAdapterFactory.b.this, new IOException("Canceled"));
        } else {
            callback3.mo10709b(DefaultCallAdapterFactory.b.this, response);
        }
    }
}
