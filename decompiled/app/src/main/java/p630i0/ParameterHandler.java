package p630i0;

import java.io.IOException;
import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: i0.r, reason: use source file name */
/* JADX INFO: compiled from: ParameterHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public class ParameterHandler<T> extends ParameterHandler3<Iterable<T>> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ ParameterHandler3 f26569a;

    public ParameterHandler(ParameterHandler3 parameterHandler3) {
        this.f26569a = parameterHandler3;
    }

    @Override // p630i0.ParameterHandler3
    /* JADX INFO: renamed from: a */
    public void mo10715a(RequestBuilder requestBuilder, Object obj) throws IOException {
        Iterable iterable = (Iterable) obj;
        if (iterable == null) {
            return;
        }
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            this.f26569a.mo10715a(requestBuilder, it.next());
        }
    }
}
