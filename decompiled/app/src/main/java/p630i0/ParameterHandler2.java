package p630i0;

import java.io.IOException;
import java.lang.reflect.Array;

/* JADX INFO: renamed from: i0.s, reason: use source file name */
/* JADX INFO: compiled from: ParameterHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public class ParameterHandler2 extends ParameterHandler3<Object> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ ParameterHandler3 f26570a;

    public ParameterHandler2(ParameterHandler3 parameterHandler3) {
        this.f26570a = parameterHandler3;
    }

    @Override // p630i0.ParameterHandler3
    /* JADX INFO: renamed from: a */
    public void mo10715a(RequestBuilder requestBuilder, Object obj) throws IOException {
        if (obj == null) {
            return;
        }
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.f26570a.mo10715a(requestBuilder, Array.get(obj, i));
        }
    }
}
