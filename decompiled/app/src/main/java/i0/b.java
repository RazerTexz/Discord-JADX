package i0;

import i0.i;
import java.io.IOException;
import retrofit2.Response;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ i.b.a j;
    public final /* synthetic */ f k;
    public final /* synthetic */ Response l;

    public /* synthetic */ b(i.b.a aVar, f fVar, Response response) {
        this.j = aVar;
        this.k = fVar;
        this.l = response;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i.b.a aVar = this.j;
        f fVar = this.k;
        Response response = this.l;
        if (i.b.this.k.d()) {
            fVar.a(i.b.this, new IOException("Canceled"));
        } else {
            fVar.b(i.b.this, response);
        }
    }
}
